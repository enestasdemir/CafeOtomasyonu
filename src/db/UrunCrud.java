package db;

import enumlar.UrunEnum;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import properties.Urun;

public class UrunCrud extends DB implements CrudPro {

    //ürünler için kullanılacak veritabanı methodlarını burada override ediyoruz
    @Override
    public ArrayList<Urun> veriGetir() {
        String q = "call urunGetir()";
        ArrayList<Urun> urunListesi = new ArrayList<>();
        HashMap<Integer, Urun> hm = new HashMap<>();
        try {
            ResultSet rs = super.baglan().executeQuery(q);
            while (rs.next()) {
                Urun u = new Urun();
                u.setID(rs.getString("" + UrunEnum.uid));
                u.setMenuID(rs.getString("" + UrunEnum.mid));
                u.setBayiID(rs.getString("" + UrunEnum.bid));
                u.setAdi(rs.getString("" + UrunEnum.uadi));
                u.setAlisFiyati(rs.getString("" + UrunEnum.ualisfiyat));
                u.setSatisFiyati(rs.getString("" + UrunEnum.usatisfiyat));
                u.setAdet(rs.getString("" + UrunEnum.uadet));
                u.setResimURL(rs.getString("" + UrunEnum.uresim));
                u.setAsciDurum(rs.getString("" + UrunEnum.adurum));

                urunListesi.add(u);
                hm.put(Integer.valueOf(u.getID()), u);
            }
        } catch (SQLException ex) {
            System.out.println("Veri getirme hatası: " + ex);
        } finally {
            super.kapat();
        }
        return urunListesi;
    }

    public HashMap<Integer, Urun> veriGetir(int bid, int mid) {
        String q = "call urunGet('" + bid + "','" + mid + "')";
        //ArrayList<Urun> urunListesi = new ArrayList<>();
        HashMap<Integer, Urun> hm = new HashMap<>();
        try {
            ResultSet rs = super.baglan().executeQuery(q);
            while (rs.next()) {
                Urun u = new Urun();
                u.setID(rs.getString("" + UrunEnum.uid));
                u.setMenuID(rs.getString("" + UrunEnum.mid));
                u.setBayiID(rs.getString("" + UrunEnum.bid));
                u.setAdi(rs.getString("" + UrunEnum.uadi));
                u.setAlisFiyati(rs.getString("" + UrunEnum.ualisfiyat));
                u.setSatisFiyati(rs.getString("" + UrunEnum.usatisfiyat));
                u.setAdet(rs.getString("" + UrunEnum.uadet));
                u.setResimURL(rs.getString("" + UrunEnum.uresim));
                u.setAsciDurum(rs.getString("" + UrunEnum.adurum));
                System.out.println("UrunCrud aşçı durumu = " + rs.getString("" + UrunEnum.adurum));
                hm.put(Integer.valueOf(u.getID()), u);
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
        Urun urun = (Urun) o;
        String query = "call urunEkle('" + urun.getMenuID() + "', '" + urun.getBayiID() + "', '" + urun.getAdi() + "', '" + urun.getAlisFiyati() + "', '" + urun.getSatisFiyati() + "','" + urun.getAdet() + "', '" + urun.getResimURL() + "', '" + urun.getAsciDurum() + "')";
        try {
            int sonuc = super.baglan().executeUpdate(query);
            if (sonuc > 0) {
                System.out.println("Ürün oluşturuldu: " + urun.getAdi());
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            super.kapat();
        }
        return false;
    }

    @Override
    public boolean guncelle(Object o) {
        Urun urun = (Urun) o;
        String query = "call urunDuzenle('" + urun.getID() + "', '" + urun.getMenuID() + "', '" + urun.getBayiID() + "', '" + urun.getAdi() + "', '" + urun.getAlisFiyati() + "', '" + urun.getSatisFiyati() + "','" + urun.getAdet() + "', '" + urun.getResimURL() + "', '" + urun.getAsciDurum() + "')";
        try {
            int sonuc = super.baglan().executeUpdate(query);
            if (sonuc > 0) {
                System.out.println("Ürün güncellendi: " + urun.getAdi());
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            super.kapat();
        }
        return false;
    }

    @Override
    public boolean sil(Object o) {
        Urun urun = (Urun) o;
        String query = "call urunSil('" + urun.getID()+ "')";
        try {
            int result = super.baglan().executeUpdate(query);
            if (result > 0) {
                //update basarili
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            super.kapat();
        }
        return false;
    }

    public ArrayList<Urun> veriCek(String bid, String mid) {
        String query = "call urunCek('" + bid + "', '" + mid + "')";
        ArrayList<Urun> urunListesi = new ArrayList<>();
        try {
            ResultSet rs = super.baglan().executeQuery(query);
            while (rs.next()) {
                Urun urun = new Urun();
                urun.setID(rs.getString("" + UrunEnum.uid));
                urun.setBayiID(rs.getString("" + UrunEnum.bid));
                urun.setMenuID(rs.getString("" + UrunEnum.mid));
                urun.setAdi(rs.getString("" + UrunEnum.uadi));
                urun.setAlisFiyati(rs.getString("" + UrunEnum.ualisfiyat));
                urun.setSatisFiyati(rs.getString("" + UrunEnum.usatisfiyat));
                urun.setAdet(rs.getString("" + UrunEnum.uadet));
                urun.setResimURL(rs.getString("" + UrunEnum.uresim));
                urun.setAsciDurum(rs.getString("" + UrunEnum.adurum));

                urunListesi.add(urun);
            }
        } catch (Exception e) {
            System.err.println("Ürün getirme hatasi: " + e);
        } finally {
            super.kapat();
        }
        return urunListesi;
    }
}
