package com.example.myapplication;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.AlarmClock;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static com.example.myapplication.MoveForActivityResult.RESULT_CODE;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText etNama;
    private EditText etUmur;
    private EditText etTelphone;
    private TextView tvHasil;
    private EditText etLokasi;
    private EditText etUrl;

    public static int REQUEST_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnPindah;
        Button btnPindahData;
        Button btnPindahObject;
        Button btnDial;
        Button btnResult;
        Button btnLokasi;
        Button btnUrl;

        etNama = findViewById(R.id.et_nama);
        etUmur = findViewById(R.id.et_umur);
        etTelphone = findViewById(R.id.et_telphone);
        etLokasi = findViewById(R.id.et_lokasi);
        etUrl = findViewById(R.id.et_url);
        btnPindah = findViewById(R.id.btn_move_activity);
        btnPindahData = findViewById(R.id.btn_move_with_data);
        btnPindahObject = findViewById(R.id.btn_move_activity_object);
        btnDial = findViewById(R.id.btn_dial_number);
        btnResult = findViewById(R.id.btn_result_data);
        tvHasil = findViewById(R.id.tv_hasil);
        btnLokasi = findViewById(R.id.btn_lokasi);
        btnUrl = findViewById(R.id.btn_url);

        btnPindah.setOnClickListener(this);
        btnPindahData.setOnClickListener(this);
        btnPindahObject.setOnClickListener(this);
        btnDial.setOnClickListener(this);
        btnResult.setOnClickListener(this);
        btnLokasi.setOnClickListener(this);
        btnUrl.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btn_move_activity: {
                Intent pindahActivity = new Intent(this, ActivityKosong.class);
                pindahActivity.putExtra(ActivityKosong.KEY_BTN, 0);
                startActivity(pindahActivity);
                break;
            }

            case R.id.btn_move_with_data: {
                Intent pindahActivityData = new Intent(this, ActivityKosong.class);
                String nama = etNama.getText().toString().trim();
                String umur = etUmur.getText().toString().trim();

                pindahActivityData.putExtra(ActivityKosong.KEY_NAMA, nama);
                pindahActivityData.putExtra(ActivityKosong.KEY_UMUR, umur);
                pindahActivityData.putExtra(ActivityKosong.KEY_BTN, 1);
                if (!TextUtils.isEmpty(nama) && !TextUtils.isEmpty(umur)) {
                    startActivity(pindahActivityData);
                } else {
                    etNama.setError("Silahkan isi Terlebih dahulu");
                    etUmur.setError("Silahkan isi Terlebih dahulu");
                }
                break;
            }

            case R.id.btn_move_activity_object: {
                Intent pindahActivityObject = new Intent(this, ActivityKosong.class);
                String nama = etNama.getText().toString().trim();
                String umur = etUmur.getText().toString().trim();

                Person mPerson = new Person();
                mPerson.setNama(nama);
                mPerson.setUmur(umur);

                pindahActivityObject.putExtra(ActivityKosong.KEY_NAMA, mPerson);
                pindahActivityObject.putExtra(ActivityKosong.KEY_BTN, 2);
                if (!TextUtils.isEmpty(nama) && !TextUtils.isEmpty(umur)) {
                    startActivity(pindahActivityObject);
                } else {
                    etNama.setError("Silahkan isi Terlebih dahulu");
                    etUmur.setError("Silahkan isi Terlebih dahulu");
                }
                break;
            }

            case R.id.btn_dial_number: {
                String number = etTelphone.getText().toString().trim();
                Intent callMe = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + number));

                if (!TextUtils.isEmpty(etTelphone.getText().toString())) {
                    startActivity(callMe);
                } else {
                    etTelphone.setError("Silahkan isi Terlebih dahulu");
                }
                break;
            }

            case R.id.btn_result_data: {
                Intent moveForResult = new Intent(this, MoveForActivityResult.class);
                startActivityForResult(moveForResult, REQUEST_CODE);
                break;
            }

            case R.id.btn_lokasi: {
                String address = etLokasi.getText().toString().trim();
                String address2 = etUrl.getText().toString().trim();
                Uri addressUri = Uri.parse("geo:" + address + "," + address2);
                Intent lokasi = new Intent(Intent.ACTION_VIEW, addressUri);
                startActivity(lokasi);
                break;
            }

            case R.id.btn_url: {
                String url = etUrl.getText().toString().trim();
                Uri alamatUrl = Uri.parse("http:" + url);
                Intent URL = new Intent(Intent.ACTION_VIEW, alamatUrl);
                startActivity(URL);
                break;
            }
            

        }
    }


    

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            if (resultCode == RESULT_CODE) {
                int intResultData = data.getIntExtra(MoveForActivityResult.EXTRA_SELECTED_DATA, 0);
                tvHasil.setText("Hasil : " + intResultData);
            }
        }
    }
}
