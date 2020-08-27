package com.example.serialkiller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.renderscript.Script;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvKillers;
    private ArrayList<Killers> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvKillers = findViewById(R.id.rv_killers);
        rvKillers.setHasFixedSize(true);

        list.addAll(KillersData.getListData());
        showDaftar();
    }

    private void showDaftar(){
        rvKillers.setLayoutManager(new LinearLayoutManager(this));
        KillerAdapter dftrAdapter =  new KillerAdapter(list);
        rvKillers.setAdapter(dftrAdapter);

        dftrAdapter.setOnItemClickCallback(new KillerAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Killers data) {
                showSelectedHero(data);
                Intent keDetail = new Intent(MainActivity.this, DetailPembunuh.class);
                keDetail.putExtra(DetailPembunuh.EXTRA_NAME, data.getName());
                keDetail.putExtra(DetailPembunuh.EXTRA_FOTO, data.getPhoto());
                keDetail.putExtra(DetailPembunuh.EXTRA_DETAIL, data.getDetail());
                keDetail.putExtra(DetailPembunuh.EXTRA_BIO, data.getBio());
                startActivity(keDetail);
            }
        });
    }

    @Override
    public  boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        setMode(item.getItemId());
        return  super.onOptionsItemSelected(item);
    }

    public void setMode(int selesctedMode){
        switch (selesctedMode){
            case R.id.action_tentang:
                Intent pindah = new Intent(MainActivity.this, ProfilPembuat.class);
                startActivity(pindah);
                break;
        }
    }

    private void showSelectedHero(Killers kill){
        Toast.makeText(this, "Kamu memilih "+kill.getName(), Toast.LENGTH_SHORT).show();
    }
}