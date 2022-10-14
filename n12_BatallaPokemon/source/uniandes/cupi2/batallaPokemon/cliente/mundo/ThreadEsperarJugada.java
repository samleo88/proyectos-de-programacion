/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
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
 * Esta clase implementa lo que se debe hacer en un hilo de ejecuci�n cuando se quiere esperar la jugada del oponente.
 */
public class ThreadEsperarJugada extends Thread
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Referencia a la batalla.
     */
    private Batalla batalla;

    /**
     * Ventana principal de la aplicaci�n.
     */
    private InterfazBatallaPokemon principal;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el nuevo hilo y lo deja listo para esperar la jugada.
     * @param pBatalla Referencia de la batalla. pBatalla != null.
     * @param pInterfaz Ventana principal de la aplicaci�n. pInterfaz != null
     */
    public ThreadEsperarJugada( Batalla pBatalla, InterfazBatallaPokemon pInterfaz )
    {
        super( );
        batalla = pBatalla;
        principal = pInterfaz;
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Inicia la ejecuci�n del hilo que espera la jugada del oponente. <br>
     * Cuando se tiene informaci�n sobre la jugada del oponente entonces se actualiza la interfaz.<br>
     * Si el juego debe terminar entonces muestra qui�n fue el ganador y termina el encuentro y la conexi�n al servidor.
     */
    public void run( )
    {
        try
        {
            batalla.esperarJugada( );
            principal.actualizarInterfaz( );

            if( batalla.juegoTerminado( ) )
            {
                batalla.terminarEncuentro( );
                principal.actualizarInterfaz( );
                principal.desactivarBotonesJugar( );
                principal.mostrarGanador( );
            }
        }
        catch( BatallaPokemonException e )
        {
            principal.mostrarError( e );
        }
    }
}
