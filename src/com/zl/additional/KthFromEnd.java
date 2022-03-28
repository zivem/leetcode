package com.zl.additional;


/**
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，
 * 即链表的尾节点是倒数第1个节点。例如，一个链表有6个节点，
 * 从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。
 * <p>
 * 链接：https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 * <p>
 * 返回链表 4->5.
 */
public class KthFromEnd {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        System.out.println("result1: " + ListNode.toString(getKthFromEnd(node1, 2)));
        System.out.println("result2: " + ListNode.toString(getKthFromEnd(node1, 6)));
        System.out.println("result3: " + ListNode.toString(getKthFromEnd(null, 2)));
    }


    public static ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode fast = head, slow = head;
        int t = 0;
        while (fast != null) {
            if (t >= k) {
                //如果k大于链表长度，此时slow指向的还是head，返回整个链表
                slow = slow.next;
            }
            fast = fast.next;
            t++;
        }
        return slow;
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    public static String toString(ListNode node) {
        String s = new String();
        while (node != null) {
            s += String.valueOf(node.val);
            node = node.next;
        }

        return s;
    }
}