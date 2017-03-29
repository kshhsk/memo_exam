package com.example.ksh.applepiapp;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;

/**
 * Created by ksh on 2016-08-30.
 */
public class Splash extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        Handler hd = new Handler();
        hd.postDelayed(new Runnable() {
            @Override
            public void run() {
                finish();
            }
        }, 3000);
    }

}
