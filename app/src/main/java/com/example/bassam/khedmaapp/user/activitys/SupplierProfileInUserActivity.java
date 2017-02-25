package com.example.bassam.khedmaapp.user.activitys;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bassam.khedmaapp.R;

public class SupplierProfileInUserActivity extends Activity implements View.OnClickListener {

    Toolbar toolbar;

    ImageButton backImageButtonBackToolbar;

    ImageView supplierPhotoImageViewInSupplierProfileInUserActivity;

    TextView supplierNameTextViewInSupplierProfileInUserActivity,supplierAddressTextViewInSupplierProfileInUserActivity;

    RatingBar supplierRateRateViewInSupplierProfileInUserActivity;

    TextView firstServicesSupplierIsSupportInSupplierProfileInUserActivity,fourthServicesSupplierIsSupportInSupplierProfileInUserActivity
            ,secondServicesSupplierIsSupportInSupplierProfileInUserActivity,thirdServicesSupplierIsSupportInSupplierProfileInUserActivity
            ,sixthServicesSupplierIsSupportInSupplierProfileInUserActivity,fifthServicesSupplierIsSupportInSupplierProfileInUserActivity;


    Button AcceptServiceButtonSupplierProfileInUserActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supplier_profile_layout);



        setUpViews();

        setUpCraftsTextViews();

        setUpListener();


    }




    private void setUpViews() {

        toolbar=(Toolbar)findViewById(R.id.back_toolbar);

        backImageButtonBackToolbar=(ImageButton)findViewById(R.id.backImageButtonBackToolbar);


        supplierPhotoImageViewInSupplierProfileInUserActivity=(ImageView)findViewById(R.id.supplierPhotoImageViewInSupplierProfileInUserActivity);

        supplierNameTextViewInSupplierProfileInUserActivity=(TextView)findViewById(R.id.supplierNameTextViewInSupplierProfileInUserActivity);
        supplierAddressTextViewInSupplierProfileInUserActivity=(TextView)findViewById(R.id.supplierAddressTextViewInSupplierProfileInUserActivity);

        supplierRateRateViewInSupplierProfileInUserActivity=(RatingBar)findViewById(R.id.supplierRateRateViewInSupplierProfileInUserActivity);

        AcceptServiceButtonSupplierProfileInUserActivity=(Button)findViewById(R.id.AcceptServiceButtonSupplierProfileInUserActivity);
    }

    private void setUpCraftsTextViews() {
        firstServicesSupplierIsSupportInSupplierProfileInUserActivity=(TextView)findViewById(R.id.firstServicesSupplierIsSupportInSupplierProfileInUserActivity);
        secondServicesSupplierIsSupportInSupplierProfileInUserActivity=(TextView)findViewById(R.id.secondServicesSupplierIsSupportInSupplierProfileInUserActivity);
        thirdServicesSupplierIsSupportInSupplierProfileInUserActivity=(TextView)findViewById(R.id.thirdServicesSupplierIsSupportInSupplierProfileInUserActivity);
        fourthServicesSupplierIsSupportInSupplierProfileInUserActivity=(TextView)findViewById(R.id.fourthServicesSupplierIsSupportInSupplierProfileInUserActivity);
        fifthServicesSupplierIsSupportInSupplierProfileInUserActivity=(TextView)findViewById(R.id.fifthServicesSupplierIsSupportInSupplierProfileInUserActivity);
        sixthServicesSupplierIsSupportInSupplierProfileInUserActivity=(TextView)findViewById(R.id.sixthServicesSupplierIsSupportInSupplierProfileInUserActivity);

    }

    private void setUpListener() {

        AcceptServiceButtonSupplierProfileInUserActivity.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.AcceptServiceButtonSupplierProfileInUserActivity:
                Toast.makeText(this, "AcceptServiceButtonSupplierProfileInUserActivity", Toast.LENGTH_SHORT).show();
                break;
            case R.id.backImageButtonBackToolbar:
                Toast.makeText(this, "backImageButtonBackToolbar", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
