package com.example.myfriendsapp;

import android.content.Intent;
import android.content.res.TypedArray;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private String[] dataNama;
    private String[] dataTtl;
    private String[] dataHobi;
    private String[] dataDesc;
    private TypedArray dataPhoto;
    private ArrayList<ModelFriend> list;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rv_item);
        recyclerView.setHasFixedSize(true);

        prepare();
        addItem();
        showRecyclerList();
    }

    private void showRecyclerList(){
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        FriendAdapter friendAdapter = new FriendAdapter(this);
        friendAdapter.setListFriend(list);
        recyclerView.setAdapter(friendAdapter);
    }

    private void prepare(){
        dataNama = getResources().getStringArray(R.array.nama);
        dataTtl = getResources().getStringArray(R.array.ttl);
        dataHobi = getResources().getStringArray(R.array.hobi);
        dataDesc = getResources().getStringArray(R.array.deskripsi);
        dataPhoto = getResources().obtainTypedArray(R.array.photo);
    }

    private void addItem(){
        list = new ArrayList<>();
        for (int i=0; i<dataNama.length; i++){
        ModelFriend modelFriend = new ModelFriend();

        modelFriend.setNama(dataNama[i]);
        modelFriend.setTtl(dataTtl[i]);
        modelFriend.setHobi(dataHobi[i]);
        modelFriend.setDesc(dataDesc[i]);
        modelFriend.setPhoto(dataPhoto.getResourceId(i, -1));

        list.add(modelFriend);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.about){
            Intent mIntent = new Intent(this, AboutActivity.class);
            startActivity(mIntent);
        }
        return super.onOptionsItemSelected(item);
    }
}
