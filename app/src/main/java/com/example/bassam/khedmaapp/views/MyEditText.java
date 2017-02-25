package com.example.bassam.khedmaapp.views;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.EditText;

/**
 * Created by bassam on 2/5/17.
 */

public class MyEditText extends EditText {
    public MyEditText(Context context) {
        super(context);
        this.setTextColor(Color.parseColor("#3E3F40"));
        Typeface face=Typeface.createFromAsset(context.getAssets(), "textviewfont.otf");
        this.setTypeface(face);
    }

    public MyEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.setTextColor(Color.parseColor("#3E3F40"));
        Typeface face=Typeface.createFromAsset(context.getAssets(), "textviewfont.otf");
        this.setTypeface(face);
    }

    public MyEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.setTextColor(Color.parseColor("#3E3F40"));
        Typeface face=Typeface.createFromAsset(context.getAssets(), "textviewfont.otf");
        this.setTypeface(face);
    }

    public MyEditText(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.setTextColor(Color.parseColor("#3E3F40"));
        Typeface face=Typeface.createFromAsset(context.getAssets(), "textviewfont.otf");
        this.setTypeface(face);
    }
}
