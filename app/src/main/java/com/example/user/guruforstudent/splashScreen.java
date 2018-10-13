package com.example.user.guruforstudent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class splashScreen extends AppCompatActivity {
    private int SLEEP_TIMER = 3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash_screen);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        LogoLauncher logoLauncher = new LogoLauncher();
        logoLauncher.start();
    }
    private class LogoLauncher extends Thread{
        public void run() {
            try {
                sleep(1000*SLEEP_TIMER);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Intent intent = new Intent(splashScreen.this, Login.class);
            startActivity(intent);
            splashScreen.this.finish();
        }

    }
}
