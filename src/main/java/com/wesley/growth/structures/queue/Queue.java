package com.wesley.growth.structures.queue;

/**
 * 队列
 * @author Created by Wesley on 2019/8/9
 */
public interface Queue<E> {
    int getSize();

    boolean isEmpty();

    /**
     * 入队操作
     */
    void enqueue(E e);

    /**
     * 出队操作
     */
    E dequeue();

    /**
     * 获取队列头元素
     */
    E getFront();
}
