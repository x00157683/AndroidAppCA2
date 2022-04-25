package com.example.androidappca2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantAdapter.RestaurantHolder> {

    private Context context;
    private List<Restaurant> restaurantList;

    public RestaurantAdapter(Context context , List<Restaurant> restaurant){
        this.context = context;
        restaurantList = restaurant;
    }
    @NonNull
    @Override
    public RestaurantHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.rowlayout , parent , false);
        return new RestaurantHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RestaurantHolder holder, int position) {

        Restaurant restaurant = restaurantList.get(position);
        holder.rating.setText(restaurant.getRating().toString());
        holder.name.setText(restaurant.getName());
        holder.type.setText(restaurant.getType());
        Glide.with(context).load(restaurant.getImage()).into(holder.imageView);
        //holder.restaurantId.setText(restaurant.getRestaurantId().toString());

        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context , DetailActivity.class);

                Bundle bundle = new Bundle();
                bundle.putString("name" , restaurant.getName());
                bundle.putString("rating" , restaurant.getRating());
                bundle.putString("type" , restaurant.getType());
                bundle.putString("image" , restaurant.getImage());
                bundle.putString("restaurantId" , restaurant.getRestaurantId());

                intent.putExtras(bundle);

                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return restaurantList.size();
    }

    public class RestaurantHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView name , rating, type, restaurantId;
        ConstraintLayout constraintLayout;

        public RestaurantHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageview);
            name = itemView.findViewById(R.id.restrant_name);
            rating = itemView.findViewById(R.id.rating);
            type = itemView.findViewById(R.id.type);
            //restaurantId = itemView.findViewById(R.id.restaurantId);
            constraintLayout = itemView.findViewById(R.id.main_layout);
        }
    }
}
