
package db;

import enumlar.SalonEnum;
import enumlar.UrunEnum;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import properties.Salon;
import properties.Urun;

public class SalonCrud extends DB implements CrudPro {
   
    public HashMap<Integer,Salon> veriGet() {
        String q = "call salonGet()";
        //ArrayList<Urun> urunListesi = new ArrayList<>();
        HashMap<Integer,Salon> hm=new HashMap<>();
        try {
            ResultSet rs = super.baglan().executeQuery(q);
            while (rs.next()) {
                Salon s = new Salon();
                s.setBayiID(rs.getString(""+SalonEnum.bid));
                s.setSalonID(rs.getString(""+SalonEnum.sid));
                s.setSalonAdi(rs.getString(""+SalonEnum.sadi));
                s.setSalonMasaAdedi(rs.getString(""+SalonEnum.smasa));
                s.setSalonDurum(rs.getString(""+SalonEnum.sdurum));

                hm.put(Integer.valueOf(s.getSalonID()), s);
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
        Salon salon = (Salon) o;
        String query = "call salonEkle('" + salon.getBayiID() + "', '" + salon.getSalonAdi() + "')";

        try {
            int sonuc = super.baglan().executeUpdate(query);
            if (sonuc > 0) {
                System.out.println("Salon oluşturuldu: " + salon.getSalonAdi());
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
        Salon salon = (Salon) o;
        String query = "call salonDuzenle('" + salon.getSalonID()+ "', '" + salon.getSalonAdi()+ "')";
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
        Salon salon = (Salon) o;
        String query = "call salonSil('" + salon.getSalonID() + "')";
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
    public ArrayList<Salon> veriGetir() {
        String query = "call salonGet()";
        ArrayList<Salon> salonListesi = new ArrayList<>();
        try {
            ResultSet rs = super.baglan().executeQuery(query);
            while (rs.next()) {
                Salon salon = new Salon();
                salon.setSalonID(rs.getString("" + SalonEnum.sid));
                salon.setBayiID(rs.getString("" + SalonEnum.bid));
                salon.setSalonAdi(rs.getString("" + SalonEnum.sadi));

                salonListesi.add(salon);
            }
        } catch (Exception e) {
            System.err.println("Salon getirme hatasi: " + e);
        } finally {
            super.kapat();
        }
        return salonListesi;
    }

    public ArrayList<Salon> veriCek(String bid) {
        String query = "call salonCek('" + bid + "')";
        ArrayList<Salon> salonListesi = new ArrayList<>();
        try {
            ResultSet rs = super.baglan().executeQuery(query);
            while (rs.next()) {
                Salon salon = new Salon();
                salon.setSalonID(rs.getString("" + SalonEnum.sid));
                salon.setBayiID(rs.getString("" + SalonEnum.bid));
                salon.setSalonAdi(rs.getString("" + SalonEnum.sadi));

                salonListesi.add(salon);
            }
        } catch (Exception e) {
            System.err.println("Salon getirme hatasi: " + e);
        } finally {
            super.kapat();
        }
        return salonListesi;
    }
    
        public HashMap<Integer,Salon> veriGetir(int bid) {
        String q = "call salonGetir('"+bid+"')";
        System.out.println("q = "+q);
        HashMap<Integer,Salon> hm=new HashMap<>();
        try {
            ResultSet rs = super.baglan().executeQuery(q);
            while (rs.next()) {
                Salon salon = new Salon();
                salon.setSalonID(rs.getString("" + SalonEnum.sid));
                salon.setBayiID(rs.getString("" + SalonEnum.bid));
                salon.setSalonAdi(rs.getString("" + SalonEnum.sadi));
                hm.put(Integer.valueOf(salon.getSalonID()), salon);
            }
        } catch (SQLException ex) {
            System.out.println("Veri getirme hatası: " + ex);
        } finally {
            super.kapat();
        }
        return hm;
    }
    
}

