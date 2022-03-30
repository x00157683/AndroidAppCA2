package com.example.androidappca2;

import android.icu.lang.UProperty;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

import androidx.annotation.ContentView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.solver.state.State;
import androidx.constraintlayout.widget.ConstraintLayout;

public abstract class BaseActivity extends AppCompatActivity {

    public ProgressBar mProgressBar;

    @Override
    public void setContentView(int layoutResID){

        ConstraintLayout constraintLayout = (ConstraintLayout) getLayoutInflater().inflate(R.layout.activity_base,null );
        FrameLayout frameLayout = constraintLayout.findViewById(R.id.activity_content);
        mProgressBar = constraintLayout.findViewById(androidx.appcompat.R.id.progress_circular);
        getLayoutInflater().inflate(layoutResID,frameLayout,true);

        super.setContentView(layoutResID);

    }

    public void showProgressBar(boolean visiblity){
        mProgressBar.setVisibility(visiblity ? View.VISIBLE : View.INVISIBLE);
    }

}
