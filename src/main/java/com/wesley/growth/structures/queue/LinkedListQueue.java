package com.wesley.growth.structures.queue;


/**
 * @author Created by Wesley on 2019/8/9
 */
public class LinkedListQueue<E> implements Queue<E> {

    private int size;

    /**
     * 队列头
     */
    private Node head;

    /**
     * 队列尾
     */
    private Node tail;

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void enqueue(E e) {
        // 队列没有元素, 头尾相等
        if (tail == null) {
            tail = new Node(e);
            head = tail;
        }
        // 追加到最后
        else {
            tail.next = new Node(e);
            tail = tail.next;
        }
        size ++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("队列为空");
        }

        // 头指向下一个元素
        Node retNode = head;
        head = head.next;
        retNode.next = null;

        if (head == null) {
            tail = null;
        }

        size --;
        return retNode.e;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("队列为空");
        }

        return head.e;
    }

    @Override
    public String toString() {
        StringBuilder sbl = new StringBuilder("Queue front ");

        Node cur = head;
        while (cur != null) {
            sbl.append(cur).append("->");
            cur = cur.next;
        }

        sbl.append("NULL tail");
        return sbl.toString();
    }

    private class Node{
        E e;
        Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }

    }
}
