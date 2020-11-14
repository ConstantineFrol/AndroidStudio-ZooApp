package com.gproject.zooapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static int SPLASH_SCREEN = 5000;

    //Variables
    Animation bottom_anim;
    ImageView image;
    TextView logo, slogan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        //Animation
        bottom_anim = AnimationUtils.loadAnimation(this,R.anim.bottom_animation);

        //Initialize
        image = findViewById(R.id.home_scr_img);
        logo = findViewById(R.id.appName);
        slogan = findViewById(R.id.app_banner);

        //Add animation
        slogan.setAnimation(bottom_anim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent go_home_screen = new Intent(MainActivity.this, Dashboard.class);
                startActivity(go_home_screen);
                finish();
            }
        }, SPLASH_SCREEN);

    }
}