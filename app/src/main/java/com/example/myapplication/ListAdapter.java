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

public class ListAdapter  extends ArrayAdapter<User> {

    public ListAdapter(Context context, ArrayList<User> userArrayList){

        super(context,R.layout.list,userArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        User user =getItem(position);

        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list,parent,false);
        }
        ImageView image = convertView.findViewById(R.id.img);
        TextView itemname = convertView.findViewById(R.id.name);
        TextView description = convertView.findViewById(R.id.description);
        TextView price = convertView.findViewById(R.id.price);

        image.setImageResource(user.img);
        itemname.setText(user.name);
        description.setText(user.description);
        price.setText(user.price);


        return convertView;
    }
}
