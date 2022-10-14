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

package uniandes.cupi2.batallaPokemon.testCliente;

import junit.framework.TestCase;
import uniandes.cupi2.batallaPokemon.cliente.mundo.*;

/**
 * Clase usada para verificar que los métodos de la clase Batalla estén correctamente implementados.
 */
public class BatallaTest extends TestCase
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Batalla sobre la que se harán las pruebas.
     */
    private Batalla batalla;

    // -----------------------------------------------------------------
    // Métodos
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
            fail( "No debería generar excepción" );
        }
    }

    /**
     * Prueba 1: Verifica el constructor de la clase Batalla. <br>
     * <b> Métodos a probar: </b> <br>
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

        assertNull( "El jugador no debería tener un pokémon seleccionado.", batalla.darPokemonSeleccionado( ) );
        assertNull( "El oponente no debería tener un pokémon seleccionado.", batalla.darPokemonSeleccionadoOponente( ) );
        assertNotNull( "El jugador debería estar inicializado.", batalla.darJugador( ) );
        assertNotNull( "El jugador debería estar inicializado.", batalla.darOponente( ) );

        Pokemon[] lista = batalla.darPokemonDisponibles( );
        assertNotNull( "La lista de pokémon del jugador debería estar inicializada.", lista );
        assertEquals( "La lista debería tener 8 pokémon.", 8, lista.length );
    }

    /**
     * Prueba 2: Verifica el método modificarPokemonSeleccionadoOponente<br>
     * <b>Métodos a probar:<b><br>
     * modificarPokemonSeleccionadoOponente<br>
     * <b>Casos de prueba:<b><br>
     * El oponente no tiene un pokémon seleccionado.<br>
     * El oponente ya tiene un pokémon seleccionado.
     */
    public void testModificarPokemonSeleccionadoOponente( )
    {
        setupEscenario1( );
        
        //1
        batalla.modificarPokemonSeleccionadoOponente( "Charmander" );
        assertNotNull( "No modificó el pokémon del oponente.", batalla.darPokemonSeleccionadoOponente( ) );
        assertEquals("El pokémon del oponente no es el esperado.", "Charmander", batalla.darPokemonSeleccionadoOponente( ).darNombre( ));
        
        //
        batalla.modificarPokemonSeleccionadoOponente( "Pidgey" );
        assertEquals("El pokémon del oponente no es el esperado.", "Pidgey", batalla.darPokemonSeleccionadoOponente( ).darNombre( ));
      
    }

    /**
     * Prueba 3: Verifica el método modificarPokemonSeleccionado<br>
     * <b>Métodos a probar:<b><br>
     * modificarPokemonSeleccionado<br>
     * <b>Casos de prueba:<b><br>
     * El jugador no tiene un pokémon seleccionado.<br>
     * El jugador ya tiene un pokémon seleccionado.
     */
    public void testModificarPokemonSeleccionado( )
    {
        setupEscenario1( );
        
        //1
        batalla.modificarPokemonSeleccionadoOponente( "Charmander" );
        assertNotNull( "No modificó el pokémon del oponente.", batalla.darPokemonSeleccionadoOponente( ) );
        assertEquals("El pokémon del oponente no es el esperado.", "Charmander", batalla.darPokemonSeleccionadoOponente( ).darNombre( ));
        
        //2
        batalla.modificarPokemonSeleccionadoOponente( "Pidgey" );
        assertEquals("El pokémon del oponente no es el esperado.", "Pidgey", batalla.darPokemonSeleccionadoOponente( ).darNombre( ));
      
    }
}
