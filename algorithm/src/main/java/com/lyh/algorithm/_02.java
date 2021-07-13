package com.lyh.algorithm;

import com.lyh.algorithm.listnode.ListNode;

import java.util.LinkedList;

public class _02 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        int capcity=0;
        LinkedList<Integer> result=new LinkedList<>();
        while (l1.next!=null&&l2.next!=null){
            int total=l1.value+l2.value+capcity;
            if (total >= 10) {
                result.add(total - 10);
                capcity=1;
            } else {
                result.add(total);
                capcity=0;
            }
            l1=l1.next;
            l2=l2.next;
        }


        return null;
    }

}
