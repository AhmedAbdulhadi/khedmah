package com.example.bassam.khedmaapp.views;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.Button;


/**
 * Created by bassam on 2/5/17.
 */

public class MyButton extends Button {
    public MyButton(Context context) {
        super(context);
        this.setTextColor(Color.WHITE);
        Typeface face=Typeface.createFromAsset(context.getAssets(), "textviewfont.otf");
        this.setTypeface(face);
    }

    public MyButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.setTextColor(Color.WHITE);
        Typeface face=Typeface.createFromAsset(context.getAssets(), "textviewfont.otf");
        this.setTypeface(face);
    }

    public MyButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.setTextColor(Color.WHITE);
        Typeface face=Typeface.createFromAsset(context.getAssets(), "textviewfont.otf");
        this.setTypeface(face);
    }

    public MyButton(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.setTextColor(Color.WHITE);
        Typeface face=Typeface.createFromAsset(context.getAssets(), "textviewfont.otf");
        this.setTypeface(face);

    }
}
