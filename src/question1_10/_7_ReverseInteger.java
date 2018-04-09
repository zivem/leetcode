package question1_10;

/**
 * 7.Reverse Integer
 *
 * Given a 32-bit signed integer, reverse digits of an integer.

 Example 1:

 Input: 123
 Output:  321

 Example 2:

 Input: -123
 Output: -321

 Example 3:

 Input: 120
 Output: 21

 Note:
 Assume we are dealing with an environment which could only hold integers within the 32-bit signed integer range. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 */

public class _7_ReverseInteger {
    public int reverse(int x) {
        /*int result = 0;
        boolean flag=false;
        if(x<0){
            flag=true;
        }
        x=Math.abs(x);
        while (x>0){
            int end = x%10;
            result=result*10+end;
            if(result>Integer.MAX_VALUE || result < Integer.MIN_VALUE){
                return 0;
            }
        }
        if(flag){
            result=result*(-1);
        }
        return result;*/
        int result=0;
        while(x!=0){
            int end = x%10;
            int newResult = result *10 +end;
            if((newResult -end)/10 != result){
                return 0;
            }
            result=newResult;
            x=x/10;
        }
        return result;
    }
}
