package com.example.myapplication;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import android.view.View;
import android.os.Bundle;
import android.widget.ImageView;
import com.google.android.gms.tasks.OnCompleteListener;
import android.widget.Toast;
import com.bumptech.glide.Glide;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    ImageView profilePic;
    CardView tractors, crops, fertilizers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        profilePic = findViewById(R.id.profilePic);
        tractors = findViewById(R.id.tractors);
        fertilizers = findViewById(R.id.fertilizers);
        crops = findViewById(R.id.crops);

        Intent intent = getIntent();
        String profileUrl = intent.getStringExtra("profilePic");
        Glide.with(MainActivity.this).load(profileUrl).into(profilePic);

        profilePic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Profile Pic Clicked", Toast.LENGTH_SHORT).show();
                Intent goToProfilePage = new Intent(MainActivity.this, profile2.class);
                goToProfilePage.putExtra("profileImageUrl", profileUrl);
                goToProfilePage.putExtra("profileUserName", intent.getStringExtra("userName"));
                goToProfilePage.putExtra("profileUserEmail", intent.getStringExtra("userEmail"));
                goToProfilePage.putExtra("profileUserPhone", intent.getStringExtra("userPhone"));

                startActivity(goToProfilePage);
            }
        });

        tractors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToTractorsPage = new Intent(MainActivity.this, tractor.class);
                startActivity(goToTractorsPage);
                Toast.makeText(MainActivity.this, "Tractors Clicked", Toast.LENGTH_SHORT).show();
            }
        });

        fertilizers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, fertilizers.class);
                startActivity(i);
                Toast.makeText(MainActivity.this, "Fertilizers Clicked", Toast.LENGTH_SHORT).show();
            }
        });
        crops.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, news.class);
                startActivity(i);
                Toast.makeText(MainActivity.this, "Crops Clicked", Toast.LENGTH_SHORT).show();
            }
        });

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigation);
        bottomNavigationView.setSelectedItemId(R.id.home);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            // Get the item ID outside the switch to avoid constant expression error
            int itemId = item.getItemId();

            // Use if-else if statements instead of switch for non-constant expressions
            if (itemId == R.id.home) {
                return true;
            } else if (itemId == R.id.profile) {
                startActivity(new Intent(getApplicationContext(), profile2.class));

                return true;
            } else if (itemId == R.id.cart) {
                startActivity(new Intent(getApplicationContext(), cart.class));
                return true;
            }
            return false;
        });

    }
    @Override
    public void onBackPressed() {

    }
}