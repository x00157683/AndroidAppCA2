package com.example.androidappca2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);



        TextView rating_tv = findViewById(R.id.mRating);
        TextView title_tv = findViewById(R.id.mTitle);
        TextView overview_tv = findViewById(R.id.movervie_tv);

        Bundle bundle = getIntent().getExtras();

        String mTitle = bundle.getString("name");

        String mtype = bundle.getString("type");
        String mRating = bundle.getString("rating");


        rating_tv.setText(mRating);
        title_tv.setText(mTitle);
        overview_tv.setText(mtype);

    }
}
