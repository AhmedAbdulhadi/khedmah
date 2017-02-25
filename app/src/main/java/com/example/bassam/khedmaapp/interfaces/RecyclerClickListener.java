package com.example.bassam.khedmaapp.interfaces;

import android.view.View;

/**
 * Created by bassam on 2/18/17.
 */

public  interface RecyclerClickListener {

    void onClick(View view, int position);

    void onLongClick(View view, int position);
}
