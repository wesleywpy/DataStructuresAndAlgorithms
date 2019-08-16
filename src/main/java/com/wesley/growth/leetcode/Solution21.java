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

    /**
     * 迭代实现
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(-1);

        ListNode prev = dummyNode;
        while (l1 != null && l2 != null) {
            // 如果 l1 当前位置的值小于等于 l2 ，我们就把 l1 的值接在 prev 节点的后面同时将 l1 指针往后移一个
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            }
            else{
                // 否则，我们对 l2 做同样的操作。
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        /**
         * 在循环终止的时候， l1 和 l2 至多有一个是非空的。
         * 由于输入的两个链表都是有序的，所以不管哪个链表是非空的，它包含的所有元素都比前面已经合并链表中的所有元素都要大。
         * 这意味着我们只需要简单地将非空链表接在合并链表的后面，并返回合并链表。
         */
        prev.next = l1 != null ? l1 : l2;
        return dummyNode.next;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 4};
        int[] arr2 = {1, 3, 4};
        ListNode node1 = new ListNode(arr1);
        ListNode node2 = new ListNode(arr2);

        ListNode result = new Solution21().mergeTwoLists(node1, node2);
        System.out.println(result);
    }

}
