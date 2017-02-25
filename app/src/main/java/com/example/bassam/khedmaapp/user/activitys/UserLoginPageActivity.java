package com.example.bassam.khedmaapp.user.activitys;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.bassam.khedmaapp.R;
import com.example.bassam.khedmaapp.checked.CheckConnectionWithInternet;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Random;



public class UserLoginPageActivity extends Activity implements View.OnClickListener {

    EditText enterPhoneNumberEditTextUserLoginActivity,countryCodeEditTextUserLoginActivity;
    Button loginButtonUserLoginActivity,newUserButtonUserLoginActivity;

    String numberWithCode="";


    CheckConnectionWithInternet withInternet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login_page_layout);

        hidenKeboard();
        setUpView();
        setUpListener();

    }

    private void hidenKeboard() {

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }

    private void setUpListener() {
        loginButtonUserLoginActivity.setOnClickListener(this);
        newUserButtonUserLoginActivity.setOnClickListener(this);

    }

    private void setUpView() {

        countryCodeEditTextUserLoginActivity=(EditText)findViewById(R.id.countryCodeEditTextUserLoginActivity);
        enterPhoneNumberEditTextUserLoginActivity=(EditText)findViewById(R.id.enterPhoneNumberEditTextUserLoginActivity);

        newUserButtonUserLoginActivity=(Button) findViewById(R.id.newUserButtonUserLoginActivity);
        loginButtonUserLoginActivity=(Button) findViewById(R.id.loginButtonUserLoginActivity);

        withInternet=new CheckConnectionWithInternet(getApplicationContext());

    }

    private boolean edittextIsEmpty(){
         return enterPhoneNumberEditTextUserLoginActivity.getText().toString().isEmpty();
    }

    private boolean numberLengthIsValied(){

        if (enterPhoneNumberEditTextUserLoginActivity.getText().toString().length()==9)
             if(countryCodeEditTextUserLoginActivity.getText().toString().length()<=3 &&countryCodeEditTextUserLoginActivity.getText().toString().length()>=1)
                 return true;
        Toast.makeText(this, "الرقم المكتوب غير صحيح", Toast.LENGTH_SHORT).show();
        return false;
    }

    @Override
    public void onClick(View view) {

            Intent intent=null;
            switch (view.getId()){
                case R.id.loginButtonUserLoginActivity:
                    if(edittextIsEmpty()){
                        Toast.makeText(this, "اكتب رقم الهاتف ", Toast.LENGTH_SHORT).show();
                        break;

                    }else if(countryCodeEditTextUserLoginActivity.getText().toString().isEmpty()){
                        Toast.makeText(this, "اكتب رمز الدولة ", Toast.LENGTH_SHORT).show();
                        break;

                    }else if(!numberLengthIsValied()){
                        break;

                    }else {
                        if(withInternet.isNetworkAvailable()){

                             numberWithCode=countryCodeEditTextUserLoginActivity.getText().toString()+
                                    enterPhoneNumberEditTextUserLoginActivity.getText().toString();

                            String code=getRandomCode();

                            Intent intent1=new Intent(getApplicationContext(),VerificationCodeActivity.class);
                            intent1.putExtra("phonenuumber",numberWithCode);
                            intent1.putExtra("verificationcode",code);
                            startActivity(intent1);

//                            try {
//
//                                callApiVerification(code);
//
//
//                            }catch (Exception ex){
//                                ex.printStackTrace();
//                            }
                        break;

                        }else {
                            Toast.makeText(this, "الجهاز المستخدم غير متصل في الانترنت", Toast.LENGTH_SHORT).show();
                            break;
                        }
                    }

                case R.id.newUserButtonUserLoginActivity:
                    intent=new Intent(getApplicationContext(),NewUserRegistrationActivity.class);
                    startActivity(intent);

                    break;
            }

        }

    private String getRandomCode() {
        int randNum=1000+(new Random()).nextInt(8999);
        String code=String.valueOf(randNum);
        Toast.makeText(this, code, Toast.LENGTH_SHORT).show();

        return code;
    }



    private void callApiVerification(final String code) {
        String url = "http://api.unifonic.com/rest/Messages/Send";

        HashMap<String, String> params = new HashMap<String, String>();
        params.put("AppSid","BOpaYJPzPTXVKxktDK1gfmts4UPLHL");
        params.put("Recipient",numberWithCode);
        params.put("Body","Your Verification code: "+code);

        //StringRequest stringRequest=new StringRequest()

        JsonObjectRequest request_json = new JsonObjectRequest(Request.Method.POST,url, new JSONObject(params),
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            Toast.makeText(UserLoginPageActivity.this, response.toString(), Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent(getApplicationContext(),VerificationCodeActivity.class);
                            intent.putExtra("phonenuumber",numberWithCode);
                            intent.putExtra("verificationcode",code);
                            startActivity(intent);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(UserLoginPageActivity.this,"هنالك مشكلة تقنية سوف تحل قريباً", Toast.LENGTH_SHORT).show();
            }
        });

        Volley.newRequestQueue(getApplicationContext()).add(request_json);

    }



}

