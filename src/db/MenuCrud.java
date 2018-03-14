package db;

import enumlar.MenuEnum;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import properties.Menu;

public class MenuCrud extends DB implements CrudPro{
    @Override
    public ArrayList<Menu> veriGetir() {
        String q = "call menuGetir()";
        ArrayList<Menu> menuListesi = new ArrayList<>();
        try {
            ResultSet rs = super.baglan().executeQuery(q);
            while (rs.next()) {
                Menu m = new Menu();
                m.setMenuID(rs.getString("" + MenuEnum.mid));
                m.setBayiID(rs.getString(""+ MenuEnum.bid));
                m.setMenuAdi(rs.getString("" + MenuEnum.madi));
               
                menuListesi.add(m);
            }
        } catch (SQLException ex) {
            System.out.println("Veri getirme hatası: " + ex);
        } finally {
            super.kapat();
        }
        return menuListesi;
    }

    @Override
    public boolean olustur(Object o) {
        Menu menu = (Menu) o;
        String query = "call menuEkle('" + menu.getBayiID() + "', '" + menu.getMenuAdi()+ "')";

        try {
            int sonuc = super.baglan().executeUpdate(query);
            if (sonuc > 0) {
                System.out.println("Menü oluşturuldu: " + menu.getMenuAdi());
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
        Menu menu = (Menu) o;
        String query = "call menuDuzenle('" + menu.getMenuID()+ "', '" + menu.getMenuAdi()+ "')";
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
        Menu menu = (Menu) o;
        String query = "call menuSil('" + menu.getMenuID()+ "')";
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
    
    public ArrayList<Menu> veriCek(String bid) {
        String query = "call menuCek('" + bid + "')";
        ArrayList<Menu> urunListesi = new ArrayList<>();
        try {
            ResultSet rs = super.baglan().executeQuery(query);
            while (rs.next()) {
                Menu menu = new Menu();
                menu.setMenuID(rs.getString("" + MenuEnum.mid));
                menu.setBayiID(rs.getString("" + MenuEnum.bid));
                menu.setMenuAdi(rs.getString("" + MenuEnum.madi));

                urunListesi.add(menu);
            }
        } catch (Exception e) {
            System.err.println("Menü getirme hatasi: " + e);
        } finally {
            super.kapat();
        }
        return urunListesi;
    }
    
}


