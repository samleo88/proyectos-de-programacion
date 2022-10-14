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

package uniandes.cupi2.batallaPokemon.cliente.mundo;

import uniandes.cupi2.batallaPokemon.cliente.interfaz.InterfazBatallaPokemon;

/**
 * Clase que representa un hilo de ejecución cuando se cambia de pokémon.
 */
public class ThreadEsperarPokemon extends Thread
{

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Referencia a la batalla.
     */
    private Batalla batalla;

    /**
     * Nombre del pokémon seleccionado.
     */
    private String nombrePokemon;

    /**
     * Ventana principal de la aplicación.
     */
    private InterfazBatallaPokemon principal;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el nuevo hilo y lo deja listo para informarle al oponente el cambio.
     * @param pBatalla Batalla en curso. pBatalla !=null.
     * @param pNombrePokemon Nombre del pokémon seleccionado. pNombrePokemon !=null.
     * @param pPrincipal Ventana principal de la aplicación. pPrincipal !=null.
     */
    public ThreadEsperarPokemon( Batalla pBatalla, String pNombrePokemon, InterfazBatallaPokemon pPrincipal )
    {
        super( );

        batalla = pBatalla;
        nombrePokemon = pNombrePokemon;
        principal = pPrincipal;

    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Inicia la ejecución del hilo que realiza el envío del mensaje para informar que se realizó un cambio. <br>
     * Cuando se tiene información del pokémon que se cambió se actualiza la interfaz.<br>
     */
    public void run( )
    {
        batalla.cambiarPokemon( nombrePokemon );
        principal.actualizarInterfaz( );
        principal.esperarJugada( );

    }

}
