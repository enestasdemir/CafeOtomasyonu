package fromlar;

import db.BayiCrud;
import db.MasaCrud;
import db.SalonCrud;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import properties.Bayi;
import properties.Masa;
import properties.Salon;

public class FormMasaEkle extends javax.swing.JFrame {

    ArrayList<Bayi> bls = new ArrayList<>();
    ArrayList<Salon> sls = new ArrayList<>();

    String bid = "1";
    String sid = "1";

    public FormMasaEkle() {
        initComponents();
        bayiModelDoldur();
        bid = bls.get(cxBayi.getSelectedIndex()).getBayiID();
        salonModelDoldur(bid);
        sid = sls.get(cxSalon.getSelectedIndex()).getSalonID();
    }

    public void bayiModelDoldur() {
        DefaultComboBoxModel<String> bmd = new DefaultComboBoxModel<>();
        bls = new BayiCrud().veriGetir();
        for (Bayi item : bls) {
            bmd.addElement(item.getBayiAdi());
        }
        cxBayi.setModel(bmd);
    }

    public void salonModelDoldur(String bid) {
        DefaultComboBoxModel<String> smd = new DefaultComboBoxModel<>();
        sls = new SalonCrud().veriGetir();
        for (Salon item : sls) {
            if (item.getBayiID().equals(bid)) {
                smd.addElement(item.getSalonAdi());
            }
        }
        cxSalon.setModel(smd);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cxBayi = new javax.swing.JComboBox<>();
        cxSalon = new javax.swing.JComboBox<>();
        btnMasaEkle = new javax.swing.JButton();
        bnMasaSil = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Bayi Seçiniz");

        jLabel2.setText("Salon Seçiniz");

        cxBayi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cxBayi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cxBayiActionPerformed(evt);
            }
        });

        cxSalon.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cxSalon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cxSalonActionPerformed(evt);
            }
        });

        btnMasaEkle.setText("Masa Ekle");
        btnMasaEkle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMasaEkleActionPerformed(evt);
            }
        });

        bnMasaSil.setText("Masa Sil");
        bnMasaSil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnMasaSilActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(bnMasaSil)
                        .addGap(18, 18, 18)
                        .addComponent(btnMasaEkle))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cxBayi, 0, 200, Short.MAX_VALUE)
                            .addComponent(cxSalon, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cxBayi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cxSalon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMasaEkle)
                    .addComponent(bnMasaSil))
                .addContainerGap(191, Short.MAX_VALUE))
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

    private void cxBayiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cxBayiActionPerformed
        bid = bls.get(cxBayi.getSelectedIndex()).getBayiID();
        System.out.println("bayi id: " + bid);
        salonModelDoldur(bid);
    }//GEN-LAST:event_cxBayiActionPerformed

    private void btnMasaEkleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMasaEkleActionPerformed
        Masa masa = new Masa();
        masa.setBid(bid);
        masa.setSid(sid);
        new MasaCrud().olustur(masa);
    }//GEN-LAST:event_btnMasaEkleActionPerformed

    private void cxSalonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cxSalonActionPerformed
        sid = sls.get(cxSalon.getSelectedIndex()).getSalonID();
        System.out.println("salon id:" + sid);
    }//GEN-LAST:event_cxSalonActionPerformed

    private void bnMasaSilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnMasaSilActionPerformed
        Masa masa = new Masa();
        masa.setBid(bid);
        masa.setSid(sid);
        new MasaCrud().sil(masa);
    }//GEN-LAST:event_bnMasaSilActionPerformed

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
            java.util.logging.Logger.getLogger(FormMasaEkle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormMasaEkle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormMasaEkle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormMasaEkle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormMasaEkle().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bnMasaSil;
    private javax.swing.JButton btnMasaEkle;
    private javax.swing.JComboBox<String> cxBayi;
    private javax.swing.JComboBox<String> cxSalon;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
