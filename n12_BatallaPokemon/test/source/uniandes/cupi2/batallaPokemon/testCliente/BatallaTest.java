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

package uniandes.cupi2.batallaPokemon.testCliente;

import junit.framework.TestCase;
import uniandes.cupi2.batallaPokemon.cliente.mundo.*;

/**
 * Clase usada para verificar que los m�todos de la clase Batalla est�n correctamente implementados.
 */
public class BatallaTest extends TestCase
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Batalla sobre la que se har�n las pruebas.
     */
    private Batalla batalla;

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Escenario 1: Construye una batalla.
     */
    private void setupEscenario1( )
    {
        try
        {
            batalla = new Batalla( );
        }
        catch( BatallaPokemonException e )
        {
            fail( "No deber�a generar excepci�n" );
        }
    }

    /**
     * Prueba 1: Verifica el constructor de la clase Batalla. <br>
     * <b> M�todos a probar: </b> <br>
     * Batalla <br>
     * darPokemonSeleccionado <br>
     * darPokemonSeleccionadoOponente <br>
     * darJugador<br>
     * darOponente<br>
     * darPokemonDisponibles<br>
     * <b> Casos de prueba: </b> <br>
     * 1. Se crea una batalla.
     */
    public void testBatalla( )
    {
        setupEscenario1( );

        assertNull( "El jugador no deber�a tener un pok�mon seleccionado.", batalla.darPokemonSeleccionado( ) );
        assertNull( "El oponente no deber�a tener un pok�mon seleccionado.", batalla.darPokemonSeleccionadoOponente( ) );
        assertNotNull( "El jugador deber�a estar inicializado.", batalla.darJugador( ) );
        assertNotNull( "El jugador deber�a estar inicializado.", batalla.darOponente( ) );

        Pokemon[] lista = batalla.darPokemonDisponibles( );
        assertNotNull( "La lista de pok�mon del jugador deber�a estar inicializada.", lista );
        assertEquals( "La lista deber�a tener 8 pok�mon.", 8, lista.length );
    }

    /**
     * Prueba 2: Verifica el m�todo modificarPokemonSeleccionadoOponente<br>
     * <b>M�todos a probar:<b><br>
     * modificarPokemonSeleccionadoOponente<br>
     * <b>Casos de prueba:<b><br>
     * El oponente no tiene un pok�mon seleccionado.<br>
     * El oponente ya tiene un pok�mon seleccionado.
     */
    public void testModificarPokemonSeleccionadoOponente( )
    {
        setupEscenario1( );
        
        //1
        batalla.modificarPokemonSeleccionadoOponente( "Charmander" );
        assertNotNull( "No modific� el pok�mon del oponente.", batalla.darPokemonSeleccionadoOponente( ) );
        assertEquals("El pok�mon del oponente no es el esperado.", "Charmander", batalla.darPokemonSeleccionadoOponente( ).darNombre( ));
        
        //
        batalla.modificarPokemonSeleccionadoOponente( "Pidgey" );
        assertEquals("El pok�mon del oponente no es el esperado.", "Pidgey", batalla.darPokemonSeleccionadoOponente( ).darNombre( ));
      
    }

    /**
     * Prueba 3: Verifica el m�todo modificarPokemonSeleccionado<br>
     * <b>M�todos a probar:<b><br>
     * modificarPokemonSeleccionado<br>
     * <b>Casos de prueba:<b><br>
     * El jugador no tiene un pok�mon seleccionado.<br>
     * El jugador ya tiene un pok�mon seleccionado.
     */
    public void testModificarPokemonSeleccionado( )
    {
        setupEscenario1( );
        
        //1
        batalla.modificarPokemonSeleccionadoOponente( "Charmander" );
        assertNotNull( "No modific� el pok�mon del oponente.", batalla.darPokemonSeleccionadoOponente( ) );
        assertEquals("El pok�mon del oponente no es el esperado.", "Charmander", batalla.darPokemonSeleccionadoOponente( ).darNombre( ));
        
        //2
        batalla.modificarPokemonSeleccionadoOponente( "Pidgey" );
        assertEquals("El pok�mon del oponente no es el esperado.", "Pidgey", batalla.darPokemonSeleccionadoOponente( ).darNombre( ));
      
    }
}
