package db;

import enumlar.KullaniciEnum;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import properties.Kullanici;

public class KullaniciCrud extends DB implements CrudPro {

    @Override
    public ArrayList<? extends Object> veriGetir() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean olustur(Object o) {
        Kullanici kullanici = (Kullanici) o;
        String query = "call kullaniciEkle('" + kullanici.getYetkiID() + "', '" + kullanici.getPersonelID()+ "', '" + kullanici.getKullaniciAdi()+ "', '" + kullanici.getParola()+ "')";
        try {
            int sonuc = super.baglan().executeUpdate(query);
            if (sonuc > 0) {
                System.out.println("Kullanıcı oluşturuldu!");
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
        Kullanici kullanici = (Kullanici) o;
        String query = "call kullaniciDuzenle('" + kullanici.getID()+ "', '" + kullanici.getYetkiID()+ "', '" + kullanici.getKullaniciAdi()+ "', '" + kullanici.getParola()+ "')";
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

    @Override
    public boolean sil(Object o) {
        Kullanici kullanici = (Kullanici) o;
        String query = "call kullaniciSil('" + kullanici.getID() +"')";
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
    
    public ArrayList<Kullanici> veriCek(){
        String query = "call kullaniciCek()";
        ArrayList<Kullanici> kullaniciListesi = new ArrayList<>();
        try {
            ResultSet rs = super.baglan().executeQuery(query);
            while (rs.next()) {
                Kullanici kullanici = new Kullanici();
                kullanici.setID(rs.getString("" + KullaniciEnum.kid));
                kullanici.setYetkiID(rs.getString("" + KullaniciEnum.yid));
                kullanici.setPersonelID(rs.getString("" + KullaniciEnum.pid));
                kullanici.setKullaniciAdi(rs.getString("" + KullaniciEnum.kadi));
                kullanici.setParola(rs.getString("" + KullaniciEnum.ksifre));

                kullaniciListesi.add(kullanici);
            }
        } catch (Exception e) {
            System.err.println("Kullanici getirme hatasi: " + e);
        } finally {
            super.kapat();
        }
        return kullaniciListesi;
    }

}
