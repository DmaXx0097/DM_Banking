package com.example.bankingapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SplashScreen extends AppCompatActivity {

    private static int SPLASH_TIMER = 5000;

    ImageView circle_back;
    TextView firstTitle;
    TextView secondTitle;
    TextView thirdTitle;
    TextView forthTitle;
    TextView fifthTitle;
    TextView credit;

    //Animation
    Animation sideAnim, bottomAnim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        //hooks
        circle_back = findViewById(R.id.Circle_sp);
        firstTitle = findViewById(R.id.firstTitle);
        secondTitle = findViewById(R.id.secondTitle);
        thirdTitle = findViewById(R.id.thirdTitle);
        forthTitle = findViewById(R.id.forthTitle);
        fifthTitle = findViewById(R.id.fifthTitle);
        credit = findViewById(R.id.credit);

        //animation
        sideAnim = AnimationUtils.loadAnimation(this, R.anim.side_anim);
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_anim);

        //set animation
        circle_back.setAnimation(sideAnim);
        firstTitle.setAnimation(bottomAnim);
        secondTitle.setAnimation(bottomAnim);
        thirdTitle.setAnimation(bottomAnim);
        forthTitle.setAnimation(bottomAnim);
        fifthTitle.setAnimation(sideAnim);
        credit.setAnimation(sideAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_TIMER);
    }
}
