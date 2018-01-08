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
    public int cacheResult = 0;
    /**
     * 上次运算符号
     */
    public int lastMark = -1;

    /**
     * 加法
     * @param input 输入的值
     * @param cache 上次显示的值
     * @return
     */
    public int plus(int input, int cache) {
        return input + cache;
    }

    /**
     * 減法
     * @param input
     * @param cache
     * @return
     */
    public int sub(int input, int cache) {
        return cache - input;
    }

    /**
     * 乘法
     * @param input
     * @param cache
     * @return
     */
    public int multi(int input, int cache) {
        return input * cache;
    }

    /**
     * 除法
     * @param input
     * @param cache
     * @return
     * @throws ArithmeticException
     */
    public int deliver(int input, int cache) throws ArithmeticException {
        return cache / input;
    }

    public int calc(int inputValue, int cacheResult, int calcType) throws ArithmeticException {
        int resultValue = 0;
        switch (calcType) {
            case 0:
                resultValue = plus(inputValue, cacheResult);
                break;
            case 1:
                resultValue = sub(inputValue, cacheResult);
                break;
            case 2:
                resultValue = multi(inputValue, cacheResult);
                break;
            case 3:
                resultValue = deliver(inputValue, cacheResult);
                break;
        }
        return resultValue;
    }
}








