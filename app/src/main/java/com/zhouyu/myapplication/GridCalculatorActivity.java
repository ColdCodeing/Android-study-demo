package com.zhouyu.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Html;
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
    public static final String brString = "<br\\\\>";

    CalculatorAdapter mAdapter;
    GridView mGridView;
    TextView textView;

    private String preString = "";          //已经计算过的表达式
    private String lastString = "";         //最新的表达式
    private Boolean isExcute = false;       //是否已经完后计算


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cal_grid);

        mGridView = findViewById(R.id.grid_calculator);
        mAdapter = new CalculatorAdapter(this, MARKS, this);
        mGridView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
        textView = findViewById(R.id.gridTextView);
    }

    @Override
    public void onKeyboardListener(String mark) {

        if ("=".equals(mark)) {         //等号时计算表达式
            excuteExpression();
        } else {                        //表达式输入
            if (isExcute) {
                preString = lastString + brString;
                lastString = mark;
                isExcute = false;
            } else {
                lastString += mark;
            }
        }
        setText();
    }

    private void excuteExpression() {
        if(lastString == null || lastString.length() == 0) {
            return;
        }
        double result;
        try {
            result = ExpressionCalc.calculate(lastString);
            isExcute = true;
        } catch (Exception e) {
            e.printStackTrace();
            textView.setError(e.getMessage());
            return;
        }
        lastString += " = " + result;
    }

    private void setText() {
        final String[] tags = new String[]{"<font color='#858585'>", "<font color='#CD2626'>", "</font> "};
        StringBuilder builder = new StringBuilder();
        // 添加颜色标签
        builder.append(tags[0]);    builder.append(preString);    builder.append(tags[2]);
        builder.append(tags[1]);    builder.append(lastString);   builder.append(tags[2]);
        textView.setText(Html.fromHtml(builder.toString()));
    }
}














