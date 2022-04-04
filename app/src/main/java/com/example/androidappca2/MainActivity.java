package com.example.androidappca2;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.androidappca2.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;

import com.google.gson.*;
import com.android.volley.*;
import com.android.volley.toolbox.*;

public class MainActivity extends BaseActivity {

    // uri of RESTful service on Azure
    private String SERVICE_URI = "https://api.json-generator.com/templates/HFU7eby3ZcFn/data?access_token=52rthn9619pcl2s336ldt6t5729kzjkcmm8mox05";
    private String TAG = "helloworldvolleyclient";

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        findViewById(R.id.test).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if(mProgressBar.getVisibility() == View.VISIBLE){
                    showProgressBar((false));

                }
                else {
                    showProgressBar((true));
                }
            }
        });

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                callService(view);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }

    // call RESTful service using volley and display results
    public void callService(View v)
    {
        // get TextView for displaying result
        final TextView outputTextView = (TextView) findViewById(R.id.outputTextView);

        try
        {
            // make a string request (JSON request an alternative)
            RequestQueue queue = Volley.newRequestQueue(this);
            Log.d(TAG, "Making request");
            try
            {
                StringRequest strObjRequest = new StringRequest(Request.Method.GET, SERVICE_URI,
                        new Response.Listener<String>()
                        {
                            @Override
                            public void onResponse(String response)
                            {
                                // parse resulting string containing JSON to Greeting object
                                Restaurant greeting = new Gson().fromJson(response, Restaurant.class);
                                outputTextView.setText(greeting.toString());
                                Log.d(TAG, "Displaying data" + greeting.toString());
                            }
                        },
                        new Response.ErrorListener()
                        {
                            @Override
                            public void onErrorResponse(VolleyError error)
                            {
                                outputTextView.setText(error.toString());
                                Log.d(TAG, "Error" + error.toString());
                            }
                        });
                queue.add(strObjRequest);           // can have multiple in a queue, and can cancel
            }
            catch (Exception e1)
            {
                Log.d(TAG, e1.toString());
                outputTextView.setText(e1.toString());
            }
        }
        catch (Exception e2)
        {
            Log.d(TAG, e2.toString());
            outputTextView.setText(e2.toString());
        }
    }

}