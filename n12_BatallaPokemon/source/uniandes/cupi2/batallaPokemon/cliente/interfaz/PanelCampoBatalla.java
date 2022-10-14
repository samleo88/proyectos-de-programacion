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

package uniandes.cupi2.batallaPokemon.cliente.interfaz;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import uniandes.cupi2.batallaPokemon.cliente.mundo.Batalla;
import uniandes.cupi2.batallaPokemon.cliente.mundo.Jugador;
import uniandes.cupi2.batallaPokemon.cliente.mundo.Pokemon;

/**
 * Panel que maneja la información del campo de batalla.
 * 
 */
public class PanelCampoBatalla extends JPanel
{

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------
    /**
     * Batalla del jugador.
     */
    private Batalla batalla;

    // -----------------------------------------------------------------
    // Atributos de la interfaz
    // -----------------------------------------------------------------

    /**
     * Panel con la información del jugador.
     */
    private PanelJugador panelJugador;

    /**
     * Panel con la información del oponente.
     */
    private PanelOponente panelOponente;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor del panel.
     * @param pPrincipal Ventana principal de la aplicación. pPrincipal != null.
     * @param pBatalla Batalla actual. pJugador != null.
     */
    public PanelCampoBatalla( InterfazBatallaPokemon pPrincipal, Batalla pBatalla )
    {

        setLayout( new BorderLayout( ) );
        setBorder( new TitledBorder( "Campo de batalla" ) );
        setSize( 1060, 580 );

        panelJugador = new PanelJugador( pBatalla.darJugador( ).darImagenAvatar( ) );
        panelOponente = new PanelOponente( );

        add( panelJugador, BorderLayout.WEST );
        add( panelOponente, BorderLayout.EAST );

    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Retorna el pokémon seleccionado actualmente.
     * @return Pokémon seleccionado.
     */
    public Pokemon darPokemonSeleccionado( )
    {
        return panelJugador.darPokemonSeleccionado( );
    }

    /**
     * Actualiza la información del campo de batalla.
     * @param pBatalla Batalla del jugador.
     */
    public void actualizar( Batalla pBatalla )
    {
        batalla = pBatalla;
        panelJugador.actualizar( batalla.darJugador( ).darPokemonesJugador( ), batalla.darPokemonSeleccionado( ) );
        panelOponente.actualizar( batalla.darCantidadPokemonDebilesOponente( ), batalla.darPokemonSeleccionadoOponente( ),batalla.darOponente( ).darImagenAvatar( ) );

    }

    /**
     * Pinta el panel y sus componentes.
     * @param pG Superficie del panel.
     */
    public void paintComponent( Graphics pG )
    {
        ImageIcon icon = new ImageIcon( "./data/imagenes/Pradera.JPG" );
        pG.drawImage( icon.getImage( ), 0, 0, null );
        setOpaque( false );
        super.paintComponent( pG );
    }
}
