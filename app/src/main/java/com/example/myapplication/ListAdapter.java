package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;

//implementation 'com.squareup.picasso:picasso:2.8'
//import com.squareuppicasso.Picasso;//

public class ListAdapter  extends ArrayAdapter<User> {

    public ListAdapter(@NonNull Context context, ArrayList<User> userArrayList){

        super(context,R.layout.list,userArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        User user =getItem(position);

        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list,parent,false);
        }
        ImageView imageView = convertView.findViewById(R.id.list_image);
        TextView name = convertView.findViewById(R.id.list_name);
        TextView description = convertView.findViewById(R.id.list_description);
        TextView price = convertView.findViewById(R.id.list_price);

        imageView.setImageResource(user.img);
        //Picasso.get().load(user.img).into(image);
        name.setText(user.name);
        description.setText(user.description);
        price.setText(user.price);

        return convertView;
    }
}
