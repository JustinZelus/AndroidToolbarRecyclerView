package jzstudio.com.recyclerview.custom;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import jzstudio.com.recyclerview.MainActivity;

/**
 * Created by icm_mobile on 2018/6/29.
 */

public class GlowingText {
    private Context context;
    private MainActivity activity;

    private View view;
    private float startGlowRadius = 0;
    private float dx = 0f;
    private float dy = 0f;
    private int glowColor = 0xFFd9f7fc;

    public GlowingText(View v, float startGlowRadius) {
        this.view = v;
        this.startGlowRadius = startGlowRadius;
        if(!(view instanceof TextView)) return;

        if(this.startGlowRadius > 0) startGlowing();
    }

    private void startGlowing() {
        ((TextView)view).setShadowLayer(startGlowRadius,dx,dy,glowColor);
    }
}
