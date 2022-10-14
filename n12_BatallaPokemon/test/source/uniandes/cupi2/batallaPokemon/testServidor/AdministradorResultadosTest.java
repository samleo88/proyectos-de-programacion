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

package uniandes.cupi2.batallaPokemon.testServidor;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.Iterator;
import java.util.Properties;

import junit.framework.TestCase;
import uniandes.cupi2.batallaPokemon.servidor.mundo.AdministradorResultados;
import uniandes.cupi2.batallaPokemon.servidor.mundo.RegistroJugador;

/**
 * Clase que verifica la correcta implementación de la clase AdministradorResultados.
 */
public class AdministradorResultadosTest extends TestCase
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Administrador de resultados sobre el que se harán las pruebas.
     */
    private AdministradorResultados administrador;

    /**
     * Propiedades para configurar las pruebas.
     */
    private Properties configuracion;

    /**
     * Conexión a la base de datos usada para las pruebas.
     */
    private Connection conexionPruebas;

    // -----------------------------------------------------------------
    // Escenarios
    // -----------------------------------------------------------------

    /**
     * Escenario 1: Inicializa la base de datos y construye un nuevo AdministradorResultados conectado a esta base de datos.
     */
    private void setupEscenario1( )
    {
        administrador = null;
        File directorioData = new File( "./test/data" );
        System.setProperty( "derby.system.home", directorioData.getAbsolutePath( ) );
        configuracion = new Properties( );
        configuracion.setProperty( "admin.db.url", "jdbc:derby:testAdmin;create=true" );
        configuracion.setProperty( "admin.test.url", "jdbc:derby:testAdmin" );
        configuracion.setProperty( "admin.db.driver", "org.apache.derby.jdbc.EmbeddedDriver" );
        configuracion.setProperty( "admin.db.shutdown", "jdbc:derby:;shutdown=true" );
        configuracion.setProperty( "admin.db.path", "./test/data" );

        // Conectar a la base de datos
        try
        {
            String driver = configuracion.getProperty( "admin.db.driver" );
            Class.forName( driver ).newInstance( );
            String url = configuracion.getProperty( "admin.db.url" );
            conexionPruebas = DriverManager.getConnection( url );
        }
        catch( Exception e )
        {
            e.printStackTrace( );
            fail( "Falló la conexión a la base de datos." );
        }

        try
        {
            // Crear la tabla de resultados si es necesario
            crearTablas( );
        }
        catch( SQLException e1 )
        {
            fail( "No se pudo crear la tabla." );
        }

        try
        {
            // Limpia todos los datos existentes e inserta datos iniciales para las pruebas
            inicializarTabla( );
        }
        catch( SQLException e2 )
        {
            e2.printStackTrace( );
            fail( "No se pudo crear la tabla" );
        }

        // Construir el administrador
        administrador = new AdministradorResultados( configuracion );
        try
        {
            administrador.conectarABD( );
        }
        catch( Exception e3 )
        {
            fail( "No se pudo conectar el administrador a la BD" );
        }
    }

    /**
     * Crea las tablas necesarias para el administrador de resultados.
     * @throws SQLException Se lanza esta excepción si hay problemas creando la tabla.
     */
    private void crearTablas( ) throws SQLException
    {
        Statement s = conexionPruebas.createStatement( );

        boolean crearTabla = false;
        try
        {
            // Verificar si ya existe la tabla resultados
            s.executeQuery( "SELECT * FROM jugadores" );
        }
        catch( SQLException se )
        {
            crearTabla = true;
        }

        if( crearTabla )
        {
            s.execute( "CREATE TABLE jugadores (alias varchar(32),nombre varchar(32),apellidos varchar(50),contrasenia varchar(12), ganadas int, perdidas int, PRIMARY KEY (alias))" );
        }
        s.close( );
    }

    /**
     * Limpia la tabla de resultados e inserta valores iniciales para las pruebas.
     * @throws SQLException Se lanza esta excepción si hay problemas inicializando la tabla.
     */
    private void inicializarTabla( ) throws SQLException
    {
        Statement s = conexionPruebas.createStatement( );

        // Limpiar la tabla resultados
        s.executeUpdate( "DELETE  FROM jugadores" );

        // Insertar los datos iniciales
        s.executeUpdate( "INSERT INTO jugadores (alias, nombre, apellidos, contrasenia, ganadas, perdidas) VALUES ('Misty', 'Alicia','Jaramillo','pw123', 1,2)" );
        s.executeUpdate( "INSERT INTO jugadores (alias, nombre, apellidos, contrasenia, ganadas, perdidas) VALUES ('AwesomeGuy', 'Beto','Contreras','bc345', 2,1)" );
        s.executeUpdate( "INSERT INTO jugadores (alias, nombre, apellidos, contrasenia, ganadas, perdidas) VALUES ('Ash', 'Carlos','Lagos','cl123', 1,2)" );
        s.executeUpdate( "INSERT INTO jugadores (alias, nombre, apellidos, contrasenia, ganadas, perdidas) VALUES ('Ace', 'Daniel','Duran','dd908', 2,1)" );
    }

    /**
     * Este método, que se llama después de cada prueba, se encarga de detener el administrador y desconectarlo de la base de datos.
     * @throws Exception Se lanza esta excepción si hay problemas en la desconexión.
     */
    protected void tearDown( ) throws Exception
    {
        // Desconectar el administrador de la base de datos
        try
        {
            if( administrador != null )
            {
                administrador.desconectarBD( );
            }
        }
        catch( Exception npe )
        {
            fail( "No se debería lanzar una excepción desconectando" );
        }
    }

    // -----------------------------------------------------------------
    // Casos de prueba
    // -----------------------------------------------------------------

    /**
     * Prueba 1: Verifica el método consultarRegistrosJugadores revisando que los datos retornados correspondan a los insertados. <br>
     * <b> Métodos a probar: </b> <br>
     * consultarRegistrosJugadores. <br>
     * <b> Casos de prueba: </b> <br>
     * 1.Existen jugadores en la tabla.
     */
    public void testConsultarRegistrosJugadores( )
    {
        // Configuración básica
        setupEscenario1( );

        // Consultar los Jugadores
        try
        {
            Collection jugadores = administrador.consultarRegistrosJugadores( );
            assertEquals( "El número de jugadores no es correcto.", 4, jugadores.size( ) );

            String nom0, nom1, nom2, nom3;
            Iterator iter = jugadores.iterator( );

            RegistroJugador j = ( RegistroJugador )iter.next( );
            nom0 = j.darAlias( );
            assertTrue( "Se retornó un jugador equivocado.", j.darAlias( ).equals( "Misty" ) );

            j = ( RegistroJugador )iter.next( );
            nom1 = j.darAlias( );
            assertTrue( "Se retornó un jugador equivocado.", j.darAlias( ).equals( "AwesomeGuy" ) );

            j = ( RegistroJugador )iter.next( );
            nom2 = j.darAlias( );
            assertTrue( "Se retornó un jugador equivocado.", j.darAlias( ).equals( "Ash" ) );

            j = ( RegistroJugador )iter.next( );
            nom3 = j.darAlias( );
            assertTrue( "Se retornó un jugador equivocado.", j.darAlias( ).equals( "Ace" ) );

            assertFalse( "Se listó dos veces el mismo jugador.", nom0.equals( nom1 ) || nom0.equals( nom2 ) || nom0.equals( nom3 ) || nom1.equals( nom2 ) || nom1.equals( nom3 ) || nom2.equals( nom3 ) );
        }
        catch( Exception e )
        {
            fail( "No se debería lanzar una excepción" );
        }
    }

    /**
     * Prueba 2: Verifica el método consultarRegistroJugador. <br>
     * <b> Métodos a probar: </b> <br>
     * consultarRegistroJugador. <br>
     * <b> Casos de prueba: </b> <br>
     * 1. Existe un jugador para con los datos ingresados.<br>
     * 2. Existe un jugador con el alias dado, pero con otra contraseña.<br>
     * 3. No existe un jugador con el alias dado.
     */
    public void testConsultarRegistroJugador( )
    {
        // Configuración básica
        setupEscenario1( );

        // 1
        try
        {
            RegistroJugador jugador = administrador.consultarRegistroJugador( "pw123", "Misty" );
            assertEquals( "El alias del jugador es incorrecto", "Misty", jugador.darAlias() );
            assertEquals( "El número de encuentros ganados es incorrecto", 1, jugador.darBatallasGanadas( ) );
            assertEquals( "El número de encuentros perdidos es incorrecto", 2, jugador.darBatallasPerdidas( ) );
        }
        catch( Exception e )
        {
            fail( "No se debería lanzar una excepción" );
        }

        // 2
        try
        {
            RegistroJugador jugador = administrador.consultarRegistroJugador( "contra", "Misty" );
            fail( "Debería lanzar una excepción el jugador no está registrado." );
        }
        catch( Exception e )
        {
            // Debería pasar por aquí.
        }

        // 3
        try
        {
            RegistroJugador jugador = administrador.consultarRegistroJugador( "contra", "Misty23" );
            fail( "Debería lanzar una excepción el jugador no está registrado." );
        }
        catch( Exception e )
        {
            // Debería pasar por aquí.
        }
    }

    /**
     * Prueba 3: Verifica el método crearRegistroJugador.<br>
     * <b> Métodos a probar: </b> <br>
     * crearRegistroJugador. <br>
     * <b> Casos de prueba: </b> <br>
     * 1. No existe un jugador con el alias dado.<br>
     * 2. Existe un jugador con el alias dado.
     * 
     */
    public void testCrearRegistroJugador( )
    {
        // Configuración básica
        setupEscenario1( );

        // 1
        try
        {
            RegistroJugador jugador = administrador.crearRegistroJugador( "Brock", "Edgar", "Bros", "thebest123" );
            assertEquals( "El alias del jugador es incorrecto.", "Brock", jugador.darAlias( ) );
            assertEquals( "El número de batallas ganadas es incorrecto.", 0, jugador.darBatallasGanadas( ) );
            assertEquals( "El número de batallas perdidas es incorrecto.", 0, jugador.darBatallasPerdidas( ) );

            // Modificar el jugador
            administrador.registrarVictoria( "Brock" );

            // Consultar nuevamente el jugador para verificar que se creó un registro
            jugador = administrador.consultarRegistroJugador( "thebest123", "Brock" );
            assertEquals( "El alias del jugador es incorrecto", "Brock", jugador.darAlias( ) );
            assertEquals( "El número de encuentros ganados es incorrecto", 1, jugador.darBatallasGanadas( ) );
            assertEquals( "El número de encuentros perdidos es incorrecto", 0, jugador.darBatallasPerdidas( ) );
        }
        catch( Exception e )
        {
            fail( "No se debería lanzar una excepción" );
        }
        
     // 1
        try
        {
            RegistroJugador jugador = administrador.crearRegistroJugador( "Brock", "Mario", "Bros", "123" );
            fail( "Debería lanzar una excepción, existe un jugador con el alias dado." );


        }
        catch( Exception e )
        {
            //Debería pasar por aquí.
        }
    }

    /**
     * Prueba 4: Verifica el método registrarVictoria. <br>
     * <b> Métodos a probar: </b> <br>
     * registrarVictoria. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Se registra una victoria.
     */
    public void testRegistrarVictoria( )
    {
        // Configuración básica
        setupEscenario1( );

        try
        {
            // Modificar el jugador
            administrador.registrarVictoria( "Misty" );

            // Consultar el jugador para verificar que se modificó el registro
            RegistroJugador jugador = administrador.consultarRegistroJugador( "pw123", "Misty" );
            assertEquals( "El alias del jugador es incorrecto", "Misty", jugador.darAlias( ) );
            assertEquals( "El número de encuentros ganados es incorrecto", 2, jugador.darBatallasGanadas( ) );
            assertEquals( "El número de encuentros perdidos es incorrecto", 2, jugador.darBatallasPerdidas( ) );
        }
        catch( Exception e )
        {
            fail( "No se debería lanzar una excepción" );
        }
    }

    /**
     * Prueba 5: Verifica el método registrarDerrota. <br>
     * <b> Métodos a probar: </b> <br>
     * registrarDerrota. <br>
     * <b> Casos de prueba: </b> <br>
     * 1. Se registra una derrota.
     */
    public void testRegistrarDerrota( )
    {
        // Configuración básica
        setupEscenario1( );

        try
        {
            // Modificar el jugador
            administrador.registrarDerrota( "Misty" );

            // Consultar el jugador para verificar que se modificó el registro
            RegistroJugador jugador = administrador.consultarRegistroJugador( "pw123", "Misty" );
            assertEquals( "El alias del jugador es incorrecto", "Misty", jugador.darAlias( ) );
            assertEquals( "El número de encuentros ganados es incorrecto", 1, jugador.darBatallasGanadas( ) );
            assertEquals( "El número de encuentros perdidos es incorrecto", 3, jugador.darBatallasPerdidas( ) );
        }
        catch( Exception e )
        {
            fail( "No se debería lanzar una excepción" );
        }
    }

}
