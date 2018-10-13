package com.example.user.guruforstudent.Controls;
import android.widget.Toast;

//import java.io.*;
import com.example.user.guruforstudent.Login;

import java.util.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by USER on 9/3/2018.
 */

public class FileRW {
   /** String username;
    private static final String FILE_NAME = "test.txt";

    public FileRW(String username) {
        this.username = username;
    }

    public FileRW() {
    }

    public void save() {
        String text = this.username;
        FileOutputStream fos = null;
        try {
            fos = openFileOutput(FILE_NAME, MODE_PRIVATE);
            fos.write(text.getBytes());
            //username.getText().clear();
            //Toast.makeText(getApplicationContext(), "Save to " + getFilesDir(), Toast.LENGTH_LONG).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            if (fos != null) {

                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public void load() {
        FileInputStream fis = null;
        try {
            fis = openFileInput(FILE_NAME);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String text;
            while ((text = br.readLine()) != null) {
                sb.append(text).append("\n");
            }
            Toast.makeText(getApplicationContext(), sb.toString(), Toast.LENGTH_LONG).show();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    } **/
}







   /* public void clearTheFile() {
        FileWriter fwOb = null;
        try {
            fwOb = new FileWriter("C:\\Users\\USER\\GuruforStudent\\app\\src\\main\\java\\com\\example\\user\\guruforstudent\\Controls\\temp.txt", false);
            PrintWriter pwOb = new PrintWriter(fwOb, false);
            pwOb.flush();
            pwOb.close();
            fwOb.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    } */






