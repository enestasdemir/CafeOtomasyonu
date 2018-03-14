package db;

import enumlar.SiparisEnum;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import properties.Siparis;

public class SiparisCrud extends DB implements CrudPro {

    @Override
    public ArrayList<Siparis> veriGetir() {
        String q = "call sip()";
        ArrayList<Siparis> siparisListesi = new ArrayList<>();
        HashMap<Integer, Siparis> hm = new HashMap<>();
        try {
            ResultSet rs = super.baglan().executeQuery(q);
            while (rs.next()) {
                Siparis s = new Siparis();
                s.setID(rs.getString("" + SiparisEnum.siparisid));
                s.setMasaID(rs.getString("" + SiparisEnum.masaid));
                s.setSiparisAdi(rs.getString("" + SiparisEnum.siparisadi));
                s.setSiparisAdet(rs.getString("" + SiparisEnum.siparisadet));
                s.setSiparisFiyat(rs.getString("" + SiparisEnum.siparisfiyat));
                s.setAscidurum(rs.getString("" + SiparisEnum.ascidurum));
                System.out.println("SiparisCrud asci durum = " + rs.getString("" + SiparisEnum.ascidurum));

                siparisListesi.add(s);
                hm.put(Integer.valueOf(s.getID()), s);
            }
        } catch (SQLException ex) {
            System.out.println("Veri getirme hatası: " + ex);
        } finally {
            super.kapat();
        }
        return siparisListesi;
    }

    public HashMap<Integer, Siparis> veriGetir(int mid) {
        String q = "call sip('" + mid + "')";
        //ArrayList<Urun> urunListesi = new ArrayList<>();
        HashMap<Integer, Siparis> hm = new HashMap<>();
        try {
            ResultSet rs = super.baglan().executeQuery(q);
            while (rs.next()) {
                Siparis s = new Siparis();
                s.setID(rs.getString("" + SiparisEnum.siparisid));
                s.setMasaID(rs.getString("" + SiparisEnum.masaid));
                s.setSiparisAdi(rs.getString("" + SiparisEnum.siparisadi));
                s.setSiparisAdet(rs.getString("" + SiparisEnum.siparisadet));
                s.setSiparisFiyat(rs.getString("" + SiparisEnum.siparisfiyat));
                s.setAscidurum(rs.getString("" + SiparisEnum.ascidurum));
                System.out.println("SiparisCrud asci durum = " + rs.getString("" + SiparisEnum.ascidurum));
                //urunListesi.add(u);
                hm.put(Integer.valueOf(s.getID()), s);
            }
        } catch (SQLException ex) {
            System.out.println("Veri getirme hatası: " + ex);
        } finally {
            super.kapat();
        }
        return hm;
    }

    @Override
    public boolean olustur(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean guncelle(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean sil(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
