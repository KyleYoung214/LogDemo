package com.kyle.demo.strategy;

/**
 * Created by Kyle on 2017/10/11 0011.
 */

public class QuickSort implements ISortIntegers {
    @Override
    public void sort(int[] unsortedIntegers) {
        quickSort(unsortedIntegers, 0, unsortedIntegers.length - 1);
    }

    private void quickSort(int data[], int low, int high) {
        if (low < high) {
            int middle = getMiddle(data, low, high);
            quickSort(data, low, middle - 1);
            quickSort(data, middle + 1, high);
        }
    }

    private int getMiddle(int[] data, int low, int high) {
        int tmp = data[low];
        while (low < high) {
            while (low < high && data[high] >= tmp) {
                high--;
            }
            data[low] = data[high];

            while (low < high && data[low] <= tmp) {
                low++;
            }
            data[high] = data[low];
        }
        data[low] = tmp;
        return low;
    }
}
