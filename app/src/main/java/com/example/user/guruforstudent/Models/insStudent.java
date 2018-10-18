package com.example.user.guruforstudent.Models;

import com.example.user.guruforstudent.MyConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class insStudent {
    Connection con = null;
    PreparedStatement ps = null;
    public insStudent(){
        con = MyConnection.getconnection();
    }
    public PreparedStatement fillInsStTable(String insId,String stdId,String crsId,String regId,int status){
        try {
            ps = con.prepareStatement("INSERT INTO `institute_students`(`institute_id`, `student_id`, `course_id`, `regNumber`, `status`) VALUES (?,?,?,?,?)");
            ps.setString(1,insId);
            ps.setString(2,stdId);
            ps.setString(3,crsId);
            ps.setString(4,regId);
            ps.setInt(5,status);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ps;
    }


}
