package com.zhouyu.sort;

import java.util.Arrays;

import static java.util.Arrays.*;

/**
 * Created by Tsubasa on 2018/1/5.
 */

public class Sort {
    public static Integer[] integerArr  = new Integer[]{11, 55, 33, 66, 22, 77, 88, 44, 99};

    public static Integer[] sort1() {
        Integer[] arrSort = Arrays.copyOf(integerArr, integerArr.length);
        Arrays.sort(arrSort);
        return arrSort;
    }

    public static Integer[] sort2() {
        Integer[] arrSort = Arrays.copyOf(integerArr, integerArr.length);
        for (int i = 0; i < integerArr.length ; i++) {
            for (int j = 0; j < integerArr.length ; j++) {
                if (arrSort[i] < arrSort[j]) {
                    Integer tmp = arrSort[j];
                    arrSort[j] = arrSort[i];
                    arrSort[i] = tmp;
                }
            }
        }
        return arrSort;
    }
}
