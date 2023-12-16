package com.example.myapplication;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.database.FirebaseDatabase;
import com.bumptech.glide.Glide;
import com.firebase.ui.auth.FirebaseAuthUIActivityResultContract;
import com.firebase.ui.auth.IdpResponse;
import com.firebase.ui.auth.data.model.FirebaseAuthUIAuthenticationResult;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.firebase.ui.auth.AuthUI;
import javax.annotation.Nullable;
import androidx.annotation.NonNull;

import com.google.android.gms.tasks.Task;


public class profile2 extends AppCompatActivity {
    Button logout;
    TextView userNaam, userEmaail, userphone;
    ImageView profilePicHere;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile2);
        Toast.makeText(this, "This is Profile Page Bro", Toast.LENGTH_SHORT).show();

        logout = findViewById(R.id.logout);
        userEmaail = findViewById(R.id.userEmaail);
        userNaam = findViewById(R.id.userName);
        userphone = findViewById(R.id.userphone);
        profilePicHere = findViewById(R.id.profilePicHere);

        Intent intent = getIntent();
        String profileUrl = intent.getStringExtra("profileImageUrl");
        String userName = intent.getStringExtra("profileUserName");
        String userEmail = intent.getStringExtra("profileUserEmail");
        String userPhone = intent.getStringExtra("profileUserPhone");

        Glide.with(profile2.this).load(profileUrl).into(profilePicHere);
        userNaam.setText(userName);
        userEmaail.setText(userEmail);
        userphone.setText(userPhone);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AuthUI.getInstance()
                        .signOut(profile2.this)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            public void onComplete(@NonNull Task<Void> task) {
                                Intent intent = new Intent(profile2.this, signup.class);
                                startActivity(intent);
                                finish();
                            }
                        });
            }
        });
    }


}