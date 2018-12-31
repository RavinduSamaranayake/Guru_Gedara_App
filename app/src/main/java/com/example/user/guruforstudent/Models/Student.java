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

public class Student {
    String nic;
    String phone;
    String school;
    int age;
    String olidex;
    String alindex;
    int pos;
    int stdId;
    static Connection con = null;

    PreparedStatement ps3 = null;
    PreparedStatement ps4 = null;
    public Student(){
        con = MyConnection.getconnection();
    }
    //for get the insert prepared statement of student
    public static PreparedStatement StReg(String nic, String phone, String school, int age, String olindex,String alindex)  {
        con = MyConnection.getconnection();
        String query = "INSERT INTO `students`( `nic`, `phone`, `school`, `age`, `olindex`, `alindex`, `user_id`) VALUES (?,?,?,?,?,?,?)";
        // userRegister u = new userRegister();
        // List<Integer> lastId = u.getAllStPos();
        // int pos = lastId.get(lastId.size()-1);
        int pos = getAllStPos();
        System.out.println("----------------------------------------------------------------------------"+pos);

        try {
            ps = con.prepareStatement(query);
            ps.setString(1, nic);
            ps.setString(2, phone);
            ps.setString(3, school);
            ps.setInt(4, age);
            ps.setString(5, olindex);
            ps.setString(6, alindex);
            ps.setInt(7,pos);
            //con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }



        return ps;
    }


   public static int getAllStPos() { // for get the last index of user table
       int posi =0;
       PreparedStatement ps1 = userRegister.getps();
//       testUser.passValue();
//       PreparedStatement ps1 = testUser.getTestps();




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
    public static void conClose(){ //for connection close
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public int getCurStId(){  //for get the current student id(login active student)
       int stId;
       User u = new User();
       u.getCurIdCurLevel();
       int crUid = u.curUid;
       int crLevel = u.curUlevel;
       if(crLevel == 4){
           try {
               ps3 = con.prepareStatement("SELECT `id` FROM `students` WHERE `user_id` = ?");
               ps3.setInt(1, crUid);

               ResultSet rs = ps3.executeQuery();
               if (rs.next()) {
                    stId = rs.getInt(1);
                   return stId;

               }
           }catch (Exception e) {
               e.printStackTrace();
           }
           stId=0;
           return stId;
       }
       else{
           stId=0;
           return stId;
       }

    }
    public List<String> getAllStRegIns(String stid){ //for get the all registered institute of a student
        List<String> instName = new ArrayList<String>();

        // Select All Query
        String selectQuery = "SELECT DISTINCT ins.`name` FROM `institutes` ins ,`institute_students` inst WHERE inst.`student_id` = ? AND ins.id = inst.`institute_id` AND `status` = 1";
        //instName.add("kushan");
       // instName.add("Ravindu");

        try {

            ps4 = con.prepareStatement(selectQuery);
            ps4.setString(1,stid);
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



    public List<String> getAllStRegCrs(String stid,String insId){ //for get the all registered course list of particular institute of a student
        List<String> crsName = new ArrayList<String>();
        String selectQuery = "SELECT crs.`name` FROM `courses` crs ,`institute_students` inst WHERE inst.`student_id` = ? AND crs.id = inst.`course_id` AND `status` = 1 AND inst.`institute_id` = ?";


        try {

            ps4 = con.prepareStatement(selectQuery);
            ps4.setString(1,stid);
            ps4.setString(2,insId);
            ResultSet rs = ps4.executeQuery();
            //insName.add("Hello");

            while(rs.next()){
                crsName.add(rs.getString(1));

            }
            //con.close();

        } catch (SQLException e) {
            //Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
            System.out.print(e.getMessage());
        }
        return  crsName;
    }
}





