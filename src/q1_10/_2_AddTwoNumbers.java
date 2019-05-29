package q1_10;

/**
 * Add Two Numbers
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Example
 * <p>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */
public class _2_AddTwoNumbers {

    private static ListNode l1 = new ListNode(0);
    private static ListNode l2 = new ListNode(1);

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode c1 = l1;          //赋值引用，指向同一地址
        ListNode c2 = l2;
        ListNode sentinel = new ListNode(0);
        ListNode d = sentinel;
        int sum = 0;
        while (c1 != null || c2 != null) {
            sum /= 10;               //判断是否有进位
            if (c1 != null) {         //判断是否还有数值
                sum += c1.val;
                c1 = c1.next;
            }
            if (c2 != null) {        //判断是否还有数值
                sum += c2.val;
                c2 = c2.next;
            }
            d.next = new ListNode(sum % 10);  //sentinel也在添加相同的对象
            d = d.next;
        }
        if (sum / 10 == 1) {
            d.next = new ListNode(1);
        }
        return sentinel.next;
    }

    public static void main(String[] args) {
        ListNode c = addTwoNumbers(l1, l2);
        while (c != null) {
            System.out.println(c.val);
        }
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}