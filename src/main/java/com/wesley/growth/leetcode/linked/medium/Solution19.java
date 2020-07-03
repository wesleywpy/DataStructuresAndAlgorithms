package com.wesley.growth.leetcode.linked.medium;

import com.wesley.growth.leetcode.linked.ListNode;

/**
 * <p>
 *  给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * </p>
 *
 * 示例：
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 *
 * 说明：
 * 给定的 n 保证是有效的。
 * @author Created by Yani on 2020/07/02
 */
public class Solution19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        // 采用 双指针
        ListNode p = dummyHead;
        ListNode q = dummyHead;

        // q 指针 先移动 n 个位置
        for (int i = 0; i < n + 1; i++) {
            q = q.next;
        }

        // p,q指针一起移动直到q指针到达链表末尾
        while (q != null) {
            p = p.next;
            q = q.next;
        }

        ListNode delNode = p.next;
        p.next = delNode.next;
        delNode = null;
        return dummyHead.next;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        new Solution19().removeNthFromEnd(new ListNode(arr), 0).println();
    }

}
