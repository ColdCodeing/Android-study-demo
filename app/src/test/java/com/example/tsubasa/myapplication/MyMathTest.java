package com.example.tsubasa.myapplication;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Tsubasa on 2018/1/3.
 */

public class MyMathTest {
    @Test
    public void testAdd() {
        Integer result = MyMath.add(1,1);
        Assert.assertNotNull(result);
        Assert.assertEquals(result, new Integer(2));
    }

    @Test
    public void testSub() {
        Integer result = MyMath.subtract(1,1);
        Assert.assertNotNull(result);
        Assert.assertEquals(result, new Integer(0));
    }
    @Test
    public void testMul() {
        Integer result = MyMath.multiply(1,1);
        Assert.assertNotNull(result);
        Assert.assertEquals(result, new Integer(1));
    }
    @Test
    public void testDiv() {
        Integer result = MyMath.divide(8,3);
        Assert.assertNotNull(result);
        Assert.assertEquals(result, new Integer(8/3));
    }
}
