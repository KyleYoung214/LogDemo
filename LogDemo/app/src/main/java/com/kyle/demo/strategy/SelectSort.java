package com.kyle.demo.strategy;

/**
 * Created by Kyle on 2017/10/11 0011.
 */

public class SelectSort implements ISortIntegers {
    @Override
    public void sort(int[] unsortedIntegers) {
        int position = 0;
        for (int i = 0; i < unsortedIntegers.length; i++) {
            int tmp = unsortedIntegers[i];
            position = i;
            int j = i + 1;
            for (; j < unsortedIntegers.length; j++) {
                if (unsortedIntegers[j] < tmp) {
                    tmp = unsortedIntegers[j];
                    position = j;
                }
            }
            unsortedIntegers[position] = unsortedIntegers[i];
            unsortedIntegers[i] = tmp;

        }
    }
}
