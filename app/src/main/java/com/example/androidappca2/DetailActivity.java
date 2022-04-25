package com.example.androidappca2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);



        TextView rating = findViewById(R.id.mRating);
        TextView restrant_name = findViewById(R.id.mRestrant);
        TextView overview = findViewById(R.id.mType);

        Bundle bundle = getIntent().getExtras();

        String mRestrant = bundle.getString("name");

        String mtype = bundle.getString("type");
        String mRating = bundle.getString("rating");


        rating.setText(mRating);
        restrant_name.setText(mRestrant);
        overview.setText(mtype);

    }
}
