package com.example.demo.algorithm.sort;

import org.apache.commons.lang3.ArrayUtils;

/**
 * 选择排序
 */
public class SelectionSorter implements Sorter {
    @Override
    public String name() {
        return "选择排序";
    }

    @Override
    public void sort(int[] array, int fromIndex, int toIndex) {

        for (int i = fromIndex; i < toIndex; i++) {
            int minIndex = i;
            int minValue = array[i];
            // 查找后续数组中的最小值
            for (int j = i + 1; j < toIndex; j++) {
                if (array[j] < minValue) {
                    minIndex = j;
                    minValue = array[j];
                }
            }
            if (minIndex != i) {
                // 与最小值交换位置
                ArrayUtils.swap(array, i, minIndex);
            }
        }
    }
}
