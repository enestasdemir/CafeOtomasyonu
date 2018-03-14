package db;

import enumlar.MasaEnum;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import properties.Masa;

public class MasaCrud extends DB implements CrudPro{
    public HashMap<Integer,Masa> veriGetir(int bid,int sid) {
        String q = "call masaGet('"+bid+"','"+sid+"')";
        System.out.println("q = "+q);
        HashMap<Integer,Masa> hm=new HashMap<>();
        try {
            ResultSet rs = super.baglan().executeQuery(q);
            while (rs.next()) {
                Masa m = new Masa();
                m.setMasaid(rs.getString(""+MasaEnum.masaid));
                m.setBid(rs.getString(""+MasaEnum.bid));
                m.setSid(rs.getString(""+MasaEnum.sid));
                m.setMdurum(rs.getString(""+MasaEnum.mdurum));
                hm.put(Integer.valueOf(m.getMasaid()), m);
            }
        } catch (SQLException ex) {
            System.out.println("Veri getirme hatası: " + ex);
        } finally {
            super.kapat();
        }
        return hm;
    }

    @Override
    public ArrayList<? extends Object> veriGetir() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean olustur(Object o) {
        Masa masa = (Masa) o;
        String query = "call masaEkle('" + masa.getBid() + "', '" + masa.getSid() + "')";

        try {
            int sonuc = super.baglan().executeUpdate(query);
            if (sonuc > 0) {
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean sil(Object o) {
        Masa masa = (Masa) o;
        String query = "call masaSil('" + masa.getBid() + "', '" + masa.getSid() + "')";
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
}
