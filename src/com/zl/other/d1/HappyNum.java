package com.zl.other.d1;

public class HappyNum {
    public static void main(String[] args) {
        boolean happy = isHappy(19);
        System.out.println(happy);
    }



    public static boolean isHappy(int n) {
        int slow = n, fast = n;
        slow = bitSum(slow);
        fast = bitSum(fast);
        fast = bitSum(fast);
        while (slow != fast) {
            slow = bitSum(slow);
            fast = bitSum(fast);
            fast = bitSum(fast);
        }
        return slow == 1;
    }

    public static int bitSum(int num) {
        int sum = 0;
        while (num > 0) {
            int b = num % 10;
            sum += b * b;
            num /= 10;
        }

        return sum;
    }
}
