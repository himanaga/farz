package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.ListAdapter;
import com.example.myapplication.databinding.ActivityTractorBinding;

import java.util.ArrayList;

public class tractor extends AppCompatActivity {
    ActivityTractorBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTractorBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        int[] image = { R.drawable.a,R.drawable.b,R.drawable.f,R.drawable.logo,R.drawable.a,R.drawable.f,R.drawable.b,R.drawable.f,R.drawable.logo,R.drawable.a};
        String[] name = {"cultivater","mahindra","plough","driller","cultivater","mahindra","plough","driller","cultivater","driller"};
        String [] description ={"free of cost","Add to Cart","Popular App","Social Media","free of cost","Add to Cart","Popular App","Social Media","free of cost Add to Cart","Popular App Social Media"};
        String [] price ={"520","520","520","520","520","520","520","520","520","520"};

        ArrayList<User> userArrayList = new ArrayList<>();
        for (int i=0;i< image.length;i++){
            User user = new User( name[i],price[i],description[i],image[i]);
            userArrayList.add(user);
        }

        ListAdapter listAdapter = new ListAdapter(tractor.this,userArrayList);
        binding.listview.setAdapter(listAdapter);
        binding.listview.setClickable(true);
        binding.listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                Intent i =new Intent(tractor.this,profile.class);

                i.putExtra("name", name[position]);
                i.putExtra("description",description[position]);
                i.putExtra("price",price[position]);
                i.putExtra("image",image[position]);
                startActivity(i);

            }
        });

    }
}