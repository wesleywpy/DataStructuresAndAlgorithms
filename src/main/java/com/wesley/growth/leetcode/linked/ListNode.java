package com.wesley.growth.leetcode.linked;

/**
 * <p>
 *
 * </p>
 * Email yani@uoko.com
 *
 * @author Created by Yani on 2019/08/14
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) {
        val = x;
    }

    public ListNode(int[] arr) {
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

    public void println() {
        System.out.println(this);
    }
}
