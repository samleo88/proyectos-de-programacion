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

package uniandes.cupi2.batallaPokemon.servidor.interfaz;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

/**
 * Panel para el manejo de extensiones.
 */
public class PanelExtensionServidor extends JPanel implements ActionListener
{

    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Representa el comando Opci?n 1.
     */
    private static final String OPCION_1 = "OPCION_1";

    /**
     * Representa el comando Opci?n 2.
     */
    private static final String OPCION_2 = "OPCION_2";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Ventana principal de la aplicaci?n.
     */
    private InterfazServidor principal;

    // -----------------------------------------------------------------
    // Atributos de interfaz
    // -----------------------------------------------------------------

    /**
     * Bot?n Opci?n 1.
     */
    private JButton btnOpcion1;

    /**
     * Bot?n Opci?n 2.
     */
    private JButton btnOpcion2;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor del panel.
     * @param pVentanaPrincipal Ventana principal. pVentanaPrincipal != null.
     */
    public PanelExtensionServidor( InterfazServidor pVentanaPrincipal )
    {
        principal = pVentanaPrincipal;

        setBorder( new TitledBorder( "Opciones" ) );
        setLayout( new GridBagLayout( ) );

        // Bot?n opci?n 1
        btnOpcion1 = new JButton( "Opci?n 1" );
        btnOpcion1.setActionCommand( OPCION_1 );
        btnOpcion1.addActionListener( this );
        GridBagConstraints gbc = new GridBagConstraints( );
        gbc.insets = new Insets( 0, 0, 0, 5 );
        gbc.gridx = 0;
        gbc.gridy = 0;
        add( btnOpcion1, gbc );

        // Bot?n opci?n 2
        btnOpcion2 = new JButton( "Opci?n 2" );
        btnOpcion2.setActionCommand( OPCION_2 );
        btnOpcion2.addActionListener( this );
        gbc.gridx = 1;
        add( btnOpcion2, gbc );

    }

    // -----------------------------------------------------------------
    // M?todos
    // -----------------------------------------------------------------

    /**
     * Manejo de los eventos de los botones.
     * @param pEvento Acci?n que gener? el evento. pEvento != null.
     */
    public void actionPerformed( ActionEvent pEvento )
    {
        String accion=pEvento.getActionCommand( );
        if( OPCION_1.equals( accion ) )
        {
            principal.reqFuncOpcion1( );
        }
        else if( OPCION_2.equals( accion ) )
        {
            principal.reqFuncOpcion2( );
        }

    }
}
