package com.example.mesutgunes.sampleandroidprojecttoautomate;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Dictionary;

import java.io.Writer;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Objects;

import android.os.Environment;


public class SinUp extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sin_up);
        Bundle extras = getIntent().getExtras();

        final Dictionary users = Users.users;

        final Auth auth = new Auth();

        Button sign_up_button = (Button) findViewById(R.id.sign_up);
        sign_up_button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                // Perform action on click
                EditText username = (EditText) findViewById(R.id.username);
                String username_value = username.getText().toString();

                EditText password = (EditText) findViewById(R.id.password);
                String password_value = password.getText().toString();

                EditText re_password = (EditText) findViewById(R.id.re_password);
                String re_password_value = re_password.getText().toString();

                TextView message = (TextView) findViewById(R.id.message);

                Object user_exits = users.get(username_value);
                String user_password = auth.get_password(username_value);

                if (username_value.equals("") || password_value.equals("") || re_password_value.equals("")){
                    message.setText("Please fill the form");
                    message.setTextColor(Color.RED);
                }
                else {
                    if (!password_value.equals(re_password_value)){
                        message.setText("Please re-type same password");
                        message.setTextColor(Color.RED);
                    }
                    else {
                        if (!user_password.isEmpty() || user_password.equals(null)) {
                            message.setText("User is exists, change user name");
                            message.setTextColor(Color.RED);
                        } else {
                            message.setText("User is registered. Click login button for login page");
                            message.setTextColor(Color.GREEN);

                            auth.write_user(username_value, password_value);
                        }
                    }
                }
            }

        });

        Button submit_button = (Button) findViewById(R.id.submit);
        submit_button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                // Perform action on click
                startActivity(new Intent(v.getContext(), MainActivity.class));
            }

        });



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.sin_up, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}




