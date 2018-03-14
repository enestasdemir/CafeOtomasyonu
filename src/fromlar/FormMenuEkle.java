package fromlar;

import db.BayiCrud;
import db.MenuCrud;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import properties.Bayi;
import properties.Menu;

public class FormMenuEkle extends javax.swing.JFrame {

    ArrayList<Bayi> bls = new ArrayList<>();
    ArrayList<Menu> mls = new ArrayList<>();
    ArrayList<Menu> msListesi = new ArrayList<>();
    ArrayList<Menu> mdListesi = new ArrayList<>();

    String beid = "";
    String bsid = "";
    String bdid = "";

    public FormMenuEkle() {
        initComponents();
        bayiModelDoldur();
        beid = bls.get(cxBayiMenuEkle.getSelectedIndex()).getBayiID();
        bayiSilModelDoldur();
        bsid = bls.get(cxBayiMenuSil.getSelectedIndex()).getBayiID();
        menuSilVeriCek();
        gridMenuSil(0, 3);
        bayiDuzneleModelDoldur();
        bdid = bls.get(cxBayiMenuDuznele.getSelectedIndex()).getBayiID();
        menuDuzenleVeriCek();
        gridMenuDuzenle(0, 3);
    }

    public void gridMenuSil(int rows, int cols) {
        panelSalonSilGrid.removeAll();
        panelSalonSilGrid.revalidate();
        panelSalonSilGrid.repaint();

        System.out.println("MEnülere girildi");
        panelSalonSilGrid.setLayout(new GridLayout(rows, cols));

        for (Menu item : msListesi) {
            String mid = item.getMenuID();
            String bid = item.getBayiID();
            String madi = item.getMenuAdi();

            JButton button = new JButton(madi);
            button.setToolTipText(mid);
            panelSalonSilGrid.add(button);
            button.addActionListener((ActionEvent e) -> {
                System.out.println("bid = " + Integer.valueOf(bid) + " sid = " + mid);
                Menu menu = new Menu();
                menu.setMenuID(mid);
                int cevap = JOptionPane.showConfirmDialog(rootPane, "(" + mid + ") Bayiyi silmek istediğinize emin misiniz?", "Bayi Sil", JOptionPane.YES_NO_OPTION);
                if (cevap == 0) {
                    new MenuCrud().sil(menu);
                    menuSilVeriCek();
                    gridMenuSil(0, 3);
                    menuDuzenleVeriCek();
                    gridMenuDuzenle(0, 3);
                    System.out.println("Silme işlemi başarılı!");
                }
            });
        }
    }

    public void gridMenuDuzenle(int rows, int cols) {
        panelSalonDuzenleGrid.removeAll();
        panelSalonDuzenleGrid.revalidate();
        panelSalonDuzenleGrid.repaint();

        System.out.println("Salonlara girildi");
        panelSalonDuzenleGrid.setLayout(new GridLayout(rows, cols));

        for (Menu item : mdListesi) {
            String mid = item.getMenuID();
            String bid = item.getBayiID();
            String madi = item.getMenuAdi();

            JButton button = new JButton(madi);
            button.setToolTipText(mid);
            panelSalonDuzenleGrid.add(button);
            button.addActionListener((ActionEvent e) -> {
                System.out.println("bid = " + Integer.valueOf(bid) + " sid = " + mid);
                Menu menu = new Menu();
                menu.setMenuID(mid);
                menu.setMenuAdi(madi);
                String gelen = JOptionPane.showInputDialog(rootPane, "Lütfen yeni menü ismini giriniz.", "Menü Güncelleme", JOptionPane.DEFAULT_OPTION);
                if (!gelen.equals("") && gelen != null) {
                    menu.setMenuAdi(gelen);
                    new MenuCrud().guncelle(menu);
                    menuSilVeriCek();
                    gridMenuSil(0, 3);
                    menuDuzenleVeriCek();
                    gridMenuDuzenle(0, 3);
                    System.out.println("Güncelleme işlemi başarılı!");
                }

            });
        }
    }

    void menuSilVeriCek() {
        msListesi = new MenuCrud().veriCek(bsid);
    }

    void menuDuzenleVeriCek() {
        mdListesi = new MenuCrud().veriCek(bdid);
    }

    public void bayiModelDoldur() {
        DefaultComboBoxModel<String> bmd = new DefaultComboBoxModel<>();
        bls = new BayiCrud().veriGetir();
        for (Bayi item : bls) {
            bmd.addElement(item.getBayiAdi());
        }
        cxBayiMenuEkle.setModel(bmd);
    }

    public void bayiSilModelDoldur() {
        DefaultComboBoxModel<String> bmd = new DefaultComboBoxModel<>();
        bls = new BayiCrud().veriGetir();
        for (Bayi item : bls) {
            bmd.addElement(item.getBayiAdi());
        }
        cxBayiMenuSil.setModel(bmd);
    }

    public void bayiDuzneleModelDoldur() {
        DefaultComboBoxModel<String> bmd = new DefaultComboBoxModel<>();
        bls = new BayiCrud().veriGetir();
        for (Bayi item : bls) {
            bmd.addElement(item.getBayiAdi());
        }
        cxBayiMenuDuznele.setModel(bmd);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cxBayiMenuEkle = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        txtMenuEkleAdi = new javax.swing.JTextField();
        btnMenuEkle = new javax.swing.JButton();
        panelMenuSil = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        cxBayiMenuSil = new javax.swing.JComboBox<>();
        panelSalonSilGrid = new javax.swing.JPanel();
        panelMenuDuzenle = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        cxBayiMenuDuznele = new javax.swing.JComboBox<>();
        panelSalonDuzenleGrid = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Menü Yönetimi"));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Menü Ekle"));

        jLabel1.setText("Bayi:");

        cxBayiMenuEkle.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cxBayiMenuEkle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cxBayiMenuEkleActionPerformed(evt);
            }
        });

        jLabel2.setText("Menü Adı:");

        btnMenuEkle.setText("Menü Ekle");
        btnMenuEkle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuEkleActionPerformed(evt);
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
                            .addComponent(cxBayiMenuEkle, 0, 280, Short.MAX_VALUE)
                            .addComponent(txtMenuEkleAdi)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnMenuEkle)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cxBayiMenuEkle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtMenuEkleAdi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnMenuEkle)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelMenuSil.setBorder(javax.swing.BorderFactory.createTitledBorder("Menü Sil"));

        jLabel3.setText("Bayi:");

        cxBayiMenuSil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cxBayiMenuSil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cxBayiMenuSilActionPerformed(evt);
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

        javax.swing.GroupLayout panelMenuSilLayout = new javax.swing.GroupLayout(panelMenuSil);
        panelMenuSil.setLayout(panelMenuSilLayout);
        panelMenuSilLayout.setHorizontalGroup(
            panelMenuSilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuSilLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMenuSilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelSalonSilGrid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelMenuSilLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                        .addComponent(cxBayiMenuSil, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panelMenuSilLayout.setVerticalGroup(
            panelMenuSilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuSilLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelMenuSilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cxBayiMenuSil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(panelSalonSilGrid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panelMenuDuzenle.setBorder(javax.swing.BorderFactory.createTitledBorder("Menü Düzenle"));

        jLabel4.setText("Bayi:");

        cxBayiMenuDuznele.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cxBayiMenuDuznele.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cxBayiMenuDuzneleActionPerformed(evt);
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

        javax.swing.GroupLayout panelMenuDuzenleLayout = new javax.swing.GroupLayout(panelMenuDuzenle);
        panelMenuDuzenle.setLayout(panelMenuDuzenleLayout);
        panelMenuDuzenleLayout.setHorizontalGroup(
            panelMenuDuzenleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuDuzenleLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMenuDuzenleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelSalonDuzenleGrid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelMenuDuzenleLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                        .addComponent(cxBayiMenuDuznele, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panelMenuDuzenleLayout.setVerticalGroup(
            panelMenuDuzenleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuDuzenleLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMenuDuzenleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cxBayiMenuDuznele, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    .addComponent(panelMenuDuzenle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelMenuSil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panelMenuSil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelMenuDuzenle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void cxBayiMenuEkleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cxBayiMenuEkleActionPerformed
        beid = bls.get(cxBayiMenuEkle.getSelectedIndex()).getBayiID();
        System.out.println("bayi id: " + beid);
    }//GEN-LAST:event_cxBayiMenuEkleActionPerformed

    private void btnMenuEkleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuEkleActionPerformed
        String madi = txtMenuEkleAdi.getText().trim();
        if (!madi.equals("")) {
            Menu menu = new Menu();
            menu.setBayiID(beid);
            menu.setMenuAdi(madi);
            new MenuCrud().olustur(menu);
            menuSilVeriCek();
            gridMenuSil(0, 3);
            menuDuzenleVeriCek();
            gridMenuDuzenle(0, 3);
            txtMenuEkleAdi.setText("");
            txtMenuEkleAdi.requestFocus();
            System.out.println("Ekleme başarılı!");
        } else {
            System.err.println("Menü adı boş bırakılamaz!");
        }
    }//GEN-LAST:event_btnMenuEkleActionPerformed

    private void cxBayiMenuSilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cxBayiMenuSilActionPerformed
        bsid = bls.get(cxBayiMenuSil.getSelectedIndex()).getBayiID();
        menuSilVeriCek();
        gridMenuSil(0, 3);
        menuDuzenleVeriCek();
        gridMenuDuzenle(0, 3);
        System.out.println("bayi id: " + bsid);
    }//GEN-LAST:event_cxBayiMenuSilActionPerformed

    private void cxBayiMenuDuzneleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cxBayiMenuDuzneleActionPerformed
        bdid = bls.get(cxBayiMenuDuznele.getSelectedIndex()).getBayiID();
        menuSilVeriCek();
        gridMenuSil(0, 3);
        menuDuzenleVeriCek();
        gridMenuDuzenle(0, 3);
        System.out.println("bayi id: " + bdid);
    }//GEN-LAST:event_cxBayiMenuDuzneleActionPerformed

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
            java.util.logging.Logger.getLogger(FormMenuEkle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormMenuEkle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormMenuEkle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormMenuEkle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormMenuEkle().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMenuEkle;
    private javax.swing.JComboBox<String> cxBayiMenuDuznele;
    private javax.swing.JComboBox<String> cxBayiMenuEkle;
    private javax.swing.JComboBox<String> cxBayiMenuSil;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel panelMenuDuzenle;
    private javax.swing.JPanel panelMenuSil;
    private javax.swing.JPanel panelSalonDuzenleGrid;
    private javax.swing.JPanel panelSalonSilGrid;
    private javax.swing.JTextField txtMenuEkleAdi;
    // End of variables declaration//GEN-END:variables

}
