package com.dicodi.me;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Produk extends AppCompatActivity {
String names = "Note 10";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produk);
        if (getSupportActionBar() != null){
            getSupportActionBar().setTitle(names);
        }
    }
}
