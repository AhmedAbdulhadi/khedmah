package com.example.bassam.khedmaapp.user.fragments;


import android.annotation.SuppressLint;


import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.bassam.khedmaapp.R;
import com.example.bassam.khedmaapp.user.activitys.SupServicesPageActivity;
import com.example.bassam.khedmaapp.user.activitys.UserHomePageActivity;
import com.example.bassam.khedmaapp.user.activitys.UserOrderActivity;
import com.example.bassam.khedmaapp.user.adapters.MainActivityGridViewAdapter;
import com.example.bassam.khedmaapp.user.models.MainActivityGridViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bassam on 11/10/16.
 */

public class GridViewFragment extends Fragment {



    String gridText[];



    GridView gridView;
    List<MainActivityGridViewModel> gridViewItem;
    MainActivityGridViewAdapter gridViewAdapter;
    MainActivityGridViewModel gridViewModel;

    public GridViewFragment() {
    }

    @SuppressLint("ValidFragment")
    public GridViewFragment(String[] gridText) {
        this.gridText = gridText;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.gridview_layout,container,false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        setUp(view);
        setUpAdapter();
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(getActivity().getClass().equals(UserHomePageActivity.class)){
                Intent intent=new Intent(getActivity(), SupServicesPageActivity.class);
                startActivity(intent);}
            else{Intent intent=new Intent(getActivity(), UserOrderActivity.class);
                startActivity(intent);}
            }
        });

    }

    protected void setUp(View view) {





        gridView=(GridView)view.findViewById(R.id.gridView);

        gridViewItem=new ArrayList<MainActivityGridViewModel>();
//        BoolModel boolModel=new BoolModel();
//        boolModel.setInTitle(false);
    }

    protected void setUpAdapter() {


        for (int i=0;i<gridText.length;i++){
            gridViewModel=new MainActivityGridViewModel(gridText[i]);
            gridViewItem.add(gridViewModel);

        }

        gridViewAdapter= new MainActivityGridViewAdapter(getActivity(),
                R.layout.gridview_layout, gridViewItem);
        gridView.setAdapter(gridViewAdapter);
    }

}
