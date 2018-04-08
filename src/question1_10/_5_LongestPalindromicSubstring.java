package question1_10;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

 Example:

 Input: "babad"

 Output: "bab"

 Note: "aba" is also a valid answer.



 Example:

 Input: "cbbd"

 Output: "bb"

 */
public class _5_LongestPalindromicSubstring {
    private static int start=0,maxLength=0;
    public static void main(String[] args){
        Scanner sc  = new Scanner(System.in);
        String input = sc.next();
        System.out.println(longestPalindromicSubstring(input));
    }
    public static String longestPalindromicSubstring(String str){
        int len = str.length();
        if(len < 2){
            return str;
        }
        for(int i=0;i<len;i++){
            extendPalindrome(str,i,i);//从中间向两边遍历
            extendPalindrome(str,i,i+1);//判断相邻的是否重复
        }
        return str.substring(start,start+maxLength);
    }
    private static void extendPalindrome(String str,int j ,int k){
        while (j>=0 && k<str.length()&&str.charAt(j)==str.charAt(k)){
            j--;
            k++;
        }
        if (maxLength < k-j-1){
            //退出循环之前，先j--，再判断条件，条件不符合退出循环，所以符合条件的最小值为j+1
            start = j+1;
            //同理，最后一次符合条件的值应该为j+1,k-1,它们之间的长度应该为(k-1)-(j+1)+1=k-j-1
            //例如，退出循环时，j=1,k=5
            //最后一次符合循环的值为，j=2,k=4
            //它们的长度为3即2,3,4
            maxLength = k - j - 1;
        }
    }
}
