package com.zl.tree.bt;

public class NumTrees {

    private static int[][] memo;

    public static void main(String[] args) {
        System.out.println(numTrees(3));
    }

    public static int numTrees(int n) {
        if (n <= 0) {
            return 0;
        }
        memo = new int[n + 1][n + 1];
        return count(1, n);
    }

    public static int count(int i, int n) {
        if (i > n) {
            return 1;
        }
        if (memo[i][n] != 0) {
            return memo[i][n];
        }

        int sum = 0;
        for (int j = i; j <= n; j++) {
            int left = count(i, j - 1);
            int right = count(j + 1, n);
            sum += left * right;
        }
        memo[i][n] = sum;
        return sum;
    }

}
