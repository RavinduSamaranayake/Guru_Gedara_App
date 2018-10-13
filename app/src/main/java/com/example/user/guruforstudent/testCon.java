package com.example.user.guruforstudent;

import android.widget.Toast;

import com.example.user.guruforstudent.Controls.FileRW;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by USER on 8/13/2018.
 */

public class testCon {
    public static void main(String [] args )  {
       //MyConnection.getconnection();
    /*    PreparedStatement ps = null;
        Connection con = MyConnection.getconnection();
        String query = "INSERT INTO `users`( `firstname`, `Lastname`, `email`, `password`, `role_id`) VALUES (?,?,?,?,?)";

        try {
            ps = con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, "jk");
            ps.setString(2, "kk");
            ps.setString(3, "12wlle11rk3j");
            ps.setString(4, "123456789");
            ps.setInt(5, 3);
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            rs.next();
            int val = rs.getInt(1);
            System.out.println("......................."+val+"......................");

        } catch (SQLException e) {

            System.out.println("Error Message : "+e.getMessage());
        } */
        testUser.passValue();
        PreparedStatement ps1 = testUser.getTestps();
        testStudent.passValue();
        PreparedStatement ps2 = testStudent.getTestps();


//        try {
//            if (ps1.executeUpdate() > 0) {
//                System.out.println("Register Success");
//
//            }
//
//        } catch (SQLException e) {
//
//            System.out.println("User Register Fail..........."+e.getMessage()+"......................");
//        }
        try {
            if (ps2.executeUpdate() > 0) {
                System.out.println("Student Register Success");

            }

        } catch (SQLException e) {

            System.out.println("Student Register Fail..........."+e.getMessage()+"......................");
        }




        //String name = "Ravindu95";
       //String passwd = "12345";
       //User u = new User();
       //u.UserLogin(name,passwd);
//        FileRW rw = new FileRW("Kushan Ravindu samaranayake");
//        rw.write();
//        rw.Read();
        //rw.clearTheFile();

    }
}
