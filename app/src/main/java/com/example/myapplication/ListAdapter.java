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
    private ArrayList<User> cartList;
    public ListAdapter(@NonNull Context context, ArrayList<User> userArrayList, ArrayList<User> cartList){

        super(context,R.layout.list,userArrayList);
        this.cartList = cartList;
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
//        Button b_id = convertView.findViewById(R.id.addToCartButton);

        imageView.setImageResource(user.img);
        //Picasso.get().load(user.img).into(image);
        name.setText(user.name);
        description.setText(user.description);
        price.setText(user.price);
    //    b_id.setId(user.id);

        //add to cart

       // Button addToCartButton = convertView.findViewById(R.id.addToCartButton);
        //addToCartButton.setOnClickListener(new View.OnClickListener() {
           // @Override
            //public void onClick(View view) {
               // addToCart(user);
            //}
        // });

       return convertView;
    }
   // private void addToCart(User user) {
        // Implement the logic to add the item to the cartList
        // You may want to check if the item is already in the cart before adding
      //  if (!cartList.contains(user)) {
         //   cartList.add(user);
            ///notifyDataSetChanged(); // Update the adapter to reflect changes
    //    }
    //}
}
