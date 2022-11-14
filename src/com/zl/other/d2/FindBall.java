package com.zl.other.d2;

/**
 * 球下落，初始位置选择 0-grid.length
 * 每次下降，r都+1
 * grid[r][c] ->  下降，grid[r+1][c+1] 或 grid[r+1][c-1]
 * <p>
 * 左上角-> 右下角 ： 1
 * 右上角->左下角： -1
 * <p>
 * grid[r][c] 下降 可写为 grid[r+1][c+grid[r][c]]
 * <p>
 * 边界值：
 * 1.  0<=r<grid.length
 * 2. 0<=c<grid[0].length
 * 3.行成V型，左右两个相邻不相等，grid[r][c] != grid[r][c+1]
 * 以上3种都返回-1
 * <p>
 * 输入：grid = [[1,1,1,1,1,1],[-1,-1,-1,-1,-1,-1],[1,1,1,1,1,1],[-1,-1,-1,-1,-1,-1]]
 * 输出：[0,1,2,3,4,-1]
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 100
 * grid[i][j] 为 1 或 -1
 */

public class FindBall {
    int m, n;
    int[][] g;

    public int[] findBall(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        g = grid;
        if (m == 1 && n == 1) {
            return grid[0];
        }
        int[] res = new int[m];
        for (int i = 0; i < n; i++) {
            res[i] = getVal(i);
        }
        return res;
    }

    int getVal(int x) {
        int r = 0, c = x;
        while (r < m) {
            int ne = c + g[r][c];
            if (ne < 0 || ne >= n) return -1;
            if (g[r][c] != g[r][ne]) return -1;
            r++;
            c = ne;
        }
        return c;
    }
}
