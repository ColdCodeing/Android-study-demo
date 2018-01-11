package com.zhouyu.myapplication;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.text.Html;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.widget.GridView;
import android.widget.ShareActionProvider;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

/**
 * Created by fuyue on 2018/1/5.
 */

public class GridCalculatorActivity extends Activity implements OnKeyboardListener{

    public static final String[] MARKS = {"(", ")", "AC", "<-", "7", "8", "9", "*",
    "4", "5", "6", "-", "1", "2", "3", "+", "0", ".", "=", "/"};
    public static final String[] ORANGE_MARKS = {"*", "-", "+", "/", "(", ")", "<-", "AC"};
    public static final String brString = "<br\\\\>";
    public static final DecimalFormat decimalFormat = new DecimalFormat("###################.#########");
    public static final String LAST_STRING_SAVE_KEY = "lastString";
    public static final String PRE_STRING_SAVE_KEY = "preString";
    CalculatorAdapter mAdapter;
    GridView mGridView;
    TextView textView;
    TextView preTextView;
    DisplayMetrics metric;
    private String preString = "";          //已经计算过的表达式
    private String lastString = "";         //最新的表达式
    private Boolean isExcute = false;       //是否已经完后计算


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cal_grid);

        metric = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metric);

        mGridView = findViewById(R.id.grid_calculator);
        mAdapter = new CalculatorAdapter(this, MARKS, this, this.getWindowManager().getDefaultDisplay().getHeight() / 9);
        mGridView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
        textView = findViewById(R.id.gridTextView);
        preTextView = findViewById(R.id.preTextView);

        textView.setTextSize(TypedValue.COMPLEX_UNIT_PX, 150);
        preTextView.setTextSize(TypedValue.COMPLEX_UNIT_PX, 150);
    }

    @Override
    public void onKeyboardListener(String mark) {
        if ("=".equals(mark)) {         //等号时计算表达式
            excuteExpression();
        } else if("<-".equals(mark)) {
            if (lastString != null && lastString.length() > 0) {
                lastString = lastString.substring(0, lastString.length() - 1);
            }
        } else if("AC".equals(mark)) {
            lastString = "";
            preString = "";
            SharedPreferences sharedPreferences = getSharedPreferences("calc", MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.clear();
            editor.commit();
        }else {                        //表达式输入
            if (isExcute) {
                preString += lastString;
                isExcute = false;
            }
            lastString += mark;
        }
        setText();
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sharedPreferences = getSharedPreferences("calc", MODE_PRIVATE);
        lastString = sharedPreferences.getString(LAST_STRING_SAVE_KEY, "");
        preString = sharedPreferences.getString(PRE_STRING_SAVE_KEY, "");
        setText();
    }

    @Override
    protected void onPause() {
        System.out.println("持久化");
        super.onPause();
        SharedPreferences sharedPreferences = getSharedPreferences("calc", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(LAST_STRING_SAVE_KEY, lastString);
        editor.putString(PRE_STRING_SAVE_KEY, preString);
        editor.commit();
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
        preString = lastString + " = ";
        lastString = decimalFormat.format(result);
    }

    private void setText() {
        setTextSize(lastString.length(), textView);
        setTextSize(preString.length(), preTextView);
        final String[] tags = new String[]{"<font color='#858585'>", "<font color='#CD2626'>", "</font> "};
        StringBuilder builderPre = new StringBuilder();
        StringBuilder builderLast = new StringBuilder();
        // 添加颜色标签
        builderPre.append(tags[0]);    builderPre.append(preString);    builderPre.append(tags[2]);
        builderLast.append(tags[1]);    builderLast.append(lastString);   builderLast.append(tags[2]);
        textView.setText(Html.fromHtml(builderLast.toString()));
        preTextView.setText(Html.fromHtml(builderPre.toString()));
    }

    private void setTextSize(int length, TextView textView) {
        if (length > 10) {
            textView.setTextSize(TypedValue.COMPLEX_UNIT_PX, 80);
        } else  {
            textView.setTextSize(TypedValue.COMPLEX_UNIT_PX, 150);
        }
    }
}














