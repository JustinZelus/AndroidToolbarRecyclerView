package jzstudio.com.recyclerview.model;

import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;

import java.util.List;

/**
 * Created by icm_mobile on 2018/6/25.
 */

public class OffLine {

    private List<String> mTitles;
    private TypedArray mBackground;

    public OffLine(List<String> mTitles, TypedArray mBackground) {
        this.mTitles = mTitles;
        this.mBackground = mBackground;
    }

    public String getTitle(int index) {
        return mTitles.get(index);
    }
    public Drawable getBackground(int index) {
        return mBackground.getDrawable(index);//0,1
    }
    public int size () {
        return mTitles.size();
    }
}
