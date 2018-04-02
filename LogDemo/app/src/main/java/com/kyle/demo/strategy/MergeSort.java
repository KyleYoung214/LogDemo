package com.kyle.demo.strategy;

/**
 * Created by Kyle on 2017/10/23 0023.
 */

public class MergeSort implements ISortIntegers {
    @Override
    public void sort(int[] unsortedIntegers) {
        shellSort(unsortedIntegers, 0, unsortedIntegers.length - 1);
    }

    private void shellSort(int[] data, int left, int right) {
        if (left < right) {
            int center = (left + right) / 2;
            shellSort(data, left, center);
            shellSort(data, center + 1, right);
            merge(data, left, center, right);
        }

    }

    private void merge(int[] data, int left, int center, int right) {
        int[] tmpArr = new int[data.length];
        int tmp = left;
        int third = left;
        int mid = center + 1;

        while (left <= center && mid <= right) {
            if (data[left] <= data[mid]) {
                tmpArr[third++] = data[left++];
            } else {
                tmpArr[third++] = data[mid++];
            }
        }

        while (left <= center) {
            tmpArr[third++] = data[left++];
        }

        while (mid <= right) {
            tmpArr[third++] = data[mid++];
        }

        while (tmp <= right) {
            data[tmp] = tmpArr[tmp++];
        }
    }
}
