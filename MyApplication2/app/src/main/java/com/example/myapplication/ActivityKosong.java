package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class ActivityKosong extends AppCompatActivity {
    public static final String KEY_NAMA = "KEY_NAMA";
    public static final String KEY_UMUR = "KEY_UMUR";
    public static final String KEY_BTN = "0";
    int noBtn = 0;
    private TextView tvNama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kosong);
        inisialisasiKomponen();
        noBtn = getIntent().getIntExtra(KEY_BTN, 0);

        if (noBtn == 1){
            String textNama = getIntent().getStringExtra(KEY_NAMA);
            String textUmur = getIntent().getStringExtra(KEY_UMUR);
            tvNama.setText("Hai " +textNama+ ", Umur anda "+ textUmur +", Pengiriman Single Data");
        } else if (noBtn == 2){
            Person mPerson = getIntent().getParcelableExtra(KEY_NAMA);

            tvNama.setText("Hai "+ mPerson.getNama() +", Umur anda "+ mPerson.getUmur()+", Pengiriman Parcelable");
        } else {
            tvNama.setText("Selamat Pagi Nub");
        }

    }

    protected void inisialisasiKomponen() {
        tvNama = findViewById(R.id.tv_nama_kosong);
    }

}