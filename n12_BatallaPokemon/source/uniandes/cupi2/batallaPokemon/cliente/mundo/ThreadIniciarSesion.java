/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogot? - Colombia)
 * Departamento de Ingenier?a de Sistemas y Computaci?n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n12_batallaPokemon
 * Autor: Equipo Cupi2 2016
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.cupi2.batallaPokemon.cliente.mundo;

import uniandes.cupi2.batallaPokemon.cliente.interfaz.*;

/**
 * Esta clase implementa lo que se debe hacer en un hilo de ejecuci?n cuando se quiere conectar al cliente con el servidor.
 */
public class ThreadIniciarSesion extends Thread
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Referencia a la batalla.
     */
    private Batalla batalla;

    /**
     * Ventana principal de la aplicaci?n
     */
    private InterfazBatallaPokemon principal;

    /**
     * Alias que utilizar? el jugador.
     */
    private String alias;

    /**
     * Password del jugador.
     */
    private String password;

    /**
     * Direcci?n para localizar al servidor.
     */
    private String servidor;

    /**
     * Puerto a trav?s del cual se realizar? la conexi?n con el servidor.
     */
    private int puerto;

    /**
     * Avatar que utilizar? el jugador.
     */
    private String avatar;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el nuevo hilo y lo deja listo para conectarse al servidor.
     * @param pBatalla Batalla actual. pBatalla != null.
     * @param pInterfaz Ventana principal de la aplicaci?n. pInterfaz != null.
     * @param pDireccionServidor Direcci?n para localizar al servidor. pDireccionServidor != null.
     * @param pPuertoServidor Puerto a trav?s del cual se realizar? la conexi?n con el servidor. pPuertoServidor != null && pPuertoServidor != "".
     * @param pAlias Alias que utilizar? el jugador. pAlias != null && pAlias != "".
     * @param pPassword Contrase?a que utilizar? el jugador. pPassword != null && pPassword != "".
     * @param pAvatar Avatar que usar? el jugador. pAvatar != null && pAvatar != "".
     */
    public ThreadIniciarSesion( Batalla pBatalla, InterfazBatallaPokemon pInterfaz, String pDireccionServidor, int pPuertoServidor, String pAlias, String pPassword, String pAvatar )
    {
        batalla = pBatalla;
        password = pPassword;
        principal = pInterfaz;
        servidor = pDireccionServidor;
        puerto = pPuertoServidor;
        alias = pAlias;
        avatar = pAvatar;
    }

    // -----------------------------------------------------------------
    // M?todos
    // -----------------------------------------------------------------

    /**
     * Inicia la ejecuci?n del hilo que realiza la conexi?n con el servidor, dispara la selecci?n de los pok?mon e incializa la batalla.<br>
     * Cuando se tiene la conexi?n y la informaci?n de la batalla entonces se actualiza la interfaz.
     */
    public void run( )
    {
        try
        {
            batalla.iniciarSesion( servidor, puerto, alias, password, avatar );
            principal.seleccionarPokemon( );
            batalla.enviarDatosAOponente( );
            batalla.leerPokemonSeleccionado( );
            principal.actualizarInterfaz( );
            principal.actualizarDatosOponente( );

            if( batalla.darEstadoJuego( ) == Batalla.ESPERANDO_OPONENTE )
            {
                principal.esperarJugada( );
            }

        }
        catch( BatallaPokemonException e )
        {
            principal.mostrarError( e );
            principal.mostrarDialogoInicio( );
        }

    }
}
