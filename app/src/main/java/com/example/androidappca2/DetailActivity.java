package com.example.androidappca2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.ImageView;
import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        ImageView imageView = findViewById(R.id.poster_image);
        TextView rating_tv = findViewById(R.id.mRating);
        TextView title_tv = findViewById(R.id.mRestaurant);
        TextView overview_tv = findViewById(R.id.mType);

        Bundle bundle = getIntent().getExtras();

        String mTitle = bundle.getString("name");
        String mPoster = bundle.getString("image");
        String mtype = bundle.getString("type");
        String mRating = bundle.getString("rating");

        Glide.with(this).load(mPoster).into(imageView);
        rating_tv.setText(mRating);
        title_tv.setText(mTitle);
        overview_tv.setText(mtype);

    }
}
