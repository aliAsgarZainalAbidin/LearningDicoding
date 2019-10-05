package com.example.mywidget;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnStart = findViewById(R.id.btn_start);
        Button btnStop = findViewById(R.id.btn_stop);

        btnStart.setOnClickListener(this);
        btnStop.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_start : {
                startJob();
                break;
            }

            case R.id.btn_stop : {
                cancelJob();
                break;
            }
        }
    }

    private static int jobId = 100;
    private static int SCHEDULE_OF_PRIOD = 3000;

    private void startJob(){
        ComponentName componentName = new ComponentName(this, UpdatingWidgetService.class);

        JobInfo.Builder builder = new JobInfo.Builder(jobId, componentName);
        builder.setRequiredNetworkType(JobInfo.NETWORK_TYPE_NONE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
            builder.setMinimumLatency(SCHEDULE_OF_PRIOD);
        } else {
            builder.setPeriodic(SCHEDULE_OF_PRIOD);
        }
        JobScheduler jobScheduler = (JobScheduler) getSystemService(Context.JOB_SCHEDULER_SERVICE);
        jobScheduler.schedule(builder.build());

        Toast.makeText(this, "Job Service started", Toast.LENGTH_SHORT).show();
    }

    private void cancelJob() {
        JobScheduler tm = (JobScheduler) getSystemService(Context.JOB_SCHEDULER_SERVICE);
        tm.cancel(jobId);
        Toast.makeText(this, "Job Service canceled", Toast.LENGTH_SHORT).show();
    }
}
