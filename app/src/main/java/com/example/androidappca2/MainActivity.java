package com.example.androidappca2;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;

import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.*;
import com.android.volley.toolbox.*;

import java.util.List;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RequestQueue requestQueue;
    private List<Restaurant> restaurantList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        requestQueue = VolleySingleton.getmInstance(this).getRequestQueue();

        restaurantList = new ArrayList<>();
        fetchRestaurant();


    }

    private void fetchRestaurant() {

        //https://ca2webapi.azurewebsites.net/index.html
        //private String SERVICE_URI = "https://ca2webapi.azurewebsites.net/api/restaurant/1";
        //private String SERVICE_URI = "https://api.json-generator.com/templates/HFU7eby3ZcFn/data?access_token=52rthn9619pcl2s336ldt6t5729kzjkcmm8mox05";
        String url = "https://ca2webapi.azurewebsites.net/api/restaurant";

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        for (int i = 0 ; i < response.length() ; i ++){
                            try {
                                JSONObject jsonObject = response.getJSONObject(i);
                                String name = jsonObject.getString("name");
                                String rating = jsonObject.getString("rating");
                                String type = jsonObject.getString("type");
                                String restaurantId = jsonObject.getString("restaurantId");

                                Restaurant restaurant = new Restaurant(name , rating , type , restaurantId);
                                restaurantList.add(restaurant);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                            RestaurantAdapter adapter = new RestaurantAdapter(MainActivity.this , restaurantList);

                            recyclerView.setAdapter(adapter);
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        requestQueue.add(jsonArrayRequest);
    }
}
