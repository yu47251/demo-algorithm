package com.example.demo.algorithm.sort;

/**
 * 排序
 */
public interface Sorter {

    /**
     * 排序算法的名字
     *
     * @return 名字
     */
    String name();

    /**
     * 数组排序
     *
     * @param array 数组
     */
    default void sort(int[] array) {
        sort(array, 0, array.length);
    }

    /**
     * 数组排序
     *
     * @param array     数组
     * @param fromIndex 需要排序的第一个元素下标，包括该元素
     * @param toIndex   需要排序的最后一个元素下标，不包括该元素
     */
    void sort(int[] array, int fromIndex, int toIndex);

}
