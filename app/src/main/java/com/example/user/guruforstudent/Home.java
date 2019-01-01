package com.example.user.guruforstudent;

import android.content.Intent;
import android.os.Bundle;


import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;

public class Home extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawer;
    NavigationView navigationView;
    Toolbar toolbar = null;
    FirebaseAuth auth;
    CardView addIns;
    CardView viewIns;
    CardView rateIns;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        auth=FirebaseAuth.getInstance();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        addIns = (CardView)findViewById(R.id.addInstitue);
        viewIns = (CardView)findViewById(R.id.viewInstitue);
        rateIns = (CardView)findViewById(R.id.rateInstitue);
        addIns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadAddInspg();
            }
        });
        rateIns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadRateInspg();
            }
        });
        viewIns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadViewInspg();
            }
        });
        
    }

    private void loadRateInspg() {
        Intent intent = new Intent(this,rateInstitute.class);
        startActivity(intent);
    }

    private void loadViewInspg() {
        Intent intent = new Intent(this,classes.class);
        startActivity(intent);
    }

    private void loadAddInspg() {
        Intent intent = new Intent(this,ChooseInstitue.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.Home) {
            Intent h = new Intent(Home.this, Home.class);
            startActivity(h);
        } else if (id == R.id.setting) {
            Intent s = new Intent(Home.this, Settings.class);
            startActivity(s);

        } else if (id == R.id.help) {
            Intent l = new Intent(Home.this, Help.class);
            startActivity(l);

        }else if (id == R.id.logout){
            auth.signOut();
            startActivity(new Intent(Home.this,Login.class));
        }else if (id == R.id.aboutapp) {
            Intent a = new Intent(Home.this,about.class);
            startActivity(a);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
