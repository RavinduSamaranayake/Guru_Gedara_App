package com.example.user.guruforstudent;

import com.example.user.guruforstudent.Models.Student;
import com.example.user.guruforstudent.Models.User;

import java.sql.PreparedStatement;

/**
 * Created by USER on 9/10/2018.
 */

public class testStudent {
    static PreparedStatement testps2;
    public static void passValue(){
        PreparedStatement ps = Student.StReg("952410343V","0915780867","RCG",21,"06001232","01442222");
        testps2 =ps;
    }
    public static PreparedStatement getTestps(){
        return testps2;
    }

}
