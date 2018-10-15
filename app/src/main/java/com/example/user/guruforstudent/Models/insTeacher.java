package com.example.user.guruforstudent.Models;

import com.example.user.guruforstudent.MyConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class insTeacher {
    Connection con = null;
    PreparedStatement ps = null;
    public insTeacher(){
        con = MyConnection.getconnection();
    }
    public PreparedStatement fillInsStTable(String insId,String teachId,String crsId,String regId,int status){
        try {
            ps = con.prepareStatement("INSERT INTO `institute_teachers`(`institute_id`, `teacher_id`, `course_id`, `regNumber`, `status`) VALUES (?,?,?,?,?)");
            ps.setString(1,insId);
            ps.setString(2,teachId);
            ps.setString(3,crsId);
            ps.setString(4,regId);
            ps.setInt(5,status);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ps;
    }


}

