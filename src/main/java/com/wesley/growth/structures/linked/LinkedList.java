package com.wesley.growth.structures.linked;

/**
 * 单向链表实现
 * @author Created by Wesley on 2019/8/5
 */
public class LinkedList<E> {

    /**
     * 链表虚拟头
     */
    private Node dummyHead;

    private int size;

    public LinkedList() {
        dummyHead = new Node(null, null);
        size = 0;
    }

    /**
     * 在链表的index(0-based)位置添加元素
     * 练习或面试用
     */
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("添加失败, 非法Index");
        }

        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }

        // 中间插入元素, 注意preve.next赋值顺序
        prev.next = new Node(e, prev.next);
        size ++;
    }

    /**
     * 在链表头添加元素
     */
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * 链表尾添加元素
     */
    public void addLast(E e) {
        add(size, e);
    }

    /**
     * 获取链表的index(0-based)位置的元素
     * 练习或面试用
     */
    public E get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("查询失败, 非法Index");
        }

        Node cur = dummyHead.next;
        for (int i = 0; i < size; i++) {
            cur = cur.next;
        }

        return cur.e;
    }

    /**
     * 获取第一个元素
     */
    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }

    /**
     * 修改链表的index(0-based)位置的元素
     * 练习或面试用
     */
    public void set(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("查询失败, 非法Index");
        }

        Node cur = dummyHead.next;
        for (int i = 0; i < size; i++) {
            cur = cur.next;
        }

        cur.e = e;
    }

    public boolean contains(E ele) {
        Node cur = dummyHead.next;
        while (cur.next != null) {
            if (cur.e.equals(ele)) {
                return true;
            }
            cur = cur.next;
        }

        return false;
    }


    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        Node cur = dummyHead.next;
        while (cur != null) {
            res.append(cur).append("->");
            cur = cur.next;
        }

        res.append("NULL");
        return res.toString();
    }

    private class Node{
        E e;
        Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        @Override
        public String toString() {
            return e.toString();
        }

    }
}
