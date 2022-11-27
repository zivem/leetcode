package com.zl.str;

public class ExpressiveWords_809 {

    public int expressiveWords(String s, String[] words) {
        int n = 0;
        for (int i = 0; i < words.length; i++) {
            if (express(s, words[i])) {
                n++;
            }
        }
        return n;
    }

    private boolean express(String s, String word) {
        int i = 0, j = 0;
        int n = s.length(), m = word.length();
        while (i < n && j < m) {
            //判断字符是否一致
            if (s.charAt(i) != word.charAt(j)) {
                return false;
            }
            int sc = s.charAt(i);
            int iCnt = 0;
            //统计相同的有多少个
            while (i < n && sc == s.charAt(i)) {
                ++i;
                ++iCnt;
            }
            int wc = word.charAt(j);
            int jCnt = 0;
            while (j < m && wc == word.charAt(j)) {
                ++j;
                ++jCnt;
            }
            //超过目标字符串字符数量
            if (iCnt < jCnt) {
                return false;
            }
            if(iCnt != jCnt && iCnt < 3){
                return false;
            }
        }
        return i == n && j == m;
    }


}
