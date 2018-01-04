package com.zhouyu.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


/**
 * Created by Administrator on 2018/1/3.
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
     * 等号按钮
     */
    Button buttonEqual;

    Calculator mcalculator;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /**
         * 添加布局文件
         */
        setContentView(R.layout.activity_calculator);

        mcalculator = new Calculator();

        inputEditText = (EditText) findViewById(R.id.editText);
        //把文本输入框设置为空字符串
        inputEditText.setText("");
        //把文本框提示文字设置为0
//        inputEditText.setHint("0");
        resultTextView = (TextView) findViewById(R.id.textView);
        //以下是按钮，需要绑定点击事件
        buttonPlus = (Button) findViewById(R.id.button);
        buttonSub = (Button) findViewById(R.id.button2);
        buttonMulti = (Button) findViewById(R.id.button3);
        buttonDeliver = (Button) findViewById(R.id.button4);
        buttonEqual = (Button) findViewById(R.id.button5);
        //设置监听
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
        } catch(NumberFormatException e) {
            System.out.print(e);
            Toast.makeText(this, "请输入数字", Toast.LENGTH_SHORT).show();
        }

//        double d = Double.parseDouble(input);
//        long l = long.parseLong(input);
//        mcalculator.inputValue = number; //给对象属性赋值

        int id = v.getId();
        switch(id) {
            case R.id.button:
                //加法结果
                result = mcalculator.plus(number, mcalculator.cacheResult);
                //将上次显示的结果缓存在cacheResult中，作为下次计算式的缓存值
                mcalculator.cacheResult = result;
                //将计算结果显示在文本中
                resultTextView.setText(result + "");
                //每次计算完成后将输入文本框重置为0
                inputEditText.setText("");
//                Toast.makeText(this, "这是加法", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button2:
                result = mcalculator.sub(number, mcalculator.cacheResult);
                mcalculator.cacheResult = result;
                resultTextView.setText(result + "");
                inputEditText.setText("");
//                Toast.makeText(this, "这是减法", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button3:
                result = mcalculator.multi(number, mcalculator.cacheResult);
                mcalculator.cacheResult = result;
                resultTextView.setText(result + "");
                inputEditText.setText("");
//                Toast.makeText(this, "这是乘法", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button4:
                result = mcalculator.deliver(number, mcalculator.cacheResult);
                mcalculator.cacheResult = result;
                resultTextView.setText(result + "");
                inputEditText.setText("");
//                Toast.makeText(this, "这是除法", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button5:
//                Toast.makeText(this, "这是等于号", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }
}
