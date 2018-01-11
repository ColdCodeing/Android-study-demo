package com.zhouyu.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by fuyue on 2018/1/5.
 */

public class CalculatorAdapter extends BaseAdapter {

    Context mContext;
    String[] mData;
    OnKeyboardListener mListener;
    int height;

    public CalculatorAdapter(Context context, String[] data, OnKeyboardListener listener, int height) {
        mContext = context;
        mData = data;
        mListener = listener;
        this.height = height;
    }

    /**
     * 这个队列的数量
     * @return
     */
    @Override
    public int getCount() {
        return mData.length;
    }

    @Override
    public Object getItem(int position) {
        return mData[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        final String mark = mData[position];
        boolean isOrange = false;
        int length = GridCalculatorActivity.ORANGE_MARKS.length;
        for (int i = 0; i < length; i++) {
            if (GridCalculatorActivity.ORANGE_MARKS[i].equals(mark)) {
                isOrange = true;
                break;
            }
        }
//        for (String s : GridCalculatorActivity.ORANGE_MARKS) {
//            if (s.equals(mark)) {
//                isOrange = true;
//                break;
//            }
//        }
        // 初始化每个View
        if (null == convertView) {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(mContext).inflate(R.layout.grid_item_calculator, null);
            holder.textView = convertView.findViewById(R.id.textViewCalItem);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        // 初始化后赋值（文字，颜色等）
        if (isOrange) {
            holder.textView.setTextColor(mContext.getResources().getColor(R.color.keyboard_orange));
        }
        holder.textView.setText(mark);
        holder.textView.setHeight(height);         //高度
        convertView.setBackgroundColor(mContext.getResources().getColor(R.color.white));
        convertView.setOnTouchListener(new KeyBoardTouchListener(isOrange, mark, mContext, mListener));
        return convertView;
    }

    public class ViewHolder {
        public TextView textView;
    }
}
