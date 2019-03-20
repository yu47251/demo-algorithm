package com.example.demo.algorithm.sort;

/**
 * 插入排序
 */
public class InsertionSorter implements Sorter {
    @Override
    public String name() {
        return "插入排序";
    }

    @Override
    public void sort(int[] array, int fromIndex, int toIndex) {

        for (int i = fromIndex + 1; i < toIndex; i++) {
            int current = array[i];
            for (int j = i - 1; j >= fromIndex; j--) {
                if (array[j] < current) {
                    array[j + 1] = current;
                    break;
                } else {
                    array[j + 1] = array[j];
                    if (j == fromIndex) {
                        array[j] = current;
                    }
                }
            }
        }
    }
}
