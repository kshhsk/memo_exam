package com.example.ksh.applepiapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends FragmentActivity implements View.OnTouchListener {

    TabLayout tabLayout;
    ViewPager viewPager;
    ImageView imageView;
    TextView sum_gisik;
    RbPreference pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startActivity(new Intent(this, Splash.class));
        viewPager = (ViewPager) findViewById(R.id.view_pager);

        viewPager.setAdapter(new MyAdapter(getSupportFragmentManager()));

        viewPager.setOffscreenPageLimit(4);
        tabLayout = (TabLayout) findViewById(R.id.Tab_Layout);
        tabLayout.setupWithViewPager(viewPager);
        sum_gisik = (TextView) findViewById(R.id.sum_gisik);

        imageView = (ImageView) findViewById(R.id.touch_image);
        imageView.setOnTouchListener(this);
        pref = new RbPreference(this);

        Player.totalJisik = pref.getValue("gisik", 0);
        sum_gisik.setText("" + Player.totalJisik);

        int tabIconArray[] = {
                R.drawable.books,
                R.drawable.student_hat,
                R.drawable.bag,
                R.drawable.money

        };
        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            tabLayout.getTabAt(i).setIcon(tabIconArray[i]);
        }
    }


    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (v.getId()) {
            case R.id.touch_image:
                Player.totalJisik += Player.increaseJisik;
                pref.put("gisik", Player.totalJisik);
                sum_gisik.setText("" + Player.totalJisik);

                break;

        }
        return false;
    }
}

