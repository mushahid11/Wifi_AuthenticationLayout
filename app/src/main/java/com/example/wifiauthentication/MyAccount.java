package com.example.wifiauthentication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toolbar;

public class MyAccount extends AppCompatActivity {
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_my_account );
        toolbar = findViewById( R.id.account_toolbar );


        TextView tvReward = findViewById( R.id.tv_reward );
       tvReward.setOnClickListener( new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               startActivity( new Intent(MyAccount.this,Rewards.class) );
           }
       } );

        TextView profiled = findViewById( R.id.profile );
        profiled.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity( new Intent(MyAccount.this,Detail.class) );
            }
        } );
    }


}