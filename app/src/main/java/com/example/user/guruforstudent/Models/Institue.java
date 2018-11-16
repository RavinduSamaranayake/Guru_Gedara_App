package com.example.user.guruforstudent.Models;

import android.widget.Toast;

import com.example.user.guruforstudent.MyConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by USER on 9/2/2018.
 */

public class Institue {
    String id;
    String name;
    Connection con = null;
    PreparedStatement ps;
    public Institue(){
        con = MyConnection.getconnection();
    }

    public List<String> getAllInstitutes(){
        List<String> insName = new ArrayList<String>();

        // Select All Query
        String selectQuery = "SELECT `name` FROM `institutes`";


        try {

            ps = con.prepareStatement(selectQuery);
            ResultSet rs = ps.executeQuery();
            //insName.add("Hello");

            while(rs.next()){
                insName.add(rs.getString(1).toString());

            }
            //con.close();

        } catch (SQLException e) {
            //Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
            System.out.print(e.getMessage());
        }






        return  insName;
    }
    public String getInsId(String name){
        String insID = null;
        String selectQuery = "SELECT `id` FROM `institutes` WHERE `name`=?";


        try {
            ps = con.prepareStatement(selectQuery);
            ps.setString(1,name);
            ResultSet rs = ps.executeQuery();
            //insName.add("Hello");

            if(rs.next()){
                insID = rs.getString(1);

            }
            //con.close();

        } catch (SQLException e) {
            //Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
            System.out.print(e.getMessage());
        }






        return  insID;
    }



}
