package com.example.bassam.khedmaapp.user.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.GestureDetector;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;


import com.example.bassam.khedmaapp.R;
import com.example.bassam.khedmaapp.interfaces.RecyclerClickListener;
import com.example.bassam.khedmaapp.interfaces.FragmentDrawerListener;
import com.example.bassam.khedmaapp.listeners.RecyclerTouchListener;
import com.example.bassam.khedmaapp.user.adapters.NavigationDrawerAdapter;
import com.example.bassam.khedmaapp.user.models.NavDrawerItem;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by bassam on 11/6/16.
 */

public class FragmentDrawer extends Fragment {

    String TAG = FragmentDrawer.class.getSimpleName();

     RecyclerView recyclerView;
     ActionBarDrawerToggle mDrawerToggle;
     DrawerLayout mDrawerLayout;
     NavigationDrawerAdapter adapter;
     View containerView;
     String[] titles = null;
     FragmentDrawerListener drawerListener;

    ImageButton imageView;

    public FragmentDrawer() {

    }

    public void setDrawerListener(FragmentDrawerListener listener) {
        this.drawerListener = listener;
    }

    public List<NavDrawerItem> getData() {
        List<NavDrawerItem> data = new ArrayList<>();

        // preparing navigation drawer items
        for (int i = 0; i < titles.length; i++) {
            NavDrawerItem navItem = new NavDrawerItem();
            navItem.setTitle(titles[i]);
            data.add(navItem);
        }
        return data;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // drawer labels
        titles = getActivity().getResources().getStringArray(R.array.nav_drawer_labels);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflating view layout
        View layout = inflater.inflate(R.layout.user_fragment_navigation_drawer, container, false);

        recyclerView = (RecyclerView) layout.findViewById(R.id.drawerList);

        adapter = new NavigationDrawerAdapter(getActivity(), getData());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);


        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getActivity(),recyclerView, new RecyclerClickListener() {

            @Override
            public void onClick(View view, int position) {
                drawerListener.onDrawerItemSelected(view, position);
                mDrawerLayout.closeDrawer(containerView);

            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
        return layout;
    }

    public void setUp(int fragmentId, DrawerLayout drawerLayout, final Toolbar toolbar) {
        containerView = getActivity().findViewById(fragmentId);
        mDrawerLayout = drawerLayout;




    }




}
