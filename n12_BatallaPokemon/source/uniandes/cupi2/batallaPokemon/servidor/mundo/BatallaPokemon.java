/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n12_batallaPokemon
 * Autor: Equipo Cupi2 2016
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.cupi2.batallaPokemon.servidor.mundo;

import java.io.*;
import java.net.*;
import java.sql.*;
import java.util.*;

/**
 * Servidor BatallaPokemon se encarga de recibir conexiones de los clientes y organizar las batallas. <br>
 * <b>inv:</b><br>
 * receptor!= null <br>
 * config!=null <br>
 * adminResultados!=null <br>
 * encuentros!=null <br>
 */
public class BatallaPokemon
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Mensaje de registro de un jugador.
     */
    public static final String REGISTRO = "REGISTRO";

    /**
     * Mensaje de login de un jugador.
     */
    public static final String LOGIN = "LOGIN";

    /**
     * Constante que representa el separador de un comando.
     */
    public static final String SEPARADOR_COMANDO = ";;;";

    /**
     * Constante que representa el separador de los parámetros.
     */
    public static final String SEPARADOR_PARAMETROS = ":::";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Punto por el cual los clientes solicitan conexiones.
     */
    private ServerSocket receptor;

    /**
     * Propiedades que contienen la configuración de la aplicación.
     */
    private Properties config;

    /**
     * Administrador que permite registrar los resultados sobre la base de datos.
     */
    private AdministradorResultados adminResultados;

    /**
     * Canal utilizado para establecer una comunicación con un jugador que está en espera de un oponente. <br>
     * Si no hay jugadores en espera, este canal debe ser null.
     */
    private Socket socketJugadorEnEspera;

    /**
     * Registro del jugador que está en espera de un oponente.
     */
    private RegistroJugador registroJugadorEnEspera;

    /**
     * Colección con los encuentros que se están llevando a cabo en este momento.
     */
    protected Collection encuentros;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Inicia el servidor y deja listo el administrador de resultados.
     * @param pArchivo Archivo de propiedades que tiene la configuración del servidor. pArchivo != null.
     * @throws BatallaPokemonServidorException Si se encuentra un error en la inicialización de la aplicación.
     */
    public BatallaPokemon( String pArchivo ) throws BatallaPokemonServidorException
    {
        encuentros = new Vector( );
        try
        {
            cargarConfiguracion( pArchivo );

            adminResultados = new AdministradorResultados( config );
            adminResultados.conectarABD( );
            adminResultados.inicializarTabla( );
            verificarInvariante( );
        }
        catch( SQLException e )
        {
            throw new BatallaPokemonServidorException( "Hubo problemas con el archivo de propiedades o en la conexión de la base de datos: " + e.getMessage( ) );
        }
        catch( Exception e )
        {
            throw new BatallaPokemonServidorException( "Hubo problemas conectado a la base de datos: " + e.getMessage( ) );
        }
    }
    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Retorna al administrador de resultados.
     * @return Administrador de resultados.
     */
    public AdministradorResultados darAdministradorResultados( )
    {
        return adminResultados;
    }

    /**
     * Retorna una colección actualizada con las batallas que se están desarrollando actualmente y no han terminado.<br>
     * Si había batallas en la lista que ya habían terminado deben ser eliminadas.
     * @return Colección de batallas.
     */
    public Collection darListaActualizadaBatallas( )
    {
        Collection listaActualizada = new Vector( );

        // Armar la lista actualizada con las batallas que no han terminado.
        Iterator iter = encuentros.iterator( );
        while( iter.hasNext( ) )
        {
            Batalla e = ( Batalla )iter.next( );
            if( !e.encuentroTerminado( ) )
                listaActualizada.add( e );
        }

        // Reemplazar la lista antigua con la lista actualizada.
        encuentros = listaActualizada;

        return encuentros;
    }

    /**
     * Carga la configuración a partir de un archivo de propiedades.
     * @param pArchivo Archivo de propiedades que contiene la configuración que requiere el servidor. pArchivo != null y el archivo debe contener la propiedad
     *        "servidor.puerto" y las propiedades que requiere el administrador de resultados.
     * @throws Exception Si hay problemas cargando el archivo de propiedades.
     */
    private void cargarConfiguracion( String pArchivo ) throws Exception
    {
        FileInputStream fis = new FileInputStream( pArchivo );
        config = new Properties( );
        config.load( fis );
        fis.close( );
    }

    /**
     * Recibe todas las conexiones entrantes y crea las batallas cuando fuera necesario.
     * @throws BatallaPokemonServidorException Si hay problemas de comunicación.
     */
    public void recibirConexiones( ) throws BatallaPokemonServidorException
    {
        String aux = config.getProperty( "servidor.puerto" );
        int puerto = Integer.parseInt( aux );
        try
        {
            receptor = new ServerSocket( puerto );

            while( true )
            {
                // Esperar una nueva conexión.
                Socket socketNuevoCliente = receptor.accept( );

                // Intentar iniciar un encuentro con el nuevo cliente.
                crearEncuentro( socketNuevoCliente );
            }
        }
        catch( IOException e )
        {
            throw new BatallaPokemonServidorException( "Hubo problemas de comunicación: " + e.getMessage( ) );
        }
        finally
        {
            try
            {
                receptor.close( );
            }
            catch( IOException e )
            {
                // Hubo un error cerrando el canal
            }
        }
    }

    /**
     * Intenta crear e iniciar un nueva batalla con el jugador que se acaba de conectar. <br>
     * Si no se tiene ya un oponente, entonces el jugador queda en espera de que otra persona se conecte.
     * @param pSocketNuevoCliente El canal que permite la comunicación con el nuevo cliente. pSocketNuevoCliente != null.
     * @throws IOException Se lanza esta excepción si se presentan problemas de comunicación.
     */
    synchronized private void crearEncuentro( Socket pSocketNuevoCliente )
    {

        PrintWriter out1;
        BufferedReader in1;
        RegistroJugador registroActual = null;

        try
        {

            out1 = new PrintWriter( pSocketNuevoCliente.getOutputStream( ), true );
            in1 = new BufferedReader( new InputStreamReader( pSocketNuevoCliente.getInputStream( ) ) );

            // Leer la información sobre los jugadores.
            String informacion = in1.readLine( );
            try
            {
                registroActual = consultarJugador( informacion );

                if( socketJugadorEnEspera == null )
                {
                    // No hay un oponente aún, así que hay que dejarlo en espera.
                    socketJugadorEnEspera = pSocketNuevoCliente;
                    registroJugadorEnEspera = registroActual;
                }
                else
                {
                    // Ya se tiene un oponente así que se puede empezar una partida.

                    Batalla nuevo = new Batalla( socketJugadorEnEspera, pSocketNuevoCliente, in1, out1, adminResultados, registroJugadorEnEspera, registroActual );
                    iniciarEncuentro( nuevo );
                    socketJugadorEnEspera = null;

                }
            }
            catch( BatallaPokemonServidorException e )
            {
                out1.println( Batalla.ERROR + SEPARADOR_COMANDO + e.getMessage( ) );
            }
        }
        catch( IOException e )
        {
            try
            {
                socketJugadorEnEspera.close( );
                pSocketNuevoCliente.close( );
            }
            catch( IOException e1 )
            {
                // Hubo un error cerrando el canal
            }

        }

        verificarInvariante( );
    }
    /**
     * Retorna el registro de un jugador a partir del mensaje que envió cuando entró a la batalla.
     * @param pInformacion Mensaje que fue enviado. pInformacion != null.
     * @return Retorna la información del jugador.
     * @throws BatallaPokemonServidorException Si hay problemas consultando a la base de datos o si recibe un mensaje con un formato inesperado.
     */
    private RegistroJugador consultarJugador( String pInformacion ) throws BatallaPokemonServidorException
    {
        RegistroJugador registro = null;
        if( pInformacion.startsWith( LOGIN ) )
        {
            String[] partes = pInformacion.split( SEPARADOR_COMANDO );
            String[] datosJugador = partes[ 1 ].split( SEPARADOR_PARAMETROS );

            String alias = datosJugador[ 0 ];
            String password = datosJugador[ 1 ];
            try
            {
                registro = adminResultados.consultarRegistroJugador( password, alias );

            }
            catch( SQLException e )
            {
                throw new BatallaPokemonServidorException( "Login no exitoso: " + e.getMessage( ) + "." );
            }
        }
        else if( pInformacion.startsWith( REGISTRO ) )
        {
            String[] partes = pInformacion.split( SEPARADOR_COMANDO );
            String[] datosJugador = partes[ 1 ].split( SEPARADOR_PARAMETROS );
            String alias = datosJugador[ 0 ];
            String nombre = datosJugador[ 1 ];
            String apellidos = datosJugador[ 2 ];
            String password = datosJugador[ 3 ];
            try
            {
                registro = adminResultados.crearRegistroJugador( alias, nombre, apellidos, password );

            }
            catch( SQLException e )
            {
                throw new BatallaPokemonServidorException( "Registro no exitoso: " + e.getMessage( ) + "." );
            }
        }
        else
        {
            throw new BatallaPokemonServidorException( "El mensaje no tiene el formato esperado." );
        }
        return registro;
    }
    /**
     * Agrega la batalla a la lista de batallas en curso y lo inicia.
     * @param pNuevaBatalla Batalla que no ha sido inicializada ni agregada a la lista de batallas. pNuevaBatalla != null.
     */
    protected void iniciarEncuentro( Batalla pNuevaBatalla )
    {
        encuentros.add( pNuevaBatalla );
        pNuevaBatalla.start( );
    }

    // -----------------------------------------------------------------
    // Invariante
    // -----------------------------------------------------------------

    /**
     * Verifica el invariante de la clase <br>
     * <b>inv:</b><br>
     * receptor!= null <br>
     * config!=null <br>
     * adminResultados!=null <br>
     * encuentros!=null <br>
     */
    private void verificarInvariante( )
    {
        assert config != null : "Conjunto de propiedades inválidas.";
        assert adminResultados != null : "El administrador de resultados no debería ser null.";
        assert encuentros != null : "La lista de encuentros no debería ser null.";
    }
    // -----------------------------------------------------------------
    // Puntos de Extensión
    // -----------------------------------------------------------------

    /**
     * Método para la extensión 1.
     * @return Respuesta 1.
     */
    public String metodo1( )
    {
        return "Respuesta 1";
    }

    /**
     * Método para la extensión2.
     * @return Respuesta 2.
     */
    public String metodo2( )
    {
        return "Respuesta 2";
    }

}
