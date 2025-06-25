
package Vista;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import control.ControlAulaVirtual;

public class IngresoModuloAula extends javax.swing.JFrame {

        private AulaVirtual ventanaPadre;

        public IngresoModuloAula(AulaVirtual padre) {
            initComponents();
            this.ventanaPadre = padre;
            setLocationRelativeTo(null);
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        }

        // Constructor vacío por compatibilidad (si NetBeans lo necesita)
        public IngresoModuloAula() {
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
        GuardarDescripcionAula = new javax.swing.JTextField();
        GuardarProfesor = new javax.swing.JTextField();
        GuardarCurso = new javax.swing.JTextField();
        GuardarTituloAula = new javax.swing.JTextField();
        GuardarSubtituloAula = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        GuardarAula = new javax.swing.JButton();
        SalirAula = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Descripcion:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 240, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Profesor:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Curso:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Titulo:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 150, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Subtitulo:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, -1, -1));
        jPanel1.add(GuardarDescripcionAula, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 240, 230, 40));
        jPanel1.add(GuardarProfesor, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, 230, -1));
        jPanel1.add(GuardarCurso, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, 230, -1));
        jPanel1.add(GuardarTituloAula, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, 130, -1));
        jPanel1.add(GuardarSubtituloAula, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 190, 130, 30));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setText("Ingreso de Datos Aula Virtual");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, 260, 30));

        GuardarAula.setBackground(new java.awt.Color(153, 255, 153));
        GuardarAula.setText("Guardar");
        GuardarAula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarAulaActionPerformed(evt);
            }
        });
        jPanel1.add(GuardarAula, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 350, -1, -1));

        SalirAula.setBackground(new java.awt.Color(153, 255, 153));
        SalirAula.setText("Salir");
        SalirAula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirAulaActionPerformed(evt);
            }
        });
        jPanel1.add(SalirAula, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 350, -1, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 410));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SalirAulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirAulaActionPerformed
        this.dispose();
    }//GEN-LAST:event_SalirAulaActionPerformed

    private void GuardarAulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarAulaActionPerformed
    String profesor = GuardarProfesor.getText();
    String curso = GuardarCurso.getText();
    String titulo = GuardarTituloAula.getText();
    String subtitulo = GuardarSubtituloAula.getText();
    String descripcion = GuardarDescripcionAula.getText();

    boolean exito = ControlAulaVirtual.registrarModulo(
        profesor, curso, titulo, subtitulo, descripcion
    );

    if (!exito) {
        JOptionPane.showMessageDialog(
            this,
            "Rellene porfavor todos los campos.",
            "Error", JOptionPane.WARNING_MESSAGE
        );
    } else {
        JOptionPane.showMessageDialog(
            this,
            "Módulo guardado exitosamente.",
            "Éxito", JOptionPane.INFORMATION_MESSAGE
        );
    if (ventanaPadre != null) {
        ventanaPadre.cargarModulos();     // 🔁 Recarga datos en AulaVirtual
        ventanaPadre.setVisible(true);  // (si fue ocultada)
    }
    this.dispose();
    }
    }//GEN-LAST:event_GuardarAulaActionPerformed

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
            java.util.logging.Logger.getLogger(IngresoModuloAula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IngresoModuloAula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IngresoModuloAula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IngresoModuloAula.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IngresoModuloAula().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton GuardarAula;
    private javax.swing.JTextField GuardarCurso;
    private javax.swing.JTextField GuardarDescripcionAula;
    private javax.swing.JTextField GuardarProfesor;
    private javax.swing.JTextField GuardarSubtituloAula;
    private javax.swing.JTextField GuardarTituloAula;
    private javax.swing.JButton SalirAula;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
