package com.example.wifiauthentication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.Random;

public class Register extends AppCompatActivity {

    FirebaseStorage storage;
    EditText email, password;
    EditText name;
    ProgressBar progressBar;
    private FirebaseAuth mAuth;
    ImageView proImage;
    Uri profileUri;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_register );

        email = findViewById( R.id.et_Email );
        password = findViewById( R.id.et_Password );
        progressBar = findViewById( R.id.progress_Bar );
        name = findViewById( R.id.et_Name );
        proImage = findViewById( R.id.logo );


        proImage.setOnClickListener( v -> {
            Intent intent = new Intent();
            intent.setType( "image/*" );
            intent.setAction( Intent.ACTION_GET_CONTENT );
            startActivityForResult( intent,1 );
            Log.e( "bsd", "onClick: " );
        } );

   }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult( requestCode, resultCode, data );
        if (resultCode == RESULT_OK) {
            Log.e( "bsd", "onClick: " );
            profileUri = data.getData();
            Log.e( "hello", "onActivityResult: " );
            proImage.setImageURI( profileUri );
        }else{
            Toast.makeText( this, "Error: Registration Class", Toast.LENGTH_SHORT ).show();
        }
    }




    public void signUpHere(View view) {
        progressBar.setVisibility( view.VISIBLE );

        String Email = email.getText().toString();
        String Password = password.getText().toString();
        mAuth = FirebaseAuth.getInstance();

        mAuth.createUserWithEmailAndPassword(Email,Password)
                .addOnCompleteListener(Register.this, new OnCompleteListener< AuthResult >() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            progressBar.setVisibility( view.INVISIBLE );
                            email.setText( "" );
                            password.setText( "" );
                            name.setText( "" );
                            Toast.makeText( Register.this, "Register Successfull", Toast.LENGTH_SHORT ).show();
                            uploadToFirebase( view );
                        } else {
                            Toast.makeText( Register.this, "Registeration Error", Toast.LENGTH_SHORT ).show();
                        }
                        // ...
                    }
                });
    }

    public void uploadToFirebase(View view) {

        final ProgressDialog dialog = new ProgressDialog( this );
        dialog.setMessage( "picture is uploading........." );
        dialog.show();
        name = findViewById( R.id.et_name );

        StorageReference reference = storage.getReference("images1"+new Random() .nextInt(50));
        reference.putFile(profileUri)
                .addOnSuccessListener(new OnSuccessListener< UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        reference.getDownloadUrl().addOnSuccessListener( new OnSuccessListener< Uri >() {
                            @Override
                            public void onSuccess(Uri uri) {
                                DatabaseReference mDatabase;
                                mDatabase = FirebaseDatabase.getInstance().getReference("users");
                                dataholder obj = new dataholder( name.getText().toString(),uri.toString() );
                                name.setText( "" );

                            }
                        } );
                        dialog.dismiss();
                        Snackbar.make( findViewById( android.R.id.content ),"image uploaded.",Snackbar.LENGTH_LONG ).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception exception) {
                        Toast.makeText( Register.this, "Failed to upload", Toast.LENGTH_SHORT ).show();
                    }
                })
                .addOnProgressListener( new OnProgressListener< UploadTask.TaskSnapshot >() {
                    @Override
                    public void onProgress(@NonNull UploadTask.TaskSnapshot snapshot) {
                        double progressPersent = (100.00*snapshot.getBytesTransferred()/snapshot.getTotalByteCount());
                        dialog.setMessage( "percentage "+(int)progressPersent+"%" );
                    }
                } );
    }
    
}