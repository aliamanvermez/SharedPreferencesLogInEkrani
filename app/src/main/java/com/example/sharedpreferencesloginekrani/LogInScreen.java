package com.example.sharedpreferencesloginekrani;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LogInScreen extends AppCompatActivity {
    private TextView usernameOutput, passwordOutput;
    private Button buttonLogOut;
    private SharedPreferences sp;
    private SharedPreferences.Editor editor;
    private String username;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log_in_screen);

        buttonLogOut = (Button) findViewById(R.id.buttonLogOut);

        usernameOutput = (TextView) findViewById(R.id.usernameOutput);

        passwordOutput = (TextView) findViewById(R.id.passwordOutput);

        sp = getSharedPreferences("Giris Bilgi",MODE_PRIVATE);
        editor = sp.edit();

        username = sp.getString("username","no username");
        password = sp.getString("password","no password");


        usernameOutput.setText("Username : " + username);
        passwordOutput.setText("Password :"+ password);


        buttonLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.remove("username");
                editor.remove("password");
                editor.commit();
                startActivity(new Intent(LogInScreen.this,MainActivity.class));


                finish();
            }
        });





    }
}