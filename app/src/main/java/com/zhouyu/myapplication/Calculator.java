package com.zhouyu.myapplication;

/**
 * Created by fuyue on 2018/1/3.
 */

public class Calculator {

    /**
     * 加
     */
    public static final int PLUS = 0;
    /**
     * 减
     */
    public static final int SUB = 1;
    /**
     * 乘
     */
    public static final int MULTI = 2;
    /**
     * 除
     */
    public static final int DELIVER = 3;

    /**
     * 输入值
     */
    public int inputValue;
    /**
     * 默认值，0
     */
    public static final int DEFAULT_VALUE = 0;
    /**
     * 上次计算结果
     */
    public static int cacheResult;

    public int plus(int a, int b) {
        return a + b;
    }

    public int sub(int a, int b) {
        return a - b;
    }

    public int multi(int a, int b) {
        return a * b;
    }

    public int deliver(int a, int b) throws ArithmeticException {
        return a / b;
    }
}
