package com.example.user.guruforstudent.Models;

import com.example.user.guruforstudent.MyConnection;
import com.example.user.guruforstudent.testUser;
import com.example.user.guruforstudent.userRegister;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static com.example.user.guruforstudent.Models.User.ps;

/**
 * Created by USER on 8/29/2018.
 */

public class teacher {

    static Connection con = null;
    int teachId;
    PreparedStatement ps3 = null;
    PreparedStatement ps4 = null;
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

    public int getCurTeachId(){  //for get the current teacher Id
        int tid;
        User u = new User();
        u.getCurIdCurLevel();
        int crUid = u.curUid;
        int crLevel = u.curUlevel;
        if(crLevel == 3){
            try {
                ps3 = con.prepareStatement("SELECT `id` FROM `teachers` WHERE `user_id` = ?");
                ps3.setInt(1, crUid);

                ResultSet rs = ps3.executeQuery();
                if (rs.next()) {
                    tid = rs.getInt(1);
                    System.out.println("*******************************teacher id is : "+tid+" *******************************");
                    return tid;

                }
            }catch (Exception e) {
                e.printStackTrace();
            }
            tid=444;
            System.out.println("*******************************teacher id is : "+tid+" *******************************");
            return tid;
        }
        else{
            tid=111;
            System.out.println("*************HELLLLLL******************teacher id is : "+tid+" *******************************");
            return tid;
        }


    }
    public List<String> getAllTeachRegIns(String tid){
        List<String> instName = new ArrayList<String>();

        // Select All Query
        String selectQuery = "SELECT DISTINCT ins.`name` FROM `institutes` ins ,`institute_teachers` inst WHERE inst.`teacher_id` = ? AND ins.id = inst.`institute_id` AND `status` = 1";
        //instName.add("kushan");
        // instName.add("Ravindu");

        try {

            ps4 = con.prepareStatement(selectQuery);
            ps4.setString(1,tid);
            ResultSet rs = ps4.executeQuery();
            //insName.add("Hello");

            while(rs.next()){
                instName.add(rs.getString(1).toString());

            }
            //con.close();

        } catch (SQLException e) {
            //Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
            System.out.print(e.getMessage());
        }
        return  instName;
    }
    public List<String> getAllTeachRegCrs(String tid,String insId){ //for get the all registered course list of particular institute of a student
        List<String> crsName = new ArrayList<String>();
        String selectQuery = "SELECT crs.`name` FROM `courses` crs ,`institute_teachers` inst WHERE inst.`teacher_id` = ? AND crs.id = inst.`course_id` AND `status` = 1 AND inst.`institute_id` = ?";


        try {

            ps4 = con.prepareStatement(selectQuery);
            ps4.setString(1,tid);
            ps4.setString(2,insId);
            ResultSet rs = ps4.executeQuery();
            //insName.add("Hello");

            while(rs.next()){
                crsName.add(rs.getString(1)); //add the crasnames for crsName list

            }
            //con.close();

        } catch (SQLException e) {
            //Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
            System.out.print(e.getMessage());
        }
        return  crsName;
    }
}





