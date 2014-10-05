package com.example.mesutgunes.sampleandroidprojecttoautomate;

import android.app.Activity;

import java.util.Dictionary;
import java.util.Hashtable;
import android.app.Application;

/**
 * Created by mesutgunes on 22/09/14.
 */
public class Users extends Application{

    public static Dictionary users = new Hashtable();

    public void onCreate(){
        super.onCreate();
    }

    public static Object getUser(String username) {
        return users.get(username);
    }

    public static void setUser(String username, String password){
        users.put(username, password);
    }

}
