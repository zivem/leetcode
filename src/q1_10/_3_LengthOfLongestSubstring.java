package q1_10;

import sun.misc.Queue;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 * <p>
 * Example 1:
 * <p>
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 * <p>
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 * <p>
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _3_LengthOfLongestSubstring {

    public static void main(String[] args) {
        System.out.println(solution1("pwwkew"));
        System.out.println(solution2("pwwkew"));
    }

    public static int solution1(String s) {
        if (s == null) {
            return 0;
        }
        int max = 0;
        String subStr = "";
        for (int i = 0; i < s.length(); i++) {
            if (subStr.indexOf(s.charAt(i)) >= 0) {
                subStr = subStr.substring(subStr.indexOf(s.charAt(i)) + 1);
            }
            subStr += s.charAt(i);
            max = Math.max(max, subStr.length());
        }
        return max;
    }

    public static int solution2(String s){
        int maxSize = 0;
        int [] dict = new int[256]; //记录ASCII 码字符出现的位置，以字符作为下标
        int base = 0;
        int key = 0;
        int i=0;
        while(key < s.length()){
            i = s.charAt(key);
            if(dict[i] > base)
                base = dict[i];
            dict[i] = key+1; //以1作为起始位置，下标加1
            maxSize = (maxSize>key-base+1)?maxSize:key-base+1;
            key++;
        }
        return maxSize;
    }
}
