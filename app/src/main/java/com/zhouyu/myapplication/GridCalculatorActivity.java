package com.zhouyu.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.GridView;
import android.widget.Toast;

/**
 * Created by fuyue on 2018/1/5.
 */

public class GridCalculatorActivity extends Activity implements OnKeyboardListener{

    public static final String[] MARKS = {"7", "8", "9", "*",
    "4", "5", "6", "-", "1", "2", "3", "+", "0", ".", "=", "/"};
    public static final String[] ORANGE_MARKS = {"*", "-", "+", "/"};

    CalculatorAdapter mAdapter;
    GridView mGridView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cal_grid);

        mGridView = findViewById(R.id.grid_calculator);
        mAdapter = new CalculatorAdapter(this, MARKS, this);
        mGridView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onKeyboardListener(String mark) {
        Toast.makeText(this, mark, Toast.LENGTH_SHORT).show();
    }
}
