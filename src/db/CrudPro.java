package db;

import java.util.ArrayList;

public interface CrudPro {

    // Bu sınıf veritabanı işlemleri için boş methodlar oluşturuyor
    
    ArrayList<? extends Object> veriGetir();

    boolean olustur(Object o);

    boolean guncelle(Object o);

    boolean sil(Object o);
}
