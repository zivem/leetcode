package com.zl.arr;

/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii/
 */
public class RemoveDuplicates_80 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 2, 2, 3};
        int len = removeDuplicates(nums);
        System.out.println("length:" + len);
        StringBuffer sb = new StringBuffer(len);
        for (int i = 0; i < len; i++) {
            sb.append(nums[i]);
            sb.append(",");
        }
        System.out.println("nums:" + sb);
    }

    private static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        return process(nums, 2);
    }

    private static int process(int[] nums, int k) {
        int idx = 0;
        for (int x : nums) {
            //允许重复的个数为k, 前期个数小于k，则直接添加，后续只要判断从后往前数，第k个是否相等
            if (idx < k || nums[idx - k] != x) nums[idx++] = x;
        }
        return idx;
    }

}
