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
 * Esta clase implementa lo que se debe hacer en un hilo de ejecuci?n cuando se quiere enviar una jugada.
 */
public class ThreadEnviarJugada extends Thread
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Referencia a la batalla.
     */
    private Batalla batalla;

    /**
     * Ventana principal de la aplicaci?n.
     */
    private InterfazBatallaPokemon principal;
    
    /**
     * Tipo del pok?mon que realiza el ataque.
     */
    private String tipo;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el nuevo hilo y lo deja listo para enviar la jugada.
     * @param pBatalla Batalla en curso. pBatalla != null.
     * @param pInterfaz Ventana principal de la aplicaci?n. pInterfaz != null.
     * @param pTipo Tipo de pok?mon que realiza el ataque. pTipo != null.
    */
    public ThreadEnviarJugada( Batalla pBatalla, InterfazBatallaPokemon pInterfaz, String pTipo )
    {
        super( );

        batalla = pBatalla;
        principal = pInterfaz;
        tipo= pTipo;
  
    }

    // -----------------------------------------------------------------
    // M?todos
    // -----------------------------------------------------------------

    /**
     * Inicia la ejecuci?n del hilo que realiza el env?o del mensaje y espera la respuesta. <br>
     * Cuando se tiene informaci?n sobre el resultado de la jugada entonces se actualiza la interfaz.<br>
     * Si el juego debe terminar entonces muestra qui?n fue el ganador, termina el encuentro y la conexi?n al servidor.
     */
    public void run( )
    {
        try
        {
            batalla.enviarJugada( tipo );
            principal.actualizarInterfaz( );

            if( batalla.juegoTerminado( ) )
            {
                batalla.terminarEncuentro( );
                principal.actualizarInterfaz( );
                principal.desactivarBotonesJugar( );
                principal.mostrarGanador( );
            }
            else
            {
                principal.esperarJugada( );
            }

        }
        catch( BatallaPokemonException e )
        {
            principal.mostrarError( e );
        }
    }
}
