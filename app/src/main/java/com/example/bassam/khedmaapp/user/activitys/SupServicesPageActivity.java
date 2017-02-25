package com.example.bassam.khedmaapp.user.activitys;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.bassam.khedmaapp.R;
import com.example.bassam.khedmaapp.user.fragments.GridViewFragment;

public class SupServicesPageActivity extends Activity {

    TextView backToolbarTitle;

    ImageButton backImageButtonBackToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sup_services_page_layout);

        String []gridText=new String[]{"&#xf1b9;","&#xf29e;","&#xf080;","&#xf206;","&#xf1e2;","&#xf207;"};
        GridViewFragment gridViewFragment=new GridViewFragment(gridText );

        getFragmentManager().beginTransaction().add(R.id.sup_services_container_body_activity,gridViewFragment).commit();

        backToolbarTitle=(TextView)findViewById(R.id.backToolbarTitle);
        backToolbarTitle.setText("قائمة  الخدمات");

        backImageButtonBackToolbar=(ImageButton)findViewById(R.id.backImageButtonBackToolbar);
        backImageButtonBackToolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),UserHomePageActivity.class);
                startActivity(intent);
            }
        });


    }
}
