package com.zl.other.d1;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 10
 * -100 <= matrix[i][j] <= 100
 *
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 *
 *
 * <p>
 * 解题思路：
 * <p>
 * int[] x = {-1,0,1,0}  x坐标，往左减一，往右加一，上下不变
 * <p>
 * int[] y = {0,-1,0,1}  y坐标，往上减一，往下加一，左右不变
 * <p>
 * 临界值：
 * <p>
 * 1.  数组为1： n>=1,m>=1  ; when n=m=1, return matrix
 * 2.  x边界， 0 <= i <= m
 */

public class SpiralOrder {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        List<Integer> res = spiralOrder(matrix);
        for (int i = 0; i < res.size(); i++) {
            System.out.printf(res.get(i)+",");
        }

    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        //接收结果
        List<Integer> res = new ArrayList<>(n * m);
        if (n == 0) return res;
        //走过的路
        boolean[][] st = new boolean[n][m];
        //x ,y向左，上，右，下，移动位置变化
        int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
        int x = 0, y = 0, d = 1;//k=1表明是顺时针
        for (int k = 0; k < n * m; k++) {
            res.add(matrix[x][y]);
            st[x][y] = true;
            int a = x + dx[d], b = y + dy[d];
            //边界判断
            if (a < 0 || a >= n || b < 0 || b >= m || st[a][b]) {
                //换方向
                d = (d + 1) % 4;
                a = x + dx[d];
                b = y + dy[d];
            }
            x = a;
            y = b;
        }
        return res;
    }
}
