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
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Panel con el encabezado.
 */
public class PanelImagen extends JPanel
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante para la serialización.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Constante con la ruta de la imagen.
     */
    public final static String RUTA = "./data/imagenes/Cielo.JPG";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Nombre del oponente.
     */
    private String nombreOponente;

    /**
     * Cantidad de victorias del oponente.
     */
    private String cantidadVictorias;

    /**
     * Cantidad de derrotas del oponente.
     */
    private String cantidadDerrotas;

    // -----------------------------------------------------------------
    // Atributos de interfaz
    // -----------------------------------------------------------------

    /**
     * Etiqueta con la imagen.
     */
    private JLabel etiquetaImagen;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor del panel.
     */
    public PanelImagen( )
    {
        nombreOponente = "";
        cantidadDerrotas = "";
        cantidadVictorias = "";
        setLayout( new BorderLayout( ) );
        setBackground( Color.WHITE );
        setPreferredSize( new Dimension( 800, 90 ) );
        etiquetaImagen = new JLabel( "" );
        etiquetaImagen.setHorizontalAlignment( JLabel.CENTER );
        etiquetaImagen.setVerticalAlignment( JLabel.CENTER );

        add( etiquetaImagen, BorderLayout.CENTER );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Método que pinta la información estadística del oponente.
     * @param pLienzo Lienzo del panel. pLienzo != null.
     */
    public void paintComponent( Graphics pLienzo )
    {
        ImageIcon icon = new ImageIcon( RUTA );
        pLienzo.drawImage( icon.getImage( ), 0, 0, null );
        setOpaque( false );
        pLienzo.setColor( Color.BLACK );
        pLienzo.setFont( new Font( "Arial", Font.BOLD, 13 ) );
        pLienzo.drawString( "Oponente: " + nombreOponente, 20, 25 );
        pLienzo.drawString( "Victorias: "+ cantidadVictorias, 20, 50 );
        pLienzo.drawString( "Derrotas: " + cantidadDerrotas, 20, 75 );
        setOpaque( false );
        super.paintComponent( pLienzo );
    }

    /**
     * Modifica los datos estadísticos del oponente.
     * @param pNombre Nombre del oponente. pNombre != null && pNombre != "".
     * @param pVictorias Cantidad de victorias del oponente. pVictorias>=0.
     * @param pDerrotas Cantidad de derrotas del oponente. pDerrotas>=0.
     */
    public void modificarDatosOponente( String pNombre, String pVictorias, String pDerrotas )
    {
        nombreOponente = pNombre;
        cantidadVictorias = pVictorias;
        cantidadDerrotas = pDerrotas;
        paintComponent( getGraphics( ) );
    }

}
