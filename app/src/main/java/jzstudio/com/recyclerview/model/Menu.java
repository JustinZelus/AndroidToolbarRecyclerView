package jzstudio.com.recyclerview.model;

import android.graphics.drawable.Drawable;

import java.nio.charset.MalformedInputException;

/**
 * Created by icm_mobile on 2018/6/26.
 */

public class Menu {
    String mTitle;
    Drawable mBackground;


    public Menu(String mTitle, Drawable mBackground) {
        this.mTitle = mTitle;
        this.mBackground = mBackground;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public Drawable getBackground() {
        return this.mBackground;
    }
}
