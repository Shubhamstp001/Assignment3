package com.shubham.myexpenses;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

public class SplashActivity extends AppCompatActivity {

    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        progressBar = (ProgressBar)findViewById(R.id.pb);

        new Thread(new Runnable() {
            @Override
            public void run() {

                startProgress();
                startApp();
                finish();

            }
        }).start();
    }

    private void startProgress(){
        for (int progress=0; progress<100; progress+=2){
            try {
                Thread.sleep(100);
                progressBar.setProgress(progress);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    private void startApp(){
        Intent intent = new Intent(SplashActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
