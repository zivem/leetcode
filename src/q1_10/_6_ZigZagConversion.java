package q1_10;

/**
 *  The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

 P   A   H   N
 A P L S I I G
 Y   I   R

 And then read line by line: "PAHNAPLSIIGYIR"

 Write the code that will take a string and make this conversion given a number of rows:

 string convert(string text, int nRows);

 convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 */
public class _6_ZigZagConversion {
    public static void main(String[] args){
        String resut = conver("AB", 4);
        System.out.println(resut);
    }
    public static String conver(String str, int nRows){
        char[] c = str.toCharArray();
        int len = c.length;
        StringBuffer[] sb = new StringBuffer[nRows];
        for(int i = 0;i<sb.length;i++){
            sb[i]=new StringBuffer();
        }
        int i =0;
        while (i<len){
            //向下
            for (int idx = 0; idx < nRows && idx < len; idx++) // vertically down
            {
                sb[idx].append(c[i++]);
            }
            //向上时，除了第一行和最后一行，所以需要nRows-2
            for (int idx = nRows-2; idx >= 1 && idx < len; idx--) // obliquely up
            {
                sb[idx].append(c[i++]);
            }
        }
        //将结果拼接
        for (int idx = 1; idx < sb.length; idx++)
        {
            sb[0].append(sb[idx]);
        }
        return sb[0].toString();
    }
}
