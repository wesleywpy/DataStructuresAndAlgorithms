package com.wesley.growth.structures.hashing;

import com.wesley.growth.structures.map.Map;
import java.util.TreeMap;

/**
 * 哈希表链地址法实现
 * @author Created by Wesley on 2019/10/05.
 */
public class HashTable<K, V> implements Map<K, V> {

    private TreeMap<K, V>[] hashtable;

    private int size;

    /**
     * m个地址, 也是模值(通常是一个素数), 使哈希值均匀分布
     */
    private int m;

    public HashTable() {
        this(97);
    }

    public HashTable(int m) {
        this.m = m;
        this.size = 0;
        hashtable = new TreeMap[m];
        for (int i = 0; i < this.m; i++) {
            hashtable[i] = new TreeMap<K, V>();
        }
    }

    private int hash(K key) {
        // 和 31位二级制1 与运算, 除去key的符号位, 再对 m 进行取模
        return (key.hashCode() & 0x7fffffff) % m;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void add(K key, V value){
        TreeMap<K, V> map = hashtable[hash(key)];
        if(map.containsKey(key))
            map.put(key, value);
        else{
            map.put(key, value);
            size ++;
        }
    }

    @Override
    public V remove(K key){
        V ret = null;
        TreeMap<K, V> map = hashtable[hash(key)];
        if(map.containsKey(key)){
            ret = map.remove(key);
            size --;
        }
        return ret;
    }

    @Override
    public void set(K key, V value){
        TreeMap<K, V> map = hashtable[hash(key)];
        if(!map.containsKey(key))
            throw new IllegalArgumentException(key + " doesn't exist!");

        map.put(key, value);
    }

    @Override
    public boolean contains(K key){
        return hashtable[hash(key)].containsKey(key);
    }

    @Override
    public V get(K key){
        return hashtable[hash(key)].get(key);
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }
}
