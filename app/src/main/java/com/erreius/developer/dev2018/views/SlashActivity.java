package com.erreius.developer.dev2018.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;

import com.erreius.developer.dev2018.MainActivity;
import com.erreius.developer.dev2018.R;

public class SlashActivity extends AppCompatActivity {

    private static final long SPLASH_SCREEN_DELAY = 5000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        // Hide title bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_slash);

        new Handler().postDelayed(new Runnable() {
            public void run() {

                Intent mainIntent = new Intent(SlashActivity.this,
                        LoginView.class);
                startActivity(mainIntent);
                SlashActivity.this.finish();
                overridePendingTransition(R.anim.fadein,R.anim.fadeout);
            }
        }, SPLASH_SCREEN_DELAY);
    }
}