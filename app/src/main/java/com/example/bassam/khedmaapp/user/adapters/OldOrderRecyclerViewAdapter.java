package com.example.bassam.khedmaapp.user.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.bassam.khedmaapp.R;
import com.example.bassam.khedmaapp.user.models.OldOrderRecyclerViewModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by bassam on 2/15/17.
 */

public class OldOrderRecyclerViewAdapter extends RecyclerView.Adapter<OldOrderRecyclerViewAdapter.MyViewHolder> {

        List<OldOrderRecyclerViewModel> data= new ArrayList<OldOrderRecyclerViewModel>();
        LayoutInflater inflater;
        Context context;

public OldOrderRecyclerViewAdapter(Context context, List<OldOrderRecyclerViewModel> data) {
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
        View view = inflater.inflate(R.layout.old_order_recycler_view_item_layout, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
        }

@Override
public void onBindViewHolder(MyViewHolder holder, int position) {

    OldOrderRecyclerViewModel current = new OldOrderRecyclerViewModel();
    current=(OldOrderRecyclerViewModel) data.get(position);

    holder.orderIdOldOrderActivity.setText(current.getOrderId());

    holder.orderTextOldOrderActivity.setText(current.getService());
    holder.orderRateStateOldOrderActivity.setText(current.getRateState());


}

@Override
public int getItemCount() {
        return data.size();
        }

class MyViewHolder extends RecyclerView.ViewHolder {
    TextView orderIdOldOrderActivity,orderTextOldOrderActivity,orderRateStateOldOrderActivity;

    public MyViewHolder(View itemView) {
             super(itemView);

        orderIdOldOrderActivity=(TextView)itemView.findViewById(R.id.orderIdOldOrderActivity);
        orderTextOldOrderActivity=(TextView)itemView.findViewById(R.id.orderTextOldOrderActivity);
        orderRateStateOldOrderActivity=(TextView)itemView.findViewById(R.id.orderRateStateOldOrderActivity);


        }
    }
}

