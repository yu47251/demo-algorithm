package com.example.demo.algorithm.string;

/**
 * 
 * 给定两个字符串形式的非负整数num1 和num2，计算它们的和并同样以字符串形式返回。
 *
 * 你不能使用任何內建的用于处理大整数的库（比如 BigInteger），也不能直接将输入的字符串转换为整数形式。
 *
 * 思路：
 * 两个字符串数组相加，
 * 两个数组的同一位相加，记录结果，区分进位
 *
 * 
 * @author Eric Wang
 * @since 2022/5/20 17:55
 */
public class Add {
    public String addStrings(String nums1, String nums2){
        if("0".equals(nums1) && "0".equals(nums2)){
            return "0";
        } else if("0".equals(nums1)){
            return nums2;
        } else if("0".equals(nums2)){
            return nums1;
        } else {
            int m = nums1.length() - nums2.length();
            if( m > 0 ){
                nums2 = intZero(m) + nums2;
            } if( m < 0 ){
                nums1 = intZero(-m) + nums1;
            }
        }
        return resultAdd(nums1, nums2);
    }

    public String resultAdd(String nums1, String nums2){
        String[] nums1Array = nums1.split("");
        String[] nums2Array = nums2.split("");
        int jw = 0;
        StringBuilder result = new StringBuilder();
        for (int i = nums1.length() - 1; i >= 0; i--) {
            String t = String.valueOf(Integer.valueOf(nums1Array[i]) + Integer.valueOf(nums2Array[i]) + jw);
            System.out.println(t + "----" + jw);
            jw = 0;
            if(t.length() == 2){
                jw = Integer.valueOf(String.valueOf(t.charAt(0)));
                result.insert(0 , t.charAt(1));
                if(i == 0 && jw != 0){
                    result.insert(0, jw);
                }
            } else {
                result.insert(0, t);
            }
        }
        return result.toString();
    }

    public void output(String[] array){
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ",");
        }
    }

    public String intZero(int length){
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < length; i++) {
            result.append("0");
        }
        return result.length() == 0 ? "" : result.toString();
    }

    public static void main(String[] args) {
        Add add = new Add();
        String t = add.addStrings("1", "9");
        System.out.println("result = " + t);
    }

}
