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
 * Clase que verifica la correcta implementación de la clase Pokémon.
 */
public class PokemonTest extends TestCase
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Pokémon sobre el que se harán las pruebas.
     */
    private Pokemon pokemon;

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Escenario 1: Crea un nuevo pokémon.
     */
    private void setupEscenario1( )
    {
        pokemon = new Pokemon( Pokemon.TIPO_FUEGO, "Growlithe", "imagen.png" );

    }

    /**
     * Prueba 1: Verifica el constructor de la clase Pokémon. <br>
     * <b> Métodos a probar: </b> <br>
     * Pokémon <br>
     * <b> Casos de prueba: </b> <br>
     * 1. Se crea el pokémon correctamente.
     */
    public void testPokemon( )
    {
        setupEscenario1( );

        assertEquals( "El nombre del pokémon no corresponde.", "Growlithe", pokemon.darNombre( ) );
        assertEquals( "El tipo del pokémon no corresponde.", Pokemon.TIPO_FUEGO, pokemon.darTipo( ) );
        assertEquals( "La salud del pokémon no corresponde.", 30.0, pokemon.darSalud( ) );
        assertEquals( "La imagen del pokémon no corresponde", "imagen.png", pokemon.darRutaImagen( ) );
    }

    /**
     * Prueba 2: Verifica el método descontarSalud. <br>
     * <b> Métodos a probar: </b> <br>
     * descontarSalud <br>
     * darSalud <br>
     * <b> Casos de prueba: </b> <br>
     * 1. El pokémon tiene puntos de salud.<br>
     * 2. El pokémon no tiene puntos de salud.
     */
    public void testDescontarSalud( )
    {
        setupEscenario1( );

        // 1
        pokemon.descontarSalud(  15.5 );
        assertEquals( "La salud del pokémon no corresponde, debería ser 4,5.", 14.5, pokemon.darSalud( ) );
        pokemon.descontarSalud( 14.5 );
        assertEquals( "La salud del pokémon no corresponde, debería ser 0.", 0.0, pokemon.darSalud( ) );

        // 2
        pokemon.descontarSalud( 2 );
        assertEquals( "La salud del pokémon no corresponde, debería ser 0.", 0.0, pokemon.darSalud( ) );

    }

    /**
     * Prueba 3: Verifica el método verificarPokemonDebilitado. <br>
     * <b> Métodos a probar: </b> <br>
     * verificarPokemonDebilitado <br>
     * descontarSalud <br>
     * <b> Casos de prueba: </b> <br>
     * 1. Un pokémon tiene puntos de salud.<br>
     * 2. No le quedan puntos de salud al pokémon.
     */
    public void testVerificarPokemonDebilitado( )
    {
        setupEscenario1( );

        // 1
        pokemon.descontarSalud( 15.5 );
        assertFalse( "El pokémon aún tiene salud, no debería ser considerado debilitado.", pokemon.verificarPokemonDebilitado( ) );
        // 2
        pokemon.descontarSalud( 14.5 );
        assertTrue( "El pokémon está debilitado.", pokemon.verificarPokemonDebilitado( ) );

    }
    
    /**
     * Prueba 4: Verifica el método modificarSalud. <br>
     * <b> Métodos a probar: </b> <br>
     * modificarSalud <br>
     * darSalud <br>
     * <b> Casos de prueba: </b> <br>
     * 1. El pokémon tiene puntos de salud.<br>
     */
    public void testModificarSalud( )
    {
        setupEscenario1( );

        // 1
        pokemon.modificarSalud(  15.5 );
        assertEquals( "La salud del pokémon no corresponde, debería ser 15.5.", 15.5, pokemon.darSalud( ) );
        pokemon.modificarSalud( 2 );
        assertEquals( "La salud del pokémon no corresponde, debería ser 2.", 2.0, pokemon.darSalud( ) );

    }
}
