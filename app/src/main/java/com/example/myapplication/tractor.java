package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

import com.bumptech.glide.Glide;
import com.example.myapplication.ListAdapter;
import com.example.myapplication.databinding.ActivityTractorBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class tractor extends AppCompatActivity {
    ActivityTractorBinding binding;
    ImageView profilePic;
    private ArrayList<User> cartList;
   // private User getItemDetails() {
        // Replace this with your logic to retrieve item details from the selected item in the ListView
        // For now, let's create a sample User object
   //     String name = "Sample Item";
      //  String description = "Sample Description";
     //   String price = "Sample Price";
        //int image = R.drawable.a; // Replace with the actual image resource
  //      int b_id = R.string.b1; // Replace with the actual ID

     //   return new User(name, price, description, image, b_id);
 //   }
    //private void addToCart(User user) {
       // if (cartList != null) {
          //  cartList.add(user);
            // Optionally, you can show a toast or perform other actions to indicate item added to the cart
            //Toast.makeText(tractor.this, "Item added to cart", Toast.LENGTH_SHORT).show();
       // }
     // }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTractorBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        profilePic = findViewById(R.id.profilePic);

        Intent io = getIntent();
        String profileUrl = io.getStringExtra("profilePic");

// Check if profileUrl is not null before loading it with Glide
        if (profileUrl != null) {
            Glide.with(tractor.this).load(profileUrl).into(profilePic);
        } else {
            // Handle the case where profileUrl is null, for example, load a default image
            //Glide.with(tractor.this).load(R.drawable.acc).into(profilePic);
        }
        profilePic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToProfilePage = new Intent(tractor.this, MainActivity.class);
                startActivity(goToProfilePage);
            }
        });


        int [] image = { R.drawable.a,R.drawable.b,R.drawable.f,R.drawable.logo,R.drawable.a,R.drawable.f,R.drawable.b,R.drawable.f,R.drawable.logo,R.drawable.a};
        String[] name = {"cultivater","mahindra","plough","driller","cultivater","mahindra","plough","driller","cultivater","driller"};
        String [] description ={"free of cost","Add to Cart","Popular App","Social Media","free of cost","Add to Cart","Popular App","Social Media","free of cost Add to Cart","Popular App Social Media"};
        String [] price ={"520","520","520","520","520","520","520","520","520","520"};
    //    int [] b_id ={R.string.b1,R.string.b2,R.string.b3,R.string.b4,R.string.b5,R.string.b5,R.string.b6,R.string.b7,R.string.b8,R.string.b9,R.string.b10,};
        ArrayList<User> userArrayList = new ArrayList<>();
        ArrayList<User> cartList = new ArrayList<>();
        for (int i=0;i< image.length;i++){
            User user = new User( name[i],price[i],description[i],image[i]);//b_id[i]
            userArrayList.add(user);
        }

        ListAdapter listAdapter = new ListAdapter(tractor.this,userArrayList, cartList);
        binding.listview.setAdapter(listAdapter);
        binding.listview.setClickable(true);
        binding.listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                Intent i =new Intent(tractor.this,profile.class);

              //  i.putExtra("b_id",b_id[position]);
                i.putExtra("name", name[position]);
                i.putExtra("description",description[position]);
                i.putExtra("price",price[position]);
                i.putExtra("image",image[position]);
                i.putExtra("cartList", cartList);  // Pass the cartList to the profile activity
                startActivity(i);

            }
        });



       // Button addToCartButton = findViewById(R.id.addToCartButton);
       // addToCartButton.setOnClickListener(new View.OnClickListener() {
          //  @Override
           // public void onClick(View view) {
                // Calling the addToCart,  when the button is clicked
              //  addToCart(getItemDetails());
          //  } });


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigation);

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
                startActivity(new Intent(getApplicationContext(), cart.class));
                finish();
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