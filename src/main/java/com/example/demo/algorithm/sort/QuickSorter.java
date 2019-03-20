package com.example.demo.algorithm.sort;

import org.apache.commons.lang3.ArrayUtils;

public class QuickSorter implements Sorter {

    @Override
    public String name() {
        return "快速排序";
    }

    @Override
    public void sort(int[] array, int fromIndex, int toIndex) {
        int len = toIndex - fromIndex;
        if (len < 2) return;
        if (len == 2) {
            if (array[fromIndex] > array[fromIndex + 1]) {
                ArrayUtils.swap(array, fromIndex, fromIndex + 1);
            }
            return;
        }
        int pivot = array[fromIndex]; // 取第一位作为基准值
        int i = fromIndex + 1;
        int j = toIndex - 1; // 最后一位的下标
        for (; i < toIndex; i++) {
            if (array[i] >= pivot) { // 如果大于基准
                // 如果大于基准，从后往前找一个小于基准的，与之替换
                boolean exists = false;
                for (; j > i; j--) {
                    if (array[j] < pivot) {
                        exists = true;
                        ArrayUtils.swap(array, i, j);
                        j--;
                        break;
                    }
                }
                if (!exists) { // 如果不存在小于基准的值
                    break;
                }
            }
        }

        if (i > fromIndex + 1) {
            // 把基准值与最后一个小于基准的值互换位置，使基准值处在中间位置，左侧都小于基准值，右侧都大于或者等于基准值
            ArrayUtils.swap(array, fromIndex, i - 1);
            sort(array, fromIndex, i); // 把左侧进行排序，注意左开右闭
            sort(array, i, toIndex); // 把右侧进行排序
        } else {
            // 如果没有比基准值小的值，说明基准值位置正确，把右侧做为一组排序
            sort(array, fromIndex + 1, toIndex);
        }

    }
}
