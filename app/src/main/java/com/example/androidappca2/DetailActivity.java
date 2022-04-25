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


        ImageView imageView = findViewById(R.id.image);
        TextView rating_tv = findViewById(R.id.mRating);
        TextView title_tv = findViewById(R.id.mRestaurant);
        TextView overview_tv = findViewById(R.id.mType);
        TextView tables_tv = findViewById(R.id.mTables);

        Bundle bundle = getIntent().getExtras();

        String mTitle = bundle.getString("name");
        String mImage = bundle.getString("image");
        String mType = bundle.getString("type");
        String mRating = bundle.getString("rating");
        String mTables= bundle.getString("tables");

        Glide.with(this).load(mImage).into(imageView);
        rating_tv.setText(mRating);
        title_tv.setText(mTitle);
        overview_tv.setText(mType);
        tables_tv.setText(mTables);

    }
}
