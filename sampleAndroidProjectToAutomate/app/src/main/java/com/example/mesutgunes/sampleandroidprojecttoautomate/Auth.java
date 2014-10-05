package com.example.mesutgunes.sampleandroidprojecttoautomate;

/**
 * Created by mesutgunes on 27/09/14.
 */

//package com.totsp.bookworm.util;

import android.app.Application;
import android.content.Context;
import android.os.Environment;
import android.util.Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.channels.FileChannel;


public class Auth extends Application {

    // Object for intrinsic lock (per docs 0 length array "lighter" than a normal Object
    //public static final Object[] DATA_LOCK = new Object[0];

    public Auth() {
    }

    public static String[] read_users(){
        File myFile = new File("/sdcard/" + "user.txt");

        //Read text from file
        StringBuilder text = new StringBuilder();

        try{
            BufferedReader br = new BufferedReader(new FileReader(myFile));
            String line;

            while ((line = br.readLine()) != null) {
                text.append(line);
                text.append('\n');
            }
        } catch (IOException e) {
            System.out.println(e);
        }

        return text.toString().split(";");
    }

    public static String get_password(String username){
        String[] users = read_users();
        String password = new String();

        try {
            for (int i = 0; i < users.length; i++) {
                String[] user = users[i].toString().split(":");

                if (user[0].equals(username)) {
                    password = user[1].trim();
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("Text file is not found!");
        }

        return password;
    }

    public static void write_user(String username, String password){
        try{
            File myFile = new File("/sdcard/" + "user.txt");
            myFile.createNewFile();
            FileOutputStream fOut = new

            FileOutputStream(myFile, true);
            OutputStreamWriter myOutWriter = new

            OutputStreamWriter(fOut);
            myOutWriter.append(username + ":" + password + ";");
            myOutWriter.flush();
            myOutWriter.close();
            fOut.close();

        } catch(IOException e) {
            System.out.println("COULD NOT WRITE USER !!!");
        }

    }

}
