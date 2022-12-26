package com.zl.arr;

/**
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * <p>
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 * <p>
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -106 <= nums1[i], nums2[i] <= 106
 */
public class FndMedianSortedArrays_4 {

    public static void main(String[] args) {
        int[] nums1 = {1,2};
        int[] nums2 = {3,4};
        System.out.println(solution1(nums1, nums2));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        return 0.9;
    }

    public static double solution1(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        if (n == 0) {
            return getMid(nums2);
        }
        if (m == 0) {
            getMid(nums1);
        }
        int i = 0, j = 0, count = 0;
        int[] nums = new int[m + n];
        while (count != m + n) {
            if (i == n) {
                //数组1已经遍历结束
                while (j < m) {
                    nums[count++] = nums2[j++];
                }
                break;
            }
            if (j == m) {
                //数组2遍历完毕
                while (i < n) {
                    nums[count++] = nums1[i++];
                }
                break;
            }

            if (nums1[i] < nums2[j]) {
                nums[count++] = nums1[i++];
            } else {
                nums[count++] = nums2[j++];
            }
        }
        return getMid(nums);
    }

    public static double getMid(int[] nums) {
        int n = nums.length;
        if (n % 2 == 0) {
            return (nums[n/2 - 1] + nums[n/2]) % 2.0;
        } else {
            return nums[n/2];
        }
    }
}
