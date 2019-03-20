package com.example.demo.algorithm.sort;

import org.apache.commons.lang3.ArrayUtils;

/**
 * 冒泡排序
 */
public class BubbleSorter implements Sorter {


    @Override
    public String name() {
        return "冒泡排序";
    }

    /**
     * 数据排序-冒泡算法
     *
     * @param array 数组
     */
    @Override
    public void sort(int[] array, int fromIndex, int toIndex) {
        boolean change = false; // 标记是否有改变
        for (int i = fromIndex; i < toIndex - 1; i++) {

            for (int j = fromIndex; j < toIndex - (i - fromIndex) - 1; j++) {
                if (array[j] > array[j + 1]) {
                    // 交换两个数的位置
                    ArrayUtils.swap(array, j, j + 1);
                    change = true;
                }
            }

            if (change) {
                change = false;
            } else {
                break; // 如果该次循环没有变化，直接跳出循环
            }
        }
    }
}
