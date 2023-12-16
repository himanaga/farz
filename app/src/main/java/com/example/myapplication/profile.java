package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.example.myapplication.databinding.ActivityProfileBinding;

public class profile extends AppCompatActivity {
    ActivityProfileBinding binding;
    Button cart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Intent intent = this.getIntent();
        cart =findViewById(R.id.item_cart);

        if (intent != null){
            String name = intent.getStringExtra("name");
            String description = intent.getStringExtra("description");
            String price = intent.getStringExtra("price");
            int image =intent.getIntExtra("image",R.drawable.a);

            binding.itemName.setText(name);
            binding.itemDesc.setText(description);
            binding.itemPrice.setText(price);
            binding.itemImg.setImageResource(image);
        }
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cart = new Intent(profile.this, cart.class);
                startActivity(cart);
                Toast.makeText(profile.this, "this is cart page brooooo malli", Toast.LENGTH_SHORT).show();
            }
        });

    }
}