package db;

import enumlar.YetkiEnum;
import java.sql.ResultSet;
import java.util.ArrayList;
import properties.Yetki;

public class YetkiCrud extends DB implements CrudPro {

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
    
    @Override
    public ArrayList<Yetki> veriGetir() {
        String query = "call yetkiGetir()";
        ArrayList<Yetki> yetkiListesi = new ArrayList<>();
        try {
            ResultSet rs = super.baglan().executeQuery(query);
            while (rs.next()) {
                Yetki yetki = new Yetki();
                yetki.setID(rs.getString("" + YetkiEnum.yid));
                yetki.setYetkiAdi(rs.getString("" + YetkiEnum.yadi));

                yetkiListesi.add(yetki);
            }
        } catch (Exception e) {
            System.err.println("Yetki getirme hatasi: " + e);
        } finally {
            super.kapat();
        }
        return yetkiListesi;
    }

}
