package com.example.androidappca2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        //ImageView imageView = findViewById(R.id.poster_image);
        TextView rating = findViewById(R.id.mRating);
        TextView restrant_name = findViewById(R.id.mRestrant);
        TextView overview = findViewById(R.id.mType);
        Bundle bundle = getIntent().getExtras();
        String mRestrant = bundle.getString("name");
        //String mPoster = bundle.getString("poster");
        String mtype = bundle.getString("type");
        String mRating = bundle.getString("rating");
        //Glide.with(this).load(mPoster).into(imageView);
        rating.setText(mRating);
        restrant_name.setText(mRestrant);
        overview.setText(mtype);

    }
}
