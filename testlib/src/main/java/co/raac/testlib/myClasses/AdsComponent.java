package co.raac.testlib.myClasses;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.View;
import android.widget.LinearLayout;

//import co.raac.testlib.R;


/**
 * TODO: document your custom view class.
 */
public class AdsComponent extends LinearLayout {

    private TextPaint mTextPaint;
    private float mTextWidth;
    private float mTextHeight;
    private String TAG="AdsComponent";

    public AdsComponent(Context context) {
        super(context);
        init(context, null, 0);
    }

    public AdsComponent(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0);
    }

    public AdsComponent(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context, attrs, defStyle);
    }

    private void init(Context context, AttributeSet attrs, int defStyle) {
        // Load attributes
        Log.d(TAG, "init: "+defStyle);
//        inflate(context,R.layout.ads_component, this);
//        final TypedArray a = getContext().obtainStyledAttributes(
//                attrs, R.styleable.AdsComponent, defStyle, 0);
//        a.recycle();
//        LinearLayout.LayoutParams llp = (LinearLayout.LayoutParams) (this).getLayoutParams();
//        if (llp == null) {
//            llp = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
//        } else {
//            llp.width = LayoutParams.MATCH_PARENT;
//            llp.height = LayoutParams.WRAP_CONTENT;
//        }
//        setOrientation(LinearLayout.VERTICAL);
//        this.setLayoutParams(llp);
        CodeExecute.getBaseBanner(this);
//        requestLayout();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

//    @Override
//    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        //Log.d(TAG, "onMeasure: "+widthMeasureSpec+":"+heightMeasureSpec+" ---  "+measureWidth(widthMeasureSpec)+":"+ measureHeight(heightMeasureSpec));
//        setMeasuredDimension(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);
//    }

    private int measureWidth(int measureSpec) {
        int preferred = LayoutParams.MATCH_PARENT;
        return getMeasurement(measureSpec, preferred);
    }

    private int measureHeight(int measureSpec) {
        int preferred = LayoutParams.WRAP_CONTENT;
        return getMeasurement(measureSpec, preferred);
    }

    private int getMeasurement(int measureSpec, int preferred) {
        int specSize = MeasureSpec.getSize(measureSpec);
        int measurement = 0;

        switch (MeasureSpec.getMode(measureSpec)) {
            case MeasureSpec.EXACTLY:
                // This means the width of this view has been given.
                measurement = specSize;
                break;
            case MeasureSpec.AT_MOST:
                // Take the minimum of the preferred size and what
                // we were told to be.
                measurement = Math.min(preferred, specSize);
                break;
            default:
                measurement = preferred;
                break;
        }

        return measurement;
    }
}
