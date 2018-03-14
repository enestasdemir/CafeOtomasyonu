package fromlar;

import db.BayiCrud;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import properties.Bayi;

public class FormBayiEkle extends javax.swing.JFrame {

    ArrayList<Bayi> bls = new ArrayList<>();
    String bsid = "";
    String bdid = "";

    public FormBayiEkle() {
        initComponents();
        bayiSilModelDoldur();
        bayiDuzenleModelDoldur();
        bsid = bls.get(cxBayiSil.getSelectedIndex()).getBayiID();
        bdid = bls.get(cxBayiDuzenle.getSelectedIndex()).getBayiID();
    }

    public void bayiSilModelDoldur() {
        DefaultComboBoxModel<String> bmd = new DefaultComboBoxModel<>();
        bls = new BayiCrud().veriGetir();
        for (Bayi item : bls) {
            bmd.addElement(item.getBayiAdi());
        }
        cxBayiSil.setModel(bmd);
    }

    public void bayiDuzenleModelDoldur() {
        DefaultComboBoxModel<String> bmd = new DefaultComboBoxModel<>();
        bls = new BayiCrud().veriGetir();
        for (Bayi item : bls) {
            bmd.addElement(item.getBayiAdi());
        }
        cxBayiDuzenle.setModel(bmd);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        txtBayiEkleAdi = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnBayiEkle = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        cxBayiSil = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        btnBayiSil = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        cxBayiDuzenle = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtBayiDuzenleAdi = new javax.swing.JTextField();
        btnBayiDuzenle = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Bayi Yönetimi"));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Bayi Ekle"));

        jLabel1.setText("Bayi Adı:");

        btnBayiEkle.setText("Bayi Ekle");
        btnBayiEkle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBayiEkleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtBayiEkleAdi, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnBayiEkle, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBayiEkleAdi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(btnBayiEkle)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Bayi Sil"));

        cxBayiSil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cxBayiSil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cxBayiSilActionPerformed(evt);
            }
        });

        jLabel2.setText("Bayi Adı:");

        btnBayiSil.setText("Bayi Sil");
        btnBayiSil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBayiSilActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(cxBayiSil, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnBayiSil)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cxBayiSil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(btnBayiSil)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Bayi Düzenle"));

        jLabel3.setText("Bayi Adı:");

        cxBayiDuzenle.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cxBayiDuzenle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cxBayiDuzenleActionPerformed(evt);
            }
        });

        jLabel4.setText("Yeni Bayi Adı:");

        btnBayiDuzenle.setText("Bayi Düzenle");
        btnBayiDuzenle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBayiDuzenleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnBayiDuzenle))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cxBayiDuzenle, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtBayiDuzenleAdi))))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cxBayiDuzenle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtBayiDuzenleAdi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(btnBayiDuzenle)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBayiEkleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBayiEkleActionPerformed
        String badi = txtBayiEkleAdi.getText().trim();
        if (!badi.equals("")) {
            Bayi bayi = new Bayi();
            bayi.setBayiAdi(badi);
            new BayiCrud().olustur(bayi);
            bayiSilModelDoldur();
            bayiDuzenleModelDoldur();
            System.out.println("Bayi ekleme başarılı!");
        } else {
            System.err.println("Bayi adı boş bırakılamaz!");
        }
    }//GEN-LAST:event_btnBayiEkleActionPerformed

    private void btnBayiSilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBayiSilActionPerformed
        Bayi bayi = new Bayi();
        bayi.setBayiID(bsid);
        int cevap = JOptionPane.showConfirmDialog(rootPane, "(" + bsid + ") Bayiyi silmek istediğinize emin misiniz?", "Bayi Sil", JOptionPane.YES_NO_OPTION);
        if (cevap == 0) {
            new BayiCrud().sil(bayi);
            bayiSilModelDoldur();
            bayiDuzenleModelDoldur();
            System.out.println("Silme işlemi başarılı!");
        }
    }//GEN-LAST:event_btnBayiSilActionPerformed

    private void cxBayiSilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cxBayiSilActionPerformed
        bsid = bls.get(cxBayiSil.getSelectedIndex()).getBayiID();
        System.out.println("bayi id: " + bsid);
    }//GEN-LAST:event_cxBayiSilActionPerformed

    private void cxBayiDuzenleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cxBayiDuzenleActionPerformed
        bdid = bls.get(cxBayiDuzenle.getSelectedIndex()).getBayiID();
        System.out.println("bayi id: " + bdid);
    }//GEN-LAST:event_cxBayiDuzenleActionPerformed

    private void btnBayiDuzenleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBayiDuzenleActionPerformed
        String bayiAdi = txtBayiDuzenleAdi.getText().trim();
        if (!bayiAdi.equals("")) {
            Bayi bayi = new Bayi();
            bayi.setBayiID(bdid);
            bayi.setBayiAdi(bayiAdi);
            int cevap = JOptionPane.showConfirmDialog(rootPane, "Bayi adını değiştirmek istediğinize emin misiniz?", "Bayi Düzenle", JOptionPane.YES_NO_OPTION);
            if (cevap == 0) {
                new BayiCrud().guncelle(bayi);
                txtBayiDuzenleAdi.setText("");
                txtBayiDuzenleAdi.requestFocus();
                bayiSilModelDoldur();
                bayiDuzenleModelDoldur();
                System.out.println("Güncelleme işlemi başarılı!");
            }

        }
    }//GEN-LAST:event_btnBayiDuzenleActionPerformed

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
            java.util.logging.Logger.getLogger(FormBayiEkle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormBayiEkle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormBayiEkle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormBayiEkle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormBayiEkle().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBayiDuzenle;
    private javax.swing.JButton btnBayiEkle;
    private javax.swing.JButton btnBayiSil;
    private javax.swing.JComboBox<String> cxBayiDuzenle;
    private javax.swing.JComboBox<String> cxBayiSil;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField txtBayiDuzenleAdi;
    private javax.swing.JTextField txtBayiEkleAdi;
    // End of variables declaration//GEN-END:variables

}
