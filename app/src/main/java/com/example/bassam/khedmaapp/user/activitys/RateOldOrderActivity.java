package com.example.bassam.khedmaapp.user.activitys;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bassam.khedmaapp.R;

public class RateOldOrderActivity extends Activity implements View.OnClickListener {

    TextView orderIdRateOldOrderActivity,orderSupplierNameRateOldOrderActivity;

    EditText orderRateTextRateOldOrderActivity;

    RatingBar OrderRateInRateOldOrderActivity;

    Button doneButtonRateOldOrderActivity;

    ImageButton backImageButtonBackToolbar;

    float userRateBar= (float) 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate_old_order);

        setUpViews();

        try {

            Bundle bundle = getIntent().getExtras();
            String id = bundle.getString("orderid");
            String suppliername = bundle.getString("suppliername");

            setTextViewData(id,suppliername);
        }catch (Exception ex){
            ex.printStackTrace();
        }




        hidenKeboard();
        setUpRatingBarListener();
        setUpButtonListener();

//        String rating=OrderRateInRateOldOrderActivity.getOnRatingBarChangeListener().toString();
//
//        Toast.makeText(this, rating, Toast.LENGTH_SHORT).show();


    }

    private void hidenKeboard() {

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }

    private void setUpRatingBarListener() {

        OrderRateInRateOldOrderActivity.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                userRateBar=v;
                Toast.makeText(RateOldOrderActivity.this, String.valueOf(v), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void setTextViewData(String id, String suppliername) {

        orderIdRateOldOrderActivity.setText(id);

        orderSupplierNameRateOldOrderActivity.setText(suppliername);

    }

    private void setUpButtonListener() {

        doneButtonRateOldOrderActivity.setOnClickListener(this);

        backImageButtonBackToolbar.setOnClickListener(this);

    }

    private void setUpViews() {

        orderIdRateOldOrderActivity=(TextView)findViewById(R.id.orderIdRateOldOrderActivity);

        orderSupplierNameRateOldOrderActivity=(TextView)findViewById(R.id.orderSupplierNameRateOldOrderActivity);

        orderRateTextRateOldOrderActivity=(EditText)findViewById(R.id.orderRateTextRateOldOrderActivity);

        OrderRateInRateOldOrderActivity=(RatingBar)findViewById(R.id.OrderRateInRateOldOrderActivity);

        doneButtonRateOldOrderActivity=(Button)findViewById(R.id.doneButtonRateOldOrderActivity);

        backImageButtonBackToolbar=(ImageButton)findViewById(R.id.backImageButtonBackToolbar);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.doneButtonRateOldOrderActivity:
                if(isEditTextEmpty()){
                    Toast.makeText(this, "ادخل الشرح عن التقييم", Toast.LENGTH_SHORT).show();
                }else if(ratingBarIsEmpty())
                {
                    Toast.makeText(this, " قم باختيار التقييم المناسب ", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(this, "doneButtonRateOldOrderActivity", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.backImageButtonBackToolbar:
                super.onBackPressed();
                break;
        }

    }

    private boolean ratingBarIsEmpty() {
        if(userRateBar==0.0)
        {return  true;}
        return false;
    }

    private boolean isEditTextEmpty() {


        return orderRateTextRateOldOrderActivity.getText().toString().isEmpty();
    }


}
