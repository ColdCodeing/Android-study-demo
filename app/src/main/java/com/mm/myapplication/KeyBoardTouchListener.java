package com.mm.myapplication;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by panmin on 18-1-10.
 */

public class KeyBoardTouchListener implements View.OnTouchListener{
    public boolean isOrange = false;
    public String mark;
    private Context mContext;
    private OnKeyboardListener listener;

    public KeyBoardTouchListener(boolean isOrange, String mark, Context mcontext, OnKeyboardListener listener) {
        this.isOrange = isOrange;
        this.mark = mark;
        this.mContext = mcontext;
        this.listener = listener;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN :
                v.setBackgroundColor(mContext.getResources().getColor(R.color.keyboard_blue));
                listener.onKeyboardListener(mark);
                break;
            default:
                v.setBackgroundColor(mContext.getResources().getColor(R.color.white));
        }
        return true;
    }
}
