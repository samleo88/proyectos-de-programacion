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

import java.util.ArrayList;

import junit.framework.TestCase;
import uniandes.cupi2.batallaPokemon.cliente.mundo.*;

/**
 * Clase que verifica los m�todos de la clase Jugador.
 */
public class JugadorTest extends TestCase
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Jugador donde se har�n las pruebas.
     */
    private Jugador jugador;

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Escenario 1: Construye un jugador sin datos y sin pok�mon seleccionados.
     */
    private void setupEscenario1( )
    {
        jugador = new Jugador( );
    }

    /**
     * Escenario 1: Construye un jugador con datos y con pok�mon seleccionados.
     */
    private void setupEscenario2( )
    {
        setupEscenario1( );

        jugador = new Jugador( );
        jugador.modificarAlias( "Pika" );
        jugador.modificarNombreJugador( "Pikach�" );
        jugador.modificarApellidos( "Rodr�guez" );
        jugador.modificarImagenAvatar( "imagePika" );
        jugador.modificarContrasenia( "123456" );
        jugador.modificarCantidadDerrotas( 5 );
        jugador.modificarCantidadVictorias( 7 );

        ArrayList pokemonSeleccionados = new ArrayList( );
        pokemonSeleccionados.add( new Pokemon( Pokemon.TIPO_AGUA, "Wartortle", "imagenWartortle" ) );
        pokemonSeleccionados.add( new Pokemon( Pokemon.TIPO_FUEGO, "Charizard", "imagenCharizard" ) );
        pokemonSeleccionados.add( new Pokemon( Pokemon.TIPO_ELECTRICO, "Raichu", "imagenRaichu" ) );
        pokemonSeleccionados.add( new Pokemon( Pokemon.TIPO_FUEGO, "Charmander", "imagenCharmander" ) );
        
        jugador.ingresarPokemones( pokemonSeleccionados );

    }

    /**
     * Prueba 1: Verifica el constructor de la clase Jugador. <br>
     * <b> M�todos a probar: </b> <br>
     * Jugador <br>
     * darPokemonesJugador <br>
     * <b> Casos de prueba: </b> <br>
     * 1. El jugador no tiene informaci�n.
     */
    public void testJugador1( )
    {
        setupEscenario1( );

        assertNotNull( "La lista de pok�mon deber�a estar inicializado", jugador.darPokemonesJugador( ) );

    }

    /**
     * Prueba 2: Verifica el constructor de la clase Jugador. <br>
     * <b> M�todos a probar: </b> <br>
     * modificarAlias<br>
     * modificarNombreJugador<br>
     * modificarApellidos<br>
     * modificarImagenAvatar<br>
     * modificarContrasenia<br>
     * modificarCantidadDerrotas<br>
     * modificarCantidadVictorias<br>
     * darAlias <br>
     * darNombreJugador <br>
     * darApellidosJugador<br>
     * darImagenAvatar <br>
     * darContrasenia <br>
     * darCantidadDerrotas<br>
     * darCantidadVictorias<br>
     * <b> Casos de prueba: </b> <br>
     * 1. El no tiene informaci�n inicial. <br>
     * 2. El jugador tiene informaci�n inicial
     */
    public void testModificar( )
    {
        setupEscenario2( );

        assertEquals( "El alias del jugador no corresponde.", "Pika", jugador.darAlias( ) );
        assertEquals( "El nombre del jugador no corresponde.", "Pikach�", jugador.darNombreJugador( ) );
        assertEquals( "El nombre del jugador no corresponde.", "Rodr�guez", jugador.darApellidosJugador( ) );
        assertEquals( "La contrase�a no corresponde.", "123456", jugador.darContrasenia( ) );
        assertEquals( "La imagen avatar del jugador no corresponde.", "imagePika", jugador.darImagenAvatar( ) );
        assertEquals( "La cantidad de derrotas no corresponde.", 5, jugador.darCantidadDerrotas( ) );
        assertEquals( "La cantidadde victorias no corresponde.", 7, jugador.darCantidadVictorias( ) );

        jugador.modificarAlias( "Ash" );
        jugador.modificarNombreJugador( "Ash A." );
        jugador.modificarApellidos( "Ketchum" );
        jugador.modificarImagenAvatar( "imageAsh" );
        jugador.modificarContrasenia( "54316" );
        jugador.modificarCantidadDerrotas( 10 );
        jugador.modificarCantidadVictorias( 0 );

        assertEquals( "El alias del jugador no corresponde.", "Ash", jugador.darAlias( ) );
        assertEquals( "El nombre del jugador no corresponde.", "Ash A.", jugador.darNombreJugador( ) );
        assertEquals( "El nombre del jugador no corresponde.", "Ketchum", jugador.darApellidosJugador( ) );
        assertEquals( "La contrase�a no corresponde.", "54316", jugador.darContrasenia( ) );
        assertEquals( "La imagen avatar del jugador no corresponde.", "imageAsh", jugador.darImagenAvatar( ) );
        assertEquals( "La cantidad de derrotas no corresponde.", 10, jugador.darCantidadDerrotas( ) );
        assertEquals( "La cantidadde victorias no corresponde.", 0, jugador.darCantidadVictorias( ) );

    }

    /**
     * Prueba 3: Verifica el m�todo ingresarPokemones. <br>
     * <b> M�todos a probar: </b> <br>
     * ingresarPokemones <br>
     * <b> Casos de prueba: </b> <br>
     * 1. El jugador no tiene ning�n pok�mon.
     */
    public void testIngresarPokemones( )
    {
        setupEscenario1( );
        ArrayList pokemonSeleccionados = new ArrayList( );
        pokemonSeleccionados.add( new Pokemon( Pokemon.TIPO_AGUA, "Wartortle", "imagenWartortle" ) );
        pokemonSeleccionados.add( new Pokemon( Pokemon.TIPO_FUEGO, "Charizard", "imagenCharizard" ) );
        pokemonSeleccionados.add( new Pokemon( Pokemon.TIPO_ELECTRICO, "Raichu", "imagenRaichu" ) );

        jugador.ingresarPokemones( pokemonSeleccionados );
        assertEquals( "El n�mero de pok�mon del jugador no corresponde.", 3, jugador.darPokemonesJugador( ).size( ) );
        Pokemon pokemon = ( Pokemon )jugador.darPokemonesJugador( ).get( 0 );
        assertEquals( "El pok�mon no es el esperado", "Wartortle", pokemon.darNombre( ) );
        pokemon = ( Pokemon )jugador.darPokemonesJugador( ).get( 1 );
        assertEquals( "El pok�mon no es el esperado", "Charizard", pokemon.darNombre( ) );
        pokemon = ( Pokemon )jugador.darPokemonesJugador( ).get( 2 );
        assertEquals( "El pok�mon no es el esperado", "Raichu", pokemon.darNombre( ) );
    }

    /**
     * Prueba 4: Verifica el m�todo darCantidadPokemonesDebilitados. <br>
     * <b> M�todos a probar: </b> <br>
     * darCantidadPokemonesDebilitados <br>
     * darPokemonesJugador<br>
     * descontarSalud<br>
     * modificarSalud<br>
     * <b> Casos de prueba: </b> <br>
     * 1. El jugador no tiene ning�n pok�mon debilitado.<br>
     * 2. El jugador tiene un pok�mon debilitado. 3. El jugador tiene 3 pok�mon debilitados
     */
    public void testDarCantidadPokemonesDebilitados( )
    {
        setupEscenario2( );

        Pokemon pokemon1 = ( Pokemon )jugador.darPokemonesJugador( ).get( 0 );
        pokemon1.descontarSalud( 13 );

        // 1
        assertEquals( "Ning�n pok�mon deber�a estar debilitado.", 0, jugador.darCantidadPokemonesDebilitados( ) );

        // 2
        pokemon1.descontarSalud( 17 );
        assertEquals( "Un pok�mon deber�a estar debilitado.", 1, jugador.darCantidadPokemonesDebilitados( ) );

        // 3
        pokemon1 = ( Pokemon )jugador.darPokemonesJugador( ).get( 3 );
        pokemon1.descontarSalud( 30 );

        pokemon1 = ( Pokemon )jugador.darPokemonesJugador( ).get( 1 );
        pokemon1.modificarSalud( 0 );

        assertEquals( "Tres pok�mon deber�an estar debilitados.", 3, jugador.darCantidadPokemonesDebilitados( ) );

    }

}
