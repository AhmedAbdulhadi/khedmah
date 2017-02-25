package com.example.bassam.khedmaapp.user.activitys;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bassam.khedmaapp.R;
import com.example.bassam.khedmaapp.constants.SharedPrefConstants;

import java.util.Random;

public class VerificationCodeActivity extends Activity implements View.OnClickListener{

    EditText firstNumberEditTextVerificationActivity,secondNumberEditTextVerificationActivity,
            thirdNumberEditTextVerificationActivity,FourthNumberEditTextVerificationActivity;
    Button loginButtonVerificationActivity,reSendButtonVerificationActivity;

    String mobileNumber="";
    String verificationCode="";

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification_code_layout);

        try {


        Bundle bundle=getIntent().getExtras();
        mobileNumber=bundle.getString("phonenuumber");
        verificationCode=bundle.getString("verificationcode");
        Toast.makeText(this, mobileNumber+"    "+verificationCode, Toast.LENGTH_SHORT).show();

        }catch (Exception ex){
            ex.printStackTrace();
        }

        hidenKeboard();
        setUpViews();
        setUpListener();
        setUpsharedpreferences();
        setUpEditTextListener();



    }

    private void hidenKeboard() {

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }

    private void setUpEditTextListener() {

        firstNumberEditTextVerificationActivity.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if(firstNumberEditTextVerificationActivity.getText().toString().length()==1){
                    hidenKeboard();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        secondNumberEditTextVerificationActivity.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if(secondNumberEditTextVerificationActivity.getText().toString().length()==1){
                    firstNumberEditTextVerificationActivity.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        thirdNumberEditTextVerificationActivity.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(thirdNumberEditTextVerificationActivity.getText().toString().length()==1){
                    secondNumberEditTextVerificationActivity.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        FourthNumberEditTextVerificationActivity.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if(FourthNumberEditTextVerificationActivity.getText().toString().length()==1){
                    thirdNumberEditTextVerificationActivity.requestFocus();
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    private void setUpsharedpreferences() {

        sharedPreferences= PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        editor= sharedPreferences.edit();
    }

    private void setUpListener() {
        loginButtonVerificationActivity.setOnClickListener(this);
        reSendButtonVerificationActivity.setOnClickListener(this);
    }

    private void setUpViews() {
        firstNumberEditTextVerificationActivity=(EditText) findViewById(R.id.firstNumberEditTextVerificationActivity);
        secondNumberEditTextVerificationActivity=(EditText)findViewById(R.id.secondNumberEditTextVerificationActivity);
        thirdNumberEditTextVerificationActivity=(EditText)findViewById(R.id.thirdNumberEditTextVerificationActivity);
        FourthNumberEditTextVerificationActivity=(EditText)findViewById(R.id.FourthNumberEditTextVerificationActivity);

        loginButtonVerificationActivity=(Button)findViewById(R.id.loginButtonVerificationActivity);
        reSendButtonVerificationActivity=(Button)findViewById(R.id.reSendButtonVerificationActivity);


    }

    private   boolean edittextIsEmpty(){

        if (!firstNumberEditTextVerificationActivity.getText().toString().isEmpty() && !secondNumberEditTextVerificationActivity.getText().toString().isEmpty()
                && !thirdNumberEditTextVerificationActivity.getText().toString().isEmpty() && !FourthNumberEditTextVerificationActivity.getText().toString().isEmpty()) {
            return false;

        }


        Toast.makeText(this, "ادخل الرقم الرباعي ", Toast.LENGTH_SHORT).show();
        return true;
    }

    @Override
    public void onClick(View view) {


        switch (view.getId()) {
         case R.id.loginButtonVerificationActivity:
             if(edittextIsEmpty()){

                 break;
             }else{
                 if (checkIfCodeIsCorrect())
                 {Toast.makeText(this, "9a7", Toast.LENGTH_SHORT).show();
                     Intent intent=new Intent(getApplicationContext(),UserHomePageActivity.class);

                     editor.putBoolean(SharedPrefConstants.getUserLogedIn(),true);
                     editor.putString(SharedPrefConstants.getUserPhoneNumber(),mobileNumber);
                     editor.apply();
                     startActivity(intent);
                     break;

                 } else {
                     clearEditText();
                     Toast.makeText(this, "3'la6", Toast.LENGTH_SHORT).show();
                 break;}
             }

            case R.id.reSendButtonVerificationActivity:
               Intent intent=new Intent(getApplicationContext(),UserLoginPageActivity.class);
                startActivity(intent);
                break;
            }
        }

    private void clearEditText() {
        FourthNumberEditTextVerificationActivity.getText().clear();
        thirdNumberEditTextVerificationActivity.getText().clear();
        secondNumberEditTextVerificationActivity.getText().clear();
        firstNumberEditTextVerificationActivity.getText().clear();
    }

    private boolean checkIfCodeIsCorrect() {
       // Toast.makeText(this, "in check", Toast.LENGTH_SHORT).show();
        String userInput="";

        userInput=FourthNumberEditTextVerificationActivity.getText().toString()+ thirdNumberEditTextVerificationActivity.getText().toString()+
                secondNumberEditTextVerificationActivity.getText().toString()+ firstNumberEditTextVerificationActivity.getText().toString();

        if(userInput.equals(verificationCode)){
           // Toast.makeText(this, userInput+"  ==========   "+verificationCode, Toast.LENGTH_SHORT).show();
            return true;}
       // Toast.makeText(this, userInput+"  ==========   "+verificationCode, Toast.LENGTH_SHORT).show();
        return false;
    }

    private String getRandomCode() {
        int randNum=1000+(new Random()).nextInt(8999);
        String code=String.valueOf(randNum);
        Toast.makeText(this, code, Toast.LENGTH_SHORT).show();

        return code;
    }

}

