package com.wesley.growth.structures.stack;

/**
 * 队列
 * @author Created by Wesley on 2019/8/7
 */
public interface Stack<E> {

    /**
     * 大小
     */
    int getSize();

    /**
     * @return 是否为空
     */
    boolean isEmpty();

    /**
     * 栈顶增加一个元素
     */
    void push(E e);

    /**
     * 栈顶弹出一个元素
     */
    E pop();

    /**
     * 获取栈顶元素
     */
    E peek();
}
