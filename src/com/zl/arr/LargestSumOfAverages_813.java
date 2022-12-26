package com.zl.arr;

public class LargestSumOfAverages_813 {
    public double largestSumOfAverages(int[] nums, int k) {
        int n = nums.length;
        double[] sum = new double[n + 1];
        if (n == 1) {
            return nums[0];
        }

        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        double[][] dp = new double[n + 1][k + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < Math.min(i, k); j++) {
                if (j == 1) {
                    dp[i][1] = sum[i] / i;
                } else {
                    for (int m = 2; m <= i; m++) {
                        dp[i][j] = Math.max(dp[i][j], dp[k - 1][j - 1] + (sum[i] - sum[m - 1]) / (i - m + 1));
                    }
                }
            }
        }

        return dp[n][k];
    }
}
