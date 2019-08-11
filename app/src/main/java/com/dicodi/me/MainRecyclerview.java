package com.dicodi.me;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainRecyclerview extends AppCompatActivity {
    private RecyclerView rvHeroes;
    private ArrayList<Hero> list = new ArrayList<>();
    private String title = "Mode List";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_recyclerview);
//        Set Title
        setActionBarTitle(title);


        rvHeroes = findViewById(R.id.rv_hero);
        rvHeroes.setHasFixedSize(true);

        list.addAll(HeroesData.getListData());
        showRecyclerList();
    }

//Call function list
    private void showRecyclerList(){
        rvHeroes.setLayoutManager(new LinearLayoutManager(this));
        ListHeroAdapter listHeroAdapter = new ListHeroAdapter(list);
        rvHeroes.setAdapter(listHeroAdapter);
    }
//    Call function grid
private void showRecyclerGrid(){
    rvHeroes.setLayoutManager(new GridLayoutManager(this, 2));
    GridHeroAdapter gridHeroAdapter = new GridHeroAdapter(list);
    rvHeroes.setAdapter(gridHeroAdapter);
}
//Call function cardview
private void showRecyclerCardView(){
    rvHeroes.setLayoutManager(new LinearLayoutManager(this));
    CardViewHeroAdapter cardViewHeroAdapter = new CardViewHeroAdapter(list);
    rvHeroes.setAdapter(cardViewHeroAdapter);
}

    private void setActionBarTitle(String title) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
    }

//This for menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        Ifalte menu
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    public void setMode(int selectedMode) {
        String title = null;
        switch (selectedMode) {
            case R.id.action_list:
                title = "Mode List";
                showRecyclerList();
                break;
            case R.id.action_grid:
                title = "Mode Grid";
                showRecyclerGrid();
                break;
            case R.id.action_cardview:
                title = "Mode Card";
                showRecyclerCardView();
                break;
        }
    }
}
