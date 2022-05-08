package com.zl.arr;

import java.util.HashSet;
import java.util.Vector;

/**
 * https://leetcode-cn.com/problems/longest-consecutive-sequence/
 */
public class LongestConsecutive_128 {

    public static void main(String[] args) {
        int[] nums = new int[]{1,10,2,4,6,8,4,3};
        System.out.println(longestConsecutive(nums));
    }



    public static int longestConsecutive(int[] nums) {
        if(nums.length <= 1){
            return nums.length;
        }
        HashSet<Integer> set = new HashSet<>(nums.length);
        for (int i: nums) {
            set.add(i);
        }

        int max=0;
        for (int num : set) {
            int cur = num;
            // 只有当num-1不存在时，才开始向后遍历num+1，num+2，num+3......
            if (!set.contains(cur - 1)) {
                while (set.contains(cur + 1)) {
                    cur++;
                }
            }
            // [num, cur]之间是连续的，数字有cur - num + 1个
            max = Math.max(max, cur - num + 1);
        }
        return max;
    }
}
