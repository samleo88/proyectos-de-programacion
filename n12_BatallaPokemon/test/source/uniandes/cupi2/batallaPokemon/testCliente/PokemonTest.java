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
 * Clase que verifica la correcta implementaci�n de la clase Pok�mon.
 */
public class PokemonTest extends TestCase
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Pok�mon sobre el que se har�n las pruebas.
     */
    private Pokemon pokemon;

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Escenario 1: Crea un nuevo pok�mon.
     */
    private void setupEscenario1( )
    {
        pokemon = new Pokemon( Pokemon.TIPO_FUEGO, "Growlithe", "imagen.png" );

    }

    /**
     * Prueba 1: Verifica el constructor de la clase Pok�mon. <br>
     * <b> M�todos a probar: </b> <br>
     * Pok�mon <br>
     * <b> Casos de prueba: </b> <br>
     * 1. Se crea el pok�mon correctamente.
     */
    public void testPokemon( )
    {
        setupEscenario1( );

        assertEquals( "El nombre del pok�mon no corresponde.", "Growlithe", pokemon.darNombre( ) );
        assertEquals( "El tipo del pok�mon no corresponde.", Pokemon.TIPO_FUEGO, pokemon.darTipo( ) );
        assertEquals( "La salud del pok�mon no corresponde.", 30.0, pokemon.darSalud( ) );
        assertEquals( "La imagen del pok�mon no corresponde", "imagen.png", pokemon.darRutaImagen( ) );
    }

    /**
     * Prueba 2: Verifica el m�todo descontarSalud. <br>
     * <b> M�todos a probar: </b> <br>
     * descontarSalud <br>
     * darSalud <br>
     * <b> Casos de prueba: </b> <br>
     * 1. El pok�mon tiene puntos de salud.<br>
     * 2. El pok�mon no tiene puntos de salud.
     */
    public void testDescontarSalud( )
    {
        setupEscenario1( );

        // 1
        pokemon.descontarSalud(  15.5 );
        assertEquals( "La salud del pok�mon no corresponde, deber�a ser 4,5.", 14.5, pokemon.darSalud( ) );
        pokemon.descontarSalud( 14.5 );
        assertEquals( "La salud del pok�mon no corresponde, deber�a ser 0.", 0.0, pokemon.darSalud( ) );

        // 2
        pokemon.descontarSalud( 2 );
        assertEquals( "La salud del pok�mon no corresponde, deber�a ser 0.", 0.0, pokemon.darSalud( ) );

    }

    /**
     * Prueba 3: Verifica el m�todo verificarPokemonDebilitado. <br>
     * <b> M�todos a probar: </b> <br>
     * verificarPokemonDebilitado <br>
     * descontarSalud <br>
     * <b> Casos de prueba: </b> <br>
     * 1. Un pok�mon tiene puntos de salud.<br>
     * 2. No le quedan puntos de salud al pok�mon.
     */
    public void testVerificarPokemonDebilitado( )
    {
        setupEscenario1( );

        // 1
        pokemon.descontarSalud( 15.5 );
        assertFalse( "El pok�mon a�n tiene salud, no deber�a ser considerado debilitado.", pokemon.verificarPokemonDebilitado( ) );
        // 2
        pokemon.descontarSalud( 14.5 );
        assertTrue( "El pok�mon est� debilitado.", pokemon.verificarPokemonDebilitado( ) );

    }
    
    /**
     * Prueba 4: Verifica el m�todo modificarSalud. <br>
     * <b> M�todos a probar: </b> <br>
     * modificarSalud <br>
     * darSalud <br>
     * <b> Casos de prueba: </b> <br>
     * 1. El pok�mon tiene puntos de salud.<br>
     */
    public void testModificarSalud( )
    {
        setupEscenario1( );

        // 1
        pokemon.modificarSalud(  15.5 );
        assertEquals( "La salud del pok�mon no corresponde, deber�a ser 15.5.", 15.5, pokemon.darSalud( ) );
        pokemon.modificarSalud( 2 );
        assertEquals( "La salud del pok�mon no corresponde, deber�a ser 2.", 2.0, pokemon.darSalud( ) );

    }
}
