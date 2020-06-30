package additional;

import sun.util.resources.cldr.rn.LocaleNames_rn;

/**
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问   可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * 示例1
 * <p>
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1
 * 示例2
 * <p>
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
 */
public class CuttingRopeQuestion {
    public static void main(String[] args) {
        int length = 10;
        System.out.println(solution1(length));;
        System.out.println(solution2(length));
        System.out.println(solution3(length));
    }

    public static int solution1(int length) {
        if (length <= 3) {
            return length - 1;
        }
        int a = length / 3;
        int b = length % 3;
        if (b == 0) {
            return (int) Math.pow(3, a);
        } else if (b == 1) {
            return (int) Math.pow(3, a - 1) * 4;
        } else {
            return (int) (Math.pow(3, a) * 2);
        }
    }

    public static int solution2(int len) {
        if (len <= 3) {
            return len - 1;
        }
        int[] dp = {1, 2, 3};
        for (int i = 3; i < len; i++) {
            int temp = Math.max(3 * dp[0], Math.max(2 * dp[1], 1 * dp[2]));
            dp[0] = dp[1];
            dp[1] = dp[2];
            dp[2] = temp;
        }
        return dp[2];
    }

    public static int solution3(int len){
        if(len <= 3){
            return len-1;
        }
        int a = len /3;
        if(len - 3*a == 1){
            a--;
        }
        int b = (len - 3*a)/2;
        return (int) (Math.pow(3, a) * Math.pow(2, b));
    }
}
