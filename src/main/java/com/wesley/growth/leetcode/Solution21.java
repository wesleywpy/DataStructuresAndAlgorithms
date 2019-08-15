package com.wesley.growth.leetcode;

/**
 * <p>
 *  将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *  示例：
 *      输入：1->2->4, 1->3->4
 *      输出：1->1->2->3->4->4
 * </p>
 * Email yani@uoko.com
 *
 * @author Created by Yani on 2019/08/14
 */
public class Solution21 {

    public ListNode mergeTwoLists(ListNode node1, ListNode node2) {

        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = node1;

        ListNode prev = dummyNode;
        while (prev.next != null) {



            prev = prev.next;
        }

        return null;
    }

}
