package com.example.user.guruforstudent.Models;

import com.example.user.guruforstudent.MyConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by USER on 9/16/2018.
 */

public class Course {
    String id;
    String name;
    Connection con = null;
    PreparedStatement ps;
    public Course(){
        con = MyConnection.getconnection();
    }

    public List<String> getAllcrs(String slctName){
        List<String> crsName = new ArrayList<String>();

        // Select All Query
        String selectQuery = "SELECT `courses`.`name` FROM `course_institutes`,`institutes`,`courses` WHERE `course_institutes`.`institute_id` = `institutes`.`id` AND `course_institutes`.`course_id` = `courses`.`id` AND `institutes`.`name` = ?";


        try {
            ps = con.prepareStatement(selectQuery);
            ps.setString(1,slctName);
            ResultSet rs = ps.executeQuery();
            //insName.add("Hello");

            while(rs.next()){
                crsName.add(rs.getString(1).toString());

            }
            //con.close();

        } catch (SQLException e) {
            //Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
            System.out.print(e.getMessage());
        }






        return  crsName;
    }
    public String getCrsId(String name){
        String crsID = null;
        String selectQuery = "SELECT `id` FROM `courses` WHERE `name`=?";


        try {
            ps = con.prepareStatement(selectQuery);
            ps.setString(1,name);
            ResultSet rs = ps.executeQuery();
            //insName.add("Hello");

            if(rs.next()){
                crsID = rs.getString(1);

            }
            //con.close();

        } catch (SQLException e) {
            //Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
            System.out.print(e.getMessage());
        }






        return  crsID;
    }

}
