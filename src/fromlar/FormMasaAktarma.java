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

public class FormMasaAktarma extends javax.swing.JFrame {

    static HashMap<Integer, Salon> sListesi = new HashMap<>();
    static HashMap<Integer, Masa> masaListesi = new HashMap<>();
    static HashMap<Integer, Urun> s = new HashMap<>();
    DB db = new DB("cafe", "root", "");

    public FormMasaAktarma() {
        initComponents();
        salonVeriGetir();
        masaVeriGetir(1, 1);
        int rows = 0;
        int cols = 5;
        gridSalonlar(rows, cols);
        int rows2 = 0;
        int cols2 = 5;
        gridMasalar(rows2, cols2, 1, 1);

    }

    public void gridSalonlar(int rows, int cols) {
        System.out.println("Salonlara girildi");
        panelSalonlar.setLayout(new GridLayout(rows, cols));
        for (int i = 1; i < 3; i++) {
            String sid = sListesi.get(i).getSalonID();
            String bid = sListesi.get(i).getBayiID();
            String madi = sListesi.get(i).getSalonMasaAdedi();
            String sadi = sListesi.get(i).getSalonAdi();

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
    static int masaaktarid;

    public void gridMasalar(int rows, int cols, int bayiid, int menuid) {

        panelMasalar.removeAll();
        panelMasalar.revalidate();
        panelMasalar.repaint();

        System.out.println("masalara girildi");
        panelMasalar.setLayout(new GridLayout(rows, cols));

        Set keyset = masaListesi.keySet();
        System.out.println("kyset masalar = " + keyset);
        System.out.println("keyset = " + keyset);
        for (Map.Entry<Integer, Masa> entry : masaListesi.entrySet()) {
            int key = entry.getKey();

            // her bir ürün için istediğim verileri arraylistten alıyorum.
            String masaID = masaListesi.get(key).getMasaid();
            String bayiID = masaListesi.get(key).getBid();
            String salonID = masaListesi.get(key).getSid();
            String masaDurum = masaListesi.get(key).getMdurum();
            System.out.println("key = " + key);

            JButton button = new JButton(masaID);
            if (Integer.valueOf(masaDurum) == 0) {
                button.setBackground( new Color(179, 194, 191) );
            } else {
                button.setBackground( new Color(230, 39, 57) );
            }
            button.setToolTipText(masaDurum);
            button.setVerticalTextPosition(SwingConstants.BOTTOM); //yazıyı alta aldık
            button.setHorizontalTextPosition(SwingConstants.CENTER); //yazıyı merkezledik
            panelMasalar.add(button);
            
            button.addActionListener((ActionEvent e) -> {
                masaaktarid = Integer.valueOf(masaID);
                int emid = FormMasalar.masaid;
                int ymid = masaaktarid;
                
                String q = "call masaAktar('" + emid + "', '" + ymid +"')";
                try {
                    db.baglan().executeUpdate(q);
                } catch (SQLException ew) {
                    System.out.println("akarma hatası: " + ew);
                }
                FormMasalar.masaid = ymid;
                FormAdisyon fa = new FormAdisyon();
                fa.setVisible(true);
                setVisible(false);

//                FormAdisyon.adisyonGeri = 1;
//                HashMap<Integer, Urun> a = new HashMap<>();
//                try {
//                    String q = "call sip('" + masaid + "')";
//                    ResultSet rs = db.baglan().executeQuery(q);
//                    while (rs.next()) {
//                        Urun u = new Urun();
//                        String masaid = rs.getString("masaid");
//                        String urunadi = rs.getString("siparisadi");
//                        String siparisadet = rs.getString("siparisadet");
//                        String toplamfiyat = rs.getString("siparisfiyat");
//                        String siparisfiyat = String.valueOf(Double.valueOf(toplamfiyat) / Double.valueOf(siparisadet));
//                        String suid = rs.getString("uid");
//                        u.setAdet(siparisadet);
//                        u.setSatisFiyati(siparisfiyat);
//                        u.setID(siparisadet);
//                        u.setAdi(urunadi);
//                        a.put(Integer.valueOf(suid), u);
//                    }
//                } catch (Exception ex) {
//                    System.out.println("Aktarma Başarısız");
//                }
//                try {
//                    String q = "call masaDurum('" + FormMasaAktarma.masaid + "','" + 1 + "')";
//                    db.baglan().executeUpdate(q);
//                } catch (Exception es) {
//                    System.out.println("masa durum güncellenmedi " + es);
//                }
//                FormAdisyon.sip = (HashMap<Integer, Urun>) a.clone();
//                FormAdisyon fa = new FormAdisyon(a);
//                fa.setVisible(true);
//                setVisible(false);
            });

        }
    }

    static void salonVeriGetir() {
        sListesi = new SalonCrud().veriGet();
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

        jPanel1 = new javax.swing.JPanel();
        panelSalonlar = new javax.swing.JPanel();
        panelMasalar = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(192, 223, 217));

        panelSalonlar.setBackground(new java.awt.Color(192, 223, 217));

        javax.swing.GroupLayout panelSalonlarLayout = new javax.swing.GroupLayout(panelSalonlar);
        panelSalonlar.setLayout(panelSalonlarLayout);
        panelSalonlarLayout.setHorizontalGroup(
            panelSalonlarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelSalonlarLayout.setVerticalGroup(
            panelSalonlarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 98, Short.MAX_VALUE)
        );

        panelMasalar.setBackground(new java.awt.Color(192, 223, 217));

        javax.swing.GroupLayout panelMasalarLayout = new javax.swing.GroupLayout(panelMasalar);
        panelMasalar.setLayout(panelMasalarLayout);
        panelMasalarLayout.setHorizontalGroup(
            panelMasalarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 610, Short.MAX_VALUE)
        );
        panelMasalarLayout.setVerticalGroup(
            panelMasalarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 293, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelMasalar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelSalonlar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelSalonlar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panelMasalar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            java.util.logging.Logger.getLogger(FormMasaAktarma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormMasaAktarma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormMasaAktarma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormMasaAktarma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormMasaAktarma().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel panelMasalar;
    private javax.swing.JPanel panelSalonlar;
    // End of variables declaration//GEN-END:variables
}
