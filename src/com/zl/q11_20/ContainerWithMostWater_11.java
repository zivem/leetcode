package com.zl.q11_20;

/**
 * Question : Container With Most Water
 * Given n non-negative integers a1, a2, ..., an ,
 * where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
 * Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 *
 * Note: You may not slant the container and n is at least 2.
 *
 * Example:
 *
 * Input: [1,8,6,2,5,4,8,3,7]
 * Output: 49
 */

/**
 * 盛水容器
 *
 * 给定n个非负整数a1，a2，…，an，其中每个表示一个坐标点（i，ai）。
 * n画垂直线，使线i的两个端点位于（i，ai）和（i，0）。找到两条线，与x轴一起构成一个容器，这样容器中的水就最多了。
 *
 * 注意：容器不能倾斜，n至少为2。
 */

/**
 * 思考：
 * 要想两线之间存储水最多，取决于面积=长*宽，长为两数之间位置间距，宽为两数中的小值
 *
 */

/**
 * Summary
 * We have to maximize the Area that can be formed between the vertical lines
 * using the shorter line as length and the distance between the lines as the width of the rectangle forming the area.
 *
 * Approach 1: Brute Force
 * Algorithm
 *
 * In this case, we will simply consider the area for every possible pair of the lines and find out the maximum area out of those.
 */

public class ContainerWithMostWater_11 {
    /**
     * Approach 1
     * Time complexity : T(n) = O(1+n+n*(n-1)*2)=O(2n^2-n+1)=O(n^2)
     * Space complexity : O(1) 除了height数组，无额外内存使用
     *
     * Calculating area for all n(n-1)/2  height pairs.
     */
    public static int maxArea1(int[] height) {
        int area = 0 ;
        for(int i = 0; i<height.length;i++){
            for(int j = i+1;j<height.length;j++){
                area = Math.max(area,Math.min(height[i],height[j]) * (j-i));
            }
        }
        return area;
    }

    /**
     * Approach 2 :Two Pointer Approach
     *
     * Algorithm
     *
     * The intuition behind this approach is that the area formed between the lines will always be limited by the height of the shorter line. Further, the farther the lines, the more will be the area obtained.
     *
     * We take two pointers, one at the beginning and one at the end of the array constituting the length of the lines. Futher, we maintain a variable \text{maxarea}maxarea to store the maximum area obtained till now. At every step, we find out the area formed between them, update \text{maxarea}maxarea and move the pointer pointing to the shorter line towards the other end by one step.
     *
     * Initially we consider the area constituting the exterior most lines.
     * Now, to maximize the area, we need to consider the area between the lines of larger lengths.
     * If we try to move the pointer at the longer line inwards,
     * we won't gain any increase in area, since it is limited by the shorter line.
     * But moving the shorter line's pointer could turn out to be beneficial, as per the same argument, despite the reduction in the width.
     * This is done since a relatively longer line obtained by moving the shorter line's pointer might overcome the reduction in area caused by the width reduction.
     *
     *
     *  Time complexity : t(n)= O(3+n)=O(n)
     *  Space complexity : O(1)
     */
    public static int maxArea2(int[] height) {
        int area = 0 ;
        int r = 0;
        int l = height.length-1;
        while (r < l){
            area = Math.max(area, Math.min(height[r],height[l]) * (l-r));
            if(height[r] < height[l]){
                r++;
            }else{
                l--;
            }
        }
        return area;
    }

    public static void main(String[] args){
        int[] height = new int[]{1,8,6,2,5,4,8,3,7};
        int area1 = maxArea1(height);
        int area2 = maxArea2(height);
        System.out.println("area1:"+area1);
        System.out.println("area2:"+area2);
    }
}
