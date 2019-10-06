package com.wesley.growth.structures.hashing;

import com.wesley.growth.structures.map.Map;
import java.util.TreeMap;

/**
 * 哈希表链地址法实现
 * @author Created by Wesley on 2019/10/05.
 */
public class HashTable<K, V> implements Map<K, V> {

    /**
     * 可选的容量值, 都为素数
     */
    private final int[] capacity = {
            53, 97, 193, 389, 769, 1543, 3079, 6151, 12289, 24593,
            49157, 98317, 196613, 393241, 786433, 1572869, 3145739, 6291469,
            12582917, 25165843, 50331653, 100663319, 201326611, 402653189, 805306457, 1610612741};

    private TreeMap<K, V>[] hashtable;

    private int size;

    /**
     * m个地址, 也是模值(通常是一个素数), 使哈希值均匀分布
     */
    private int m;

    /**
     * 容量初始下标
     */
    private int capacityIndex = 0;

    private static final int upperTol = 10;

    private static final int lowerTol = 2;

    public HashTable() {
        this.m = capacity[capacityIndex];
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

            // 平均每个索引承载的元素超过一定程度, 进行扩容
            if(size >= upperTol * m && capacityIndex + 1 < capacity.length){
                capacityIndex ++;
                resize(capacity[capacityIndex]);
            }
        }
    }

    @Override
    public V remove(K key){
        V ret = null;
        TreeMap<K, V> map = hashtable[hash(key)];
        if(map.containsKey(key)){
            ret = map.remove(key);
            size --;

            // 平均每个索引承载的元素少过一定程度, 进行缩容
            if(size < lowerTol * m && capacityIndex - 1 >= 0){
                capacityIndex --;
                resize(capacity[capacityIndex]);
            }
        }
        return ret;
    }

    private void resize(int newM){
        TreeMap<K, V>[] newHashTable = new TreeMap[newM];
        for(int i = 0 ; i < newM ; i ++)
            newHashTable[i] = new TreeMap<>();

        int oldM = m;
        this.m = newM;
        for(int i = 0 ; i < oldM ; i ++){
            TreeMap<K, V> map = hashtable[i];
            for(K key: map.keySet())
                newHashTable[hash(key)].put(key, map.get(key));
        }

        this.hashtable = newHashTable;
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
