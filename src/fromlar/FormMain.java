package fromlar;

import java.awt.Color;

public class FormMain extends javax.swing.JFrame {

    int yetkiid = FormLogin.yetkiID;

    public FormMain() {
        setUndecorated(true);
        initComponents();
        lblKullanici.setText(FormLogin.personelAdi);
        lblKullanici1.setText(FormLogin.bayiAdi);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        panelMasalar = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        panelAsci = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        panelRaporlar = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        panelYonetim = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        panelBar = new javax.swing.JPanel();
        lblKullanici = new javax.swing.JLabel();
        lblKullanici1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(233, 236, 229));

        panelMasalar.setBackground(new java.awt.Color(192, 223, 217));
        panelMasalar.setPreferredSize(new java.awt.Dimension(200, 90));
        panelMasalar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelMasalarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelMasalarMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panelMasalarMousePressed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(71, 136, 199));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/masa.png"))); // NOI18N
        jLabel3.setText("Masalar");
        jLabel3.setIconTextGap(20);

        javax.swing.GroupLayout panelMasalarLayout = new javax.swing.GroupLayout(panelMasalar);
        panelMasalar.setLayout(panelMasalarLayout);
        panelMasalarLayout.setHorizontalGroup(
            panelMasalarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMasalarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelMasalarLayout.setVerticalGroup(
            panelMasalarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMasalarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelAsci.setBackground(new java.awt.Color(192, 223, 217));
        panelAsci.setPreferredSize(new java.awt.Dimension(200, 90));
        panelAsci.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelAsciMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelAsciMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panelAsciMousePressed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(71, 136, 199));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/asci.png"))); // NOI18N
        jLabel2.setText("Aşçı");
        jLabel2.setIconTextGap(20);

        javax.swing.GroupLayout panelAsciLayout = new javax.swing.GroupLayout(panelAsci);
        panelAsci.setLayout(panelAsciLayout);
        panelAsciLayout.setHorizontalGroup(
            panelAsciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAsciLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelAsciLayout.setVerticalGroup(
            panelAsciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAsciLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelRaporlar.setBackground(new java.awt.Color(192, 223, 217));
        panelRaporlar.setPreferredSize(new java.awt.Dimension(200, 90));
        panelRaporlar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelRaporlarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelRaporlarMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panelRaporlarMousePressed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(71, 136, 199));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/rapor.png"))); // NOI18N
        jLabel4.setText("Raporlar");
        jLabel4.setIconTextGap(20);

        javax.swing.GroupLayout panelRaporlarLayout = new javax.swing.GroupLayout(panelRaporlar);
        panelRaporlar.setLayout(panelRaporlarLayout);
        panelRaporlarLayout.setHorizontalGroup(
            panelRaporlarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRaporlarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelRaporlarLayout.setVerticalGroup(
            panelRaporlarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRaporlarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelYonetim.setBackground(new java.awt.Color(192, 223, 217));
        panelYonetim.setPreferredSize(new java.awt.Dimension(200, 90));
        panelYonetim.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelYonetimMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelYonetimMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panelYonetimMousePressed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(71, 136, 199));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/yonetim.png"))); // NOI18N
        jLabel5.setText("Yönetim");
        jLabel5.setIconTextGap(20);

        javax.swing.GroupLayout panelYonetimLayout = new javax.swing.GroupLayout(panelYonetim);
        panelYonetim.setLayout(panelYonetimLayout);
        panelYonetimLayout.setHorizontalGroup(
            panelYonetimLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelYonetimLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelYonetimLayout.setVerticalGroup(
            panelYonetimLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelYonetimLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelBar.setBackground(new java.awt.Color(59, 58, 54));

        lblKullanici.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        lblKullanici.setForeground(new java.awt.Color(255, 255, 255));
        lblKullanici.setText("Kullanıcı Adı");

        lblKullanici1.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        lblKullanici1.setForeground(new java.awt.Color(255, 255, 255));
        lblKullanici1.setText("Bayi Adı");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/kapatbeyaz.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel1MousePressed(evt);
            }
        });

        javax.swing.GroupLayout panelBarLayout = new javax.swing.GroupLayout(panelBar);
        panelBar.setLayout(panelBarLayout);
        panelBarLayout.setHorizontalGroup(
            panelBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblKullanici)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 477, Short.MAX_VALUE)
                .addComponent(lblKullanici1)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(2, 2, 2))
        );
        panelBarLayout.setVerticalGroup(
            panelBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBarLayout.createSequentialGroup()
                .addGroup(panelBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblKullanici1)
                        .addComponent(lblKullanici))
                    .addComponent(jLabel1))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(111, 111, 111)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelMasalar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelRaporlar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelAsci, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelYonetim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(111, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(panelBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelAsci, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelMasalar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelYonetim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelRaporlar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(61, 61, 61))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void panelMasalarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelMasalarMousePressed
        if (yetkiid == 1 || yetkiid == 2 || yetkiid == 3) {
            FormMasalar fm = new FormMasalar();
            fm.setVisible(true);
            this.setVisible(false);
        }
    }//GEN-LAST:event_panelMasalarMousePressed

    private void jLabel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MousePressed
        System.exit(0);
    }//GEN-LAST:event_jLabel1MousePressed

    private void panelMasalarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelMasalarMouseEntered
        panelMasalar.setBackground(new Color(219, 255, 248));
    }//GEN-LAST:event_panelMasalarMouseEntered

    private void panelMasalarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelMasalarMouseExited
        panelMasalar.setBackground(new Color(192, 223, 217));
    }//GEN-LAST:event_panelMasalarMouseExited

    private void panelAsciMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelAsciMouseEntered
        panelAsci.setBackground(new Color(219, 255, 248));
    }//GEN-LAST:event_panelAsciMouseEntered

    private void panelRaporlarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRaporlarMousePressed
        if (yetkiid == 1) {
            FormRaporlar fr = new FormRaporlar();
            fr.setVisible(true);
        }
    }//GEN-LAST:event_panelRaporlarMousePressed

    private void panelRaporlarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRaporlarMouseEntered
        panelRaporlar.setBackground(new Color(219, 255, 248));
    }//GEN-LAST:event_panelRaporlarMouseEntered

    private void panelYonetimMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelYonetimMouseEntered
        panelYonetim.setBackground(new Color(219, 255, 248));
    }//GEN-LAST:event_panelYonetimMouseEntered

    private void panelAsciMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelAsciMouseExited
        panelAsci.setBackground(new Color(192, 223, 217));
    }//GEN-LAST:event_panelAsciMouseExited

    private void panelRaporlarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRaporlarMouseExited
        panelRaporlar.setBackground(new Color(192, 223, 217));
    }//GEN-LAST:event_panelRaporlarMouseExited

    private void panelYonetimMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelYonetimMouseExited
        panelYonetim.setBackground(new Color(192, 223, 217));
    }//GEN-LAST:event_panelYonetimMouseExited

    private void panelYonetimMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelYonetimMousePressed
        if (yetkiid == 1 || yetkiid == 2) {
            FormYonetim fy = new FormYonetim();
            fy.setVisible(true);
            this.setVisible(false);
        }
    }//GEN-LAST:event_panelYonetimMousePressed

    private void panelAsciMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelAsciMousePressed
        FormAsci fa = new FormAsci();
        fa.setVisible(true);
    }//GEN-LAST:event_panelAsciMousePressed

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
            java.util.logging.Logger.getLogger(FormMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblKullanici;
    private javax.swing.JLabel lblKullanici1;
    private javax.swing.JPanel panelAsci;
    private javax.swing.JPanel panelBar;
    private javax.swing.JPanel panelMasalar;
    private javax.swing.JPanel panelRaporlar;
    private javax.swing.JPanel panelYonetim;
    // End of variables declaration//GEN-END:variables
}
