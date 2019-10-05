package com.example.mygcmnetworkmanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnSetScheduler, btnCancelScheduler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSetScheduler = findViewById(R.id.btn_set_scheduler);
        btnCancelScheduler = findViewById(R.id.btn_cancel_scheduler);

        btnSetScheduler.setOnClickListener(this);
        btnCancelScheduler.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_set_scheduler : {
                break;
            }

            case R.id.btn_cancel_scheduler : {
                break;
            }
        }
    }
}
