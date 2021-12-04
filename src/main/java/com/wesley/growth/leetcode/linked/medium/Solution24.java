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
        // 设置虚拟头结点
        ListNode dmHead = new ListNode(-1);
        dmHead.next = head;

        ListNode cur = dmHead;
        while (cur.next != null && cur.next.next != null) {
            ListNode a = cur.next;
            ListNode b = cur.next.next;

            // s1: 当前节点 指向 a.next.next 节点(就是指向节点 b)
            cur.next = b;
            // s2: a.next 指向 b.next 节点 (b.next节点可能为null)
            a.next = b.next;
            // s3: b.next 指向 a, 完成a与b的位置转换
            b.next = a;

            cur = a;
        }

        return dmHead.next;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(new int[]{1, 2, 3, 4, 5});
        new Solution24().swapPairs(node).println();
    }

}
