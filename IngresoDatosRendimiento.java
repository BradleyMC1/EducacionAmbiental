
package Vista;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import control.ControlRendimientoAcademico;

public class IngresoDatosRendimiento extends javax.swing.JFrame {

    private RendimientoAcademico ventanaPadre;

    public IngresoDatosRendimiento(RendimientoAcademico padre) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.ventanaPadre = padre;
    }

    public IngresoDatosRendimiento() {
        this(null); // por compatibilidad con NetBeans si lo necesita
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        GuardarDR = new javax.swing.JButton();
        SalirDR = new javax.swing.JButton();
        NombreDR = new javax.swing.JTextField();
        PorcentajeDR = new javax.swing.JTextField();
        CheckDR = new javax.swing.JCheckBox();
        CheckDR2 = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Ingreso de datos del Estudiante");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Nombre:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Porcentaje:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Nivelaciòn:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, -1, -1));

        GuardarDR.setBackground(new java.awt.Color(153, 255, 153));
        GuardarDR.setText("Guardar");
        GuardarDR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarDRActionPerformed(evt);
            }
        });
        jPanel1.add(GuardarDR, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 220, -1, -1));

        SalirDR.setBackground(new java.awt.Color(153, 255, 153));
        SalirDR.setText("Salir");
        SalirDR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirDRActionPerformed(evt);
            }
        });
        jPanel1.add(SalirDR, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 220, -1, 30));
        jPanel1.add(NombreDR, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, 180, -1));
        jPanel1.add(PorcentajeDR, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 190, -1));

        CheckDR.setText("Pasa de Nivel");
        jPanel1.add(CheckDR, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, -1, -1));

        CheckDR2.setText("Se mantiene de Nivel");
        jPanel1.add(CheckDR2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 130, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 470, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SalirDRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirDRActionPerformed
        this.dispose();
    }//GEN-LAST:event_SalirDRActionPerformed

    private void GuardarDRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarDRActionPerformed
    try {
        String nombre = NombreDR.getText().trim();
        int porcentaje = Integer.parseInt(PorcentajeDR.getText().trim());
        boolean pasaNivel = CheckDR.isSelected();
        boolean mantieneNivel = CheckDR2.isSelected();

        boolean ok = ControlRendimientoAcademico.agregarEstudiante(
                nombre, porcentaje, pasaNivel, mantieneNivel
        );

        if (!ok) {
            JOptionPane.showMessageDialog(this,
                "Verifica los campos. Solo uno de los checkboxes debe estar marcado.",
                "Error de validación", JOptionPane.WARNING_MESSAGE);
            return;
        }

        JOptionPane.showMessageDialog(this, "Estudiante guardado correctamente.");
        if (ventanaPadre != null) {
            ventanaPadre.cargarEstudiantes(); // ⚡ actualiza los datos en pantalla
            ventanaPadre.setVisible(true);    // vuelve a mostrarla si la ocultaste
        }
        this.dispose(); // cierra esta ventana

    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this,
            "Porcentaje debe ser un número entre 0 y 100.",
            "Error de formato", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_GuardarDRActionPerformed

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
            java.util.logging.Logger.getLogger(IngresoDatosRendimiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IngresoDatosRendimiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IngresoDatosRendimiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IngresoDatosRendimiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IngresoDatosRendimiento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox CheckDR;
    private javax.swing.JCheckBox CheckDR2;
    private javax.swing.JButton GuardarDR;
    private javax.swing.JTextField NombreDR;
    private javax.swing.JTextField PorcentajeDR;
    private javax.swing.JButton SalirDR;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
