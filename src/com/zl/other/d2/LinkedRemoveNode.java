package com.zl.other.d2;

import com.zl.base.ListNode;

public class LinkedRemoveNode {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode f = head, p = head;
        for (int i = 0; i < n; i++) {
            p = p.next;
        }
        if (p == null) {
            return head;
        }
        while (p.next != null) {
            f = f.next;
            p = p.next;
        }
        f.next=f.next.next;
        return head;
    }
}
