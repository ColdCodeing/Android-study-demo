package com.zhouyu.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by fuyue on 2018/1/5.
 */

public class GridCalculatorActivity extends Activity implements OnKeyboardListener{

    public static final String[] MARKS = {"7", "8", "9", "*",
    "4", "5", "6", "-", "1", "2", "3", "+", "0", ".", "=", "/"};
    public static final String[] ORANGE_MARKS = {"*", "-", "+", "/"};
    public static final String[] NUMBERS = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
    public static final String[] CALCS = {"+", "-", "*", "/"};

    CalculatorAdapter mAdapter;
    GridView mGridView;
    Calculator mCalculator;
    TextView resultTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cal_grid);

        mGridView = findViewById(R.id.grid_calculator);
        mAdapter = new CalculatorAdapter(this, MARKS, this);
        mGridView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
        mCalculator = new Calculator();
        resultTextView = findViewById(R.id.gridTextView);
    }

    @Override
    public void onKeyboardListener(String mark) {
        Integer keyType = 0;
        Integer value = 0;
        Integer calc = 0;
        for (int i = 0; i < NUMBERS.length; i++) {
            if (NUMBERS[i].equals(mark)) {
                keyType = 1;
                value = i;
                break;
            }
        }
        for (int i = 0; i < CALCS.length; i++) {
            if (CALCS[i].equals(mark)) {
                keyType = 2;
                calc = i;
                break;
            }
        }
        if ("=".equals(mark)) {
            keyType = 3;
        }
        switch (keyType) {
            case 0:
                break;
            case 1:
                mCalculator.inputValue = mCalculator.inputValue * 10 + value;
                resultTextView.setText(mCalculator.inputValue + "");
                break;
            case 2:
                showResult(mCalculator.calc(mCalculator.inputValue, mCalculator.cacheResult, calc));
                break;
            case 3:
                break;
        }
    }

    private void showResult(int result) {
        // 将上次显示的结果缓存在cacheResult中，作为下次计算时的缓存值
        mCalculator.cacheResult = result;
        mCalculator.inputValue = 0;
        // 将计算结果显示在文本中
        resultTextView.setText(result + "");
        // 每次计算完成后将输入文本框重置为0
    }
}














