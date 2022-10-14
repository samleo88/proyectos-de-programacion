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
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import uniandes.cupi2.batallaPokemon.cliente.mundo.Pokemon;

/**
 * Panel con la información de batalla del jugador.
 */
public class PanelJugador extends JPanel implements ActionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante con la ruta a las imágenes.
     */
    private final static String RUTA = "./data/imagenes/";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Lista con los pokémon del jugador.
     */
    private ArrayList pokemones;

    /**
     * Pokémon seleccionado.
     */
    private Pokemon pokemonSeleccionado;

    // -----------------------------------------------------------------
    // Atributos de la Interfaz
    // -----------------------------------------------------------------

    /**
     * Etiqueta con la imagen del jugador.
     */
    private JLabel etiquetaImagenJugador;

    /**
     * Etiqueta con la imagen del pokémon seleccionado actualmente.
     */
    private JLabel etiquetaImagenPokemonSeleccionado;

    /**
     * Etiqueta con la salud del pokémon.
     */
    private JLabel etiquetaSaludPokemon;

    /**
     * Panel con los pokémon seleccionados para la batalla.
     */
    private JPanel panelPokemones;

    /**
     * Panel con la imagen y salud del pokémon seleccionado.
     */
    private JPanel panelPokemon;

    /**
     * Botón del pokémon a seleccionar.
     */
    private JButton btnPokemonSeleccionado;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor del panel.
     * @param pImagen Imagen del jugador.
     */
    public PanelJugador( String pImagen )
    {

        setLayout( new BorderLayout( ) );

        etiquetaImagenJugador = new JLabel( );
        // etiquetaImagenJugador.setPreferredSize( new Dimension( 250, 0 ) );
        etiquetaImagenJugador.setHorizontalAlignment( JLabel.CENTER );
        etiquetaImagenJugador.setVerticalAlignment( JLabel.NORTH );
        etiquetaImagenJugador.setIcon( new ImageIcon( RUTA + pImagen + ".PNG" ) );

        add( etiquetaImagenJugador, BorderLayout.WEST );

        panelPokemon = new JPanel( );
        panelPokemon.setLayout( new BorderLayout( ) );
        panelPokemon.setOpaque( false );

        etiquetaSaludPokemon = new JLabel( );
        etiquetaSaludPokemon.setHorizontalAlignment( JLabel.CENTER );
        etiquetaSaludPokemon.setForeground( Color.white );
        etiquetaSaludPokemon.setFont( new Font( "Tahoma", Font.BOLD, 30 ) );

        etiquetaImagenPokemonSeleccionado = new JLabel( );
        etiquetaImagenPokemonSeleccionado.setVerticalAlignment( JLabel.BOTTOM );

        panelPokemon.add( etiquetaImagenPokemonSeleccionado, BorderLayout.CENTER );
        panelPokemon.add( etiquetaSaludPokemon, BorderLayout.SOUTH );

        add( panelPokemon, BorderLayout.EAST );

        panelPokemones = new JPanel( );
        panelPokemones.setLayout( new FlowLayout( FlowLayout.LEFT ) );
        panelPokemones.setOpaque( false );
        add( panelPokemones, BorderLayout.SOUTH );

        setOpaque( false );

    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Retorna el pokémon seleccionado por el jugador.
     * @return Pokémon seleccionado.
     */
    public Pokemon darPokemonSeleccionado( )
    {
        return pokemonSeleccionado;
    }

    /**
     * Actualiza la información del jugador mostrada.
     * @param pPokemones Lista de pokémon del jugador.
     * @param pPokemonSeleccionado Pokémon seleccionado actualmente.
     */
    public void actualizar( ArrayList pPokemones, Pokemon pPokemonSeleccionado )
    {

       pokemones = pPokemones;
        pokemonSeleccionado = pPokemonSeleccionado;
        panelPokemones.removeAll( );
        for( int i = 0; i < pPokemones.size( ); i++ )
        {
            Pokemon pokemon = ( Pokemon )pPokemones.get( i );
            JButton btPokemon = new JButton( );
            btPokemon.setBackground( new Color( 0, 0, 0, 255 ));
            btPokemon.setRolloverEnabled( false );
            btPokemon.setBorder( new LineBorder( Color.ORANGE, 2 ) );
            btPokemon.setPreferredSize( new Dimension( 54, 54 ) );
            btPokemon.setHorizontalAlignment( JLabel.CENTER );
            btPokemon.setVerticalAlignment( JLabel.CENTER );
            btPokemon.addActionListener( this );
            btPokemon.setActionCommand( String.valueOf( i ) );
            btPokemon.setBorderPainted( false );
            String imagen = null;
            if( pokemon.verificarPokemonDebilitado( ) )
            {
                imagen = RUTA + pokemon.darNombre( ) + "MiniaturaInhabilitado.png";
               btPokemon.setEnabled( false );

            }
            else
            {
                imagen = RUTA + pokemon.darNombre( ) + "Miniatura.png";
                btPokemon.setEnabled( true );
            }
            btPokemon.setIcon( new ImageIcon( imagen ) );
            btPokemon.setOpaque( false );
            panelPokemones.add( btPokemon );
            validate( );
            repaint( );

            etiquetaImagenPokemonSeleccionado.setIcon( new ImageIcon( RUTA + pokemonSeleccionado.darNombre( ) + ".PNG" ) );
            etiquetaSaludPokemon.setText( "" + pPokemonSeleccionado.darSalud( ) );
            
        }
        pokemonSeleccionado = null;
    }

    /**
     * Manejo de los eventos de los botones.
     * @param pEvento Acción que generó el evento.
     */
    public void actionPerformed( ActionEvent pEvento )
    {

        int indice = Integer.parseInt( pEvento.getActionCommand( ) );
        JButton source = ( JButton )pEvento.getSource( );

        if( btnPokemonSeleccionado != null )
        {
            if( btnPokemonSeleccionado.equals( source ) )
            {
                btnPokemonSeleccionado.setBorderPainted( false );
                btnPokemonSeleccionado = null;
                pokemonSeleccionado = null;
            }
            else
            {
                btnPokemonSeleccionado.setBorderPainted( false );
                btnPokemonSeleccionado = source;
                source.setBorderPainted( true );
                Pokemon pokemon = ( Pokemon )pokemones.get( indice );
                pokemonSeleccionado = pokemon;
            }
        }
        else
        {
            btnPokemonSeleccionado = source;
            source.setBorderPainted( true );
            Pokemon pokemon = ( Pokemon )pokemones.get( indice );
            pokemonSeleccionado = pokemon;
        }

    }

}
