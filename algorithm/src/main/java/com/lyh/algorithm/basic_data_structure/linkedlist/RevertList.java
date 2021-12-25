package com.lyh.algorithm.basic_data_structure.linkedlist;

import com.lyh.algorithm.listnode.ListNode;

public class RevertList {

    /**
     * 链表的基本形式是： 1 -> 2 -> 3 -> null ，
     * 反转需要变为 3 -> 2 -> 1 -> null 。这里要注 意：
     * 访问某个节点 curt.next 时，要检验 curt 是否为 null。
     * 要把反转后的最后一个节点（即反转前的第一个节点）指向 null
     *
     * @param head
     * @return
     */
    public ListNode revert(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    class DListNode {
        int val;
        DListNode prev, next;

        DListNode(int val) {
            this.val = val;
            this.prev = this.next = null;
        }
    }

    /**
     * 删除链表中的某个节点一定需要知道这个点的前继节点，
     * 所以需要一直有指针指向前继节点。还有一种 删除是伪删除，
     * 是指复制一个和要删除节点值一样的节点，然后删除，这样就不必知道其真正的前继节 点了。
     * 然后只需要把 prev -> next = prev -> next -> next 即可。
     * 但是由于链表表头可能在这个过程 中产生变化，导致我们需要一些特别的技巧去处理这种情况。就是下面提到的 Dummy Node。
     */

    /**
     * 综合上面讨论的两种基本操作，链表操作时的鲁棒性问题主要包含两个情况：
     * 当访问链表中某个节点 curt.next 时，一定要先判断 curt 是否为 null。
     * 全部操作结束后，判断是否有环；若有环，则置其中一端为 null。
     *
     * Dummy node 是链表问题中一个重要的技巧，中文翻译叫“哑节点”或者“假人头结点”。 Dummy node 是一个虚拟节点，也可以认为是标杆节点。Dummy node 就是在链表表头 head 前加 一个节点指向 head，即 dummy -> head。Dummy node 的使用多针对单链表没有前向指针的问 题，保证链表的 head 不会在删除操作中丢失。除此之外，还有一种用法比较少见，就是使用 dummy node 来进行head的删除操作，
     * 比如 Remove Duplicates From Sorted List II，
     * 一般的方法 current = current.next 是无法删除 head 元素的，
     * 所以这个时候如果有一个dummy node在 head的前面。
     * 所以，当链表的 head 有可能变化（被修改或者被删除）时，
     * 使用 dummy node 可以很好的简化代 码，最终返回 dummy.next 即新的链表。
     */

    /**
     * 快慢指针也是一个可以用于很多问题的技巧。
     * 所谓快慢指针中的快慢指的是指针向前移动的步长，
     * 每次 移动的步长较大即为快，步长较小即为慢
     * ，常用的快慢指针一般是在单链表中让快指针每次向前移动
     *
     * 2，慢指针则每次向前移动
     * 1。快慢两个指针都从链表头开始遍历，
     * 于是快指针到达链表末尾的时候慢指针刚好到达中间位置，
     * 于是可以得到中间元素的值。
     * 快慢指针在链表相关问题中主要有两个应用：
     * 快速找出未知长度单链表的中间节点
     * 设置两个指针 *fast 、 *slow 都指向单链表的头节点，
     * 其中 *fast 的移动速度 是 *slow 的2倍，
     * 当 *fast 指向末尾节点的时候，
     * slow 正好就在中间了。
     * 判断单链表是否有环 利用快慢指针的原理，
     * 同样设置两个指针 *fast 、 *slow 都指向单链表的头节点，
     * 其中 *fast 的移动速度是 *slow 的2倍。
     * 如果 *fast = NULL ，说明该单链表 以 NULL 结尾，
     * 不是循环链表；如果 *fast = *slow ，
     * 则快指针追上慢指针，说明该链表是循环链表。
     */
}
