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
            return null;
        }

        head.next = removeElementsByRecursion(head.next, val);
        // 返回head.next就相当于删除当前元素
        return head.val == val ? head.next : head;
    }

    /**
     * 递归实现, 打印执行过程
     */
    public ListNode removeElementsByRecursion(ListNode head, int val, int depth) {
        System.out.print(generateDepthString(depth));
        System.out.println("Call: remove "+ val + " in " + head);
        if (head == null) {
            System.out.print(generateDepthString(depth));
            System.out.println("Return NULL");
            return null;
        }

        ListNode resNode = removeElementsByRecursion(head.next, val, depth + 1);
        ListNode result;
        if (head.val == val) {
            result = resNode;
        } else {
            head.next = resNode;
            result = head;
        }

        System.out.print(generateDepthString(depth));
        System.out.println("AfterRemove: "+ resNode);
        System.out.print(generateDepthString(depth));
        System.out.println("Return: "+ head);
        return result;
    }

    private String generateDepthString(int depth) {
        StringBuilder sbl = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            sbl.append("-- ");
        }

        return sbl.toString();
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 6, 3, 4, 5, 6};
//        int[] arr = {1};
        ListNode listNode = new ListNode(arr);

        System.out.println(listNode);
        ListNode result = new Solution203().removeElementsByRecursion(listNode, 6, 0);
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
