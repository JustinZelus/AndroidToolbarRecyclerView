package jzstudio.com.recyclerview.custom;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by icm_mobile on 2018/6/28.
 *
 */

public class LinearDividerItemDecoration extends RecyclerView.ItemDecoration{
    private Paint paint;
    private Context context;
    private int dividerHeight;

    private int layoutOrientation = -1;

    public LinearDividerItemDecoration(Context context,int color, int dHeight) {
        this.context = context;
        paint = new Paint();
        paint.setColor(color);
        paint.setStrokeWidth(dHeight);
        dividerHeight = dHeight;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect,view,parent,state);
//        outRect.set(0, 0, dividerHeight, dividerHeight);
        outRect.set(0, 0, dividerHeight, 0);

    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);

            horizontalDivider(c, parent);

//            verticalDivider(c, parent);

    }
    private void horizontalDivider(Canvas c, RecyclerView parent){
        final int top = parent.getPaddingTop();
        final int bottom = parent.getHeight() - parent.getPaddingBottom();

        final int itemCount = parent.getChildCount();
        for (int i = 0; i < itemCount; i++) {
            final View child = parent.getChildAt(i);
            final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child
                    .getLayoutParams();
            final int left = child.getRight() + params.rightMargin;
            c.drawLine(left,top,left,bottom, paint);
        }
    }
    private void verticalDivider(Canvas c, RecyclerView parent){
        final int left = parent.getPaddingLeft();
        final int right = parent.getWidth() - parent.getPaddingRight();

        final int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            final View child = parent.getChildAt(i);
            final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child
                    .getLayoutParams();
            final int top = child.getBottom() + params.bottomMargin;
            c.drawLine(left,top,right,top, paint);
        }
    }
}
