package com.example.bassam.khedmaapp.views;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by bassam on 2/13/17.
 */

public class FontAwesomeTextView extends TextView {
    public FontAwesomeTextView(Context context) {
        super(context);
        Typeface face=Typeface.createFromAsset(context.getAssets(), "fontawesome.otf");
        this.setTypeface(face);
    }

    public FontAwesomeTextView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        Typeface face=Typeface.createFromAsset(context.getAssets(), "fontawesome.otf");
        this.setTypeface(face);
    }

    public FontAwesomeTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Typeface face=Typeface.createFromAsset(context.getAssets(), "fontawesome.otf");
        this.setTypeface(face);
    }

    public FontAwesomeTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Typeface face=Typeface.createFromAsset(context.getAssets(), "fontawesome.otf");
        this.setTypeface(face);
    }
}
