package fromlar;

import db.DB;
import db.MasaCrud;
import db.SalonCrud;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import properties.Masa;
import properties.Salon;
import properties.Urun;

public class FormMasalar extends javax.swing.JFrame {
    int kbid = FormLogin.bayiID;
    static HashMap<Integer, Salon> sListesi = new HashMap<>();
    static HashMap<Integer, Masa> masaListesi = new HashMap<>();
    static HashMap<Integer, Urun> s = new HashMap<>();
    DB db = new DB("cafe", "root", "");

    public FormMasalar() {
        setUndecorated(true);
        initComponents();
        salonVeriGetir(kbid);
        masaVeriGetir(kbid, 1);
        int rows = 0;
        int cols = 5;
        gridSalonlar(rows, cols);
        int rows2 = 0;
        int cols2 = 5;
        gridMasalar(rows2, cols2, 1, 1);
        lblKullanici.setText(FormLogin.personelAdi);
        lblKullanici1.setText(FormLogin.bayiAdi);
    }

    public void gridSalonlar(int rows, int cols) {
        System.out.println("Salonlara girildi");
        panelSalonlar.setLayout(new GridLayout(rows, cols));

        for (Map.Entry<Integer, Salon> entry : sListesi.entrySet()) {
            int key = entry.getKey();
            String sid = sListesi.get(key).getSalonID();
            String bid = sListesi.get(key).getBayiID();
            String madi = sListesi.get(key).getSalonMasaAdedi();
            String sadi = sListesi.get(key).getSalonAdi();

            JButton button = new JButton(sadi); //buton textini ürünün adı yaptık
            button.setVerticalTextPosition(SwingConstants.BOTTOM); //yazıyı alta aldık
            button.setHorizontalTextPosition(SwingConstants.CENTER); //yazıyı merkezledik
            button.setToolTipText(sid);
            panelSalonlar.add(button);
            button.addActionListener((ActionEvent e) -> {
                System.out.println("bid = " + Integer.valueOf(bid) + " sid = " + sid);
                masaVeriGetir(Integer.valueOf(bid), Integer.valueOf(sid));
                gridMasalar(rows, cols, Integer.valueOf(bid), Integer.valueOf(sid));
            });
        }
    }
    static int masaid;
    static String masano;

    public void gridMasalar(int rows, int cols, int bayiid, int menuid) {
        panelMasalar.removeAll();
        panelMasalar.revalidate();
        panelMasalar.repaint();

        System.out.println("masalara girildi");
        panelMasalar.setLayout(new GridLayout(rows, cols));

        Set keyset = masaListesi.keySet();
        System.out.println("kyset masalar = " + keyset);
        System.out.println("keyset = " + keyset);

        int i = 0;

        for (Map.Entry<Integer, Masa> entry : masaListesi.entrySet()) {
            int key = entry.getKey();

            // her bir ürün için istediğim verileri arraylistten alıyorum.
            String masaID = masaListesi.get(key).getMasaid();
            String bayiID = masaListesi.get(key).getBid();
            String salonID = masaListesi.get(key).getSid();
            String masaDurum = masaListesi.get(key).getMdurum();
            System.out.println("key = " + key);

            int masanu = ++i;

            JButton button = new JButton(String.valueOf(masanu));
            try {
                String q = "call masaNo('" + masaID + "','" + masanu + "')";
                db.baglan().executeUpdate(q);
            } catch (SQLException e) {
                System.err.println("Masa no hatasi = " + e);
            }
            if (Integer.valueOf(masaDurum) == 0) {
                button.setBackground( new Color(179, 194, 191) );
            } else {
                button.setBackground( new Color(230, 39, 57) );
            }

            button.setVerticalTextPosition(SwingConstants.BOTTOM); //yazıyı alta aldık
            button.setHorizontalTextPosition(SwingConstants.CENTER); //yazıyı merkezledik
            panelMasalar.add(button);
            button.addActionListener((ActionEvent e) -> {
                masaid = Integer.valueOf(masaID);
                masano = button.getText();
                System.out.println("masano: " + masano);

                FormAdisyon.adisyonGeri = 1;
                HashMap<Integer, Urun> a = new HashMap<>();
                try {
                    String q = "call sip('" + masaid + "')";
                    ResultSet rs = db.baglan().executeQuery(q);
                    while (rs.next()) {
                        Urun u = new Urun();
                        String masaid = rs.getString("masaid");
                        String urunadi = rs.getString("siparisadi");
                        String siparisadet = rs.getString("siparisadet");
                        String toplamfiyat = rs.getString("siparisfiyat");
                        String siparisfiyat = String.valueOf(Double.valueOf(toplamfiyat) / Double.valueOf(siparisadet));    
                        String ascidurum = rs.getString("ascidurum");
                        String suid = rs.getString("uid");
                        u.setAdet(siparisadet);
                        u.setSatisFiyati(siparisfiyat);
                        u.setID(siparisadet);
                        u.setAdi(urunadi);
                        u.setAsciDurum(ascidurum);
                        a.put(Integer.valueOf(suid), u);
                    }
                } catch (Exception ex) {
                    System.out.println("Aktarma Başarısız");
                }
                try {
                    String q = "call masaDurum('" + FormMasalar.masaid + "','" + 1 + "')";
                    db.baglan().executeUpdate(q);
                } catch (Exception es) {
                    System.out.println("masa durum güncellenmedi " + es);
                }
                FormAdisyon.sip = (HashMap<Integer, Urun>) a.clone();
                FormAdisyon fa = new FormAdisyon(a);
                
                fa.setVisible(true);
                setVisible(false);
            });

        }
    }

    static void salonVeriGetir(int bid) {
        sListesi = new SalonCrud().veriGetir(bid);
    }

    static void masaVeriGetir(int bid, int sid) {
        // urunCrud ürün için veritabanı işlemlerini yapan sınıf
        //o sınıftan veriyi getirip kullanmak üzere array liste atıyorum
        //uListesi = new UrunCrud().veriGetir();
        masaListesi = new MasaCrud().veriGetir(bid, sid);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMasa = new javax.swing.JPanel();
        panelSalonlar = new javax.swing.JPanel();
        panelMasalar = new javax.swing.JPanel();
        panelBar = new javax.swing.JPanel();
        lblKullanici = new javax.swing.JLabel();
        lblKullanici1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelMasa.setBackground(new java.awt.Color(192, 223, 217));

        panelSalonlar.setBackground(new java.awt.Color(192, 223, 217));

        javax.swing.GroupLayout panelSalonlarLayout = new javax.swing.GroupLayout(panelSalonlar);
        panelSalonlar.setLayout(panelSalonlarLayout);
        panelSalonlarLayout.setHorizontalGroup(
            panelSalonlarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 710, Short.MAX_VALUE)
        );
        panelSalonlarLayout.setVerticalGroup(
            panelSalonlarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 109, Short.MAX_VALUE)
        );

        panelMasalar.setBackground(new java.awt.Color(192, 223, 217));

        javax.swing.GroupLayout panelMasalarLayout = new javax.swing.GroupLayout(panelMasalar);
        panelMasalar.setLayout(panelMasalarLayout);
        panelMasalarLayout.setHorizontalGroup(
            panelMasalarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelMasalarLayout.setVerticalGroup(
            panelMasalarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 266, Short.MAX_VALUE)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblKullanici1)
                .addGap(18, 18, 18)
                .addComponent(jLabel1))
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

        javax.swing.GroupLayout panelMasaLayout = new javax.swing.GroupLayout(panelMasa);
        panelMasa.setLayout(panelMasaLayout);
        panelMasaLayout.setHorizontalGroup(
            panelMasaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMasaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMasaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelSalonlar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelMasalar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(panelBar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelMasaLayout.setVerticalGroup(
            panelMasaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMasaLayout.createSequentialGroup()
                .addComponent(panelBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panelSalonlar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panelMasalar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMasa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMasa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MousePressed
        FormMain fm = new FormMain();
        fm.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel1MousePressed

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
            java.util.logging.Logger.getLogger(FormMasalar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormMasalar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormMasalar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormMasalar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormMasalar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblKullanici;
    private javax.swing.JLabel lblKullanici1;
    private javax.swing.JPanel panelBar;
    private javax.swing.JPanel panelMasa;
    private javax.swing.JPanel panelMasalar;
    private javax.swing.JPanel panelSalonlar;
    // End of variables declaration//GEN-END:variables
}
