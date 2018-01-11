package com.mm.sort;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.mm.myapplication.R;
import com.mm.sort.Sort;

import static com.mm.sort.Sort.integerArr;

/**
 * Created by Tsubasa on 2018/1/5.
 */

public class SortActivity extends Activity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sort);

        TextView s0 = (TextView) findViewById(R.id.s0);
        TextView s1 = (TextView) findViewById(R.id.s1);
        TextView s2 = (TextView) findViewById(R.id.s2);
        Integer[] sortArr1 = Sort.sort1();
        Integer[] sortArr2 = Sort.sort2();
        s0.setText(String.format("%d %d %d %d %d %d %d %d %d", integerArr[0], integerArr[1], integerArr[2], integerArr[3], integerArr[4], integerArr[5], integerArr[6], integerArr[7], integerArr[8]));
        s1.setText(String.format("%d %d %d %d %d %d %d %d %d", sortArr1[0], sortArr1[1], sortArr1[2], sortArr1[3], sortArr1[4], sortArr1[5], sortArr1[6], sortArr1[7], sortArr1[8]));
        s2.setText(String.format("%d %d %d %d %d %d %d %d %d", sortArr2[0], sortArr2[1], sortArr2[2], sortArr2[3], sortArr2[4], sortArr2[5], sortArr2[6], sortArr2[7], sortArr2[8]));
    }
}
