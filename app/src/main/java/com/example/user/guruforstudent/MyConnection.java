package com.example.user.guruforstudent;

/**
 * Created by USER on 8/13/2018.
 */
import android.os.StrictMode;
import java.sql.Connection;
import java.sql.DriverManager;
public class MyConnection {
    public static Connection getconnection(){

        Connection con = null;
        try{
         StrictMode.ThreadPolicy policy = new  StrictMode.ThreadPolicy.Builder()
                .permitAll().build();
         StrictMode.setThreadPolicy(policy);
            Class.forName("com.mysql.jdbc.Driver");
            //con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/gurugedara","root","");
            con = DriverManager.getConnection("jdbc:mysql://35.198.222.95:3306/gurugedara","guru","guruGedara@2018");
            System.out.print("Connected......................");
        }
        catch(Exception ex){
            System.out.println(ex);
            System.out.println("Bad Network Connection.");
        }
        return con;
    }
}