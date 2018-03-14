package fromlar;

import db.DB;
import db.MenuCrud;
import db.UrunCrud;
import static fromlar.FormAdisyon.urunVeriGetir;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import properties.Urun;
import properties.Menu;

public class FormAdisyon extends javax.swing.JFrame {

    DB db = new DB("cafe", "root", "");
    static HashMap<Integer, Urun> uListesi = new HashMap<>();
    static HashMap<Integer, Urun> sip = new HashMap<>();
    static ArrayList<Menu> mListesi = new ArrayList<>();
    int kbid = FormLogin.bayiID;

    public FormAdisyon() {
        setUndecorated(true);
        initComponents();
        lblKullanici.setText(FormLogin.personelAdi);
        lblKullanici1.setText(FormLogin.bayiAdi);
        System.out.println("Form Adisyon");
        // DB'den çekilen ürünleri arrayliste aktaran method
        //urunVeriGetir();
        dataDoldur();

        urunVeriGetir(kbid, 1);
        menuVeriGetir();
        int rows = 0;
        int cols = 5;
        gridMenuler(rows, cols);

        int rows2 = 0;
        int cols2 = 5;
        gridUrunler(rows2, cols2, 1, 4);

    }

    public FormAdisyon(HashMap<Integer, Urun> a) {
        setUndecorated(true);
        initComponents();
        lblKullanici.setText(FormLogin.personelAdi);
        lblKullanici1.setText(FormLogin.bayiAdi);
        System.out.println("HashMap<Integer,Urun>");

        if (FormAdisyon.adisyonGeri == 1) {
            dataDoldur();
            System.out.println("daa doldur çalıştı");
        }
        FormAdisyon.adisyonGeri = 0;

        // DB'den çekilen ürünleri arrayliste aktaran method
        //urunVeriGetir();
        dataDoldur();
        urunVeriGetir(1, 1);
        menuVeriGetir();
        int rows = 0;
        int cols = 5;
        gridMenuler(rows, cols);

        int rows2 = 0;
        int cols2 = 5;
        gridUrunler(rows2, cols2, 1, 4);
//        a = (HashMap<Integer, Urun>) sip.clone();
//        DefaultTableModel siparis = new DefaultTableModel();
//        siparis.addColumn("Adı");
//        siparis.addColumn("Adet");
//        siparis.addColumn("Fiyat");

    }

    public void gridMenuler(int rows, int cols) {
        panelMenuler.setLayout(new GridLayout(rows, cols));
        for (int i = 0; i < mListesi.size(); i++) {
            String mid = mListesi.get(i).getMenuID();
            String bid = mListesi.get(i).getBayiID();
            String madi = mListesi.get(i).getMenuAdi();

            JButton button = new JButton(madi); //buton textini ürünün adı yaptık
            button.setVerticalTextPosition(SwingConstants.BOTTOM); //yazıyı alta aldık
            button.setHorizontalTextPosition(SwingConstants.CENTER); //yazıyı merkezledik
            button.setToolTipText(mid);
            panelMenuler.add(button);
            button.addActionListener((ActionEvent e) -> {

                String did = button.getToolTipText();
                uListesi.clear();

                urunVeriGetir(Integer.valueOf(1), Integer.valueOf(did));

                gridUrunler(rows, cols, Integer.valueOf(bid), Integer.valueOf(mid));

            });
        }
    }

    Urun siparisler = new Urun();

    int iz = 0;
    String name = "";
    int bayiid = 1;
    int menuid = 4;
    int ac = 0;

    public void gridUrunler(int rows, int cols, int bayiid, int menuid) {

        panelUrunler.removeAll();
        panelUrunler.revalidate();
        panelUrunler.repaint();
        panelUrunler.setLayout(new GridLayout(rows, cols));

        Set keyset = uListesi.keySet();
        System.out.println("keyset = " + keyset);
        for (Map.Entry<Integer, Urun> entry : uListesi.entrySet()) {
            int key = entry.getKey();

            // her bir ürün için istediğim verileri arraylistten alıyorum.
            String urunID = uListesi.get(key).getID();
            String urunAdi = uListesi.get(key).getAdi();
            String urunResim = uListesi.get(key).getResimURL();
            String fiyat = uListesi.get(key).getSatisFiyati();
            String bid = uListesi.get(key).getBayiID();
            String mid = uListesi.get(key).getMenuID();
            String uid = uListesi.get(key).getID();
            String asciDurum = uListesi.get(key).getAsciDurum();

            System.out.println("aşçı durum = " + asciDurum);

            int sıralama = key;

            JButton button = new JButton(urunAdi); //buton textini ürünün adı yaptık

            ImageIcon resim = new ImageIcon(urunResim);
            Image image = resim.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
            resim.setImage(image);

            button.setIcon(resim); //buton resmini ürün resmi yaptık
            button.setVerticalTextPosition(SwingConstants.BOTTOM); //yazıyı alta aldık
            button.setHorizontalTextPosition(SwingConstants.CENTER); //yazıyı merkezledik
            button.setToolTipText(uid);
            int uadet = 1;
            panelUrunler.add(button);

            button.addActionListener((ActionEvent e) -> {
                //arrayliste verileri atıp daha sonra bu verileri sipariş table'ında kullanmak için
                Urun siparisler = new Urun();
                System.out.println("masaNO = " + FormMasalar.masano);
                if (sip.isEmpty()) {
                    siparisler.setAdi(urunAdi);
                    siparisler.setSatisFiyati(fiyat);
                    siparisler.setAdet(String.valueOf(uadet));
                    siparisler.setAsciDurum(asciDurum);
                    siparisler.setBayiID(bid);
                    System.out.println("asci Durum = " + asciDurum);
                    sip.put(key, siparisler);

                    name += urunAdi;
                    iz++;

                } else {
                    if (sip.get(key) != null) {
                        int a = Integer.valueOf(sip.get(sıralama).getAdet());
                        sip.get(sıralama).setAdet(String.valueOf(a + 1));
                    } else {
                        siparisler.setAdi(urunAdi);
                        siparisler.setSatisFiyati(fiyat);
                        siparisler.setAdet(String.valueOf(uadet));
                        siparisler.setAsciDurum(asciDurum);
                        siparisler.setBayiID(bid);
                        System.out.println("ascidurum = " + asciDurum);
                        sip.put(key, siparisler);
                        iz++;
                        name += urunAdi;
                    }

                }
                panelUrunler.setLayout(null);
                dataDoldur();

            });

        }
    }

    static void menuVeriGetir() {
        mListesi = new MenuCrud().veriGetir();
    }

    static void urunVeriGetir() {
        // urunCrud ürün için veritabanı işlemlerini yapan sınıf
        //o sınıftan veriyi getirip kullanmak üzere array liste atıyorum
        //uListesi = new UrunCrud().veriGetir();
    }

    public void dataDoldur() {
        DefaultTableModel siparis = new DefaultTableModel();
        siparis.addColumn("Adı");
        siparis.addColumn("Adet");
        siparis.addColumn("Fiyat");
        siparis.addColumn("Durum");
        double toplamOdeme = 0;
        Set keyset1 = sip.keySet();
        System.out.println("keyset = " + keyset1);
        for (Map.Entry<Integer, Urun> entry1 : sip.entrySet()) {
            int key1 = entry1.getKey();
            double adet = Double.valueOf(sip.get(key1).getAdet());
            System.out.println("data doldur getAcidurum = " + sip.get(key1).getAsciDurum());
            siparis.addRow(new Object[]{sip.get(key1).getAdi(), sip.get(key1).getAdet(), Double.valueOf(sip.get(key1).getSatisFiyati()) * adet, sip.get(key1).getAsciDurum()});
            toplamOdeme += Double.valueOf(sip.get(key1).getSatisFiyati()) * adet;
        }
        jLabel1.setText(String.valueOf(toplamOdeme));
        sTablo.setModel(siparis);

    }

    static void urunVeriGetir(int bid, int mid) {
        uListesi = new UrunCrud().veriGetir(bid, mid);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelArka = new javax.swing.JPanel();
        panelMenuler = new javax.swing.JPanel();
        panelUrunler = new javax.swing.JPanel();
        panelSiparis = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        sTablo = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        panelBar = new javax.swing.JPanel();
        lblKullanici = new javax.swing.JLabel();
        lblKullanici1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelArka.setBackground(new java.awt.Color(192, 223, 217));

        panelMenuler.setBackground(new java.awt.Color(192, 223, 217));
        panelMenuler.setBorder(javax.swing.BorderFactory.createTitledBorder("Menüler"));
        panelMenuler.setPreferredSize(new java.awt.Dimension(648, 150));

        javax.swing.GroupLayout panelMenulerLayout = new javax.swing.GroupLayout(panelMenuler);
        panelMenuler.setLayout(panelMenulerLayout);
        panelMenulerLayout.setHorizontalGroup(
            panelMenulerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelMenulerLayout.setVerticalGroup(
            panelMenulerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        panelUrunler.setBackground(new java.awt.Color(192, 223, 217));
        panelUrunler.setBorder(javax.swing.BorderFactory.createTitledBorder("Ürünler"));
        panelUrunler.setPreferredSize(new java.awt.Dimension(648, 380));

        javax.swing.GroupLayout panelUrunlerLayout = new javax.swing.GroupLayout(panelUrunler);
        panelUrunler.setLayout(panelUrunlerLayout);
        panelUrunlerLayout.setHorizontalGroup(
            panelUrunlerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 630, Short.MAX_VALUE)
        );
        panelUrunlerLayout.setVerticalGroup(
            panelUrunlerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        panelSiparis.setBackground(new java.awt.Color(192, 223, 217));
        panelSiparis.setBorder(javax.swing.BorderFactory.createTitledBorder("Sipariş"));

        sTablo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        sTablo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                sTabloMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(sTablo);

        jButton1.setText("Ekle");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Çıkar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Hesap Öde");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Geri");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Masa Aktar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelSiparisLayout = new javax.swing.GroupLayout(panelSiparis);
        panelSiparis.setLayout(panelSiparisLayout);
        panelSiparisLayout.setHorizontalGroup(
            panelSiparisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSiparisLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelSiparisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(panelSiparisLayout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        panelSiparisLayout.setVerticalGroup(
            panelSiparisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSiparisLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelSiparisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelSiparisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1)
                        .addComponent(jButton2)
                        .addComponent(jButton3)
                        .addComponent(jButton4)
                        .addComponent(jButton5))))
        );

        panelBar.setBackground(new java.awt.Color(59, 58, 54));

        lblKullanici.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        lblKullanici.setForeground(new java.awt.Color(255, 255, 255));
        lblKullanici.setText("Kullanıcı Adı");

        lblKullanici1.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        lblKullanici1.setForeground(new java.awt.Color(255, 255, 255));
        lblKullanici1.setText("Bayi Adı");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/kapatbeyaz.png"))); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel2MousePressed(evt);
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
                .addComponent(jLabel2))
        );
        panelBarLayout.setVerticalGroup(
            panelBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBarLayout.createSequentialGroup()
                .addGroup(panelBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblKullanici1)
                        .addComponent(lblKullanici))
                    .addComponent(jLabel2))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelArkaLayout = new javax.swing.GroupLayout(panelArka);
        panelArka.setLayout(panelArkaLayout);
        panelArkaLayout.setHorizontalGroup(
            panelArkaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelArkaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelArkaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelUrunler, 642, 642, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelMenuler, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(panelSiparis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(panelBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelArkaLayout.setVerticalGroup(
            panelArkaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelArkaLayout.createSequentialGroup()
                .addComponent(panelBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelArkaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelSiparis, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelArkaLayout.createSequentialGroup()
                        .addComponent(panelMenuler, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelUrunler, javax.swing.GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelArka, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelArka, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    String uadi = "";
    private void sTabloMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sTabloMousePressed
        int row = sTablo.getSelectedRow();
        if (row > -1) {
            uadi = "" + sTablo.getValueAt(row, 0);
            System.out.println("uadi : " + uadi);
        }
    }//GEN-LAST:event_sTabloMousePressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        for (Map.Entry<Integer, Urun> entry : sip.entrySet()) {
            int key = entry.getKey();
            if (sip.get(key).getAdi().equals(uadi)) {
                int adet = Integer.valueOf(sip.get(key).getAdet());
                sip.get(key).setAdet("" + (adet + 1));
            }
        }
        dataDoldur();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        for (Map.Entry<Integer, Urun> entry : sip.entrySet()) {
            int key = entry.getKey();

            if (sip.get(key).getAdi().equals(uadi)) {
                if (Integer.valueOf(sip.get(key).getAdet()) > 1) {
                    int adet = Integer.valueOf(sip.get(key).getAdet());
                    sip.get(key).setAdet("" + (adet - 1));
                    dataDoldur();
                } else if (Integer.valueOf(sip.get(key).getAdet()) == 1) {
                    sip.remove(key);
                    uadi = "";
                    dataDoldur();
                    break;
                }
            }

        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Calendar simdi = Calendar.getInstance();
        Date date = simdi.getTime();
        System.out.println("Date : " + date);
        String ay = String.valueOf(simdi.get(Calendar.MONTH)); // Ağustos
        String gun = String.valueOf(simdi.get(Calendar.DATE));         // 24
        String yıl = String.valueOf(simdi.get(Calendar.YEAR));         // 2014

        simdi.add(Calendar.HOUR_OF_DAY, +1);
        String saat = String.valueOf(simdi.get(Calendar.HOUR_OF_DAY));         // 2
        String dakika = String.valueOf(simdi.get(Calendar.MINUTE));       // 12
        String saniye = String.valueOf(simdi.get(Calendar.SECOND));       // 51
        for (Map.Entry<Integer, Urun> entry : sip.entrySet()) {
            int key = entry.getKey();
            try {
                double adet = Double.valueOf(sip.get(key).getAdet());
                System.out.println("sipariş adı = " + sip.get(key).getAdi());
                String q = "call raporEkle('" + sip.get(key).getBayiID() + "','" + sip.get(key).getAdi() + "','" + sip.get(key).getAdet() + "','" + Double.valueOf(sip.get(key).getSatisFiyati()) * adet + "',now())";
                System.out.println("callSipGetir = " + q);
                int rs = db.baglan().executeUpdate(q);
            } catch (NumberFormatException | SQLException e) {
                System.err.println("ekleme hatası = " + e);

            }
        }
        try {
            String q = "call masaDurum('" + FormMasalar.masaid + "','" + 0 + "')";
            db.baglan().executeUpdate(q);
        } catch (SQLException e) {
            System.out.println("silme hatası");
        }

        try {
            String q = "call sipSil('" + FormMasalar.masaid + "')";
            db.baglan().executeUpdate(q);
        } catch (SQLException e) {
            System.out.println("silme hatası");
        }
        sip.clear();
        dataDoldur();


    }//GEN-LAST:event_jButton3ActionPerformed

    static int adisyonGeri = 0;
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        for (Map.Entry<Integer, Urun> entry : sip.entrySet()) {
            int key = entry.getKey();
            try {
                System.out.println("ıd = " + key);
                String q = "call sipSil('" + FormMasalar.masaid + "')";
                int rs = db.baglan().executeUpdate(q);
            } catch (SQLException e) {
                System.err.println("Silme Hatası");
            }
        }
        System.out.println("sip key = " + sip.entrySet());
        for (Map.Entry<Integer, Urun> entry : sip.entrySet()) {
            int key = entry.getKey();
            try {
                double adet = Double.valueOf(sip.get(key).getAdet());
                System.out.println("sipariş adı = " + sip.get(key).getAdi());
                String q = "call sipGetir('" + FormMasalar.masaid + "','" + String.valueOf(key) + "','" + sip.get(key).getAdi() + "','" + sip.get(key).getAdet() + "','" + Double.valueOf(sip.get(key).getSatisFiyati()) * adet + "','" + Integer.valueOf(sip.get(key).getAsciDurum()) + "')";
                System.out.println("callSipGetir = " + q);
                int rs = db.baglan().executeUpdate(q);
            } catch (NumberFormatException | SQLException e) {
                System.err.println("ekleme hatası = " + e);

            }
        }

        FormMasalar.s = (HashMap<Integer, Urun>) sip.clone();
        adisyonGeri = 1;
        FormMasalar fm = new FormMasalar();
        fm.setVisible(true);
        setVisible(false);
        dispose();

        sip.clear();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        FormMasaAktarma fma = new FormMasaAktarma();
        fma.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jLabel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MousePressed
        FormMasalar fm = new FormMasalar();
        fm.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel2MousePressed

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
            java.util.logging.Logger.getLogger(FormAdisyon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormAdisyon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormAdisyon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormAdisyon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new FormAdisyon().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblKullanici;
    private javax.swing.JLabel lblKullanici1;
    private javax.swing.JPanel panelArka;
    private javax.swing.JPanel panelBar;
    private javax.swing.JPanel panelMenuler;
    private javax.swing.JPanel panelSiparis;
    private static javax.swing.JPanel panelUrunler;
    private static javax.swing.JTable sTablo;
    // End of variables declaration//GEN-END:variables
}
