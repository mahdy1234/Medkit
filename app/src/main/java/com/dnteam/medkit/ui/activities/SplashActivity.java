package com.dnteam.medkit.ui.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.dnteam.medkit.R;
import com.dnteam.medkit.util.SharedPreferencesUtil;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(() -> {

            String lang = SharedPreferencesUtil.getLang(SplashActivity.this);

            Intent i = (lang == null) ? new Intent(SplashActivity.this, LocaleActivity.class) :
                    new Intent(SplashActivity.this, HomeActivity.class);
            startActivity(i);
            finish();
        }, 1000);
    }
}