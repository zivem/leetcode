package q1_10;

public class question3 {
    public static void main(String[] args) {
        int s = digitCounts(0, 12);
        System.out.println(s);
    }

    public static int digitCounts(int k, int n) {
        int current = 0;
        int before = 0;
        int after = 0;
        int index = 1, n_count = 0;
        if (n == 0 && k == 0) {
            return 1;
        }
        while (n / index != 0) {
            if (k == 0 && n / (index * 10) == 0) {//最高位不能为0
                break;
            }
            current = (n / index) % 10;
            before = n / (index * 10);
            after = n - n / index * index;
            if (current > k) {
                n_count = n_count + (before + 1) * index;
            } else if (current < k) {
                n_count = n_count + before * index;
            } else {
                n_count = n_count + before * index + after + 1;
            }
            index *= 10;
        }
        return n_count;
    }
}
