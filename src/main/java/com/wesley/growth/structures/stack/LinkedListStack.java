package com.wesley.growth.structures.stack;

import com.wesley.growth.structures.linked.LinkedList;

/**
 * 链表实现栈
 * @author Created by Wesley on 2019/8/7
 */
public class LinkedListStack<E> implements Stack<E>{

    private LinkedList<E> linkedList;

    public LinkedListStack() {
        linkedList = new LinkedList<>();
    }

    @Override
    public int getSize() {
        return linkedList.getSize();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    @Override
    public void push(E e) {
        linkedList.addFirst(e);
    }

    @Override
    public E pop() {
        return linkedList.removeFirst();
    }

    @Override
    public E peek() {
        return linkedList.getFirst();
    }


}
