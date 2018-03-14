package db;

import enumlar.PersonelEnum;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import properties.Personel;

public class PersonelCrud extends DB implements CrudPro {

    @Override
    public ArrayList<? extends Object> veriGetir() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean olustur(Object o) {
        Personel personel = (Personel) o;
        String query = "call personelEkle('" + personel.getBayiID()+ "', '" + personel.getTckn()+ "', '" + personel.getAdi()+ "', '" + personel.getSoyadi()+ "', '" + personel.getTelefon()+ "','" + personel.getAdres()+ "')";
        try {
            int sonuc = super.baglan().executeUpdate(query);
            if (sonuc > 0) {
                System.out.println("Personel oluşturuldu: " + personel.getAdi() + " " + personel.getSoyadi() + "");
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
        Personel personel = (Personel) o;
        String query = "call personelDuzenle('" + personel.getID()+ "', '" + personel.getBayiID()+ "', '" + personel.getTckn()+ "', '" + personel.getAdi()+ "', '" + personel.getSoyadi()+ "', '" + personel.getTelefon()+ "','" + personel.getAdres()+ "')";
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
        Personel personel = (Personel) o;
        String query = "call personelSil('" + personel.getID()+ "')";
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
    
    public ArrayList<Personel> veriCek(){
        String query = "call personelCek()";
        ArrayList<Personel> personelListesi = new ArrayList<>();
        try {
            ResultSet rs = super.baglan().executeQuery(query);
            while (rs.next()) {
                Personel personel = new Personel();
                personel.setID(rs.getString("" + PersonelEnum.pid));
                personel.setBayiID(rs.getString("" + PersonelEnum.bid));
                personel.setTckn(rs.getString("" + PersonelEnum.ptckn));
                personel.setAdi(rs.getString("" + PersonelEnum.padi));
                personel.setSoyadi(rs.getString("" + PersonelEnum.psoyadi));
                personel.setTelefon(rs.getString("" + PersonelEnum.ptel));
                personel.setAdres(rs.getString("" + PersonelEnum.padres));

                personelListesi.add(personel);
            }
        } catch (Exception e) {
            System.err.println("Personel getirme hatasi: " + e);
        } finally {
            super.kapat();
        }
        return personelListesi;
    }

}
