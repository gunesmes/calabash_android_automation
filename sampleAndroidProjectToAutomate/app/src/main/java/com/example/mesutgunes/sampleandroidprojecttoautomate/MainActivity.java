package com.example.mesutgunes.sampleandroidprojecttoautomate;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;

import java.util.Dictionary;
import java.util.Objects;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Users users;
        users = ((Users)getApplicationContext());

        final Auth auth = new Auth();

        Button submit_button = (Button) findViewById(R.id.submit);
        submit_button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                // Perform action on click
                EditText username = (EditText) findViewById(R.id.username);
                String username_value = username.getText().toString();

                EditText password = (EditText) findViewById(R.id.password);
                String password_value = password.getText().toString();

                TextView text_message = (TextView) findViewById(R.id.message);
                String password_auth = auth.get_password(username_value).toString();

                if (password_auth.toString().equals(password_value.toString())){
                    System.out.println("passwords are same!");
                    System.out.println(password_auth + " : " + password_value);
                }

                try {
                    if (password_value.equals(password_auth) && !password_value.equals("")) {
                        setContentView(R.layout.home_page);
                    } else {
                        text_message.setText("Username or Password is incorrect!");
                        text_message.setTextColor(Color.RED);
                    }
                } catch (NullPointerException e) {
                    text_message.setText("Username is not registered!");
                    text_message.setTextColor(Color.RED);
                }
            }

        });

        final Button sign_up_button = (Button) findViewById(R.id.signup);
        sign_up_button.setOnClickListener(  new View.OnClickListener(){
            public void onClick(View v) {
                // Perform action on click
                startActivity(new Intent(v.getContext(), SinUp.class));
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
