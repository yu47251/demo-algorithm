package com.example.demo.algorithm.array;

import java.util.Arrays;
import java.util.Date;

/**
 *
 * 给定高度m 、宽度n 的一张 m * n的乘法表，以及正整数k，你需要返回表中第k 小的数字。
 *
 * 思路：
 * 把所有m*n的可能性放到一个数组里面，
 * 排序，
 * 获取到数组下标为K的value
 *
 * @author Eric Wang
 * @since 2022/5/18 15:11
 */
public class FindKthNumber {
    public int find(int m, int n, int k){
        int[] array = new int[(m * n) ];
        int index = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                array[index] = i * j;
                index++;
            }
        }
        Arrays.sort(array);
        return array[k - 1];
    }

    public void output(int[] array){
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ",");
        }
    }

    public static void main(String[] args) {
        FindKthNumber find = new FindKthNumber();
        long start = new Date().getTime();
        int m = find.find(9895, 28405, 100787757);
        long end = new Date().getTime();
        System.out.println(end - start);
        System.out.println(m);
    }




}
