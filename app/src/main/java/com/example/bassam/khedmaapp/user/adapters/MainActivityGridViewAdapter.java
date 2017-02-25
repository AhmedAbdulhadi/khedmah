package com.example.bassam.khedmaapp.user.adapters;

import android.app.Activity;
import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bassam.khedmaapp.R;
import com.example.bassam.khedmaapp.user.models.MainActivityGridViewModel;

import java.util.List;

/**
 * Created by bassam on 11/9/16.
 */

public class MainActivityGridViewAdapter extends ArrayAdapter<MainActivityGridViewModel> {

    TextView GridViewItemTextView;


    Context context;
    int listLength;

    public MainActivityGridViewAdapter(Context context, int resource, List<MainActivityGridViewModel> objects) {
        super(context, resource, objects);
        this.context=context;
        listLength=objects.size();
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {



        for (int j = 0; j <= listLength; j++) {

            MainActivityGridViewModel rowItem = getItem(position);

            LayoutInflater mInflater = (LayoutInflater) context
                    .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            if (convertView == null) {
                convertView = mInflater.inflate(R.layout.gridview_item, null);

                GridViewItemTextView=(TextView) convertView.findViewById(R.id.GridViewItemTextView);

            } else {

                GridViewItemTextView.setText(Html.fromHtml(rowItem.getGridText()));
            }

        }
        return convertView;
    }


}
