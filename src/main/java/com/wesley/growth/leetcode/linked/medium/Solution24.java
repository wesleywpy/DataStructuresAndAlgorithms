package com.wesley.growth.leetcode.linked.medium;

import com.wesley.growth.leetcode.linked.ListNode;

/**
 * <p>
 *  给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 *  你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * </p>
 *  示例:
 *  给定 1->2->3->4, 你应该返回 2->1->4->3.
 *
 * @author Created by Yani on 2020/06/04
 */
public class Solution24 {

    public ListNode swapPairs(ListNode head) {

        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode p = dummyHead;
        while (p.next != null && p.next.next != null) {
            ListNode node1 = p.next;
            ListNode node2 = node1.next;
            ListNode next = node2.next;

            // 交互位置
            node2.next = node1;
            node1.next = next;
            p.next = node2;
            // 移动到第二个node位置
            p = node1;
        }


        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(new int[]{1, 2, 3, 4, 5});
        new Solution24().swapPairs(node).println();
    }


}
