package com.example.user.guruforstudent.Models;

import com.example.user.guruforstudent.MyConnection;
import com.example.user.guruforstudent.testUser;
import com.example.user.guruforstudent.userRegister;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import static com.example.user.guruforstudent.Models.User.ps;

/**
 * Created by USER on 8/29/2018.
 */

public class teacher {

    static Connection con = null;
    public teacher(){
        con = MyConnection.getconnection();
    }
    public static PreparedStatement teachReg(String nic, String phone, String school, String edu, String subject,String qulific) {
        con = MyConnection.getconnection();
        String query = "INSERT INTO `teachers`(`nic`, `phone`, `school`, `education`, `subjects`, `qualification`, `user_id`) VALUES (?,?,?,?,?,?,?)";

        int pos = getAllteachPos();
        System.out.println("----------------------------------------------------------------------------"+pos);

        try {
            ps = con.prepareStatement(query);
            ps.setString(1, nic);
            ps.setString(2, phone);
            ps.setString(3, school);
            ps.setString(4, edu);
            ps.setString(5, subject);
            ps.setString(6, qulific);
            ps.setInt(7,pos);
            //con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }



        return ps;
    }


    public static int getAllteachPos()  {
        int posi =0;
        PreparedStatement ps1 = userRegister.getps();




        try {
            if (ps1.executeUpdate() > 0) {

                ResultSet rs = ps1.getGeneratedKeys();

                if (rs.next()) {
                    posi = rs.getInt(1);

                    //lastid.add(pos);
                }
                //con.close();

            }
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }


        return posi;

    }
    public static void conClose(){
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}





