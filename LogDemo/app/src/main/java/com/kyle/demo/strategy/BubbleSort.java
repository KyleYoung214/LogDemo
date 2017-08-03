package com.kyle.demo.strategy;

/**
 * Created by Kyle on 2017/8/3 0003.
 */

public class BubbleSort implements ISortIntegers {
    @Override
    public void sort(int[] unsortedIntegers) {
        int len = unsortedIntegers.length;
        int tmp;

        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len - i - 1; j++) {
                if (unsortedIntegers[j] > unsortedIntegers[j + 1]) {
                    tmp = unsortedIntegers[j];
                    unsortedIntegers[j] = unsortedIntegers[j + 1];
                    unsortedIntegers[j + 1] = tmp;
                }
            }
        }
    }
}
