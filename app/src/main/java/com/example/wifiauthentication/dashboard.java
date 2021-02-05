package com.example.wifiauthentication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class dashboard extends AppCompatActivity {
          TextView t1,t2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_dashboard );

    t1= findViewById( R.id.email );
    t2= findViewById( R.id.uid );

        Intent intent = getIntent();
       String Email = intent.getStringExtra(  "email");
       String Uid = intent.getStringExtra("uid");

       t1.setText( Email );
       t2.setText( Uid);


    }

    public void logout(View view) {
        FirebaseAuth.getInstance().signOut();
        startActivity( new Intent( com.example.wifiauthentication.dashboard.this,MainActivity.class) );
    }
}