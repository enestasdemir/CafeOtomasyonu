package fromlar;

import db.BayiCrud;
import db.SalonCrud;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import properties.Bayi;
import properties.Salon;

public class FormSalonEkle extends javax.swing.JFrame {

    ArrayList<Bayi> bls = new ArrayList<>();
    ArrayList<Salon> sls = new ArrayList<>();
    ArrayList<Salon> ssListesi = new ArrayList<>();
    ArrayList<Salon> sdListesi = new ArrayList<>();

    String beid = "";
    String bsid = "";
    String bdid = "";

    public FormSalonEkle() {
        initComponents();
        bayiModelDoldur();
        beid = bls.get(cxBayiSalonEkle.getSelectedIndex()).getBayiID();
        bayiSilModelDoldur();
        bsid = bls.get(cxBayiSalonSil.getSelectedIndex()).getBayiID();
        salonSilVeriCek();
        gridSalonSil(0, 3);
        bayiDuzneleModelDoldur();
        bdid = bls.get(cxBayiSalonDuznele.getSelectedIndex()).getBayiID();
        salonDuzenleVeriCek();
        gridSalonDuzenle(0, 3);
    }

    public void gridSalonSil(int rows, int cols) {
        panelSalonSilGrid.removeAll();
        panelSalonSilGrid.revalidate();
        panelSalonSilGrid.repaint();

        System.out.println("Salonlara girildi");
        panelSalonSilGrid.setLayout(new GridLayout(rows, cols));

        for (Salon item : ssListesi) {
            String sid = item.getSalonID();
            String bid = item.getBayiID();
            String madi = item.getSalonMasaAdedi();
            String sadi = item.getSalonAdi();

            JButton button = new JButton(sadi);
            button.setToolTipText(sid);
            panelSalonSilGrid.add(button);
            button.addActionListener((ActionEvent e) -> {
                System.out.println("bid = " + Integer.valueOf(bid) + " sid = " + sid);
                Salon salon = new Salon();
                salon.setSalonID(sid);
                int cevap = JOptionPane.showConfirmDialog(rootPane, "(" + sid + ") Bayiyi silmek istediğinize emin misiniz?", "Bayi Sil", JOptionPane.YES_NO_OPTION);
                if (cevap == 0) {
                    new SalonCrud().sil(salon);
                    salonSilVeriCek();
                    gridSalonSil(0, 3);
                    salonDuzenleVeriCek();
                    gridSalonDuzenle(0, 3);
                    System.out.println("Silme işlemi başarılı!");
                }
            });
        }
    }

    public void gridSalonDuzenle(int rows, int cols) {
        panelSalonDuzenleGrid.removeAll();
        panelSalonDuzenleGrid.revalidate();
        panelSalonDuzenleGrid.repaint();

        System.out.println("Salonlara girildi");
        panelSalonDuzenleGrid.setLayout(new GridLayout(rows, cols));

        for (Salon item : sdListesi) {
            String sid = item.getSalonID();
            String bid = item.getBayiID();
            String madi = item.getSalonMasaAdedi();
            String sadi = item.getSalonAdi();

            JButton button = new JButton(sadi);
            button.setToolTipText(sid);
            panelSalonDuzenleGrid.add(button);
            button.addActionListener((ActionEvent e) -> {
                System.out.println("bid = " + Integer.valueOf(bid) + " sid = " + sid);
                Salon salon = new Salon();
                salon.setSalonID(sid);
                salon.setSalonAdi(sadi);
                String gelen = JOptionPane.showInputDialog(rootPane, "Lütfen yeni salon ismini giriniz.", "Salon Güncelleme", JOptionPane.DEFAULT_OPTION);
                if (!gelen.equals("") && gelen != null) {
                    salon.setSalonAdi(gelen);
                    new SalonCrud().guncelle(salon);
                    salonSilVeriCek();
                    gridSalonSil(0, 3);
                    salonDuzenleVeriCek();
                    gridSalonDuzenle(0, 3);
                    System.out.println("Güncelleme işlemi başarılı!");
                }

            });
        }
    }

    void salonSilVeriCek() {
        ssListesi = new SalonCrud().veriCek(bsid);
    }

    void salonDuzenleVeriCek() {
        sdListesi = new SalonCrud().veriCek(bdid);
    }

    public void bayiModelDoldur() {
        DefaultComboBoxModel<String> bmd = new DefaultComboBoxModel<>();
        bls = new BayiCrud().veriGetir();
        for (Bayi item : bls) {
            bmd.addElement(item.getBayiAdi());
        }
        cxBayiSalonEkle.setModel(bmd);
    }

    public void bayiSilModelDoldur() {
        DefaultComboBoxModel<String> bmd = new DefaultComboBoxModel<>();
        bls = new BayiCrud().veriGetir();
        for (Bayi item : bls) {
            bmd.addElement(item.getBayiAdi());
        }
        cxBayiSalonSil.setModel(bmd);
    }

    public void bayiDuzneleModelDoldur() {
        DefaultComboBoxModel<String> bmd = new DefaultComboBoxModel<>();
        bls = new BayiCrud().veriGetir();
        for (Bayi item : bls) {
            bmd.addElement(item.getBayiAdi());
        }
        cxBayiSalonDuznele.setModel(bmd);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cxBayiSalonEkle = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        txtSalonEkleAdi = new javax.swing.JTextField();
        btnSalonEkle = new javax.swing.JButton();
        panelSalonSil = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        cxBayiSalonSil = new javax.swing.JComboBox<>();
        panelSalonSilGrid = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        cxBayiSalonDuznele = new javax.swing.JComboBox<>();
        panelSalonDuzenleGrid = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Salon Yönetimi"));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Salon Ekle"));

        jLabel1.setText("Bayi:");

        cxBayiSalonEkle.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cxBayiSalonEkle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cxBayiSalonEkleActionPerformed(evt);
            }
        });

        jLabel2.setText("Salon Adı:");

        btnSalonEkle.setText("Salon Ekle");
        btnSalonEkle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalonEkleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cxBayiSalonEkle, 0, 280, Short.MAX_VALUE)
                            .addComponent(txtSalonEkleAdi)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSalonEkle)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cxBayiSalonEkle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtSalonEkleAdi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnSalonEkle)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelSalonSil.setBorder(javax.swing.BorderFactory.createTitledBorder("Salon Sil"));

        jLabel3.setText("Bayi:");

        cxBayiSalonSil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cxBayiSalonSil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cxBayiSalonSilActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelSalonSilGridLayout = new javax.swing.GroupLayout(panelSalonSilGrid);
        panelSalonSilGrid.setLayout(panelSalonSilGridLayout);
        panelSalonSilGridLayout.setHorizontalGroup(
            panelSalonSilGridLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelSalonSilGridLayout.setVerticalGroup(
            panelSalonSilGridLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 109, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelSalonSilLayout = new javax.swing.GroupLayout(panelSalonSil);
        panelSalonSil.setLayout(panelSalonSilLayout);
        panelSalonSilLayout.setHorizontalGroup(
            panelSalonSilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSalonSilLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelSalonSilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelSalonSilGrid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelSalonSilLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                        .addComponent(cxBayiSalonSil, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panelSalonSilLayout.setVerticalGroup(
            panelSalonSilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSalonSilLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelSalonSilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cxBayiSalonSil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(panelSalonSilGrid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Salon Düzenle"));

        jLabel4.setText("Bayi:");

        cxBayiSalonDuznele.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cxBayiSalonDuznele.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cxBayiSalonDuzneleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelSalonDuzenleGridLayout = new javax.swing.GroupLayout(panelSalonDuzenleGrid);
        panelSalonDuzenleGrid.setLayout(panelSalonDuzenleGridLayout);
        panelSalonDuzenleGridLayout.setHorizontalGroup(
            panelSalonDuzenleGridLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelSalonDuzenleGridLayout.setVerticalGroup(
            panelSalonDuzenleGridLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 112, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelSalonDuzenleGrid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                        .addComponent(cxBayiSalonDuznele, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cxBayiSalonDuznele, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(panelSalonDuzenleGrid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelSalonSil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panelSalonSil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cxBayiSalonEkleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cxBayiSalonEkleActionPerformed
        beid = bls.get(cxBayiSalonEkle.getSelectedIndex()).getBayiID();
        System.out.println("bayi id: " + beid);
    }//GEN-LAST:event_cxBayiSalonEkleActionPerformed

    private void btnSalonEkleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalonEkleActionPerformed
        String sadi = txtSalonEkleAdi.getText().trim();
        if (!sadi.equals("")) {
            Salon salon = new Salon();
            salon.setBayiID(beid);
            salon.setSalonAdi(sadi);
            new SalonCrud().olustur(salon);
            salonSilVeriCek();
            gridSalonSil(0, 3);
            salonDuzenleVeriCek();
            gridSalonDuzenle(0, 3);
            txtSalonEkleAdi.setText("");
            txtSalonEkleAdi.requestFocus();
            System.out.println("Ekleme başarılı!");
        } else {
            System.err.println("Salon adı boş bırakılamaz!");
        }
    }//GEN-LAST:event_btnSalonEkleActionPerformed

    private void cxBayiSalonSilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cxBayiSalonSilActionPerformed
        bsid = bls.get(cxBayiSalonSil.getSelectedIndex()).getBayiID();
        salonSilVeriCek();
        gridSalonSil(0, 3);
        salonDuzenleVeriCek();
        gridSalonDuzenle(0, 3);
        System.out.println("bayi id: " + bsid);
    }//GEN-LAST:event_cxBayiSalonSilActionPerformed

    private void cxBayiSalonDuzneleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cxBayiSalonDuzneleActionPerformed
        bdid = bls.get(cxBayiSalonDuznele.getSelectedIndex()).getBayiID();
        salonSilVeriCek();
        gridSalonSil(0, 3);
        salonDuzenleVeriCek();
        gridSalonDuzenle(0, 3);
        System.out.println("bayi id: " + bdid);
    }//GEN-LAST:event_cxBayiSalonDuzneleActionPerformed

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
            java.util.logging.Logger.getLogger(FormSalonEkle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormSalonEkle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormSalonEkle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormSalonEkle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormSalonEkle().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalonEkle;
    private javax.swing.JComboBox<String> cxBayiSalonDuznele;
    private javax.swing.JComboBox<String> cxBayiSalonEkle;
    private javax.swing.JComboBox<String> cxBayiSalonSil;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel panelSalonDuzenleGrid;
    private javax.swing.JPanel panelSalonSil;
    private javax.swing.JPanel panelSalonSilGrid;
    private javax.swing.JTextField txtSalonEkleAdi;
    // End of variables declaration//GEN-END:variables

}
