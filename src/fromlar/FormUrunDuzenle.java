package fromlar;

import db.BayiCrud;
import db.MenuCrud;
import db.UrunCrud;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import org.apache.commons.io.FilenameUtils;
import properties.Bayi;
import properties.Menu;
import properties.Urun;

public class FormUrunDuzenle extends javax.swing.JFrame {

    ArrayList<Bayi> bls = new ArrayList<>();
    ArrayList<Menu> mls = new ArrayList<>();
    String bid = FormUrunDuzenleSecim.dbid;
    String mida = FormUrunDuzenleSecim.dmid;
    String madia = "";
    int index = 0;
    int resim_buton = 0;

    public FormUrunDuzenle() {
        initComponents();
        bayiModelDoldur();
        int i = 0;
        for (Bayi item : bls) {
            String a = item.getBayiID();
            if (a.equals(bid)) {
                index = i;
                break;
            }
            i++;
        }
        cxBayi.setSelectedIndex(index);
        menuVeriCek();
        gridMenu(0, 2);
        for (Menu item : mls) {
            String a = item.getMenuID();
            if (a.equals(mida)) {
                index = i;
                madia = item.getMenuAdi();
                break;
            }
            i++;
        }
        lblMenu.setText(madia);
        txtAdi.setText(FormUrunDuzenleSecim.duadi);
        txtAlis.setText(FormUrunDuzenleSecim.dalis);
        txtSatis.setText(FormUrunDuzenleSecim.dsatis);
        txtAdet.setText(FormUrunDuzenleSecim.dadet);
        yol = FormUrunDuzenleSecim.dresim;
    }

    public void bayiModelDoldur() {
        DefaultComboBoxModel<String> bmd = new DefaultComboBoxModel<>();
        bls = new BayiCrud().veriGetir();
        for (Bayi item : bls) {
            bmd.addElement(item.getBayiAdi());
        }
        cxBayi.setModel(bmd);
    }

    public void gridMenu(int rows, int cols) {
        panelMenu.removeAll();
        panelMenu.revalidate();
        panelMenu.repaint();

        System.out.println("Salonlara girildi");
        panelMenu.setLayout(new GridLayout(rows, cols));

        for (Menu item : mls) {
            String mid = item.getMenuID();
            String bid = item.getBayiID();
            String madi = item.getMenuAdi();

            JButton button = new JButton(madi);
            button.setToolTipText(mid);
            panelMenu.add(button);

            button.addActionListener((ActionEvent e) -> {
                mida = item.getMenuID();
                madia = item.getMenuAdi();
                lblMenu.setText(madia);
                lblMenu.setForeground(Color.black);
                System.out.println(mida);
                System.out.println(madia);
            });
        }
    }

    void menuVeriCek() {
        mls = new MenuCrud().veriCek(bid);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        cxBayi = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtAdi = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtAlis = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtSatis = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtAdet = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnEkle = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        lblMenu = new javax.swing.JLabel();
        btnDosyaSec = new javax.swing.JButton();
        lblGorsel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        panelMenu = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Ürün Düzenlee"));

        cxBayi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cxBayi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cxBayiActionPerformed(evt);
            }
        });

        jLabel1.setText("Bayi:");

        jLabel2.setText("Ürün Adı:");

        jLabel3.setText("Alış Fiyatı:");

        jLabel4.setText("Satış Fiyatı:");

        jLabel5.setText("Adet:");

        jLabel6.setText("Ürün Resmi:");

        btnEkle.setText("Ürün Güncelleme");
        btnEkle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEkleActionPerformed(evt);
            }
        });

        jLabel7.setText("Menü:");

        lblMenu.setForeground(new java.awt.Color(153, 0, 0));
        lblMenu.setText("Lütfen bir menü seçiniz!");

        btnDosyaSec.setText("Dosya Seç");
        btnDosyaSec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDosyaSecActionPerformed(evt);
            }
        });

        lblGorsel.setBackground(new java.awt.Color(204, 204, 255));
        lblGorsel.setOpaque(true);

        javax.swing.GroupLayout panelMenuLayout = new javax.swing.GroupLayout(panelMenu);
        panelMenu.setLayout(panelMenuLayout);
        panelMenuLayout.setHorizontalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 346, Short.MAX_VALUE)
        );
        panelMenuLayout.setVerticalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 118, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(panelMenu);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnEkle))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cxBayi, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtAdi)
                            .addComponent(txtAlis)
                            .addComponent(txtSatis)
                            .addComponent(txtAdet)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblMenu)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(lblGorsel, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnDosyaSec)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane1))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cxBayi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(lblMenu))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtAdi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtAlis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtSatis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtAdet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDosyaSec)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(lblGorsel, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEkle)
                .addContainerGap())
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
        menuVeriCek();
        gridMenu(0, 2);
        System.out.println("bayi id: " + bid);
    }//GEN-LAST:event_cxBayiActionPerformed

    String yol;
    BufferedImage img = null;
    File f = null;
    String uzanti = null;

    private void btnDosyaSecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDosyaSecActionPerformed
        resim_buton = 1;
        JFileChooser resimSec = new JFileChooser();
        resimSec.showOpenDialog(null);
        File f = resimSec.getSelectedFile();
        yol = f.getAbsolutePath();
        uzanti = FilenameUtils.getExtension(f.getName());

        try {
            img = ImageIO.read(new File(yol));
        } catch (Exception e) {
            e.printStackTrace();
        }

        Image dimg = img.getScaledInstance(lblGorsel.getWidth(), lblGorsel.getHeight(), Image.SCALE_REPLICATE);
        ImageIcon resim = new ImageIcon(dimg);
        lblGorsel.setIcon(resim);
    }//GEN-LAST:event_btnDosyaSecActionPerformed

    String resimPath = "";
     
    String tur = "";
    private void btnEkleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEkleActionPerformed
        if (resim_buton == 0) {
            resimPath = yol;
        } else if (resim_buton == 1) {
            resimPath = "";
            try {
                Random rnd = new Random();
                int sayi = rnd.nextInt(999999999);
                if (uzanti.equalsIgnoreCase("jpg")) {
                    tur = "jpg";
                    f = new File("./src/img/" + sayi + ".jpg");
                    resimPath = "./src/img/" + sayi + ".jpg";
                }
                else if (uzanti.equalsIgnoreCase("png")) {
                    tur = "png";
                    f = new File("./src/img/" + sayi + ".png");
                    resimPath = "./src/img/" + sayi + ".png";
                }
                
                try {
                    ImageIO.write(img, tur, f);
                    System.out.println("Kayıt başarılı!");
                } catch (Exception e) {
                    System.out.println("Resim yükleme hatası!");
                }
            } catch (Exception e) {
            }
        }

        String kmid = mida;
        String kbid = bid;
        String adi = txtAdi.getText().trim();
        String alis = txtAlis.getText().trim();
        String satis = txtSatis.getText().trim();
        String adet = txtAdet.getText().trim();
        String resim = resimPath;

        System.out.println("GELDİ");

        Urun urun = new Urun();
        urun.setID(FormUrunDuzenleSecim.duid);
        urun.setMenuID(kmid);
        urun.setBayiID(kbid);
        urun.setAdi(adi);
        urun.setAlisFiyati(alis);
        urun.setSatisFiyati(satis);
        urun.setAdet(adet);
        urun.setResimURL(resim);
        urun.setAsciDurum("0");

        new UrunCrud().guncelle(urun);
        this.dispose();
    }//GEN-LAST:event_btnEkleActionPerformed

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
            java.util.logging.Logger.getLogger(FormUrunDuzenle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormUrunDuzenle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormUrunDuzenle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormUrunDuzenle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
                new FormUrunDuzenle().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDosyaSec;
    private javax.swing.JButton btnEkle;
    private javax.swing.JComboBox<String> cxBayi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblGorsel;
    private javax.swing.JLabel lblMenu;
    private javax.swing.JPanel panelMenu;
    private javax.swing.JTextField txtAdet;
    private javax.swing.JTextField txtAdi;
    private javax.swing.JTextField txtAlis;
    private javax.swing.JTextField txtSatis;
    // End of variables declaration//GEN-END:variables

}
