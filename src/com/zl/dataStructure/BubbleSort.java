package com.zl.dataStructure;

import java.util.Arrays;

/**
 * 冒泡排序
 * <p>
 * 算法步骤
 * <p>
 * 比较相邻的元素，如果第一个比第二个大，就交换他们两个；
 * <p>
 * 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。这步做完后，最后的元素会是最大的数；
 * <p>
 * 针对所有的元素重复以上的步骤，除了最后一个；
 * <p>
 * 持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
 */

public class BubbleSort {
    public static int[] sort(int[] sourceArr) {
        int[] arr = Arrays.copyOf(sourceArr, sourceArr.length);
        for (int i = 1; i < arr.length; i++) {
            for (int j = arr.length - 1; j >= i; j--) {
                System.out.println("比较：" + arr[j - 1] + "," + arr[j]);
                if (arr[j] < arr[j - 1]) {
                    System.out.println("交换：" + arr[j - 1] + "," + arr[j]);
                    int temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                    System.out.println("交换后为：");
                    printArr(arr);
                    System.out.println();
                }
            }
        }
        return arr;
    }

    public static void printArr(int[] arr) {
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空");
        } else {
            for (int i : arr) {
                System.out.print(i + ",");
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5, 2, 4, 3, 8};
        System.out.println("初始为：");
        printArr(arr);
        System.out.println();
        int[] result = sort(arr);
        System.out.println("排序后为：");
        printArr(result);
    }
}
