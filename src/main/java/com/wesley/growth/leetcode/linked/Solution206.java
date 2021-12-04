package com.wesley.growth.leetcode.linked;

/**
 * <p>
 * 反转一个单链表
 * 示例:
 *  输入: 1->2->3->4->5->NULL
 *  输出: 5->4->3->2->1->NULL
 * </p>
 * Email yani@uoko.com
 *
 * @author Created by Yani on 2019/08/22
 */
public class Solution206 {

    /**
     * 反转一个链表, 迭代实现
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            // 取出后节点，用于后移
            ListNode next = curr.next;
            // 将curr节点的后节点 指向 它前面的节点
            curr.next = prev;
            // 前节点(指针)后移
            prev = curr;

            // curr节点(指针)后移，循环上面逻辑
            curr = next;
        }
        return prev;
    }

    /**
     * 递归实现, 与迭代实现 逻辑相似
     */
    public ListNode reverseListByRecursion(ListNode head) {
        return reverse(null, head, 0);
    }

    private ListNode reverse(ListNode pre, ListNode cur){
        if(cur == null) {
            return pre;
        }
        ListNode next = cur.next;
        cur.next = pre;
        return reverse(cur,next);
    }

    private ListNode reverse(ListNode pre, ListNode cur, int depth){
        if(cur == null) {
            System.out.println(generateDepthString(depth) + "Pre : "+ pre);
            return pre;
        }

        System.out.println(generateDepthString(depth) + "Pre : "+ pre);
        System.out.println(generateDepthString(depth) + "Cur : "+ cur);
        // 暂存当前节点的下一节点，用于继续递归
        ListNode next = cur.next;
        // 当前节点 指向前一个节点
        cur.next = pre;
        // 当前节点作为前一个节点, 进行递归
        return reverse(cur, next, depth + 1);
    }

    private String generateDepthString(int depth) {
        StringBuilder sbl = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            sbl.append("-- ");
        }

        return sbl.toString();
    }


    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        ListNode node = new ListNode(arr1);
        ListNode result = new Solution206().reverseList(node);
        System.out.println(result);
    }


}

