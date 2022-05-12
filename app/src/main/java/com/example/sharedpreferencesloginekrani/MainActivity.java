package com.example.sharedpreferencesloginekrani;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText usernameText,passwordText;
    private Button logInButton;
    private SharedPreferences sp;
    private SharedPreferences.Editor editor;
    private String username;
    private String password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        usernameText = (EditText) findViewById(R.id.usernameText);
        passwordText = (EditText) findViewById(R.id.passwordText);
        logInButton = (Button) findViewById(R.id.logInButton);

        sp = getSharedPreferences("Giris Bilgi",MODE_PRIVATE);
        editor = sp.edit();

        username = sp.getString("username","no username");
        password = sp.getString("password","no password");

        if ( username.equals("admin") && password.equals("123")){
            startActivity(new Intent(MainActivity.this,LogInScreen.class));
            finish();
            //bu satır giriş yapıldıktan sonra uygulamaya dönüldüğünde tekrar log in gerekmemesi için
        }



        logInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (usernameText.getText().toString().equals("admin") && passwordText.getText().toString().equals("123")) {
                    editor.putString("username",usernameText.getText().toString());
                    editor.putString("password",passwordText.getText().toString());
                    editor.commit();
                    startActivity(new Intent(MainActivity.this,LogInScreen.class));

                    finish();
                }
                else {
                    Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_LONG).show();
                }
            }
        });





    }
}