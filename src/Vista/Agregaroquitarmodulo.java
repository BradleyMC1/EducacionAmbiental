
package Vista;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import control.ControlAprendizajeActivo;

public class Agregaroquitarmodulo extends javax.swing.JFrame {

    private AprendizajeActivo ventanaPadre;

    public Agregaroquitarmodulo(AprendizajeActivo padre) {
        initComponents();
        this.ventanaPadre = padre;
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    // Constructor vacío por si NetBeans lo usa
    public Agregaroquitarmodulo() {
        this(null);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        DescripcionModuloAA = new javax.swing.JTextField();
        ProgresoAAFinal = new javax.swing.JTextField();
        NumeroModulo = new javax.swing.JTextField();
        ProgresoAAInicial = new javax.swing.JTextField();
        EliminarAA = new javax.swing.JButton();
        AgregarAA = new javax.swing.JButton();
        SalirAA = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Agregar o Quitar Modulo Educativo");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 310, 30));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Progreso para superar Modulo:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Numero de Modulo:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Descripcion de Modulo");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Progreso Inicial:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, -1, -1));
        jPanel1.add(DescripcionModuloAA, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 110, 260, 50));
        jPanel1.add(ProgresoAAFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 230, 260, -1));
        jPanel1.add(NumeroModulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, 260, -1));
        jPanel1.add(ProgresoAAInicial, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 190, 260, -1));

        EliminarAA.setBackground(new java.awt.Color(153, 255, 153));
        EliminarAA.setText("Eliminar");
        EliminarAA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarAAActionPerformed(evt);
            }
        });
        jPanel1.add(EliminarAA, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 300, -1, -1));

        AgregarAA.setBackground(new java.awt.Color(153, 255, 153));
        AgregarAA.setText("Agregar");
        AgregarAA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarAAActionPerformed(evt);
            }
        });
        jPanel1.add(AgregarAA, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 300, -1, -1));

        SalirAA.setBackground(new java.awt.Color(153, 255, 153));
        SalirAA.setText("Salir");
        SalirAA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirAAActionPerformed(evt);
            }
        });
        jPanel1.add(SalirAA, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 300, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 490, 390));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SalirAAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirAAActionPerformed
    this.dispose();
    }//GEN-LAST:event_SalirAAActionPerformed

    private void AgregarAAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarAAActionPerformed
    try {
        int numero        = Integer.parseInt(NumeroModulo.getText().trim());
        String descripcion= DescripcionModuloAA.getText();
        int progIni       = Integer.parseInt(ProgresoAAInicial.getText().trim());
        int progMeta      = Integer.parseInt(ProgresoAAFinal.getText().trim());

        boolean ok = ControlAprendizajeActivo.agregarModulo(
                numero, descripcion, progIni, progMeta);

        if (!ok) {
            JOptionPane.showMessageDialog(this,
                "Datos inválidos o número de módulo duplicado.",
                "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        JOptionPane.showMessageDialog(this,
            "Módulo añadido con éxito.",
            "OK", JOptionPane.INFORMATION_MESSAGE);

        if (ventanaPadre != null) {
            ventanaPadre.cargarModulos();
            ventanaPadre.setVisible(true);
        }
        this.dispose();

    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(this,
            "Número y progresos deben ser enteros.",
            "Formato incorrecto", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_AgregarAAActionPerformed

    private void EliminarAAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarAAActionPerformed
    try {
        int numero = Integer.parseInt(NumeroModulo.getText().trim());
        boolean eliminado = ControlAprendizajeActivo.eliminarModulo(numero);

        String msg = eliminado ? "Módulo eliminado." : "No existe ese módulo.";
        JOptionPane.showMessageDialog(this, msg);

        if (ventanaPadre != null) {
            ventanaPadre.cargarModulos();
            ventanaPadre.setVisible(true);
        }
        this.dispose();

    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(this,
            "Ingresa un número válido para eliminar.",
            "Formato incorrecto", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_EliminarAAActionPerformed

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
            java.util.logging.Logger.getLogger(Agregaroquitarmodulo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Agregaroquitarmodulo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Agregaroquitarmodulo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Agregaroquitarmodulo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Agregaroquitarmodulo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AgregarAA;
    private javax.swing.JTextField DescripcionModuloAA;
    private javax.swing.JButton EliminarAA;
    private javax.swing.JTextField NumeroModulo;
    private javax.swing.JTextField ProgresoAAFinal;
    private javax.swing.JTextField ProgresoAAInicial;
    private javax.swing.JButton SalirAA;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
