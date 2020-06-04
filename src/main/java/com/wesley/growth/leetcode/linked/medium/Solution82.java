package com.wesley.growth.leetcode.linked.medium;

import com.wesley.growth.leetcode.linked.ListNode;

/**
 * <p>
 *  给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 * </p>
 *
 * 示例 1:
 *   输入: 1->2->3->3->4->4->5
 *   输出: 1->2->5
 *
 * 示例 2:
 *   输入: 1->1->1->2->3
 *   输出: 2->3
 *
 * @author Created by Yani on 2020/05/28
 */
public class Solution82 {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode pre = dummyHead;
        ListNode cur = dummyHead.next;
        while (cur != null) {
            // 两个指针都前进一位
            if (pre.next.val != cur.val) {
                pre = pre.next;
                cur = cur.next;
            } else {
                while (pre.next.val == cur.val && cur.next != null) {
                    cur = cur.next;
                }
                pre.next = cur;
                cur = cur.next;
            }

        }

        return dummyHead.next;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 3, 4, 5};
        ListNode listNode = new ListNode(arr);
        new Solution82().deleteDuplicates(listNode).println();
    }

}
