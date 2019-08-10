package com.dicodi.me;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainRecyclerview extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_recyclerview);
        if(getSupportActionBar() != null){
            getSupportActionBar().setTitle("Hello World");
        }
    }
}
