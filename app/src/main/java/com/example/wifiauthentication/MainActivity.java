package com.example.wifiauthentication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        Button buttonLogin = findViewById( R.id. btn_login);
         buttonLogin.setOnClickListener( new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 startActivity( new Intent(MainActivity.this,MyAccount.class) );
             }
         } );


    }

    public void register(View view) {
        startActivity( new Intent(MainActivity.this,Register.class) );
    }

    public void login(View view) {
        startActivity( new Intent(MainActivity.this,Register.class) );
    }
}