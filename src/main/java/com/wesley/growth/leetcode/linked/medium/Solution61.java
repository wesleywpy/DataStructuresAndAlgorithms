package com.wesley.growth.leetcode.linked.medium;

import com.wesley.growth.leetcode.linked.ListNode;

/**
 * <p>
 *  给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 * </p>
 *
 * 示例 1:
 *  输入: 1->2->3->4->5->NULL, k = 2
 *  输出: 4->5->1->2->3->NULL
 * 解释:
 *  向右旋转 1 步: 5->1->2->3->4->NULL
 *  向右旋转 2 步: 4->5->1->2->3->NULL
 *
 * @author Created by Yani on 2020/07/03
 */
public class Solution61 {

    /**
     * 双指针 解法1
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        // 优化步骤, k如果大于链表的长度，其旋转的结果与 k % len 次是相同的
        int len = getLen(head);
        int times = k % len;
        if (times == 0) {
            return head;
        }

        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode p = dummyHead;
        ListNode q = dummyHead;
        // q 指针 先移动times次
        while (times > 0) {
            q = q.next;
            times--;
        }

        // p,q指针一起移动直到q指向最后一个节点
        while (q.next != null) {
            p = p.next;
            q = q.next;
        }

        ListNode last = p.next;
        p.next = null;
        q.next = dummyHead.next;
        dummyHead.next = last;
        return dummyHead.next;
    }


    private int getLen(ListNode node){
        int count = 0;
        while (node != null){
            node = node.next;
            count++;
        }
        return  count;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2};
//        int[] arr = {0, 1, 2};
        new Solution61().rotateRight(new ListNode(arr), 2).println();
    }

}
