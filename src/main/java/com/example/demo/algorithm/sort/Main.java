package com.example.demo.algorithm.sort;

import org.apache.commons.lang3.RandomUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class Main {

    private static final int LEN = 10; // 随机数组长度
    private static final int REPEATS = 2; // 重复测试次数
    private static int[] array = newArray(LEN);
    private static int[] correct;

    static {
        print(array);
        correct = copy(array);
        Arrays.sort(correct);
        print(correct);
        System.out.println("=============");
    }


    public static void main(String[] args) {
        List<SortTimeInfo> list = new ArrayList<>();
        list.add(test(copy(array), new QuickSorter()));
//        list.add(test(copy(array), new ShellSorter()));
//        list.add(test(copy(array), new MergeSorter()));
//        list.add(test(copy(array), new SelectionSorter()));
//        list.add(test(copy(array), new InsertionSorter()));
//        list.add(test(copy(array), new BubbleSorter()));

        list.stream()
            .sorted(Comparator.comparing(SortTimeInfo::getAvg))
            .forEach(x -> System.out.println(x.toString()))
        ;

    }

    private static SortTimeInfo test(int[] array, Sorter sorter) {
        System.out.println(sorter.name() + " - 测试");
        long start = System.nanoTime();
        for (int i = 0; i < REPEATS; i++) {
            int[] copy = copy(array);
            sorter.sort(copy);
             print(copy);
            if (!checkSorted(copy)) { // 检查排序结果是否正确
                System.err.println(sorter.name() + "排序失败");
            }
        }
        long end = System.nanoTime();

        SortTimeInfo info = new SortTimeInfo();
        info.setName(sorter.name());
        info.setTotal(end - start);
        info.setAvg((end - start) / REPEATS);
        info.setLength(array.length);

        //         print(array);
        // 判断排序结果是否正确
        return info;
    }

    private static int[] copy(int[] array) {
        return Arrays.copyOf(array, array.length);
    }

    /**
     * 生成随机数组
     *
     * @param len 数组长度
     * @return 数组
     */
    private static int[] newArray(int len) {
        int[] array = new int[len];
        IntStream.range(0, len).forEach(i -> {
            array[i] = RandomUtils.nextInt(0, len * 10);
        });
        return array;
    }

    private static void print(int[] array) {
        int maxLength = 50;
        if (array.length > maxLength) {
            System.out.println(Arrays.toString(Arrays.copyOfRange(array, 0, maxLength)));
        } else {
            System.out.println(Arrays.toString(array));
        }
    }

    /**
     * 查询排序结果是否正确
     *
     * @param array 数组
     * @return 是否排序成功
     */
    private static boolean checkSorted(int[] array) {
        return Arrays.equals(array, correct);
    }

    static class SortTimeInfo {
        private String name;
        private long avg;
        private long total;
        private int length;

        public int getLength() {
            return length;
        }

        public void setLength(int length) {
            this.length = length;
        }

        @Override
        public String toString() {
            String template = "%s - 数组长度：%d - 平均耗时：%dns %dms %ds - 总耗时：%dns %dms %ds";
            return String.format(template, name, length, avg, (long) (avg / 1e6), (long) (avg / 1e9), total, (long) (total / 1e6), (long) (total / 1e9));
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public long getAvg() {
            return avg;
        }

        public void setAvg(long avg) {
            this.avg = avg;
        }

        public long getTotal() {
            return total;
        }

        public void setTotal(long total) {
            this.total = total;
        }
    }

}
