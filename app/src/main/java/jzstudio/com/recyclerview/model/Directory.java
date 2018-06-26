package jzstudio.com.recyclerview.model;

import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;

import java.util.List;

/**
 * Created by icm_mobile on 2018/6/25.
 */

public class Directory {

    private String mTitle;
    private Drawable mBackground_0;
    private Drawable mBackground_1;
    private Drawable mBackground;


    public Directory(String mTitle, Drawable mBackground) {
        this.mTitle = mTitle;
        this.mBackground = mBackground;
    }

    public Directory(String mTitle, Drawable mBackground_0, Drawable mBackground_1) {
        this.mTitle = mTitle;
        this.mBackground_0 = mBackground_0;
        this.mBackground_1 = mBackground_1;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public Drawable getBackground() {
        return this.mBackground;
    }

    public Drawable getBackground_0() {
        return this.mBackground_0;
    }

    public Drawable getBackground_1() {
        return this.mBackground_1;
    }


}
