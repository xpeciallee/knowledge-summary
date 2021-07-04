package com.lyh.algorithm;

import com.lyh.algorithm.listnode.ListNode;

public class _142 {
    public static void main(String[] args) {

    }
  //2i=L+b+c2*(b+c)
    //i=L+b+c1*(b+c)
    public ListNode getNode(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        if (head.next == head) {
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (true) {
            if (fast.next == null || fast.next.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                slow = head;
                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return fast;
            }
        }


    }
}
