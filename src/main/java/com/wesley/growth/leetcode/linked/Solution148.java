package com.wesley.growth.leetcode.linked;

/**
 * <p>
 *  在 O(n log n) 时间复杂度 和 常数级空间复杂度 下，对链表进行排序。
 * </p>
 * Email yani@uoko.com
 *
 * @author Created by Yani on 2019/10/14
 */
public class Solution148 {

    /**
     * 冒泡
     */
    public ListNode sortList(ListNode head) {
        ListNode curr = head;
        ListNode res = curr;
        while (curr != null) {
            ListNode next = curr.next;
            ListNode temp;
            while (next != null) {
                if (curr.val > next.val) {
                    int tmp = curr.val;
                    curr.val = next.val;
                    next.val = tmp;
                }
                next = next.next;
            }
            curr = curr.next;
        }
        return res;
    }

    /**
     * 归并排序
     */
    public ListNode mergeSort(ListNode node) {
        if (node == null || node.next == null) {
            return node;
        }

        ListNode middle = findMiddle(node);
        // 先合并 右边
        ListNode right = mergeSort(middle.next);
        middle.next = null;

        ListNode left = mergeSort(node);
        return merge(left, right);
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode dummyHead = new ListNode(-1);
        // 一个指针指向虚拟头结点，便于插入操作
        ListNode curr = dummyHead;

        ListNode leftTmp = left;
        ListNode rightTmp = right;
        while(leftTmp != null && rightTmp != null){
            //如果左边链表节点的值比较小，把它插入到链表中
            if(leftTmp.val < rightTmp.val){
                curr.next = leftTmp;
                leftTmp = leftTmp.next;
            }else{
                curr.next = rightTmp;
                rightTmp = rightTmp.next;
            }
            curr = curr.next;
        }

        //如果左节点没有插完，把这段链表放到cur的后面就好了
        if(leftTmp != null){
            curr.next = leftTmp;
        }
        //如果右节点没有插完，同样的操作
        if(rightTmp != null){
            curr.next = rightTmp;
        }

        return dummyHead.next;
    }
    /**
     * 归并排序 找到中间节点
     */
    private ListNode findMiddle(ListNode node) {
        // 慢指针
        ListNode slow = node;
        // 快指针
        ListNode fast = node.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
