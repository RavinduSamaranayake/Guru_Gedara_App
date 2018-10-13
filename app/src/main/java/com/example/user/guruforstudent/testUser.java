package com.example.user.guruforstudent;

import com.example.user.guruforstudent.Models.User;

import java.sql.PreparedStatement;

/**
 * Created by USER on 9/10/2018.
 */

public class testUser {
    static PreparedStatement testps;
    public static void passValue(){
        PreparedStatement ps = User.UserReg("KUSHAN","RAVINDU","kishaklfbjj@gmail.com","12345678",4);
        testps =ps;
    }
    public static PreparedStatement getTestps(){
        return testps;
    }

}
