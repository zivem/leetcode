package com.zl.box;

public class MaxNumOfBallInBox {

    public static void main(String[] args) {
        System.out.println(countBalls(1, 9));
    }

    public static int countBalls(int lowLimit, int highLimit) {
        if (lowLimit == highLimit) {
            return 1;
        }
        int[] box = new int[46];
        int index = sum(lowLimit);
        box[index]++;
        int s = 0;
        for (int i = lowLimit + 1; i <= highLimit; i++) {
            int num = zeroNum(i);
            index += 1 - 9 * num;
            box[index]++;
            s = Math.max(s, box[index]);
        }
        return s;
    }

    public static int sum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    public static int zeroNum(int num) {
        int n = 0;
        while (num % 10 == 0) {
            n++;
            num /= 10;
        }
        return n;
    }
}
