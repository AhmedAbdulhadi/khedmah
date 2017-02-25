package com.example.bassam.khedmaapp.user.fragments;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.bassam.khedmaapp.R;
import com.example.bassam.khedmaapp.interfaces.RecyclerClickListener;
import com.example.bassam.khedmaapp.listeners.RecyclerTouchListener;
import com.example.bassam.khedmaapp.user.activitys.RateOldOrderActivity;
import com.example.bassam.khedmaapp.user.activitys.UserHomePageActivity;
import com.example.bassam.khedmaapp.user.adapters.OldOrderRecyclerViewAdapter;
import com.example.bassam.khedmaapp.user.models.OldOrderRecyclerViewModel;

import java.util.ArrayList;
import java.util.List;

public class OldOrderFragment extends Fragment {

    String[] orderId,serves,rateState,supplierName;

    RecyclerView recyclerView;
    List<OldOrderRecyclerViewModel> recyclerViewModels;
    OldOrderRecyclerViewAdapter recyclerViewAdapter;


    RecyclerView.LayoutManager recylerViewLayoutManager;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.activity_old_order_layout,container,false);

        setUpRecyclerView(view);
        setupRecyclerViewData();
        setDataInList();


        return view;

    }



    private void setDataInList() {

        for (int i = 0; i <orderId.length ; i++) {

            OldOrderRecyclerViewModel oldOrderRecyclerViewModel=new OldOrderRecyclerViewModel(orderId[i],rateState[i],serves[i]);
            recyclerViewModels.add(oldOrderRecyclerViewModel);
        }

        recyclerViewAdapter=new OldOrderRecyclerViewAdapter(getActivity(),recyclerViewModels);
        recyclerView.setLayoutManager(recylerViewLayoutManager);
        recyclerView.setAdapter(recyclerViewAdapter);
        setUpRecyclerViewListener();



    }

    private void setUpRecyclerViewListener() {
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getActivity(), recyclerView, new RecyclerClickListener() {
            @Override
            public void onClick (View view, int position) {

                if(rateState[position]=="تم التقييم"){
                    Toast.makeText(getActivity(), "قمت بتقيم هذا الطلب من قبل", Toast.LENGTH_SHORT).show();
                }else{
                Intent intent=new Intent(getActivity(), RateOldOrderActivity.class);
                intent.putExtra("orderid",orderId[position]);
                intent.putExtra("suppliername",supplierName[position]);
                startActivity(intent);
                }

            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
    }

    private void setUpRecyclerView(View view) {


        recylerViewLayoutManager=new LinearLayoutManager(getActivity());
        recyclerView=(RecyclerView)view.findViewById(R.id.oldOrderRecyclerView);
        recyclerViewModels=new ArrayList<OldOrderRecyclerViewModel>();


    }

    private void setupRecyclerViewData() {

        orderId=new String[]{"1111","2222","3333"};
        serves=new String[]{"خدمة كهرباء","خدمة نجارة","خدمة سباكة"};
        rateState=new String[]{"تقييم الان","تم التقييم","تقييم الان"};
        supplierName=new String[]{"محمد","ابراهيم","بسام"};
    }






//    @Override
//    public void onClick(View view) {
//
//        int itemPosition = recyclerView.getChildLayoutPosition(view);
//        String item = orderId[itemPosition];
//        Toast.makeText(getActivity(), item, Toast.LENGTH_LONG).show();

//    }
}
