package com.wesley.growth.leetcode.linked;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>
 * 给定一个链表，判断链表中是否有环。
 * </p>
 * Email yani@uoko.com
 *
 * @author Created by Yani on 2019/08/23
 */
public class Solution141 {

    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return false;
    }

    /**
     * 思路: 我们可以通过检查一个结点此前是否被访问过来判断链表是否为环形链表。常用的方法是使用哈希表。
     * 时间复杂度：O(n)，对于含有 n 个元素的链表，我们访问每个元素最多一次。添加一个结点到哈希表中只需要花费 O(1)的时间。
     * 空间复杂度：O(n)，空间取决于添加到哈希表中的元素数目，最多可以添加 n 个元素。
     */
    public boolean hasCycleByHash(ListNode head) {
        Set<ListNode> sets = new HashSet<>();

        while (head != null) {
            if (sets.contains(head)) {
                return true;
            }
            sets.add(head);
            head = head.next.next;
        }

        return false;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
//        node4.next = node2;

        boolean result = new Solution141().hasCycleByHash(node1);
        System.out.println(result);
    }

}
