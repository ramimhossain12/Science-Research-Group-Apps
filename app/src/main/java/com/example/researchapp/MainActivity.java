package com.example.researchapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

import com.example.researchapp.User.LoginAdminActivity;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    int progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);


        progressBar = findViewById(R.id.progreesbarID);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                doWork();
                startApp();
            }
        });
        thread.start();
    }

    private void startApp() {


        Intent intent= new Intent(MainActivity.this, ResearchUserActivity.class);
        startActivity(intent);
        finish();
    }


    private void doWork() {


        for (progress=20;progress<=100;progress=progress+20){
            try {
                Thread.sleep(1500); //1500
                progressBar.setProgress(progress);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }




    }
}