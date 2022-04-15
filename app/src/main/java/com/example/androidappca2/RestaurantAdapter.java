package com.example.androidappca2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantAdapter.MovieHolder> {

    private Context context;
    private List<Restaurant> restaurantList;

    public RestaurantAdapter(Context context , List<Restaurant> restaurantList){
        this.context = context;
        this.restaurantList = restaurantList;
    }
    @NonNull
    @Override
    public MovieHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.rowlayout , parent , false);
        return new MovieHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieHolder holder, int position) {

        Restaurant restaurant = restaurantList.get(position);
        holder.rating.setText(restaurant.getRating().toString());
        holder.name.setText(restaurant.getName());
        holder.type.setText(restaurant.getType());
        //holder.restaurantId.setText(restaurant.getRestaurantId().toString());

        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context , DetailActivity.class);

                Bundle bundle = new Bundle();
                bundle.putString("name" , restaurant.getName());
                bundle.putString("rating" , restaurant.getRating());
                bundle.putString("type" , restaurant.getType());
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

    public class MovieHolder extends RecyclerView.ViewHolder{


        TextView name , rating, type, restaurantId;
        ConstraintLayout constraintLayout;

        public MovieHolder(@NonNull View itemView) {
            super(itemView);


            name = itemView.findViewById(R.id.title_tv);
            rating = itemView.findViewById(R.id.rating);
            type = itemView.findViewById(R.id.overview_tv);
            //restaurantId = itemView.findViewById(R.id.restaurantId);
            constraintLayout = itemView.findViewById(R.id.main_layout);
        }
    }
}
