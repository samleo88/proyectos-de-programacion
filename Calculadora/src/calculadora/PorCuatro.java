/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;

/**
 *
 * @author tata7
 */
public class PorCuatro extends javax.swing.JFrame {

    /**
     * Creates new form PorCuatro
     */
    public PorCuatro() {
        initComponents();
        this.setLocationRelativeTo(null);
        
    }
    EjecutarCu ps=new EjecutarCu();

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToggleButton1 = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        a = new javax.swing.JTextField();
        b = new javax.swing.JTextField();
        c = new javax.swing.JTextField();
        d = new javax.swing.JTextField();
        q = new javax.swing.JTextField();
        e = new javax.swing.JTextField();
        f = new javax.swing.JTextField();
        g = new javax.swing.JTextField();
        h = new javax.swing.JTextField();
        r = new javax.swing.JTextField();
        i = new javax.swing.JTextField();
        j = new javax.swing.JTextField();
        k = new javax.swing.JTextField();
        l = new javax.swing.JTextField();
        s = new javax.swing.JTextField();
        m = new javax.swing.JTextField();
        n = new javax.swing.JTextField();
        o = new javax.swing.JTextField();
        p = new javax.swing.JTextField();
        t = new javax.swing.JTextField();
        rx = new javax.swing.JLabel();
        ry = new javax.swing.JLabel();
        rz = new javax.swing.JLabel();
        rw = new javax.swing.JLabel();
        Menu = new javax.swing.JButton();
        Limpiar = new javax.swing.JButton();
        Salir = new javax.swing.JButton();
        X1 = new javax.swing.JLabel();
        X2 = new javax.swing.JLabel();
        X3 = new javax.swing.JLabel();
        X4 = new javax.swing.JLabel();
        resul = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        X5 = new javax.swing.JLabel();
        X6 = new javax.swing.JLabel();
        X7 = new javax.swing.JLabel();
        X8 = new javax.swing.JLabel();
        Resolver = new javax.swing.JButton();
        fondo = new javax.swing.JLabel();

        jToggleButton1.setText("jToggleButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 21)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Calculadora de Matrices");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, -1, -1));

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Por metodo: Regla de Cramer");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, -1, -1));

        a.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        a.setMargin(new java.awt.Insets(3, 3, 3, 3));
        getContentPane().add(a, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 40, 40));

        b.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        b.setMargin(new java.awt.Insets(3, 3, 3, 3));
        getContentPane().add(b, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, 40, 40));

        c.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        c.setMargin(new java.awt.Insets(3, 3, 3, 3));
        getContentPane().add(c, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 120, 40, 40));

        d.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        d.setMargin(new java.awt.Insets(3, 3, 3, 3));
        d.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dActionPerformed(evt);
            }
        });
        getContentPane().add(d, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 120, 40, 40));
        d.getAccessibleContext().setAccessibleDescription("");

        q.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        getContentPane().add(q, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 120, 40, 40));

        e.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        e.setMargin(new java.awt.Insets(3, 3, 3, 3));
        getContentPane().add(e, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, 40, 40));

        f.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        f.setMargin(new java.awt.Insets(3, 3, 3, 3));
        getContentPane().add(f, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, 40, 40));

        g.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        g.setMargin(new java.awt.Insets(3, 3, 3, 3));
        getContentPane().add(g, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 170, 40, 40));

        h.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        h.setMargin(new java.awt.Insets(3, 3, 3, 3));
        getContentPane().add(h, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 170, 40, 40));

        r.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        r.setMargin(new java.awt.Insets(3, 3, 3, 3));
        r.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rActionPerformed(evt);
            }
        });
        getContentPane().add(r, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 170, 40, 40));

        i.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        i.setMargin(new java.awt.Insets(3, 3, 3, 3));
        getContentPane().add(i, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 220, 40, 40));

        j.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        j.setMargin(new java.awt.Insets(3, 3, 3, 3));
        getContentPane().add(j, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 220, 40, 40));

        k.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        k.setMargin(new java.awt.Insets(3, 3, 3, 3));
        getContentPane().add(k, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 220, 40, 40));

        l.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        l.setMargin(new java.awt.Insets(3, 3, 3, 3));
        getContentPane().add(l, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 220, 40, 40));

        s.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        s.setMargin(new java.awt.Insets(3, 3, 3, 3));
        getContentPane().add(s, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 220, 40, 40));

        m.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        m.setMargin(new java.awt.Insets(3, 3, 3, 3));
        getContentPane().add(m, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 270, 40, 40));

        n.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        n.setMargin(new java.awt.Insets(3, 3, 3, 3));
        getContentPane().add(n, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 270, 40, 40));

        o.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        o.setMargin(new java.awt.Insets(3, 3, 3, 3));
        getContentPane().add(o, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 270, 40, 40));

        p.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        p.setMargin(new java.awt.Insets(3, 3, 3, 3));
        getContentPane().add(p, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 270, 40, 40));

        t.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        t.setMargin(new java.awt.Insets(3, 3, 3, 3));
        getContentPane().add(t, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 270, 40, 40));

        rx.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        rx.setForeground(new java.awt.Color(255, 255, 255));
        rx.setText("0");
        getContentPane().add(rx, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 350, -1, -1));

        ry.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        ry.setForeground(new java.awt.Color(255, 255, 255));
        ry.setText("0");
        getContentPane().add(ry, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 350, -1, -1));

        rz.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        rz.setForeground(new java.awt.Color(255, 255, 255));
        rz.setText("0");
        getContentPane().add(rz, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 350, -1, 20));

        rw.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        rw.setForeground(new java.awt.Color(255, 255, 255));
        rw.setText("0");
        getContentPane().add(rw, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 350, -1, 20));

        Menu.setBackground(new java.awt.Color(0, 51, 102));
        Menu.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Menu.setForeground(new java.awt.Color(204, 255, 255));
        Menu.setText("Menu");
        Menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuActionPerformed(evt);
            }
        });
        getContentPane().add(Menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 330, 80, 25));

        Limpiar.setBackground(new java.awt.Color(0, 51, 102));
        Limpiar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Limpiar.setForeground(new java.awt.Color(204, 255, 255));
        Limpiar.setText("Limpiar");
        Limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LimpiarActionPerformed(evt);
            }
        });
        getContentPane().add(Limpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 300, 80, 25));

        Salir.setBackground(new java.awt.Color(0, 51, 102));
        Salir.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Salir.setForeground(new java.awt.Color(204, 255, 255));
        Salir.setText("Salir");
        Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirActionPerformed(evt);
            }
        });
        getContentPane().add(Salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 360, 80, 25));

        X1.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 18)); // NOI18N
        X1.setForeground(new java.awt.Color(255, 255, 255));
        X1.setText("W:");
        getContentPane().add(X1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 350, -1, 20));

        X2.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 18)); // NOI18N
        X2.setForeground(new java.awt.Color(255, 255, 255));
        X2.setText("Y");
        getContentPane().add(X2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, -1, -1));

        X3.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 18)); // NOI18N
        X3.setForeground(new java.awt.Color(255, 255, 255));
        X3.setText("Z");
        getContentPane().add(X3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 90, -1, -1));

        X4.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 18)); // NOI18N
        X4.setForeground(new java.awt.Color(255, 255, 255));
        X4.setText("W");
        getContentPane().add(X4, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 90, -1, -1));

        resul.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 18)); // NOI18N
        resul.setForeground(new java.awt.Color(255, 255, 255));
        resul.setText("B");
        getContentPane().add(resul, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 90, -1, -1));

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("El resultado es:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, -1, -1));

        X5.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 18)); // NOI18N
        X5.setForeground(new java.awt.Color(255, 255, 255));
        X5.setText("X");
        getContentPane().add(X5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, -1, -1));

        X6.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 18)); // NOI18N
        X6.setForeground(new java.awt.Color(255, 255, 255));
        X6.setText("X:");
        getContentPane().add(X6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, -1, 20));

        X7.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 18)); // NOI18N
        X7.setForeground(new java.awt.Color(255, 255, 255));
        X7.setText("Y:");
        getContentPane().add(X7, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 350, -1, 20));

        X8.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 18)); // NOI18N
        X8.setForeground(new java.awt.Color(255, 255, 255));
        X8.setText("Z:");
        getContentPane().add(X8, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 350, -1, 20));

        Resolver.setBackground(new java.awt.Color(0, 51, 102));
        Resolver.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Resolver.setForeground(new java.awt.Color(204, 255, 255));
        Resolver.setText("Resolver");
        Resolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResolverActionPerformed(evt);
            }
        });
        getContentPane().add(Resolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 270, 80, 25));

        fondo.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 18)); // NOI18N
        fondo.setForeground(new java.awt.Color(255, 255, 255));
        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/calculadora/fondo05.jpg"))); // NOI18N
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void dActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dActionPerformed

    private void MenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuActionPerformed
        this.setVisible(false);
        Menu v=new Menu();
        v.setVisible(true);
        v.setTitle("Calculadora Matriz");
        
    }//GEN-LAST:event_MenuActionPerformed

    private void LimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LimpiarActionPerformed
        a.setText(null);
        b.setText(null);
        c.setText(null);
        d.setText(null);
        e.setText(null);
        f.setText(null);
        g.setText(null);
        h.setText(null);
        i.setText(null);
        j.setText(null);
        k.setText(null);
        l.setText(null);
        m.setText(null);
        n.setText(null);
        o.setText(null);
        p.setText(null);
        q.setText(null);
        r.setText(null);
        s.setText(null);
        t.setText(null);
        rx.setText("0");
        ry.setText("0");
        rz.setText("0");
        rw.setText("0");
    }//GEN-LAST:event_LimpiarActionPerformed

    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_SalirActionPerformed

    private void rActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rActionPerformed

    private void ResolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResolverActionPerformed
       ps.Capturardatos();
       ps.imprimir();
    }//GEN-LAST:event_ResolverActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PorCuatro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PorCuatro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PorCuatro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PorCuatro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PorCuatro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Limpiar;
    private javax.swing.JButton Menu;
    private javax.swing.JButton Resolver;
    private javax.swing.JButton Salir;
    private javax.swing.JLabel X1;
    private javax.swing.JLabel X2;
    private javax.swing.JLabel X3;
    private javax.swing.JLabel X4;
    private javax.swing.JLabel X5;
    private javax.swing.JLabel X6;
    private javax.swing.JLabel X7;
    private javax.swing.JLabel X8;
    public static javax.swing.JTextField a;
    public static javax.swing.JTextField b;
    public static javax.swing.JTextField c;
    public static javax.swing.JTextField d;
    public static javax.swing.JTextField e;
    public static javax.swing.JTextField f;
    private javax.swing.JLabel fondo;
    public static javax.swing.JTextField g;
    public static javax.swing.JTextField h;
    public static javax.swing.JTextField i;
    public static javax.swing.JTextField j;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JToggleButton jToggleButton1;
    public static javax.swing.JTextField k;
    public static javax.swing.JTextField l;
    public static javax.swing.JTextField m;
    public static javax.swing.JTextField n;
    public static javax.swing.JTextField o;
    public static javax.swing.JTextField p;
    public static javax.swing.JTextField q;
    public static javax.swing.JTextField r;
    private javax.swing.JLabel resul;
    public static javax.swing.JLabel rw;
    public static javax.swing.JLabel rx;
    public static javax.swing.JLabel ry;
    public static javax.swing.JLabel rz;
    public static javax.swing.JTextField s;
    public static javax.swing.JTextField t;
    // End of variables declaration//GEN-END:variables
}
