package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.myapplication.databinding.ActivityProfileBinding;

public class profile extends AppCompatActivity {
    ActivityProfileBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Intent intent = this.getIntent();

        if (intent != null){
            String name = intent.getStringExtra("name");
            String description = intent.getStringExtra("description");
            String price = intent.getStringExtra("price");
            int image =intent.getIntExtra("image",R.drawable.ratingbar);

            binding.itemName.setText(name);
            binding.itemDesc.setText(description);
            binding.itemPrice.setText(price);
            binding.itemImg.setImageResource(image);
        }

    }
}