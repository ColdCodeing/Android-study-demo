package com.mm.myapplication;

import android.view.View;

/**
 * Created by fuyue on 2018/1/5.
 */

public class KeyboardClickListener implements View.OnClickListener{

    public String mark;
    private OnKeyboardListener listener;

    public KeyboardClickListener(String mark, OnKeyboardListener listener) {
        this.mark = mark;
        this.listener = listener;
    }

    @Override
    public void onClick(View v) {
        listener.onKeyboardListener(mark);
    }

}
