package com.kyle.demo.strategy;

/**
 * Created by Kyle on 2017/10/23 0023.
 */

public class ShellSort implements ISortIntegers {
    @Override
    public void sort(int[] unsortedIntegers) {
        double d1 = unsortedIntegers.length;

        int temp;
        while (true) {
            d1 = d1 / 2;
            int d = (int) Math.ceil(d1);
            for (int x = 0; x < d1; x++) {
                for (int i = x + d; i < unsortedIntegers.length; i += d) {
                    int j = i - d;
                    temp = unsortedIntegers[i];
                    for (; j >= 0 && unsortedIntegers[j] > temp; j -= d) {
                        unsortedIntegers[j + d] = unsortedIntegers[j];
                    }
                    unsortedIntegers[j + d] = temp;
                }
            }

            if (d1 == 1) {
                break;
            }
        }
    }
}
