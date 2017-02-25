package com.example.bassam.khedmaapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import com.example.bassam.khedmaapp.user.activitys.UserHomePageActivity;
import com.example.bassam.khedmaapp.user.activitys.UserLoginPageActivity;

public class WelcomePageActivity extends Activity implements View.OnClickListener{

    Button userButtonWelcomePage,supplaierButtonWelcomePage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_page_layout);

        setUpViews();
        setUpListener();

    }

    private void setUpListener() {

        userButtonWelcomePage.setOnClickListener(this);
        supplaierButtonWelcomePage.setOnClickListener(this);


    }

    private void setUpViews() {

        supplaierButtonWelcomePage=(Button)findViewById(R.id.supplaierButtonWelcomePage);
        userButtonWelcomePage=(Button)findViewById(R.id.userButtonWelcomePage);

    }

    @Override
    public void onClick(View view) {

        Intent intent=null;

        switch (view.getId()){
            case R.id.supplaierButtonWelcomePage :
                intent=new Intent(getApplicationContext(), UserHomePageActivity.class);
                break;
            case R.id.userButtonWelcomePage :
                intent=new Intent(getApplicationContext(),UserLoginPageActivity.class);
                break;
        }

        startActivity(intent);
    }
}
