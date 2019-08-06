package com.wesley.growth.structures.linked;

import org.junit.Test;

/**
 * @author Created by Wesley on 2019/8/6
 */
public class LinkedTest {

    @Test
    public void linkedTest() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }

        linkedList.add(3, 233);
        System.out.println(linkedList);
    }
}
