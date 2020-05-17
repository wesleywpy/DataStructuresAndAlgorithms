package com.wesley.growth.leetcode.linked.medium;

import com.wesley.growth.leetcode.linked.ListNode;

/**
 * <p>
 *
 * </p>
 *
 * @author Created by Wesley on 2020/05/17
 */
public class Solution86 {

    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode cur = head;
        ListNode left = new ListNode(-1);
        ListNode right = new ListNode(-1);
        ListNode r1 = left;
        ListNode r2 = right;

        while (cur != null) {
            // 小于 x 为左链
            ListNode newnode = new ListNode(cur.val);
            if (cur.val < x) {
                left.next = newnode;
                left = newnode;
            } else {
                right.next = newnode;
                right = newnode;
            }

            cur = cur.next;
        }

        if (r1.next != null) {
            left.next = r2.next;
            return r1.next;
        } else {
            return r2.next;
        }
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(new int[]{1,1});
        new Solution86().partition(node, 0).println();
    }
}
