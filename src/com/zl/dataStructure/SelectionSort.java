package com.zl.dataStructure;

import java.util.Arrays;

/**
 * 选择排序
 * <p>
 * 首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置；
 * <p>
 * 再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾；
 * <p>
 * 重复第二步，直到所有元素均排序完毕。
 */
public class SelectionSort {
    public int[] sort(int[] sourceArray) throws Exception {
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        // 总共要经过 N-1 轮比较
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;

            // 每轮需要比较的次数 N-i
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    // 记录目前能找到的最小值元素的下标
                    min = j;
                }
            }
            // 将找到的最小值和i位置所在的值进行交换
            if (i != min) {
                int tmp = arr[i];
                arr[i] = arr[min];
                arr[min] = tmp;
            }
        }
        return arr;
    }
    public int maxArea(int[] height) {
        int area = 0 ;
        int r = height.length/2;
        int l = r+1;
        while (r>0 && l < height.length){
            area = Math.max(area,Math.min(height[r],height[l])*(l-r));
            if(height[r] < height[l]){
                r--;
            }else{
                l++;
            }
        }
        return area;
    }
}
