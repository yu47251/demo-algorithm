package com.example.demo.algorithm.sort;

import org.apache.commons.lang3.ArrayUtils;

/**
 * 归并排序
 * <p>
 * 归并排序是建立在归并操作上的一种有效的排序算法。该算法是采用分治法（Divide and Conquer）的一个非常典型的应用。将已有序的子序列合并，得到完全有序的序列；即先使每个子序列有序，再使子序列段间有序。若将两个有序表合并成一个有序表，称为2-路归并。
 * <p>
 * 算法描述
 * <ul>
 * <li>
 * 把长度为n的输入序列分成两个长度为n/2的子序列；
 * </li>
 * <li>
 * 对这两个子序列分别采用归并排序；
 * </li>
 * <li>
 * 将两个排序好的子序列合并成一个最终的排序序列。
 * </li>
 * </ul>
 */
public class MergeSorter implements Sorter {

    @Override
    public String name() {
        return "归并排序";
    }

    @Override
    public void sort(int[] array, int fromIndex, int toIndex) {
        int l = toIndex - fromIndex;
        if (l < 2) return;
        if (l == 2) {
            if (array[fromIndex] > array[fromIndex + 1]) {
                ArrayUtils.swap(array, fromIndex, fromIndex + 1);
            }
            return;
        }
        int subToIndex = fromIndex + l / 2 + 1; // 因为sort方法，排序区间是左闭右开的，所以需要 + 1
        sort(array, fromIndex, subToIndex);
        sort(array, subToIndex, toIndex);
        int[] subArray = new int[l];
        for (int i = fromIndex, j = subToIndex, k = 0; k < l; k++) {
            if (j >= toIndex) {
                subArray[k] = array[i];
                i++;
            } else if (i >= subToIndex) {
                subArray[k] = array[j];
                j++;
            } else if (array[i] <= array[j]) {
                subArray[k] = array[i];
                i++;
            } else {
                subArray[k] = array[j];
                j++;
            }
        }
        System.arraycopy(subArray, 0, array, fromIndex, l);
    }
}
