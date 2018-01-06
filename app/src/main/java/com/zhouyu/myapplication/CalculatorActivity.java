package com.zhouyu.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.zhouyu.myapplication.Calculator;

/**
 * Created by fuyue on 2018/1/3.
 */

public class CalculatorActivity extends Activity implements View.OnClickListener {

    /**
     * 计算器输入框
     */
    EditText inputEditText;
    /**
     * 计算结果
     */
    TextView resultTextView;
    /**
     * 加法按钮
     */
    Button buttonPlus;
    /**
     * 减法按钮
     */
    Button buttonSub;
    /**
     * 乘法按钮
     */
    Button buttonMulti;
    /**
     * 除法按钮
     */
    Button buttonDeliver;
    /**
     * 等于号按钮
     */
    Button buttonEqual;

    Calculator mCalculator;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        mCalculator = new Calculator();

        inputEditText = (EditText) findViewById(R.id.editText);//输入
        // 把文本输入框设置为空字符串
        inputEditText.setText("");
        // 把文本框提示文字设置为0
        inputEditText.setHint("0");
        resultTextView = (TextView) findViewById(R.id.textView);//结果
        // 以下是按钮，需要绑定点击事件
        buttonPlus = (Button) findViewById(R.id.button);//加
        buttonSub = (Button) findViewById(R.id.button2);//减
        buttonMulti = (Button) findViewById(R.id.button3);//乘
        buttonDeliver = (Button) findViewById(R.id.button4);//除
        buttonEqual = (Button) findViewById(R.id.button5);//等

        buttonPlus.setOnClickListener(this);
        buttonSub.setOnClickListener(this);
        buttonMulti.setOnClickListener(this);
        buttonDeliver.setOnClickListener(this);
        buttonEqual.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String input = inputEditText.getText().toString().trim();
        int number = 0;
        int result;
        try {
            number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.print(e);
            Toast.makeText(this, "请输入数字", Toast.LENGTH_SHORT).show();
        }
        int id = v.getId();
        switch (id) {
            case R.id.button:
                // 加法结果
                result = mCalculator.plus(number, mCalculator.cacheResult);
                showResult(result);
                break;
            case R.id.button2:
                result = mCalculator.sub(number, mCalculator.cacheResult);
                showResult(result);
                break;
            case R.id.button3:
                result = mCalculator.multi(number, mCalculator.cacheResult);
                showResult(result);
                break;
            case R.id.button4:
                try {
                    result = mCalculator.deliver(number, mCalculator.cacheResult);
                    showResult(result);
                } catch (ArithmeticException e) {
                    Toast.makeText(this, "除数不能为0", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.button5:
                break;
            default:
                break;
        }
    }

    private void showResult(int result) {
        // 将上次显示的结果缓存在cacheResult中，作为下次计算时的缓存值
        mCalculator.cacheResult = result;
        // 将计算结果显示在文本中
        resultTextView.setText(result + "");
        // 每次计算完成后将输入文本框重置为0
        inputEditText.setText("");
    }
}
