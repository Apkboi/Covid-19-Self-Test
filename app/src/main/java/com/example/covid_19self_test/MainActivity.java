package com.example.covid_19self_test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;

import com.wang.avi.AVLoadingIndicatorView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ImageView sticker = findViewById(R.id.sticker);
        final TextView textView = findViewById(R.id.splash_text);
        final AVLoadingIndicatorView loader = findViewById(R.id.loader);
        final Animation fadeOutAnimation = new AlphaAnimation(1.0f,0.0f);
        final Animation fadeInAnimation = new AlphaAnimation(0.0f,1.0f);
        final Animation TextfadeInAnimation = new AlphaAnimation(0.0f,1.0f);
        final Animation TextfadeOutAnimation = new AlphaAnimation(1.0f,0.0f);
        fadeOutAnimation.setDuration(750);
        fadeOutAnimation.setFillAfter(true);
        TextfadeOutAnimation.setDuration(700);
        TextfadeOutAnimation.setFillAfter(true);
        fadeInAnimation.setDuration(700);
        fadeInAnimation.setFillAfter(true);
        TextfadeInAnimation.setDuration(5000);
        TextfadeInAnimation.setFillAfter(true);
        sticker.setAnimation(fadeInAnimation);
        textView.setAnimation(fadeInAnimation);
        loader.setAnimation(TextfadeInAnimation);
        fadeOutAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                startActivity(new Intent(MainActivity.this,WebviewActivity.class));
                loader.setVisibility(View.GONE);

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        CountDownTimer timer = new CountDownTimer(4000,30) {
            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {

                sticker.startAnimation(fadeOutAnimation);
                textView.startAnimation(fadeOutAnimation);
                loader.startAnimation(fadeOutAnimation);

            }
        }.start();

    }
}