package com.kyle.demo.strategy;

/**
 * Created by Kyle on 2017/10/11 0011.
 */

public class HeapSort implements ISortIntegers {
    @Override
    public void sort(int[] unsortedIntegers) {
        int length = unsortedIntegers.length;
        for (int i = 0; i < length; i++) {
            buildMaxHeap(unsortedIntegers, length - 1 - i);
            swap(unsortedIntegers, 0, length - 1 - i);
        }
    }

    private void buildMaxHeap(int[] data, int lastIndex) {
        for (int i = (lastIndex - 1) / 2; i >= 0; i--) {
            int k = i;
            while (2 * k + 1 < lastIndex) {
                int biggerIndex = 2 * k + 1;
                if (biggerIndex < lastIndex) {
                    if (data[biggerIndex] < data[biggerIndex + 1]) {
                        biggerIndex++;
                    }
                }

                if (data[k] < data[biggerIndex]) {
                    swap(data, k, biggerIndex);
                    k = biggerIndex;
                } else {
                    break;
                }
            }
        }
    }

    private void swap(int[] data, int i, int j) {
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }

}
