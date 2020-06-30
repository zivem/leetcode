package additional;

import java.util.Arrays;

/**
 * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 示例1
 * <p>
 * 输入: [10,2]
 * 输出: "102"
 * 示例2
 * <p>
 * 输入: [3,30,34,5,9]
 * 输出: "3033459"
 */
public class MinNumberQuestion {
    public static void main(String[] args) {
        int[] nums1 = new int[]{10, 2};
        int[] nums2 = new int[]{3, 30, 34, 5, 9};
        System.out.println("solution1 result1: " + minNumber1(nums1));
        System.out.println("solution1 result2: " + minNumber1(nums2));
        System.out.println("solution2 result1: " + minNumber2(nums1));
        System.out.println("solution2 result2: " + minNumber2(nums2));
    }

    public static String minNumber1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        String[] numStrs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numStrs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(numStrs, (m, n) -> (m + n).compareTo(n + m));
        String result = new String();
        for (String s : numStrs) {
            result += s;
        }
        return result;
    }

    public static String minNumber2(int[] nums) {
        String[] numStrs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numStrs[i] = String.valueOf(nums[i]);
        }
        quickSort(numStrs, 0, numStrs.length - 1);
        String result = new String();
        for (String s : numStrs) {
            result += s;
        }
        return result;
    }


    public static void quickSort(String[] arr, int start, int end) {
        if (arr.length <= 0) {
            return;
        }
        if (start >= end) {
            return;
        }

        int i = start;
        int j = end;
        String temp = arr[i];
        while (i < j) {
            while ((arr[j] + arr[start]).compareTo(arr[start] + arr[j]) >= 0 && i < j) {
                j--;
            }
            arr[i] = arr[j];
            while ((arr[i] + arr[start]).compareTo(arr[start] + arr[i]) <= 0 && i < j) {
                i++;
            }
            arr[j] = arr[i];
        }
        arr[i] = temp;
        quickSort(arr, start, i - 1);
        quickSort(arr, i + 1, end);
    }


}
