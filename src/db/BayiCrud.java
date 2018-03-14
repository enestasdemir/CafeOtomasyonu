package db;

import enumlar.BayiEnum;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import properties.Bayi;

public class BayiCrud extends DB implements CrudPro {

    @Override
    public boolean olustur(Object o) {
        Bayi bayi = (Bayi) o;
        String query = "call bayiEkle('" + bayi.getBayiAdi() + "')";

        try {
            int sonuc = super.baglan().executeUpdate(query);
            if (sonuc > 0) {
                System.out.println("Bayi oluşturuldu: " + bayi.getBayiAdi());
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
        Bayi bayi = (Bayi) o;
        String query = "call bayiDuzenle('" + bayi.getBayiID() + "', '" + bayi.getBayiAdi() + "')";
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
        Bayi bayi = (Bayi) o;
        String query = "call bayiSil('" + bayi.getBayiID() + "')";
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
    public ArrayList<Bayi> veriGetir() {
        String query = "call bayiGetir()";
        ArrayList<Bayi> bayiListesi = new ArrayList<>();
        try {
            ResultSet rs = super.baglan().executeQuery(query);
            while (rs.next()) {
                Bayi bayi = new Bayi();
                bayi.setBayiID(rs.getString("" + BayiEnum.bid));
                bayi.setBayiAdi(rs.getString("" + BayiEnum.badi));

                bayiListesi.add(bayi);
            }
        } catch (Exception e) {
            System.err.println("Kategori getirme hatasi: " + e);
        } finally {
            super.kapat();
        }
        return bayiListesi;
    }
}