package com.example.tsubasa.myapplication;

import com.mm.sort.Sort;

import org.junit.Test;

/**
 * Created by Tsubasa on 2018/1/5.
 */

public class SortTest {
    @Test
    public void testArraySort() {
        for (Integer integer : Sort.sort1()) {
            System.out.print(integer);
        }
        System.out.println();
        for (Integer integer : Sort.sort2()) {
            System.out.print(integer);
        }
    }
}
