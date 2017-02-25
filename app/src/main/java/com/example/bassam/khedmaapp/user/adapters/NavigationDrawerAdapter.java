package com.example.bassam.khedmaapp.user.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.bassam.khedmaapp.R;
import com.example.bassam.khedmaapp.user.models.NavDrawerItem;

import java.util.Collections;
import java.util.List;



/**
 * Created by bassam on 11/6/16.
 */

public class NavigationDrawerAdapter extends RecyclerView.Adapter<NavigationDrawerAdapter.MyViewHolder> {

    List<NavDrawerItem> data= Collections.emptyList();
    LayoutInflater inflater;
    Context context;

    public NavigationDrawerAdapter(Context context, List<NavDrawerItem> data) {
        this.data = data;
        inflater = LayoutInflater.from(context);
        this.context = context;
    }

    public void delete(int position) {
        data.remove(position);
        notifyItemRemoved(position);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.user_nav_drawer_row, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        NavDrawerItem current = data.get(position);
        holder.title.setText(current.getTitle());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title;

        public MyViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
        }
    }
}
