package com.wesley.growth.leetcode.linked;

/**
 * <p>
 *  给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * </p>
 *  示例
 *  输入: 1->1->2
 *  输出: 1->2
 * @author Created by Wesley on 2020/05/16
 */
public class Solution83 {

    /**
     * 迭代解法
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode cur = head;
        while (cur.next != null) {
            // 下一个节点值重复, 当前节点指向下下个节点
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(new int[]{1, 1, 1});
        new Solution83().deleteDuplicates(node).println();
    }

}
