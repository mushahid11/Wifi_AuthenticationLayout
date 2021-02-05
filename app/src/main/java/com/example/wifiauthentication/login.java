package com.example.wifiauthentication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login extends AppCompatActivity {
    EditText email, password;
    ProgressBar progressBar;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_login );

        email = findViewById( R.id.et_email );
        password = findViewById( R.id.et_password );
        progressBar = findViewById( R.id.progress_Bar );
        mAuth = FirebaseAuth.getInstance();

    }
    public void register(View view) {
        Intent intent = new Intent( com.example.wifiauthentication.login.this,MainActivity.class );
        startActivity( intent );
        startActivity( intent );
    }

    public void signInHere(View view) {
        progressBar.setVisibility( view.VISIBLE );
        String Email =  email.getText().toString();
        String Password =  password.getText().toString();

        mAuth.signInWithEmailAndPassword(Email, Password)
                .addOnCompleteListener( com.example.wifiauthentication.login.this, new OnCompleteListener< AuthResult >() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            progressBar.setVisibility( view.INVISIBLE );
                            Intent intent = new Intent( com.example.wifiauthentication.login.this,dashboard.class);
                            intent.putExtra( "email",mAuth.getCurrentUser().getEmail() );
                            intent.putExtra( "uid",mAuth.getCurrentUser().getUid() );
                            startActivity( intent );

                        } else {
                            progressBar.setVisibility( view.INVISIBLE );
                            email.setText( "" );
                            password.setText( "" );
                            Toast.makeText( com.example.wifiauthentication.login.this, "invalid email/password", Toast.LENGTH_SHORT ).show();
                        }

                    }
                });
    }
}