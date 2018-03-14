package db;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {
    final private String driver ="com.mysql.jdbc.Driver";
    final private String url="jdbc:mysql://localhost/";
    final private String encode="?useUnicode=true&characterEncoding=utf-8";
    private String dbName="cafe";
    private String dbUser="root";
    private String dbPass="";
    
    private Connection conn=null;
    private Statement st=null;
    private PreparedStatement preSt=null;
    
    public DB(){
    }
    
    public DB(String dbName,String dbUser,String dbPass ){
    this.dbName=dbName;
    this.dbUser=dbUser;
    this.dbPass=dbPass;
    }
    
    public Statement baglan(){
        if (st!=null) {
            kapat();
        }
        try {
            Class.forName(driver);
            conn=DriverManager.getConnection(url+dbName+encode,dbUser,dbPass);
            st=conn.createStatement();
            System.out.println("Baglanti Basarili");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Baglani Hatasi : "+e);
        }
   return st;
    }
    
    public PreparedStatement preBaglan(String query){
        if (preSt!=null) {
            kapat();
        }
        try {
            Class.forName(driver);
            conn=DriverManager.getConnection(url+dbName+encode, dbUser, dbPass);
            preSt=conn.prepareStatement(query);
            System.out.println("Baglanti Basarili");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Baglani Hatasi : "+e);
        }
    return preSt;
    }
    //bağlantı kapatma
    public void kapat(){
        try {
            if(preSt!=null){
                preSt.close();
                preSt=null;
                System.out.println("preSt kapatildi");
            }
            if(st!=null){
                st.close();
                st=null;
                System.out.println("st kapatildi");
            }
            if (conn!=null) {
                conn.close();
                conn=null;
                System.out.println("conn kapatildi");
            }
        } catch (SQLException e) {
            System.err.println("Kapatma hatasi : "+e);
        }
    }
    
    
}
