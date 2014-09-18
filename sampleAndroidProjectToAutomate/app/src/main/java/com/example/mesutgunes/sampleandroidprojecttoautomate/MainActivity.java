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


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.submit);
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                // Perform action on click
                EditText username = (EditText) findViewById(R.id.username);
                String username_value = username.getText().toString();

                EditText password = (EditText) findViewById(R.id.password);
                String password_value = password.getText().toString();

                if ((username_value.equals("mesut")) && (password_value.equals("12345"))){
                    setContentView(R.layout.home_page);
                }
                else{
                    TextView text = (TextView) findViewById(R.id.message);
                    text.setText("Username or Password is incorrect!");
                    text.setTextColor(Color.RED);
                }
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
