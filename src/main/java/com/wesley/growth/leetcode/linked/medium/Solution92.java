package com.wesley.growth.leetcode.linked.medium;

import com.wesley.growth.leetcode.linked.ListNode;

/**
 * <p>
 *      反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 *  说明:
 *  1 ≤ m ≤ n ≤ 链表长度。
 *  示例:
 *  输入: 1->2->3->4->5->NULL, m = 2, n = 4
 *  输出: 1->4->3->2->5->NULL
 * </p>
 *
 * @author Created by Yani on 2020/04/16
 */
public class Solution92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) {
            return null;
        }

        ListNode pre = null;
        ListNode cur = head;
        // 推进两个指针，直到 cur 指针到达从链表头起的第 m 个结点。这是我们反转链表的起始位置。
        while (m > 1) {
            pre = cur;
            cur = cur.next;
            // 注意点, n随链表长度递减
            m--;
            n--;
        }

        // tail 指针 指向从链表头起的第m个结点，此结点是反转后链表的尾部
        ListNode tail = cur;
        // con 指针 指向第 m 个结点的前一个结点
        ListNode con = pre;

        // 迭代地反转链接。不断迭代，直到完成指向第 n 个结点的链接。此时，prev 指针会指向第 n 个结点。
        ListNode third = null; // 帮助反转过程的进行
        while (n > 0) {
            // 临时节点，暂存当前节点的下一节点，用于后移
            third = cur.next;
            // 将当前节点指向它前面的节点
            cur.next = pre;
            // 前指针后移
            pre = cur;
            // 当前指针后移
            cur = third;
            n--;
        }

        // con 指针来连接 prev 指针，这是因为 prev 指针当前指向的结点(第 n 个结点)会代替第 m 个结点的位置。
        if (con != null) {
            con.next = pre;
        }else{
            head = pre;
        }

        tail.next = cur;
        return head;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        ListNode node = new ListNode(arr1);
        ListNode result = new Solution92().reverseBetween(node, 1, 5);
        System.out.println(result);
    }
}
