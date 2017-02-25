package com.example.bassam.khedmaapp.listeners;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import com.example.bassam.khedmaapp.interfaces.RecyclerClickListener;

/**
 * Created by bassam on 2/18/17.
 */

public class RecyclerTouchListener  implements RecyclerView.OnItemTouchListener {

    private GestureDetector gestureDetector;
    private RecyclerClickListener recyclerClickListener;

    public RecyclerTouchListener(Context context, final RecyclerView recyclerView, final RecyclerClickListener recyclerClickListener) {
        this.recyclerClickListener = recyclerClickListener;
        gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                return true;
            }

            @Override
            public void onLongPress(MotionEvent e) {
                View child = recyclerView.findChildViewUnder(e.getX(), e.getY());
                if (child != null && recyclerClickListener != null) {
                    recyclerClickListener.onLongClick(child, recyclerView.getChildPosition(child));
                }
            }
        });
    }

//    public RecyclerTouchListener(FragmentActivity activity, RecyclerView recyclerView, RecyclerClickListener recyclerClickListener) {
//    }

    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {

        View child = rv.findChildViewUnder(e.getX(), e.getY());
        if (child != null && recyclerClickListener != null && gestureDetector.onTouchEvent(e)) {
            recyclerClickListener.onClick(child, rv.getChildPosition(child));
        }
        return false;
    }

    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {
    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }
}
