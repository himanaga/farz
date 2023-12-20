package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import java.util.ArrayList;

import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.util.Log;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
public class cart extends AppCompatActivity {
    ImageView profilePic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        profilePic = findViewById(R.id.profilePic);

        Intent intent = getIntent();
        String profileUrl = intent.getStringExtra("profilePic");
        Glide.with(cart.this).load(profileUrl).into(profilePic);
        Glide.with(cart.this).load(profileUrl).into(profilePic);

        profilePic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(cart.this, "Profile  Clicked", Toast.LENGTH_SHORT).show();
                Intent goToProfilePage = new Intent(cart.this, profile2.class);
                goToProfilePage.putExtra("profileImageUrl", profileUrl);
                goToProfilePage.putExtra("profileUserName", intent.getStringExtra("userName"));
                goToProfilePage.putExtra("profileUserEmail", intent.getStringExtra("userEmail"));
                goToProfilePage.putExtra("profileUserPhone", intent.getStringExtra("userPhone"));

                startActivity(goToProfilePage);
            }
        });
        Intent intent1 = getIntent();
        if (intent1 != null) {
            ArrayList<User> cartList = (ArrayList<User>) intent1.getSerializableExtra("cartList");
            //ArrayList<User> cartList = (ArrayList<User>) getIntent().getSerializableExtra("cartList");

        // Check if cartList is not null before using it
        if (cartList != null) {
            // Create and set up the adapter for the cart list
            CartAdapter cartAdapter = new CartAdapter(cart.this, cartList);
            // Find the ListView in your cart layout
            ListView cartListView = findViewById(R.id.cart_listview1);
            // Set the adapter to the ListView
            cartListView.setAdapter(cartAdapter);
        } else {
            Toast.makeText(this, "Cart is empty", Toast.LENGTH_SHORT).show();
        }
        //new 17-12 1:46
        }

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigation);
        bottomNavigationView.setSelectedItemId(R.id.cart);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            // Get the item ID outside the switch to avoid constant expression error
            int itemId = item.getItemId();

            // Use if-else if statements instead of switch for non-constant expressions
            if (itemId == R.id.home) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();
                return true;
            } else if (itemId == R.id.profile) {
                startActivity(new Intent(getApplicationContext(), profile2.class));
               finish();
                return true;
            } else if (itemId == R.id.cart) {
                return true;
            }

            return false;
        });


    }
    @Override
    public void onBackPressed() {
        finish();
    }
}
