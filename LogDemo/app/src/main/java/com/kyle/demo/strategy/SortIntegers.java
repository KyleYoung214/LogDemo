package com.kyle.demo.strategy;

import com.kyle.demo.utils.LogUtils;

import java.util.Arrays;

/**
 * Created by Kyle on 2017/7/19 0019.
 */

public class SortIntegers {
    private ISortIntegers mSortMethod = null;
    private int[] mUnsortedIntegers = null;

    public SortIntegers() {

    }

    public void setSortMethod(ISortIntegers method) {
        mSortMethod = method;
    }

    public void setIntegers(int[] array) {
        mUnsortedIntegers = new int[array.length];
        System.arraycopy(array, 0, mUnsortedIntegers, 0, array.length);
    }

    public void sortAndPrint() {
        if (null != mSortMethod && null != mUnsortedIntegers) {
            print("Before sorted by " + mSortMethod.getClass().getSimpleName());
            mSortMethod.sort(mUnsortedIntegers);
            print("After sorted by " + mSortMethod.getClass().getSimpleName());
        } else {
            LogUtils.e("no sort method is set OR no numbers to print.");
        }
    }

    private void print(String info) {
        if (null != mUnsortedIntegers) {
            LogUtils.i(info + "\n" + Arrays.toString(mUnsortedIntegers));
        } else {
            LogUtils.e("no numbers to print.");
        }
    }

}
