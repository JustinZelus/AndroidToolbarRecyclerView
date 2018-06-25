package jzstudio.com.recyclerview.model;

import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;

import java.util.List;

/**
 * Created by icm_mobile on 2018/6/22.
 */

public class MyMenu {

    private String[] myTitles;
    private TypedArray mBackground;


    public MyMenu(String[] myTitles, TypedArray mBackground) {
        this.myTitles = myTitles;
        this.mBackground = mBackground;
    }

    public String[] getTitles() {
        return myTitles;
    }
    public Drawable getBackground(int index) {
        return mBackground.getDrawable(index);
    }
    public int size() {
        return myTitles.length;
    }
}
