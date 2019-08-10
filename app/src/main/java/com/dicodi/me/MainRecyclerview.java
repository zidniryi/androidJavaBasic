package com.dicodi.me;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

public class MainRecyclerview extends AppCompatActivity {
    private RecyclerView rvHeroes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_recyclerview);
        if(getSupportActionBar() != null){
            getSupportActionBar().setTitle("Hello World");

            rvHeroes = findViewById(R.id.rv_hero);
            rvHeroes.setHasFixedSize(true);
        }
    }
}
