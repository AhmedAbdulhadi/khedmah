package com.example.bassam.khedmaapp.views;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by bassam on 2/9/17.
 */

public class MytoolbarTextView extends TextView {

    public MytoolbarTextView(Context context) {
        super(context);

            this.setTextColor(Color.parseColor("#9E9E9E"));
        Typeface face=Typeface.createFromAsset(context.getAssets(), "textviewfont.otf");
        this.setTypeface(face);
    }

    public MytoolbarTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        this.setTextColor(Color.parseColor("#9E9E9E"));
        Typeface face=Typeface.createFromAsset(context.getAssets(), "textviewfont.otf");
        this.setTypeface(face);
    }

    public MytoolbarTextView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.setTextColor(Color.parseColor("#9E9E9E"));
        Typeface face=Typeface.createFromAsset(context.getAssets(), "textviewfont.otf");
        this.setTypeface(face);
    }

    public MytoolbarTextView(Context context, AttributeSet attrs) {
        super(context, attrs);

        this.setTextColor(Color.parseColor("#9E9E9E"));
        Typeface face=Typeface.createFromAsset(context.getAssets(), "textviewfont.otf");
        this.setTypeface(face);
    }
}
