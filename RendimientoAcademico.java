
package Vista;
import java.awt.Desktop;
import java.net.URI;
import javax.swing.*;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import control.ControlRendimientoAcademico;
import java.util.List;
import java.awt.Dimension;

public class RendimientoAcademico extends javax.swing.JFrame {

    public RendimientoAcademico() {
        initComponents();
        cargarEstudiantes();
        this.pack();
        setSize(1265, 950);
        setResizable(false);
        this.setLocationRelativeTo(null);
                // Placeholder inicial
        jTextField17.setText("Buscar...");

        // Limpia "Buscar..." al hacer foco y lo restaura si queda vacío
        jTextField17.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                if ("Buscar...".equals(jTextField17.getText())) {
                    jTextField17.setText("");
                }
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (jTextField17.getText().isEmpty()) {
                    jTextField17.setText("Buscar...");
                }
            }
        });
        jTextField17.addActionListener(e -> abrirDestino());

        /* 2️⃣  CLIC en la lupa (jLabel33) */
        jLabel33.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        jLabel33.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                abrirDestino();
            }
        });   
    }
    /* 3️⃣  Método común para decidir a dónde ir */
    public void abrirDestino() {
        String query = jTextField17.getText().trim().toLowerCase();

        switch (query) {
            case "aprendizaje activo":
            case "aprendizaje":
                new AprendizajeActivo().setVisible(true);
                this.dispose();          // cierra AulaVirtual (opcional)
                break;

            case "rendimiento academico":
            case "rendimiento":
                // Ya estamos aquí; puedes ignorar o mostrar info extra
                JOptionPane.showMessageDialog(
                        this, "¡Ya te encuentras en el Rendimiento Academico!",
                        "Info", JOptionPane.INFORMATION_MESSAGE
                );
                break;

            /* Si alguien escribe "aula" estando ya en AulaVirtual… */
            case "aula virtual":
            case "aula":
                new AulaVirtual().setVisible(true);
                this.dispose();
                break;

            default:
                JOptionPane.showMessageDialog(
                        this,
                        "No se encontró: «" + query + "»\nPrueba con:\n• aula\n• aprendizaje\n• rendimiento",
                        "Sin resultados",
                        JOptionPane.ERROR_MESSAGE
                );
        }
    }
    
public void cargarEstudiantes() {

    List<ControlRendimientoAcademico.Estudiante> lista =
            ControlRendimientoAcademico.obtenerEstudiantes();

    /* ─── Arreglos del panel IZQUIERDO  (pasan) ─── */
    JTextField[] usuariosPasa = {
        Usuario1,  Usuario2,  Usuario3,  Usuario4,
        Usuario5,  Usuario6,  Usuario7,  Usuario8
    };
    JTextField[] porcentajesPasa = {
        NumeroPorcentaje1,  NumeroPorcentaje2,  NumeroPorcentaje3,  NumeroPorcentaje4,
        NumeroPorcentaje5,  NumeroPorcentaje6,  NumeroPorcentaje7,  NumeroPorcentaje8
    };
    JProgressBar[] barrasPasa = {
        PorcentajeRA1,  PorcentajeRA2,  PorcentajeRA3,  PorcentajeRA4,
        PorcentajeRA5,  PorcentajeRA6,  PorcentajeRA7,  PorcentajeRA8
    };
    JCheckBox[] checksPasa = {
        Check1, Check2, Check3, Check4, Check5, Check6, Check7, Check8
    };

    /* ─── Arreglos del panel DERECHO (mantienen) ─── */
    JTextField[] usuariosMant = {
        Usuario9,  Usuario10, Usuario11, Usuario12,
        Usuario13, Usuario14, Usuario15, Usuario16
    };
    JTextField[] porcentajesMant = {
        NumeroPorcentaje9,  NumeroPorcentaje10, NumeroPorcentaje11, NumeroPorcentaje12,
        NumeroPorcentaje13, NumeroPorcentaje14, NumeroPorcentaje15, NumeroPorcentaje16
    };
    JProgressBar[] barrasMant = {
        PorcentajeRA9,  PorcentajeRA10, PorcentajeRA11, PorcentajeRA12,
        PorcentajeRA13, PorcentajeRA14, PorcentajeRA15, PorcentajeRA16
    };
    JCheckBox[] checksMant = {
        Check9, Check10, Check11, Check12, Check13, Check14, Check15, Check16
    };

    /* Primero limpia todo */
    for (int i = 0; i < 8; i++) {
        usuariosPasa[i].setText("");
        porcentajesPasa[i].setText("");
        barrasPasa[i].setValue(0);
        checksPasa[i].setSelected(false);

        usuariosMant[i].setText("");
        porcentajesMant[i].setText("");
        barrasMant[i].setValue(0);
        checksMant[i].setSelected(false);
    }

    /* Rellena según pase/mantenga */
    int idxPasa = 0, idxMant = 0;
    for (ControlRendimientoAcademico.Estudiante e : lista) {

        if (e.pasaNivel && idxPasa < 8) {                // panel izquierdo
            usuariosPasa[idxPasa].setText(e.nombre);
            porcentajesPasa[idxPasa].setText(e.porcentaje + " %");
            barrasPasa[idxPasa].setValue(e.porcentaje);
            checksPasa[idxPasa].setSelected(true);
            idxPasa++;
        } else if (e.mantieneNivel && idxMant < 8) {     // panel derecho
            usuariosMant[idxMant].setText(e.nombre);
            porcentajesMant[idxMant].setText(e.porcentaje + " %");
            barrasMant[idxMant].setValue(e.porcentaje);
            checksMant[idxMant].setSelected(true);
            idxMant++;
        }
        /* Si el registro no marca ninguna opción válida
           simplemente se ignora (no debería ocurrir). */
    }
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel42 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jPanel25 = new javax.swing.JPanel();
        jLabel121 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jTextField17 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jPanel23 = new javax.swing.JPanel();
        jLabel71 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        PorcentajeRA1 = new javax.swing.JProgressBar();
        PorcentajeRA2 = new javax.swing.JProgressBar();
        PorcentajeRA3 = new javax.swing.JProgressBar();
        PorcentajeRA4 = new javax.swing.JProgressBar();
        PorcentajeRA5 = new javax.swing.JProgressBar();
        PorcentajeRA6 = new javax.swing.JProgressBar();
        PorcentajeRA8 = new javax.swing.JProgressBar();
        PorcentajeRA7 = new javax.swing.JProgressBar();
        Check1 = new javax.swing.JCheckBox();
        Check2 = new javax.swing.JCheckBox();
        Check3 = new javax.swing.JCheckBox();
        Check4 = new javax.swing.JCheckBox();
        Check5 = new javax.swing.JCheckBox();
        Check6 = new javax.swing.JCheckBox();
        Check7 = new javax.swing.JCheckBox();
        Check8 = new javax.swing.JCheckBox();
        NumeroPorcentaje1 = new javax.swing.JTextField();
        NumeroPorcentaje2 = new javax.swing.JTextField();
        NumeroPorcentaje3 = new javax.swing.JTextField();
        NumeroPorcentaje4 = new javax.swing.JTextField();
        NumeroPorcentaje5 = new javax.swing.JTextField();
        NumeroPorcentaje6 = new javax.swing.JTextField();
        NumeroPorcentaje7 = new javax.swing.JTextField();
        NumeroPorcentaje8 = new javax.swing.JTextField();
        Usuario1 = new javax.swing.JTextField();
        Usuario8 = new javax.swing.JTextField();
        Usuario7 = new javax.swing.JTextField();
        Usuario6 = new javax.swing.JTextField();
        Usuario5 = new javax.swing.JTextField();
        Usuario2 = new javax.swing.JTextField();
        Usuario3 = new javax.swing.JTextField();
        Usuario4 = new javax.swing.JTextField();
        jPanel24 = new javax.swing.JPanel();
        jLabel96 = new javax.swing.JLabel();
        jLabel97 = new javax.swing.JLabel();
        jLabel98 = new javax.swing.JLabel();
        jLabel99 = new javax.swing.JLabel();
        jLabel100 = new javax.swing.JLabel();
        jLabel101 = new javax.swing.JLabel();
        jLabel102 = new javax.swing.JLabel();
        jLabel103 = new javax.swing.JLabel();
        jLabel104 = new javax.swing.JLabel();
        PorcentajeRA9 = new javax.swing.JProgressBar();
        PorcentajeRA11 = new javax.swing.JProgressBar();
        PorcentajeRA10 = new javax.swing.JProgressBar();
        PorcentajeRA12 = new javax.swing.JProgressBar();
        PorcentajeRA14 = new javax.swing.JProgressBar();
        PorcentajeRA13 = new javax.swing.JProgressBar();
        PorcentajeRA16 = new javax.swing.JProgressBar();
        PorcentajeRA15 = new javax.swing.JProgressBar();
        Check9 = new javax.swing.JCheckBox();
        Check10 = new javax.swing.JCheckBox();
        Check11 = new javax.swing.JCheckBox();
        Check12 = new javax.swing.JCheckBox();
        Check13 = new javax.swing.JCheckBox();
        Check14 = new javax.swing.JCheckBox();
        Check15 = new javax.swing.JCheckBox();
        Check16 = new javax.swing.JCheckBox();
        NumeroPorcentaje9 = new javax.swing.JTextField();
        NumeroPorcentaje16 = new javax.swing.JTextField();
        NumeroPorcentaje15 = new javax.swing.JTextField();
        NumeroPorcentaje14 = new javax.swing.JTextField();
        NumeroPorcentaje13 = new javax.swing.JTextField();
        NumeroPorcentaje12 = new javax.swing.JTextField();
        NumeroPorcentaje11 = new javax.swing.JTextField();
        NumeroPorcentaje10 = new javax.swing.JTextField();
        Usuario12 = new javax.swing.JTextField();
        Usuario16 = new javax.swing.JTextField();
        Usuario15 = new javax.swing.JTextField();
        Usuario13 = new javax.swing.JTextField();
        Usuario11 = new javax.swing.JTextField();
        Usuario10 = new javax.swing.JTextField();
        Usuario14 = new javax.swing.JTextField();
        Usuario9 = new javax.swing.JTextField();
        jButton19 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        IngresoRendimiento = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));

        jLabel42.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/usuario.png"))); // NOI18N

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setText("Usuario");

        jLabel43.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/estrella.png"))); // NOI18N
        jLabel43.setToolTipText("");

        jLabel44.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel44.setText("Puntos");

        jLabel45.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Campana.png"))); // NOI18N
        jLabel45.setToolTipText("");

        jLabel46.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Engranaje.png"))); // NOI18N

        jPanel25.setBackground(new java.awt.Color(204, 204, 204));

        jLabel121.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/State-layer.png"))); // NOI18N

        jLabel33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Lupa.png"))); // NOI18N

        jTextField17.setBackground(new java.awt.Color(204, 204, 204));
        jTextField17.setText("Buscar...");
        jTextField17.setBorder(null);
        jTextField17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField17ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel121, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField17, javax.swing.GroupLayout.DEFAULT_SIZE, 615, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel33)
                .addContainerGap())
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel25Layout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel121, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(jLabel33, javax.swing.GroupLayout.Alignment.TRAILING)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel42)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addGap(39, 39, 39)
                .addComponent(jLabel43)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel44)
                .addGap(44, 44, 44)
                .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 162, Short.MAX_VALUE)
                .addComponent(jLabel45)
                .addGap(18, 18, 18)
                .addComponent(jLabel46)
                .addGap(26, 26, 26))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel43)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel42)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel44)
                                    .addComponent(jLabel45)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel46))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, 1170, 40));

        jPanel2.setBackground(new java.awt.Color(204, 255, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/container.png"))); // NOI18N
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        jButton7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icon.png"))); // NOI18N
        jButton7.setText("Nivel 5");
        jButton7.setContentAreaFilled(false);
        jButton7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton7.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 440, -1, -1));

        jButton8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icon.png"))); // NOI18N
        jButton8.setText("Nivel 1");
        jButton8.setContentAreaFilled(false);
        jButton8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton8.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, -1, -1));

        jButton9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icon.png"))); // NOI18N
        jButton9.setText("Nivel 2");
        jButton9.setContentAreaFilled(false);
        jButton9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton9.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, -1, -1));

        jButton10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icon.png"))); // NOI18N
        jButton10.setText("Nivel 3");
        jButton10.setContentAreaFilled(false);
        jButton10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton10.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, -1, -1));

        jButton11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icon.png"))); // NOI18N
        jButton11.setText("Nivel 4");
        jButton11.setContentAreaFilled(false);
        jButton11.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton11.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, -1, -1));

        jButton18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/FAB elevation-override.png"))); // NOI18N
        jButton18.setContentAreaFilled(false);
        jPanel2.add(jButton18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 80, 970));

        jPanel4.setBackground(new java.awt.Color(204, 255, 204));

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setFont(new java.awt.Font("News701 BT", 1, 24)); // NOI18N
        jLabel1.setText("Modulo Educativo");

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("<html><div style='width:300px;'> Este módulo está diseñado para fomentar la conciencia ambiental en las personas a través de experiencias educativas interactivas, visuales y participativas.  El objetivo es que comprendan la relación entre sus acciones cotidianas y el medio ambiente, desarrollando hábitos sostenibles y una actitud crítica frente a los problemas ecológicos actuales. </div></html> ");
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jButton1.setBackground(new java.awt.Color(153, 255, 153));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 102, 102));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icon1.png"))); // NOI18N
        jButton1.setText("  Descargar mas Informacion");
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel1))
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(204, 204, 204));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setText("Secciones →");
        jPanel5.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 6, 90, -1));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Image3.png"))); // NOI18N
        jButton2.setText("Manejar Modulo Educativo");
        jButton2.setContentAreaFilled(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, -1, -1));

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Image2.png"))); // NOI18N
        jButton3.setText("Administrar Sistemas");
        jButton3.setContentAreaFilled(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 40, -1, -1));

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Image2.png"))); // NOI18N
        jButton4.setText("Administrar Usuarios");
        jButton4.setContentAreaFilled(false);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Image2.png"))); // NOI18N
        jButton5.setText("Control de Gamnificaciones");
        jButton5.setContentAreaFilled(false);
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 40, -1, -1));

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Image2.png"))); // NOI18N
        jButton6.setText("Coordinar Comunidad y Foros");
        jButton6.setContentAreaFilled(false);
        jButton6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 40, -1, -1));

        jPanel23.setBackground(new java.awt.Color(204, 204, 204));
        jPanel23.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel71.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel71.setText("Estudiantes que pasaran de nivel");

        jLabel72.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Avatar.png"))); // NOI18N

        jLabel73.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Avatar.png"))); // NOI18N

        jLabel74.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Avatar.png"))); // NOI18N

        jLabel75.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Avatar.png"))); // NOI18N

        jLabel76.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Avatar.png"))); // NOI18N

        jLabel77.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Avatar.png"))); // NOI18N

        jLabel78.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Avatar.png"))); // NOI18N

        jLabel79.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Avatar.png"))); // NOI18N

        NumeroPorcentaje1.setEditable(false);
        NumeroPorcentaje1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        NumeroPorcentaje1.setText("Numero %");

        NumeroPorcentaje2.setEditable(false);
        NumeroPorcentaje2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        NumeroPorcentaje2.setText("Numero %");

        NumeroPorcentaje3.setEditable(false);
        NumeroPorcentaje3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        NumeroPorcentaje3.setText("Numero %");

        NumeroPorcentaje4.setEditable(false);
        NumeroPorcentaje4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        NumeroPorcentaje4.setText("Numero %");

        NumeroPorcentaje5.setEditable(false);
        NumeroPorcentaje5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        NumeroPorcentaje5.setText("Numero %");

        NumeroPorcentaje6.setEditable(false);
        NumeroPorcentaje6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        NumeroPorcentaje6.setText("Numero %");

        NumeroPorcentaje7.setEditable(false);
        NumeroPorcentaje7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        NumeroPorcentaje7.setText("Numero %");

        NumeroPorcentaje8.setEditable(false);
        NumeroPorcentaje8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        NumeroPorcentaje8.setText("Numero %");

        Usuario1.setEditable(false);
        Usuario1.setText("Usuario 1");

        Usuario8.setEditable(false);
        Usuario8.setText("Usuario 8");

        Usuario7.setEditable(false);
        Usuario7.setText("Usuario 7");

        Usuario6.setEditable(false);
        Usuario6.setText("Usuario 6");

        Usuario5.setEditable(false);
        Usuario5.setText("Usuario 5");

        Usuario2.setEditable(false);
        Usuario2.setText("Usuario 2");

        Usuario3.setEditable(false);
        Usuario3.setText("Usuario 3");

        Usuario4.setEditable(false);
        Usuario4.setText("Usuario 4");

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel23Layout.createSequentialGroup()
                                .addComponent(jLabel78)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Usuario8))
                            .addGroup(jPanel23Layout.createSequentialGroup()
                                .addComponent(jLabel77)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Usuario7))
                            .addGroup(jPanel23Layout.createSequentialGroup()
                                .addComponent(jLabel79)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Usuario6))
                            .addGroup(jPanel23Layout.createSequentialGroup()
                                .addComponent(jLabel75)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Usuario5))
                            .addGroup(jPanel23Layout.createSequentialGroup()
                                .addComponent(jLabel73)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Usuario3))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel23Layout.createSequentialGroup()
                                .addComponent(jLabel74)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Usuario4))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel23Layout.createSequentialGroup()
                                .addComponent(jLabel72)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Usuario2))
                            .addGroup(jPanel23Layout.createSequentialGroup()
                                .addComponent(jLabel76)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Usuario1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(NumeroPorcentaje4, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                            .addComponent(NumeroPorcentaje5)
                            .addComponent(NumeroPorcentaje6)
                            .addComponent(NumeroPorcentaje7)
                            .addComponent(NumeroPorcentaje8)
                            .addComponent(NumeroPorcentaje3)
                            .addComponent(NumeroPorcentaje2)
                            .addComponent(NumeroPorcentaje1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(PorcentajeRA7, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(PorcentajeRA3, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(PorcentajeRA2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(PorcentajeRA4, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(PorcentajeRA5, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(PorcentajeRA6, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(PorcentajeRA8, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(PorcentajeRA1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, 45)
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Check1)
                            .addComponent(Check3)
                            .addComponent(Check2)
                            .addComponent(Check4)
                            .addComponent(Check5)
                            .addComponent(Check6)
                            .addComponent(Check7)
                            .addComponent(Check8)))
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addGap(157, 157, 157)
                        .addComponent(jLabel71)))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addContainerGap(45, Short.MAX_VALUE)
                        .addComponent(jLabel76))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel23Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(Check1))
                            .addGroup(jPanel23Layout.createSequentialGroup()
                                .addComponent(jLabel71)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(PorcentajeRA1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(NumeroPorcentaje1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Usuario1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(12, 12, 12)))
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel72))
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Check2)
                            .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(PorcentajeRA2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(NumeroPorcentaje2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Usuario2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel73))
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Check3)
                            .addComponent(PorcentajeRA3, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(NumeroPorcentaje3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Usuario3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel74)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                            .addComponent(Check4)
                            .addGap(12, 12, 12)))
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(PorcentajeRA4, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(NumeroPorcentaje4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Usuario4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)))
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel75)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(NumeroPorcentaje5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Usuario5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(PorcentajeRA5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Check5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel79))
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Check6)
                            .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(NumeroPorcentaje6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Usuario6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(PorcentajeRA6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel77))
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Check7)
                            .addComponent(PorcentajeRA7, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(NumeroPorcentaje7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Usuario7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addComponent(jLabel78)
                        .addGap(10, 10, 10))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Check8)
                            .addComponent(PorcentajeRA8, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(NumeroPorcentaje8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Usuario8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(20, 20, 20))))
        );

        jPanel5.add(jPanel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 530, -1));

        jPanel24.setBackground(new java.awt.Color(204, 204, 204));
        jPanel24.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel96.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel96.setText("Estudiantes que se quedaran de nivel");

        jLabel97.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Avatar.png"))); // NOI18N

        jLabel98.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Avatar.png"))); // NOI18N

        jLabel99.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Avatar.png"))); // NOI18N

        jLabel100.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Avatar.png"))); // NOI18N

        jLabel101.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Avatar.png"))); // NOI18N

        jLabel102.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Avatar.png"))); // NOI18N

        jLabel103.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Avatar.png"))); // NOI18N

        jLabel104.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Avatar.png"))); // NOI18N

        NumeroPorcentaje9.setEditable(false);
        NumeroPorcentaje9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        NumeroPorcentaje9.setText("Numero %");

        NumeroPorcentaje16.setEditable(false);
        NumeroPorcentaje16.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        NumeroPorcentaje16.setText("Numero %");

        NumeroPorcentaje15.setEditable(false);
        NumeroPorcentaje15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        NumeroPorcentaje15.setText("Numero %");

        NumeroPorcentaje14.setEditable(false);
        NumeroPorcentaje14.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        NumeroPorcentaje14.setText("Numero %");

        NumeroPorcentaje13.setEditable(false);
        NumeroPorcentaje13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        NumeroPorcentaje13.setText("Numero %");

        NumeroPorcentaje12.setEditable(false);
        NumeroPorcentaje12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        NumeroPorcentaje12.setText("Numero %");

        NumeroPorcentaje11.setEditable(false);
        NumeroPorcentaje11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        NumeroPorcentaje11.setText("Numero %");

        NumeroPorcentaje10.setEditable(false);
        NumeroPorcentaje10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        NumeroPorcentaje10.setText("Numero %");

        Usuario12.setEditable(false);
        Usuario12.setText("Usuario 4");

        Usuario16.setEditable(false);
        Usuario16.setText("Usuario 8");

        Usuario15.setEditable(false);
        Usuario15.setText("Usuario 7");

        Usuario13.setEditable(false);
        Usuario13.setText("Usuario 5");

        Usuario11.setEditable(false);
        Usuario11.setText("Usuario 3");

        Usuario10.setEditable(false);
        Usuario10.setText("Usuario 2");
        Usuario10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Usuario10ActionPerformed(evt);
            }
        });

        Usuario14.setEditable(false);
        Usuario14.setText("Usuario 6");

        Usuario9.setEditable(false);
        Usuario9.setText("Usuario 1");

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel24Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel96)
                .addGap(125, 125, 125))
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addComponent(jLabel99)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Usuario13))
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addComponent(jLabel102)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Usuario14))
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel24Layout.createSequentialGroup()
                                .addComponent(jLabel101)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Usuario12, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel24Layout.createSequentialGroup()
                                .addComponent(jLabel98)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Usuario11, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel24Layout.createSequentialGroup()
                                .addComponent(jLabel100)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Usuario10, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel24Layout.createSequentialGroup()
                                .addComponent(jLabel97)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Usuario9, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel103)
                            .addComponent(jLabel104))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Usuario15)
                            .addComponent(Usuario16))))
                .addGap(18, 18, 18)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel24Layout.createSequentialGroup()
                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(NumeroPorcentaje12, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                            .addComponent(NumeroPorcentaje9))
                        .addGap(18, 18, 18))
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(NumeroPorcentaje11, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                            .addComponent(NumeroPorcentaje15)
                            .addComponent(NumeroPorcentaje16))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addComponent(NumeroPorcentaje10)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel24Layout.createSequentialGroup()
                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(NumeroPorcentaje14)
                            .addComponent(NumeroPorcentaje13))
                        .addGap(18, 18, 18)))
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PorcentajeRA9, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PorcentajeRA10, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PorcentajeRA16, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PorcentajeRA15, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PorcentajeRA14, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PorcentajeRA13, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PorcentajeRA12, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PorcentajeRA11, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(102, 102, 102)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Check9)
                    .addComponent(Check10)
                    .addComponent(Check11)
                    .addComponent(Check12)
                    .addComponent(Check13)
                    .addComponent(Check14)
                    .addComponent(Check15)
                    .addComponent(Check16))
                .addGap(29, 29, 29))
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel96)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel24Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel97))
                            .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel24Layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(Check9))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel24Layout.createSequentialGroup()
                                    .addGap(28, 28, 28)
                                    .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(PorcentajeRA9, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(NumeroPorcentaje9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Usuario9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel24Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel100))
                            .addGroup(jPanel24Layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(Check10)
                                    .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(PorcentajeRA10, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(NumeroPorcentaje10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Usuario10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel98)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel24Layout.createSequentialGroup()
                                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(Check11)
                                    .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(PorcentajeRA11, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(NumeroPorcentaje11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Usuario11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(9, 9, 9))))
                    .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel24Layout.createSequentialGroup()
                            .addGap(171, 171, 171)
                            .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(NumeroPorcentaje12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Usuario12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(PorcentajeRA12, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Check12)))
                            .addGap(11, 11, 11))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel24Layout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addComponent(jLabel101)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))))
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Check13)
                            .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(PorcentajeRA13, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Usuario13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(NumeroPorcentaje13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(jLabel99))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel102)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel24Layout.createSequentialGroup()
                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Check14)
                            .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(PorcentajeRA14, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(NumeroPorcentaje14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Usuario14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(9, 9, 9)))
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addComponent(jLabel103)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel104))
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Check15)
                            .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(PorcentajeRA15, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(NumeroPorcentaje15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Usuario15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(Usuario16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(NumeroPorcentaje16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(Check16)
                                .addComponent(PorcentajeRA16, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.add(jPanel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 180, 570, 420));

        jButton19.setText("Aprendizaje Activo");
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton19, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 120, 130, 40));

        jButton20.setText("Aula Virtual");
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton20, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 120, 150, 40));

        jButton21.setText("Rendimiento Academico");
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton21, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 120, 170, 40));

        IngresoRendimiento.setText("Ingresar Rendimiento");
        IngresoRendimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IngresoRendimientoActionPerformed(evt);
            }
        });
        jPanel5.add(IngresoRendimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 120, 200, 40));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("EducacionAmbiental");

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icon3.png"))); // NOI18N
        jLabel25.setToolTipText("");

        jLabel39.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icon4.png"))); // NOI18N

        jLabel41.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icon5.png"))); // NOI18N

        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icon.png"))); // NOI18N
        jButton12.setText("Administrar Sistema");
        jButton12.setContentAreaFilled(false);
        jButton12.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton12.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icon.png"))); // NOI18N
        jButton13.setText("Manejar Modulo Educativo");
        jButton13.setContentAreaFilled(false);
        jButton13.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton13.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icon.png"))); // NOI18N
        jButton14.setText("Administrar Usuarios");
        jButton14.setContentAreaFilled(false);
        jButton14.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton14.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jButton15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icon.png"))); // NOI18N
        jButton15.setText("Coordinar Foros y Comunidades");
        jButton15.setContentAreaFilled(false);
        jButton15.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton15.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jButton16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icon.png"))); // NOI18N
        jButton16.setText("Control de Gamnificaciones");
        jButton16.setContentAreaFilled(false);
        jButton16.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton16.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        jButton17.setText("Apoyanos!");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel25)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel39)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(30, 30, 30)
                        .addComponent(jButton13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton12)
                        .addGap(18, 18, 18)
                        .addComponent(jButton17)
                        .addGap(0, 14, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 1167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 642, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jButton13)
                                .addComponent(jButton12)
                                .addComponent(jButton14)
                                .addComponent(jButton15)
                                .addComponent(jButton16))
                            .addGap(8, 8, 8))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGap(12, 12, 12)
                            .addComponent(jLabel11)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jButton17)
                        .addGap(25, 25, 25)))
                .addGap(48, 48, 48))
        );

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1250, 910));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        JOptionPane.showMessageDialog(
        this,
        "⏳ Aún no llegas a este nivel.\n¡Acumula más puntos para alcanzarlo!",
        "Nivel bloqueado",
        JOptionPane.WARNING_MESSAGE
    );
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
    JOptionPane.showMessageDialog(
        this,
        "⭐ Estás aquí, en el Nivel 1\n¡Nivel Estrella alcanzado!",
        "Nivel 1 - Estrella",
        JOptionPane.INFORMATION_MESSAGE
    );
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        JOptionPane.showMessageDialog(
        this,
        "⏳ Aún no llegas a este nivel.\n¡Acumula más puntos para alcanzarlo!",
        "Nivel bloqueado",
        JOptionPane.WARNING_MESSAGE
    );
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        JOptionPane.showMessageDialog(
        this,
        "⏳ Aún no llegas a este nivel.\n¡Acumula más puntos para alcanzarlo!",
        "Nivel bloqueado",
        JOptionPane.WARNING_MESSAGE
    );
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        JOptionPane.showMessageDialog(
        this,
        "⏳ Aún no llegas a este nivel.\n¡Acumula más puntos para alcanzarlo!",
        "Nivel bloqueado",
        JOptionPane.WARNING_MESSAGE
    );
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            Desktop.getDesktop().browse(new URI("https://www.un.org/sustainabledevelopment/es/education/"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        JOptionPane.showMessageDialog(
        this,
        "📌 Ya estás en esta sección.",
        "Información",
        JOptionPane.INFORMATION_MESSAGE
    );
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        JOptionPane.showMessageDialog(
        this,
        "🔧 Trabajando...\nEsta sección aún no se implementa.",
        "En desarrollo",
        JOptionPane.INFORMATION_MESSAGE
    );
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        JOptionPane.showMessageDialog(
        this,
        "🔧 Trabajando...\nEsta sección aún no se implementa.",
        "En desarrollo",
        JOptionPane.INFORMATION_MESSAGE
    );
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        JOptionPane.showMessageDialog(
        this,
        "🔧 Trabajando...\nEsta sección aún no se implementa.",
        "En desarrollo",
        JOptionPane.INFORMATION_MESSAGE
    );
    }//GEN-LAST:event_jButton6ActionPerformed

    private void Usuario10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Usuario10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Usuario10ActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        new AulaVirtual().setVisible(true); // Abre la nueva ventana Aula Virtual
        this.dispose(); // Cierra la ventana actual 
    }//GEN-LAST:event_jButton20ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        new AprendizajeActivo().setVisible(true); // Abre la nueva ventana Aprendizaje Activo
        this.dispose(); // Cierra la ventana actual 
    }//GEN-LAST:event_jButton19ActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        new RendimientoAcademico().setVisible(true); // Abre la nueva ventana Rendimiento Academico
        this.dispose(); // Cierra la ventana actual 
    }//GEN-LAST:event_jButton21ActionPerformed

    private void jTextField17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField17ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField17ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        JOptionPane.showMessageDialog(
        this,
        "¡Únete a nuestra campaña en:\nwww.CampañaDeEducaciónAmbiental.com!",
        "Campaña Ambiental",
        JOptionPane.INFORMATION_MESSAGE
    );
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        JOptionPane.showMessageDialog(
        this,
        "🔧 Trabajando...\nEsta sección aún no se implementa.",
        "En desarrollo",
        JOptionPane.INFORMATION_MESSAGE
    );
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        JOptionPane.showMessageDialog(
        this,
        "📌 Ya estás en esta sección.",
        "Información",
        JOptionPane.INFORMATION_MESSAGE
    );
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        JOptionPane.showMessageDialog(
        this,
        "⚠️ Aún lo estamos implementando.",
        "Función en desarrollo",
        JOptionPane.WARNING_MESSAGE
    );
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        JOptionPane.showMessageDialog(
        this,
        "⚠️ Aún lo estamos implementando.",
        "Función en desarrollo",
        JOptionPane.WARNING_MESSAGE
    );
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        JOptionPane.showMessageDialog(
        this,
        "⚠️ Aún lo estamos implementando.",
        "Función en desarrollo",
        JOptionPane.WARNING_MESSAGE
    );
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        JOptionPane.showMessageDialog(
        this,
        "⚠️ Aún lo estamos implementando.",
        "Función en desarrollo",
        JOptionPane.WARNING_MESSAGE
    );
    }//GEN-LAST:event_jButton12ActionPerformed

    private void IngresoRendimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IngresoRendimientoActionPerformed
        IngresoDatosRendimiento ingreso = new IngresoDatosRendimiento(this);
        ingreso.setVisible(true);
    }//GEN-LAST:event_IngresoRendimientoActionPerformed

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
            java.util.logging.Logger.getLogger(RendimientoAcademico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RendimientoAcademico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RendimientoAcademico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RendimientoAcademico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RendimientoAcademico().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox Check1;
    private javax.swing.JCheckBox Check10;
    private javax.swing.JCheckBox Check11;
    private javax.swing.JCheckBox Check12;
    private javax.swing.JCheckBox Check13;
    private javax.swing.JCheckBox Check14;
    private javax.swing.JCheckBox Check15;
    private javax.swing.JCheckBox Check16;
    private javax.swing.JCheckBox Check2;
    private javax.swing.JCheckBox Check3;
    private javax.swing.JCheckBox Check4;
    private javax.swing.JCheckBox Check5;
    private javax.swing.JCheckBox Check6;
    private javax.swing.JCheckBox Check7;
    private javax.swing.JCheckBox Check8;
    private javax.swing.JCheckBox Check9;
    private javax.swing.JButton IngresoRendimiento;
    private javax.swing.JTextField NumeroPorcentaje1;
    private javax.swing.JTextField NumeroPorcentaje10;
    private javax.swing.JTextField NumeroPorcentaje11;
    private javax.swing.JTextField NumeroPorcentaje12;
    private javax.swing.JTextField NumeroPorcentaje13;
    private javax.swing.JTextField NumeroPorcentaje14;
    private javax.swing.JTextField NumeroPorcentaje15;
    private javax.swing.JTextField NumeroPorcentaje16;
    private javax.swing.JTextField NumeroPorcentaje2;
    private javax.swing.JTextField NumeroPorcentaje3;
    private javax.swing.JTextField NumeroPorcentaje4;
    private javax.swing.JTextField NumeroPorcentaje5;
    private javax.swing.JTextField NumeroPorcentaje6;
    private javax.swing.JTextField NumeroPorcentaje7;
    private javax.swing.JTextField NumeroPorcentaje8;
    private javax.swing.JTextField NumeroPorcentaje9;
    private javax.swing.JProgressBar PorcentajeRA1;
    private javax.swing.JProgressBar PorcentajeRA10;
    private javax.swing.JProgressBar PorcentajeRA11;
    private javax.swing.JProgressBar PorcentajeRA12;
    private javax.swing.JProgressBar PorcentajeRA13;
    private javax.swing.JProgressBar PorcentajeRA14;
    private javax.swing.JProgressBar PorcentajeRA15;
    private javax.swing.JProgressBar PorcentajeRA16;
    private javax.swing.JProgressBar PorcentajeRA2;
    private javax.swing.JProgressBar PorcentajeRA3;
    private javax.swing.JProgressBar PorcentajeRA4;
    private javax.swing.JProgressBar PorcentajeRA5;
    private javax.swing.JProgressBar PorcentajeRA6;
    private javax.swing.JProgressBar PorcentajeRA7;
    private javax.swing.JProgressBar PorcentajeRA8;
    private javax.swing.JProgressBar PorcentajeRA9;
    private javax.swing.JTextField Usuario1;
    private javax.swing.JTextField Usuario10;
    private javax.swing.JTextField Usuario11;
    private javax.swing.JTextField Usuario12;
    private javax.swing.JTextField Usuario13;
    private javax.swing.JTextField Usuario14;
    private javax.swing.JTextField Usuario15;
    private javax.swing.JTextField Usuario16;
    private javax.swing.JTextField Usuario2;
    private javax.swing.JTextField Usuario3;
    private javax.swing.JTextField Usuario4;
    private javax.swing.JTextField Usuario5;
    private javax.swing.JTextField Usuario6;
    private javax.swing.JTextField Usuario7;
    private javax.swing.JTextField Usuario8;
    private javax.swing.JTextField Usuario9;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel121;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JTextField jTextField17;
    // End of variables declaration//GEN-END:variables
}
