package com.example.myfriendsapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_DATA = "extra_data";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView tvNama;
        TextView tvHobi;
        TextView tvTtl;
        TextView tvDesc;
        ImageView imgPhoto;

        tvNama = findViewById(R.id.tv_nama_detail);
        tvTtl = findViewById(R.id.tv_ttl_detail);
        tvHobi = findViewById(R.id.tv_hobi_detail);
        tvDesc = findViewById(R.id.tv_desc_detail);
        imgPhoto = findViewById(R.id.circleImageView);

        ModelFriend modelFriend = getIntent().getParcelableExtra(EXTRA_DATA);

        tvNama.setText(modelFriend.getNama());
        tvTtl.setText(modelFriend.getTtl());
        tvHobi.setText(modelFriend.getHobi());
        tvDesc.setText(modelFriend.getDesc());
        imgPhoto.setImageResource(modelFriend.getPhoto());
    }
}
