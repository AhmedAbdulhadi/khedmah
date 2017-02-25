package com.example.bassam.khedmaapp.user.activitys;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bassam.khedmaapp.R;

public class UserOrderActivity extends Activity implements View.OnClickListener {

    Button appointmentButtonUserOrderActivity,orderNowButtonUserOrderActivity;

    EditText costEditTextNewUserRegistrationActivity,descriptionEditTextNewUserRegistrationActivity;

    ImageView problemImageUserOrderActivity;
    ImageButton backImageButtonBackToolbar;

    Toolbar toolbar;

    TextView backToolbarTitle;

    final static int getImageId=1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_order_layout);

        hidenKeboard();
        setUpViews();
        setUpListener();

        backToolbarTitle=(TextView)findViewById(R.id.backToolbarTitle);
        backToolbarTitle.setText("صفحة الطلبات");

    }

    private void hidenKeboard() {

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }


    private void setUpListener() {
        orderNowButtonUserOrderActivity.setOnClickListener(this);
        appointmentButtonUserOrderActivity.setOnClickListener(this);
        problemImageUserOrderActivity.setOnClickListener(this);
    }

    private void setUpViews() {

        appointmentButtonUserOrderActivity=(Button)findViewById(R.id.appointmentButtonUserOrderActivity);
        orderNowButtonUserOrderActivity=(Button)findViewById(R.id.orderNowButtonUserOrderActivity);

        costEditTextNewUserRegistrationActivity=(EditText)findViewById(R.id.costEditTextNewUserRegistrationActivity);
        descriptionEditTextNewUserRegistrationActivity=(EditText)findViewById(R.id.descriptionEditTextNewUserRegistrationActivity);

        problemImageUserOrderActivity=(ImageView)findViewById(R.id.problemImageUserOrderActivity);

        backImageButtonBackToolbar=(ImageButton) findViewById(R.id.backImageButtonBackToolbar);

        toolbar=(Toolbar)findViewById(R.id.back_toolbar);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if (requestCode==getImageId)
            if(resultCode==RESULT_OK){
                Uri selectedImage=data.getData();

                problemImageUserOrderActivity.setImageURI(selectedImage);

                // Toast.makeText(this, selectedImage.toString(), Toast.LENGTH_SHORT).show();
            }


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.appointmentButtonUserOrderActivity:
                Toast.makeText(getApplicationContext(), "appointmentButtonUserOrderActivity", Toast.LENGTH_SHORT).show();
                break;
            case R.id.orderNowButtonUserOrderActivity:
                Toast.makeText(getApplicationContext(), "orderNowButtonUserOrderActivity", Toast.LENGTH_SHORT).show();
                break;
            case R.id.problemImageUserOrderActivity:
                Intent galleryIntent=new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(galleryIntent,getImageId);
                break;
            case R.id.backImageButtonBackToolbar:
                Intent intent=new Intent(getApplicationContext(),SupServicesPageActivity.class);
                startActivity(intent);
                break;
        }
    }
}
