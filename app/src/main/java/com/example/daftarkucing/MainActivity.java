package com.example.daftarkucing;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvCategory;
    private ArrayList<Kucing> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvCategory = findViewById(R.id.rv_category);
        rvCategory.setHasFixedSize(true);

        list.addAll(KucingData.getListData());
        showRecyclerList();
    }

    private void showRecyclerList() {
        rvCategory.setLayoutManager(new LinearLayoutManager(this));
        ListKucingAdapter listKucingAdapter = new ListKucingAdapter(this);
        listKucingAdapter.setListKucing(list);
        rvCategory.setAdapter(listKucingAdapter);

        ItemClickSupport.addTo(rvCategory).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                showSelectedKucing(list.get(position));
            }
        });
    }

    private void showRecyclerGrid() {
        rvCategory.setLayoutManager(new GridLayoutManager(this, 2));
        GridKucingAdapter gridKucingAdapter = new GridKucingAdapter(this);
        gridKucingAdapter.setListKucing(list);
        rvCategory.setAdapter(gridKucingAdapter);

        ItemClickSupport.addTo(rvCategory).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                showSelectedKucing(list.get(position));
            }
        });
    }

    private void showRecycleCardView() {
        rvCategory.setLayoutManager(new LinearLayoutManager(this));
        CardViewKucingAdapter cardViewKucingAdapter = new CardViewKucingAdapter(this);
        cardViewKucingAdapter.setListKucing(list);
        rvCategory.setAdapter(cardViewKucingAdapter);

        ItemClickSupport.addTo(rvCategory).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                showSelectedKucing(list.get(position));
            }
        });
    }

    private void showSelectedKucing(Kucing kucing){
        Toast.makeText(this, "Anda memilih "+kucing.getName(), Toast.LENGTH_SHORT).show();
        Intent moveIntent = new Intent(MainActivity.this, Detail.class);
        moveIntent.putExtra(Detail.EXTRA_PHOTO, kucing.getPhoto());
        moveIntent.putExtra(Detail.EXTRA_NAME, kucing.getName());
        moveIntent.putExtra(Detail.EXTRA_REMARKS, kucing.getRemarks());
        moveIntent.putExtra(Detail.EXTRA_DETAIL, kucing.getDetail());
        startActivity(moveIntent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.actions_cardview:
                showRecycleCardView();
            break;
            case R.id.actions_grid:
                showRecyclerGrid();
            break;
            case R.id.actions_list:
                showRecyclerList();
            break;
        }
        return super.onOptionsItemSelected(item);
    }
}
