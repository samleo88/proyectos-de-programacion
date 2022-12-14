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

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Clase que representa un jugador.<br>
 * <b>inv:</b><br>
 * pokemonesJugador != null. No puede haber dos pok?mon con el mismo nombre.
 */
public class Jugador
{

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Nombre del jugador.
     */
    private String nombreJugador;

    /**
     * Apellidos del jugador.
     */
    private String apellidosJugador;

    /**
     * Alias del jugador.
     */
    private String alias;

    /**
     * Contrase?a del jugador.
     */
    private String contrasenia;

    /**
     * Ruta de la imagen del avatar del jugador.
     */
    private String imagenAvatar;

    /**
     * Cantidad de victorias del jugador.
     */
    private int cantidadVictorias;

    /**
     * Cantidad de derrotas del jugador.
     */
    private int cantidadDerrotas;

    /**
     * Lista de pok?mon que tiene el jugador.
     */
    private ArrayList pokemonesJugador;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye un nuevo jugador. <br>
     * <b> post: </b> La lista de de pok?mon fue inicializada.
     */
    public Jugador( )
    {
        pokemonesJugador = new ArrayList( );
        verificarInvariante( );

    }

    // -----------------------------------------------------------------
    // M?todos
    // -----------------------------------------------------------------

    /**
     * Retorna el nombre del jugador.
     * @return Nombre del jugador.
     */
    public String darNombreJugador( )
    {
        return nombreJugador;
    }

    /**
     * Retorna el nombre del jugador.
     * @return Nombre del jugador.
     */
    public String darApellidosJugador( )
    {
        return apellidosJugador;
    }

    /**
     * Retorna el alias del jugador.
     * @return Alias del jugador.
     */
    public String darAlias( )
    {
        return alias;
    }

    /**
     * Retorna la contrase?a del jugador.
     * @return Contrase?a del jugador.
     */
    public String darContrasenia( )
    {
        return contrasenia;
    }

    /**
     * Retorna la ruta de la imagen del avatar del jugador.
     * @return Ruta de la imagen del jugador.
     */
    public String darImagenAvatar( )
    {
        return imagenAvatar;
    }

    /**
     * Retorna la cantidad de victorias del jugador.
     * @return Victorias del jugador.
     */
    public int darCantidadVictorias( )
    {
        return cantidadVictorias;
    }

    /**
     * Retorna la cantidad de derrotas del jugador.
     * @return Derrotas del jugador.
     */
    public int darCantidadDerrotas( )
    {
        return cantidadDerrotas;
    }

    /**
     * Retorna la lista de pok?mon del jugador.
     * @return Lista con los pok?mon del jugador.
     */
    public ArrayList darPokemonesJugador( )
    {
        return pokemonesJugador;
    }

    /**
     * Modifica el nombre del jugador.
     * @param pNombre Nuevo nombre del jugador.
     */
    public void modificarNombreJugador( String pNombre )
    {
        nombreJugador = pNombre;
    }

    /**
     * Modifica los apellidos del jugador.
     * @param pApellidos Nuevos apellidos del jugador.
     */
    public void modificarApellidos( String pApellidos )
    {
        apellidosJugador = pApellidos;
    }

    /**
     * Modifica el alias del jugador.
     * @param pAlias Nuevo alias del jugador.
     */
    public void modificarAlias( String pAlias )
    {
        alias = pAlias;
    }

    /**
     * Modifica la contrase?a del jugador.
     * @param pContrasenia Nueva contrase?a del jugador.
     */
    public void modificarContrasenia( String pContrasenia )
    {
        contrasenia = pContrasenia;
    }

    /**
     * Modifica la cantidad de victorias del jugador.
     * @param pCantidadVictorias Nueva cantidad de victorias del jugador.
     */
    public void modificarCantidadVictorias( int pCantidadVictorias )
    {
        cantidadVictorias = pCantidadVictorias;
    }

    /**
     * Modifica la cantidad de derrotas del jugador.
     * @param pCantidadDerrotas Nueva cantidad de derrotas del jugador.
     */
    public void modificarCantidadDerrotas( int pCantidadDerrotas )
    {
        cantidadDerrotas = pCantidadDerrotas;
    }

    /**
     * Modifica la imagen del avatar del jugador.
     * @param pImagenAvatar Nuevo avatar del jugador.
     */
    public void modificarImagenAvatar( String pImagenAvatar )
    {
        imagenAvatar = pImagenAvatar;
    }

    /**
     * Retorna la cantidad de pok?mon con salud en cero.
     * @return Cantidad de pok?mon debilitados.
     */
    public int darCantidadPokemonesDebilitados( )
    {
        int cantidadPokemonesDebilitados = 0;

        for( int i = 0; i < pokemonesJugador.size( ); i++ )
        {
            double saludPokemon = ( ( Pokemon )pokemonesJugador.get( i ) ).darSalud( );
            if( saludPokemon == 0.0 )
            {
                cantidadPokemonesDebilitados++;
            }
        }

        return cantidadPokemonesDebilitados;

    }
    
    /**
     * Retorna el porcentaje de efectividad del jugador. <br>
     * Se calcula batallasGanadas * 100 / batallasTotales.
     * Si el jugador no ha terminado ning?n encuentro, la efectividad es 0.
     * @return Efectividad del jugador.
     */
    public double darEfectividad( )
    {
        if( cantidadVictorias + cantidadDerrotas > 0 )
            return ( ( double )cantidadVictorias * 100.0 / ( double ) ( cantidadVictorias + cantidadDerrotas ) );
        else
            return 0.0;
    }

    /**
     * Ingresa los pok?mon seleccionados por el jugador.
     * @param pPokemonesSeleccionados Lista de pok?mon.
     * @return Nombre del pok?mon seleccionado inicialmente.
     */
    public String ingresarPokemones( ArrayList pPokemonesSeleccionados )
    {
        for( int i = 0; i < pPokemonesSeleccionados.size( ); i++ )
        {
            Pokemon pokemonSeleccionado = ( Pokemon )(( Pokemon )pPokemonesSeleccionados.get( i ) ).clone( );
            pokemonesJugador.add( pokemonSeleccionado );
        }
        return ( ( Pokemon )pokemonesJugador.get( 0 ) ).darNombre( );
    }
    

    
    /**
     * Retorna una cadena con la informaci?n del jugador.
     * @return Retorna una cadena de la forma <nombre>: <victorias> ganadas / <derrotas> perdidas ( <efectividad>% )
     */
    public String toString( )
    {
        DecimalFormat df = new DecimalFormat( "0.00" );
        String efectividad = df.format( darEfectividad( ) );
        return alias + ": " + cantidadVictorias + " ganadas / " + cantidadDerrotas + " perdidas (" + efectividad + "%)";
    }

    // -----------------------------------------------------------------
    // Invariante
    // -----------------------------------------------------------------

    /**
     * Verifica el invariante de la clase Jugador.<br>
     * <b>inv: </b><br>
     * pokemonesJugador != null.<br>
     * No existen dos pok?mon con el mismo nombre. <br>
     */
    private void verificarInvariante( )
    {
        assert ( pokemonesJugador != null ) : "La lista de pok?mon no puede ser nula.";
        assert ( !hayPokemonRepetidos( ) ) : "No pueden haber dos pok?mon con el mismo nombre.";
    }

    /**
     * Indica si existen o no dos pok?mon con el mismo nombre.
     * @return True si existen dos pok?mon con el mismo nombre, false de lo contrario.
     */
    private boolean hayPokemonRepetidos( )
    {
        boolean existen = false;

        for( int i = 0; i < pokemonesJugador.size( ) && !existen; i++ )
        {
            Pokemon pokemon1 = ( Pokemon )pokemonesJugador.get( i );

            for( int j = 0; j < pokemonesJugador.size( ) && !existen; j++ )
            {
                Pokemon pokemon2 = ( Pokemon )pokemonesJugador.get( j );
                if( pokemon1.darNombre( ).equals( pokemon2.darNombre( ) ) && i != j )
                {
                    existen = true;
                }
            }
        }
        return existen;
    }

}
