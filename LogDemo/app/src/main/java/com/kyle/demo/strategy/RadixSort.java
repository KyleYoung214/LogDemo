package com.kyle.demo.strategy;

import java.util.ArrayList;

/**
 * Created by Kyle on 2017/10/16 0016.
 */

public class RadixSort implements ISortIntegers {
    @Override
    public void sort(int[] unsortedIntegers) {
        int len = unsortedIntegers.length;
        int max = unsortedIntegers[0];
        for (int i = 1; i < len; i++) {
            if (max < unsortedIntegers[i]) {
                max = unsortedIntegers[i];
            }
        }

        int time = 0;
        while (max > 0) {
            max /= 10;
            time++;
        }

        ArrayList<ArrayList<Integer>> queue = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            queue.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < time; i++) {
            for (int j = 0; j < len; j++) {
                int x = unsortedIntegers[j] % (int) Math.pow(10, i + 1) / (int) Math.pow(10, i);
                ArrayList<Integer> q1 = queue.get(x);
                q1.add(unsortedIntegers[j]);
                queue.set(x, q1);
            }

            int counter = 0;
            for (int k = 0; k < 10; k++) {
                while (queue.get(k).size() > 0) {
                    ArrayList<Integer> q2 = queue.get(k);
                    unsortedIntegers[counter++] = q2.get(0);
                    q2.remove(0);
                }
            }
        }
    }
}
