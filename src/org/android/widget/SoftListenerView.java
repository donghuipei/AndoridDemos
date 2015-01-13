package org.android.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

public class SoftListenerView extends LinearLayout {

    private SoftListener mListener;
    
    private int mNormalHeight;
    
    public enum SoftState{
        SHOW, HIDE
    }
    
    public interface SoftListener{
        public void onSoftChange(SoftState softState, int softHeight);
    }
    
    public SoftListenerView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public SoftListenerView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SoftListenerView(Context context) {
        super(context);
    }
    
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if(oldh == 0){
            mNormalHeight = h;
        }else if(mListener != null){
            int distance = h - oldh;
            if(Math.abs(distance) > 50){
                if(distance > 0){
                    mListener.onSoftChange(SoftState.HIDE, 0);
                }else{
                    mListener.onSoftChange(SoftState.SHOW, mNormalHeight - h);
                }
            }
        }
    }
    
    public void setSoftListener(SoftListener l){
        this.mListener = l;
    }
}
