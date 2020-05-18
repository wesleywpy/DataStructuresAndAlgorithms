package com.wesley.growth.leetcode.linked.medium;

import com.wesley.growth.leetcode.linked.ListNode;

/**
 * <p>
 *  给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 *
 *  请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 * </p>
 *
 * 示例 1:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 1->3->5->2->4->NULL
 * 示例 2:
 *
 * 输入: 2->1->3->5->6->4->7->NULL
 * 输出: 2->3->6->7->1->5->4->NULL
 *
 * 应当保持奇数节点和偶数节点的相对顺序。
 * 链表的第一个节点视为奇数节点，第二个节点视为偶数节点，以此类推。
 *
 * @author Created by Yani on 2020/05/18
 */
public class Solution328 {

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // 奇偶指针
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;
        while (odd.next != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;

            // 移动到对应的奇偶位置
            odd = odd.next;
            even = even.next;
        }

        odd.next = evenHead;
        return head;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(new int[]{1, 3, 2});
        new Solution328().oddEvenList(node).println();
    }


}
