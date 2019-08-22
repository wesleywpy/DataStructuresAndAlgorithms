package com.wesley.growth.leetcode.linked;

/**
 * <p>
 *
 * </p>
 * Email yani@uoko.com
 *
 * @author Created by Yani on 2019/08/19
 */
public class Solution237 {

    /**
     * 删除某个链表中给定的（非末尾）节点，你将只被给定要求被删除的节点。
     * 说明:
     *  链表至少包含两个节点。
     *  链表中所有节点的值都是唯一的。
     *  给定的节点为非末尾节点并且一定是链表中的一个有效节点。
     */
    public void deleteNode(ListNode node) {
        // 思路:原地删除链表节点，使用该节点下一个值代替当前节点的值，然后删除下一个节点，即替换
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void main(String[] args) {
        int[] arr1 = {4, 5, 1, 9};
        ListNode node1 = new ListNode(arr1);
        System.out.println(node1);

        new Solution237().deleteNode(node1);
        System.out.println(node1);
    }

}
