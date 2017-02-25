package com.example.bassam.khedmaapp.user.activitys;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NewUserRegistrationActivity extends Activity implements View.OnClickListener {

    EditText userNameEditTextNewUserRegistrationActivity,countryCodeEditTextNewUserRegistrationActivity,
            PhoneNumberEditTextNewUserRegistrationActivity,EmailEditTextNewUserRegistrationActivity;

    Button DoneButtonNewUserRegistrationActivity,loginButtonNewUserRegistrationActivity;

    String numberWithCode;

    CheckConnectionWithInternet withInternet;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user_registration_layout);

        hidenKeboard();
        setUpViews();
        setUpListener();
    }

    private void hidenKeboard() {

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }

    private void setUpListener() {


        DoneButtonNewUserRegistrationActivity.setOnClickListener(this);
        loginButtonNewUserRegistrationActivity.setOnClickListener(this);

    }

    private void setUpViews() {

        userNameEditTextNewUserRegistrationActivity=(EditText)findViewById(R.id.userNameEditTextNewUserRegistrationActivity);
        PhoneNumberEditTextNewUserRegistrationActivity=(EditText)findViewById(R.id.PhoneNumberEditTextNewUserRegistrationActivity);
        EmailEditTextNewUserRegistrationActivity=(EditText)findViewById(R.id.EmailEditTextNewUserRegistrationActivity);
        countryCodeEditTextNewUserRegistrationActivity=(EditText)findViewById(R.id.countryCodeEditTextNewUserRegistrationActivity);


        DoneButtonNewUserRegistrationActivity=(Button)findViewById(R.id.DoneButtonNewUserRegistrationActivity);
        loginButtonNewUserRegistrationActivity=(Button)findViewById(R.id.loginButtonNewUserRegistrationActivity);

        withInternet=new CheckConnectionWithInternet(getApplicationContext());

    }

    @Override
    public void onClick(View view) {
        Intent intent=null;
        switch (view.getId()){
            case R.id.DoneButtonNewUserRegistrationActivity:
                if(edittextIsEmpty()){
                    break;
                }else{
                    if(withInternet.isNetworkAvailable()){
                     numberWithCode= countryCodeEditTextNewUserRegistrationActivity.getText().toString()+
                            PhoneNumberEditTextNewUserRegistrationActivity.getText().toString();

                  //  Toast.makeText(this, numberWithCode, Toast.LENGTH_SHORT).show();

                    callApiVerification(getRandomCode());
                    break;
                    } else {
                    Toast.makeText(this, "الجهاز المستخدم غير متصل في الانترنت", Toast.LENGTH_SHORT).show();
                    break;
                }
                }

            case R.id.loginButtonNewUserRegistrationActivity:
                intent=new Intent(getApplicationContext(),UserLoginPageActivity.class);
                    startActivity(intent);
                break;


        }
    }



    public boolean edittextIsEmpty(){

        boolean cuntrycodebool=countryCodeEditTextNewUserRegistrationActivity.getText().toString().isEmpty();
        boolean usernamebool=userNameEditTextNewUserRegistrationActivity.getText().toString().isEmpty();
        boolean phonenumberbool=PhoneNumberEditTextNewUserRegistrationActivity.getText().toString().isEmpty();
        boolean emailbool=EmailEditTextNewUserRegistrationActivity.getText().toString().isEmpty();

        String emailAddress =EmailEditTextNewUserRegistrationActivity.getText().toString();
        String userName=userNameEditTextNewUserRegistrationActivity.getText().toString();
        String phoneNumber=PhoneNumberEditTextNewUserRegistrationActivity.getText().toString();
        String cuntryCode=countryCodeEditTextNewUserRegistrationActivity.getText().toString();

        String fullPhoneNumber=cuntryCode+phoneNumber;



        if(usernamebool){
            Toast.makeText(this, "ادخل الاسم (الكّنية)", Toast.LENGTH_SHORT).show();
            return true;
        }else if(userName.length()<3){

            Toast.makeText(this, "يجب ان يكون الاسم ٣ احرف او اكثر", Toast.LENGTH_SHORT).show();
            return true;

        }else if(phonenumberbool){
            Toast.makeText(this, "ادخل رقم الهاتف", Toast.LENGTH_SHORT).show();
            return true;
        }else if(emailbool){
            Toast.makeText(this, "ادخل البريد الاكتروني", Toast.LENGTH_SHORT).show();
            return true;
        }else if(!isEmailValid(emailAddress))
        {
            Toast.makeText(this, "البريد الالكتروني المدخل غير صحيح ", Toast.LENGTH_SHORT).show();
            EmailEditTextNewUserRegistrationActivity.setHint("مثال: user@khdmat.com");
            EmailEditTextNewUserRegistrationActivity.setHintTextColor(Color.RED);
            EmailEditTextNewUserRegistrationActivity.getText().clear();
            return true;
        }else if (cuntrycodebool){
            Toast.makeText(this, "ادخل الرمز الدولي", Toast.LENGTH_SHORT).show();
            return true;
        }else if (cuntryCode.length()>3 || cuntryCode.length()<1){
            Toast.makeText(this, "رمز الدولة غير صحيح", Toast.LENGTH_SHORT).show();
            return true;
        }else if (phoneNumber.length()!=9){
            Toast.makeText(this, "رقم الهاتف المدخل غير صحيح", Toast.LENGTH_SHORT).show();
            return true;
        }

        return false;
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


        JsonObjectRequest request_json = new JsonObjectRequest(Request.Method.POST,url, new JSONObject(params),
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
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

                Toast.makeText(getApplicationContext(),"برنامج خدمة لا يخدم المنطقة التي تقيم فيها", Toast.LENGTH_SHORT).show();

            }
        });

        Volley.newRequestQueue(getApplicationContext()).add(request_json);

    }


    public static boolean isEmailValid(String email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }



}
