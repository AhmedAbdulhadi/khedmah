package com.example.bassam.khedmaapp.user.activitys;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bassam.khedmaapp.R;
import com.example.bassam.khedmaapp.constants.SharedPrefConstants;

import com.example.bassam.khedmaapp.interfaces.FragmentDrawerListener;
import com.example.bassam.khedmaapp.user.fragments.FragmentDrawer;
import com.example.bassam.khedmaapp.user.fragments.GridViewFragment;
import com.example.bassam.khedmaapp.user.fragments.OldOrderFragment;
import com.example.bassam.khedmaapp.user.fragments.UserProfileFragment;

public class UserHomePageActivity extends AppCompatActivity  implements FragmentDrawerListener,View.OnClickListener {

    Toolbar toolbar;
    FragmentDrawer drawerFragment;

    TextView textView;

    GridViewFragment gridViewFragment;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

     DrawerLayout mDrawerLayout;

    int backButtonCount=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_home_page_layout);


        toolbar=(Toolbar)findViewById(R.id.toolbar);


         textView=(TextView)findViewById(R.id.toolbarId);

        mDrawerLayout=(DrawerLayout) findViewById(R.id.drawer_layout);






        manageDrawerFragment();

        setUpMainFragment();

        setUpSharedPref();






    }

    private void setUpSharedPref() {

        sharedPreferences= PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        editor=sharedPreferences.edit();
    }

    private void setUpMainFragment() {
        String [] gridText=new String[]{"&#xf26e;","&#xf2bc;","&#xf0f9;","&#xf2b9;","&#xf042;","&#xf2a1;"};
         gridViewFragment=new GridViewFragment(gridText);
        getFragmentManager().beginTransaction().add(R.id.container_body,gridViewFragment,"GridFragment").commit();
        textView.setText("قائمة الاقسام");
    }

    private void manageDrawerFragment() {
        Fragment fragmentManager=getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        drawerFragment = (FragmentDrawer)fragmentManager;

        drawerFragment.setUp(R.id.fragment_navigation_drawer, mDrawerLayout, toolbar);

        drawerFragment.setDrawerListener(this);



        ImageButton imageView=(ImageButton) findViewById(R.id.drowerImageIcon);

        imageView.setOnClickListener(this);


    }

    @Override
    public void onDrawerItemSelected(View view, int position) {

        FragmentManager fragmentManager=getSupportFragmentManager();
        Fragment fragment=null;

        switch (position){
            case 0:

                setUpMainFragment();

                break;
            case 1:

                fragment=new OldOrderFragment();
                fragmentManager.beginTransaction().replace(R.id.container_body,fragment).addToBackStack("").commit();
                textView.setText("قائمة الطلبات السابقة");

                break;
            case 2:

                fragment=new UserProfileFragment();
                fragmentManager.beginTransaction().replace(R.id.container_body,fragment).addToBackStack("").commit();
                textView.setText("الملف الشخصي");

                break;

            case 3:

                editor.putBoolean(SharedPrefConstants.getUserLogedIn(),false);
                editor.apply();
                closeApp();

                break;
        }


    }

    private void closeApp() {

        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }

    /*
    // show menu in left on toolbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.END)) {
            drawer.closeDrawer(GravityCompat.END);
        }
//        else if(){
//            if(backButtonCount >= 1) {
//                backButtonCount=0;
//                 closeApp();
//
//            }
//            else {
//                Toast.makeText(this, "انقر مرة اخرى للخروج من البرنامج", Toast.LENGTH_SHORT).show();
//                backButtonCount++;
//            }
//        }
            else {
            closeApp();
        }
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.drowerImageIcon:
                mDrawerLayout.openDrawer(Gravity.RIGHT);
                break;
        }
    }
}
