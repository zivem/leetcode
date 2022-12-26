package com.zl.tx;

public class MinimumMoves {
    public int minimumMoves(String s) {
        char[] chars = s.toCharArray();
        int sum=0;
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] == 'X'){
                i=i+2;
                sum++;
            }
        }
        return sum;
    }
}
