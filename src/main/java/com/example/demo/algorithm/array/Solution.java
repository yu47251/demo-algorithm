package com.example.demo.algorithm.array;

import org.springframework.util.StringUtils;

import java.util.Arrays;

/**
 *
 * 给定一个不重复的整数数组nums 。最大二叉树可以用下面的算法从nums 递归地构建:
 *
 * 创建一个根节点，其值为nums 中的最大值。
 * 递归地在最大值左边的子数组前缀上构建左子树。
 * 递归地在最大值 右边 的子数组后缀上构建右子树。
 * 返回nums 构建的 最大二叉树 。
 *
 * 举例：
 * 输入：nums = [3,2,1,6,0,5]
 * 输出：[6,3,5,null,2,0,null,null,1]
 *
 * 思路：
 * 1. 寻找到当前数组中最大的value，
 * 2. 截取数组中，第一个元素到value，初始化成一个数组，进行递归
 * 3. 截取数组中，value到最后一个元素，初始化成一个数组，进行递归
 *
 *
 * @author Eric Wang
 * @since 2022/5/5 15:18
*/
public class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums == null || nums.length == 0) return null;
        if(nums.length == 1) {
            return new TreeNode(nums[0], null, null);
        }
        if(nums.length > 1) {
            int max = findMax(nums);
            System.out.println(max);
            if(max != -1){
                return new TreeNode(max, constructMaximumBinaryTree(left(nums, max)), constructMaximumBinaryTree(right(nums, max)));
            } else {
                return null;
            }
        }
        return null;
    }

    public int[] left(int[] nums, int max){
        int index = findIndex(nums, max);
        if(index >= 0 ) {
            int[] result = new int[index];
            for (int i = 0; i < index; i++) {
                int item = nums[i];
                result[i] = item;
            }
            return result;
        } else {
            return null;
        }
    }

    public int[] right(int[] nums, int max){
        int index = findIndex(nums, max);
        // 如果index是nums的最后一个元素
        if(index == nums.length - 1) return null;
        if(index >= 0 ) {
            int[] result = new int[nums.length - (index + 1)];
            for (int i = index + 1; i < nums.length; i++) {
                result[i - (index + 1)] = nums[i];
            }
            return result;
        } else {
            return null;
        }
    }

    public int findMax(int[] arrays){
        if(arrays != null && arrays.length > 1){
            int t = Arrays.stream(arrays).max().getAsInt();
            return t;
        } else if(arrays.length == 1) {
            return arrays[0];
        } else {
            return -1;
        }
    }

    public int findIndex(int[] arrays, int val){
        for (int i = 0; i < arrays.length; i++) {
            if(arrays[i] == val){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
//        int[] array = {1,2,4,3,10,6,9,7,8};
        int[] array = {3,2,1,6,0,5};

        Solution s = new Solution();
        TreeNode node = s.constructMaximumBinaryTree(array);
        System.out.println(node);

    }
}

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }

 }