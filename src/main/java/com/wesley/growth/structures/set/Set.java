package com.wesley.growth.structures.set;

/**
 * <p>
 * 集合
 * </p>
 * Email yani@uoko.com
 *
 * @author Created by Yani on 2019/08/28
 */
public interface Set<E> {

    int size();

    boolean isEmpty();

    boolean contains(E e);

    void add(E e);

    void remove(E e);

}
