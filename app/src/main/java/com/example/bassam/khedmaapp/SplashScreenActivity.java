package com.example.bassam.khedmaapp;


import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.bassam.khedmaapp.constants.SharedPrefConstants;
import com.example.bassam.khedmaapp.user.activitys.UserHomePageActivity;


public class SplashScreenActivity extends Activity {

    Intent intent;
    Handler handler;
    int delay=2000;

    ImageView khedmaImageViewInSplash,txtkhedmaImageViewInSplash;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen_layout);






        setUpViews();
        setUpAnimation();
        runDelay();

    }

    private void setUpAnimation() {

        Animation animation= AnimationUtils.loadAnimation(getApplicationContext(),R.animator.translateend);
        khedmaImageViewInSplash.setAnimation(animation);

        Animation animation1= AnimationUtils.loadAnimation(getApplicationContext(),R.animator.translatestart);
        txtkhedmaImageViewInSplash.setAnimation(animation1);
    }


    protected void setUpViews() {

        khedmaImageViewInSplash=(ImageView)findViewById(R.id.khedmaImageViewInSplash);
        txtkhedmaImageViewInSplash=(ImageView)findViewById(R.id.txtkhedmaImageViewInSplash);

        sharedPreferences= PreferenceManager.getDefaultSharedPreferences(getApplicationContext());


        if(sharedPreferences.getBoolean(SharedPrefConstants.getUserLogedIn(),false))
        {
            intent=new Intent(this,UserHomePageActivity.class);

        }else{

            intent=new Intent(this,WelcomePageActivity.class);
        }


        handler= new Handler();
    }
    protected void runDelay() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(intent);
                finish();

            }
        },delay);
    }
}
