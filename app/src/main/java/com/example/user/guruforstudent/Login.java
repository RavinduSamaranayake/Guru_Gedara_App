package com.example.user.guruforstudent;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.sql.PreparedStatement;

public class Login extends AppCompatActivity {

    //Connection con = null;
    PreparedStatement ps = null;
    Button tomain;
    Button userregpg;
    EditText username;
    EditText passwd;
    TextView tv;
    FirebaseAuth auth;
//    private static final String FILE_NAME = "test.txt";
   // User u = new User();
    public Login(){}

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        //con = MyConnection.getconnection();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        tomain=(Button)findViewById(R.id.login);
        userregpg = (Button)findViewById(R.id.regBtn);
        username =(EditText)findViewById(R.id.txtUname);
        passwd =(EditText)findViewById(R.id.txtPasswd);
        auth = FirebaseAuth.getInstance();

        if (auth.getCurrentUser() != null) {
            startActivity(new Intent(Login.this, Home.class));
            finish();
        }

        tomain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // save();
                String uname = username.getText().toString();
                String paswd = passwd.getText().toString();

                auth.signInWithEmailAndPassword(uname,paswd).addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(!task.isSuccessful()){
                            Toast.makeText(Login.this,"Username or password is invalid",Toast.LENGTH_LONG).show();
                        }else{
                            startActivity(new Intent(Login.this,ChooseInstitue.class));
                            finish();
                        }
                    }
                });
            }
        });
        userregpg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // load();
                openregpg();
            }
        });

    }
    public void openslctclsspg() {
        Intent intent = new Intent(this,ChooseInstitue.class);
        startActivity(intent);
    }
    public void openregpg() {
        Intent intent = new Intent(this,userRegister.class);
        startActivity(intent);
    }
}
