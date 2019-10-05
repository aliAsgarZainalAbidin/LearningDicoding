package com.example.mythreadhandlerasynctask;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String DEMO_ASYNC = "DemoAsync";
    private TextView tvStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvStatus = findViewById(R.id.tv_status);
        DemoAsync demoAsync = new DemoAsync();
        demoAsync.execute(" Halo Ini Demo AsyncTask");
    }

    private class DemoAsync extends AsyncTask<String, Integer, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            tvStatus.setText("Status : onPreExecute");
        }

        @Override
        protected String doInBackground(String... strings) {
            try {
                for (int a=1; a<=10; a++){
                    Thread.sleep(1000);
                    Log.d(DEMO_ASYNC, "doInBackground: " + a);
                    publishProgress(a);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return strings[0];
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            tvStatus.setText("Status : onPreExecute"+s);
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            String count = String.valueOf(values[0]);
            tvStatus.setText("Status : doInBackground " + count);
        }
    }
}
