package question1_10;

import java.util.Scanner;

public class question2 {
    public static void main(String[] args){
        System.out.println(System.currentTimeMillis());
//        1.long result = trailingZeros(11);
        //2.超出int范围
        Scanner scanner = new Scanner(System.in);
        long result = trailingZeros(scanner.nextLong());
        System.out.println(result);
        System.out.println(System.currentTimeMillis());
    }
    public static long trailingZeros(long n) {
        long count=0;
        while(n/5>0){
            count=count+n/5;
            n=n/5;
        }
        return count;
    }
}
