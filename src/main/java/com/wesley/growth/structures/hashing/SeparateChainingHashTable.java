package com.wesley.growth.structures.hashing;

import java.util.List;

/**
 * @author Created by Wesley on 2017/10/24.
 */
public class SeparateChainingHashTable<AnyType> {
    private static final int DEFAULT_TABLE_SIZE = 101;

    private int currentSize;

    private List<AnyType> theLists;

    public SeparateChainingHashTable() {
        this(DEFAULT_TABLE_SIZE);
    }

    public SeparateChainingHashTable(int size) {

    }


}
