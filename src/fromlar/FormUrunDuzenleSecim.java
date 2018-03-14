package fromlar;

import db.BayiCrud;
import db.MenuCrud;
import db.UrunCrud;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import properties.Bayi;
import properties.Menu;
import properties.Urun;

public class FormUrunDuzenleSecim extends javax.swing.JFrame {

    ArrayList<Bayi> bls = new ArrayList<>();
    ArrayList<Menu> mls = new ArrayList<>();
    ArrayList<Urun> uls = new ArrayList<>();
    String bid = "";
    String mid = "1";
    String mida = "";
    String madia = "";

    static String duid = "";
    static String dbid = "";
    static String dmid = "";
    static String duadi = "";
    static String dalis = "";
    static String dsatis = "";
    static String dadet = "";
    static String dresim = "";
    static String dasci = "";

    public FormUrunDuzenleSecim() {
        initComponents();
        bayiModelDoldur();
        bid = bls.get(cxBayi.getSelectedIndex()).getBayiID();
        menuVeriCek();
        gridMenu(0, 2);
        urunVeriCek();
        gridUrun(0, 5);
        
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

        System.out.println("Menülere girildi");
        panelMenu.setLayout(new GridLayout(rows, cols));

        for (Menu item : mls) {
            String mid = item.getMenuID();
            String bid = item.getBayiID();
            String madi = item.getMenuAdi();

            JButton button = new JButton(madi);
            button.setToolTipText(mid);
            panelMenu.add(button);

            button.addActionListener((ActionEvent e) -> {
                this.mid = mid;
                System.out.println(this.mid);
                urunVeriCek();
                gridUrun(0, 5);
            });
        }
    }

    public void gridUrun(int rows, int cols) {
        panelUrun.removeAll();
        panelUrun.revalidate();
        panelUrun.repaint();

        System.out.println("Ürünlere girildi");
        panelUrun.setLayout(new GridLayout(rows, cols));

        for (Urun item : uls) {
            String uid = item.getID();
            String bid = item.getBayiID();
            String mid = item.getMenuID();
            String uadi = item.getAdi();
            String alis = item.getAlisFiyati();
            String satis = item.getSatisFiyati();
            String adet = item.getAdet();
            String resim = item.getResimURL();
            String asci = item.getAsciDurum();

            JButton button = new JButton(uadi);
            button.setToolTipText(uid);
            panelUrun.add(button);

            button.addActionListener((ActionEvent e) -> {
                duid = uid;
                dbid = bid;
                dmid = mid;
                duadi = uadi;
                dalis = alis;
                dsatis = satis;
                dadet = adet;
                dresim = resim;
                dasci = asci;
                FormUrunDuzenle fud =  new FormUrunDuzenle();
                fud.setVisible(true);
                this.setVisible(false);
            });
        }
    }

    void menuVeriCek() {
        mls = new MenuCrud().veriCek(bid);
    }

    void urunVeriCek() {
        uls = new UrunCrud().veriCek(bid, mid);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cxBayi = new javax.swing.JComboBox<>();
        panelMenu = new javax.swing.JPanel();
        panelUrun = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Ürün Düzenle"));

        jLabel1.setText("Bayi:");

        cxBayi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cxBayi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cxBayiActionPerformed(evt);
            }
        });

        panelMenu.setBorder(javax.swing.BorderFactory.createTitledBorder("Menüler"));

        javax.swing.GroupLayout panelMenuLayout = new javax.swing.GroupLayout(panelMenu);
        panelMenu.setLayout(panelMenuLayout);
        panelMenuLayout.setHorizontalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelMenuLayout.setVerticalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 145, Short.MAX_VALUE)
        );

        panelUrun.setBorder(javax.swing.BorderFactory.createTitledBorder("Ürünler"));

        javax.swing.GroupLayout panelUrunLayout = new javax.swing.GroupLayout(panelUrun);
        panelUrun.setLayout(panelUrunLayout);
        panelUrunLayout.setHorizontalGroup(
            panelUrunLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelUrunLayout.setVerticalGroup(
            panelUrunLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 178, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelUrun, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(cxBayi, 0, 616, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cxBayi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(panelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panelUrun, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void cxBayiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cxBayiActionPerformed
        bid = bls.get(cxBayi.getSelectedIndex()).getBayiID();
        mid = "1";
        menuVeriCek();
        gridMenu(0, 2);
        urunVeriCek();
        gridUrun(0, 5);
        System.out.println("bayi id: " + bid);
        System.out.println("menu id: " + mid);
    }//GEN-LAST:event_cxBayiActionPerformed

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
            java.util.logging.Logger.getLogger(FormUrunDuzenleSecim.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormUrunDuzenleSecim.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormUrunDuzenleSecim.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormUrunDuzenleSecim.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormUrunDuzenleSecim().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cxBayi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel panelMenu;
    private javax.swing.JPanel panelUrun;
    // End of variables declaration//GEN-END:variables

}
