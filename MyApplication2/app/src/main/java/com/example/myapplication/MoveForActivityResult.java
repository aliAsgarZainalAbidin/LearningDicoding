package com.example.myapplication;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

public class MoveForActivityResult extends AppCompatActivity implements View.OnClickListener {
    private Button btnPilih;
    private RadioGroup rgNilai;
    public static String EXTRA_SELECTED_DATA = "Select_data";
    public static int RESULT_CODE = 110;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_for_result);

        btnPilih = findViewById(R.id.btn_pilih);
        rgNilai = findViewById(R.id.rg_nilai);
        btnPilih.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_pilih: {
                if (rgNilai.getCheckedRadioButtonId() != 0) {
                    int value = 0;
                    switch (rgNilai.getCheckedRadioButtonId()) {
                        case R.id.rb_50: {
                            value = 50;
                            break;
                        }
                        case R.id.rb_100: {
                            value = 100;
                            break;
                        }
                        case R.id.rb_150: {
                            value = 150;
                            break;
                        }
                        case R.id.rb_200: {
                            value = 200;
                            break;
                        }
                    }
                    Intent moveResult = new Intent(this, MainActivity.class);
                    moveResult.putExtra(EXTRA_SELECTED_DATA, value);
                    setResult(RESULT_CODE, moveResult);
                    finish();
                }
                break;
            }
        }
    }
}