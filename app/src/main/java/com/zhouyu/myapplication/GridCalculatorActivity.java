package com.zhouyu.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.GridView;

/**
 * Created by fuyue on 2018/1/5.
 */

public class GridCalculatorActivity extends Activity {

    public static final String[] MARKS = {"7", "8", "9", "*",
    "4", "5", "6", "-", "1", "2", "3", "+", "0", ".", "=", "/"};

    CalculatorAdapter mAdapter;
    GridView mGridView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cal_grid);

        mGridView = findViewById(R.id.grid_calculator);
        mAdapter = new CalculatorAdapter(this, MARKS);
        mGridView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
    }
}
