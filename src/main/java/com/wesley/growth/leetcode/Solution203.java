package com.wesley.growth.leetcode;

/**
 * 删除链表中等于给定值 val 的所有节点。
 *
 * <p>
 *  示例:
 *     输入: 1->2->6->3->4->5->6, val = 6
 *     输出: 1->2->3->4->5
 * </p>
 * @author Created by Wesley on 2019/8/10
 */
public class Solution203 {

    /**
     * 使用虚拟头节点辅助 进行删除
     */
    public ListNode removeElements(ListNode head, int val) {

        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.val == val) {
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }

        return dummyHead.next;
    }

    /**
     * 递归实现
     */
    public ListNode removeElementsByRecursion(ListNode head, int val) {
        if (head == null) {
            return head;
        }

        ListNode node = removeElementsByRecursion(head.next, val);
        if (head.val == val) {
            return node;
        } else {
            head.next = node;
            return head;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 6, 3, 4, 5, 6};
//        int[] arr = {1};
        ListNode listNode = new ListNode(arr);

        System.out.println(listNode);
        ListNode result = new Solution203().removeElementsByRecursion(listNode, 6);
        System.out.println(result);
    }

}

 class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
         val = x;
     }

     ListNode(int[] arr) {
         if (arr == null || arr.length < 1) {
             throw new IllegalArgumentException("参数不能错误");
         }

         this.val = arr[0];
         ListNode cur = this;
         for (int i = 1; i < arr.length; i ++) {
             cur.next = new ListNode(arr[i]);
             cur = cur.next;
         }
     }

     @Override
     public String toString() {
         StringBuilder res = new StringBuilder();
         ListNode cur = this;
         while (cur != null) {
             res.append(cur.val).append("->");
             cur = cur.next;
         }

         res.append("NULL");
         return res.toString();
     }
 }
