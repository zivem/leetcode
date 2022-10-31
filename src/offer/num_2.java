package offer;

/**
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class num_2 {
    public static void main(String[] args) {
        int[][] nums = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        boolean solution = solution(nums, 7);
        System.out.println(solution);
    }

    /**
     * 从左上角（右下角）
     * 左边的数(8)总比（9）小，下面的数（12），总比（9）大
     * 与目标值相比，如果大于（9）就往左移动，比9大，往下移动
     * @param nums
     * @param target
     * @return
     */
    public static boolean solution(int[][] nums, int target) {
        if (nums.length == 0 || nums[0].length == 0) {
            return false;
        }
        int i = 0, j = nums.length - 1;
        while (i < nums.length && j >= 0){
            if(nums[i][j] == target){
                return true;
            }
            if(nums[i][j] > target){
                j--;
            }else {
                i++;
            }

        }

        return false;
    }
}
