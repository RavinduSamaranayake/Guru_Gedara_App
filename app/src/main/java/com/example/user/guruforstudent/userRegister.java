package com.example.user.guruforstudent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.user.guruforstudent.Models.User;
import com.example.user.guruforstudent.StudentRegistration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class userRegister extends AppCompatActivity {

    EditText fname;
    EditText lname;

    EditText passwd;
    EditText conpasswd;
    EditText email;
    Button regteacher;
    Button regstudent;

    //for Firebase Auth
    String returnEmail=null;
    String returnPassword=null;

    static PreparedStatement newps;
   PreparedStatement ps = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_user_register);
        fname = (EditText) findViewById(R.id.fname);
        lname = (EditText) findViewById(R.id.lname);

        passwd = (EditText) findViewById(R.id.passwd);
        conpasswd = (EditText) findViewById(R.id.conpasswd);
        email = (EditText) findViewById(R.id.email);
        regteacher = (Button) findViewById(R.id.regTeacher);
        regstudent = (Button) findViewById(R.id.regStudent);
        regteacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (fname.getText().length() == 0) {
                    Toast.makeText(getApplicationContext(), "Name is Empty", Toast.LENGTH_LONG).show();
                } else if (email.getText().length() == 0) {
                    Toast.makeText(getApplicationContext(), "email is Empty", Toast.LENGTH_LONG).show();
                } else if (passwd.getText().length() == 0) {
                    Toast.makeText(getApplicationContext(), "password is Empty", Toast.LENGTH_LONG).show();
                } else if (passwd.getText().length() < 8) {
                    Toast.makeText(getApplicationContext(), "password is short", Toast.LENGTH_LONG).show();
                } else if (passwd.getText().length() > 20) {
                    Toast.makeText(getApplicationContext(), "password is long", Toast.LENGTH_LONG).show();
                } else if (!String.valueOf(passwd.getText()).equals(String.valueOf(conpasswd.getText()))) {
                    Toast.makeText(getApplicationContext(), "not match your entered passwords", Toast.LENGTH_LONG).show();
                } else {

                    String finame = fname.getText().toString();
                    String laname = lname.getText().toString();
                    String emai = email.getText().toString();
                    returnEmail = emai;
                    String passwrd = passwd.getText().toString();
                    returnPassword = passwrd;
                    ps = User.UserReg(finame, laname, emai, passwrd, 3); //prepared statement of user as a teacher
                    newps = ps; //to save static ps
                    regteachpg();






                }

            }

        });
        regstudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (fname.getText().length() == 0) {
                    Toast.makeText(getApplicationContext(), "Name is Empty", Toast.LENGTH_LONG).show();
                } else if (email.getText().length() == 0) {
                    Toast.makeText(getApplicationContext(), "email is Empty", Toast.LENGTH_LONG).show();
                } else if (passwd.getText().length() == 0) {
                    Toast.makeText(getApplicationContext(), "password is Empty", Toast.LENGTH_LONG).show();
                } else if (passwd.getText().length() < 8) {
                    Toast.makeText(getApplicationContext(), "password is short", Toast.LENGTH_LONG).show();
                } else if (passwd.getText().length() > 20) {
                    Toast.makeText(getApplicationContext(), "password is long", Toast.LENGTH_LONG).show();
                } else if (!String.valueOf(passwd.getText()).equals(String.valueOf(conpasswd.getText()))) {
                    Toast.makeText(getApplicationContext(), "not match your entered passwords", Toast.LENGTH_LONG).show();
                } else {

                    String finame = fname.getText().toString();
                    String laname = lname.getText().toString();
                    String emai = email.getText().toString();
                    returnEmail = emai;
                    String passwrd = passwd.getText().toString();
                    returnPassword = passwrd;
                    ps = User.UserReg(finame, laname, emai, passwrd, 4);  //prepared statement of user as a student
                    newps = ps;
                    regstpg();

                }


            }
        });
    }

    public void regteachpg() {
        Intent intent = new Intent(this, teacherRegistration.class);
        intent.putExtra("Email",email.getText().toString());
        intent.putExtra("Password",passwd.getText().toString());
        startActivity(intent);

    }

    public void regstpg() {
        Intent intent = new Intent(this, StudentRegistration.class);
        System.out.println("Email = "+returnEmail);
        System.out.println("password = "+returnPassword);
        intent.putExtra("Email",returnEmail);
        intent.putExtra("Password",returnPassword);
        startActivity(intent);
    }


    public static PreparedStatement getps(){
        return newps;
    }

}

