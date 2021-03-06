package com.wesley.growth.structures.map;

public interface Map<K, V> {

    void add(K key, V value);

    boolean contains(K key);

    V get(K key);

    void set(K key, V newValue);

    V remove(K key);

    int size();

    boolean isEmpty();
}
