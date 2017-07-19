package com.kyle.demo.strategy;

/**
 * Created by Kyle on 2017/7/19 0019.
 */

public class InsertSort implements ISortIntegers {
    @Override
    public void sort(int[] unsortedIntegers) {
        for (int i = 1; i < unsortedIntegers.length; i++) {
            int tmp = unsortedIntegers[i];
            int j = i - 1;
            for (; j >= 0 && unsortedIntegers[j] > tmp; j--) {
                unsortedIntegers[j + 1] = unsortedIntegers[j];
            }
            unsortedIntegers[j + 1] = tmp;
        }
    }
}
