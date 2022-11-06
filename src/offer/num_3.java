package offer;

/**
 * 题目描述：
 * <p>
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
 * 并保证奇数和奇数，
 * <p>
 * 偶数和偶数之间的相对位置不变。
 *
 *
 * <p>
 * 解题思路：
 * <p>
 * 首先，如果不考虑奇数和奇数，偶数和偶数的相对位置，那么我们有一种双指针解法来求解，类似于快排，维护两个指针，
 * 第一个指针指向数组的第一个数字，第二个指针指向数组的最后一个数字。第一个指针向后移，第二个指针向前移，如果第一个指针指向偶数，
 * 第二个指针指向的是奇数，则交换着两个数字，接着继续移动直到两指针相遇。
 * <p>
 * 上面的方法看似不错，但是对本题不适用，因为本题有相对位置不变的要求，
 * 直接交换会导致相对位置改变。因此，我们采用下面的思路来解决本题。
 * <p>
 * 本题解法：对数组进行遍历，设置两个指针even和odd，even指向当前第一个偶数，odd从这个偶数之后开始查找，
 * <p>
 * 找到第一个奇数，此时为了相对位置不变，不能直接交换even和odd，而是将从even到odd-1的元素都依次向后移一个位置，
 * 将odd指向的那个奇数放到even的位置。然后再找下一个偶数，重复这一过程，最终就可以将奇数都放到偶数的前面，并且保证了相对位置的不变。
 * <p>
 * 编程实现（Java）：
 */
public class num_3 {
    public static void main(String[] args){
        int[] arr = {1,2,4,5,6,8,7};
        int[] move = solution2(arr);
        for (int i = 0; i < move.length ; i++) {
            System.out.println(move[i]+",");
        }
    }

    /**
     * 位置会变化
     * @param arr
     * @return
     */
    public static int[] move(int[] arr) {
        if (arr.length == 0) {
            return new int[0];
        }
        if (arr.length == 1) {
            return arr;
        }

        int l = 0, r = arr.length - 1;

        while (l < r) {
            while ((l < r) && (arr[l] % 2 == 1)) {
                l++;
            }
            while ((l < r) && arr[r] % 2 == 0) {
                r--;
            }
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
        }
        return arr;
    }

    public static int[] solution2(int[] array){
        int k =0;
        for(int i = 0; i < array.length; ++i)
        {
            //找到奇数
            if(array[i] %2 == 1)
            {
                //从左向右，每次遇到的，都是最前面的奇数，一定将来要被放在k下标处
                int temp = array[i]; //现将当前奇数保存起来
                int j = i;
                while(j > k)
                {
                    //将该奇数之前的内容(偶数序列)，整体后移一个位置
                    array[j] = array[j-1];
                    j--;
                }
                //将奇数保存在它将来改在的位置，因为我们是从左往右放的，没有跨越奇数，所以一定是相对位置不变的
                array[k++] = temp;
            }
        }
        return array;
    }

}
