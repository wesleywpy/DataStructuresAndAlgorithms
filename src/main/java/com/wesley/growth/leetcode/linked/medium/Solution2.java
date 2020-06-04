package com.wesley.growth.leetcode.linked.medium;

import com.wesley.growth.leetcode.linked.ListNode;

/**
 * <p>
 *  给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 *  如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 *  您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * </p>
 *  示例：
 *  输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 *  输出：7 -> 0 -> 8
 *  原因：342 + 465 = 807
 * @author Created by Yani on 2020/05/19
 */
public class Solution2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode head = null;
        ListNode pre = null;
        while (l1 != null && l2 != null) {
            int val = l1.val + l2.val;
            ListNode newNode = new ListNode(val);

            if (val >= 10) {
                newNode.val = val - 10;
                if (pre != null) {
                    pre.val = pre.val + 1;
                }
            }

            head = newNode;

            head.next = pre;

            pre = head;

            l1 = l1.next;
            l2 = l2.next;
        }

        return pre;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(new int[]{2, 4, 4});
        ListNode node2 = new ListNode(new int[]{5, 6, 4});
        new Solution2().addTwoNumbers(node1, node2).println();
    }

}
