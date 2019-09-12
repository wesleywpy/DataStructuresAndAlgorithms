package com.wesley.growth.structures.uf;

/**
 * <p>
 *
 * </p>
 * Email yani@uoko.com
 *
 * @author Created by Yani on 2019/09/12
 */
public class UnionFind1 implements UF {

    private int[] id;

    public UnionFind1(int size) {
        id = new int[size];

        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }
    }

    /**
     * 查找元素p 和 元素q 是否属于同一个集合
     */
    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    /**
     * 合并元素p 和 元素q 所属的集合
     */
    @Override
    public void unionElements(int p, int q) {
        int pId = find(p);
        int qId = find(q);
        if (pId == qId) {
            return;
        }

        for (int i = 0; i < id.length; i++) {
            if (id[i] == qId) {
                id[i] = pId;
            }
        }
    }

    /**
     * 查找元素p所对应的集合编号
     */
    private int find(int p) {
        if (p < 0 || p >= id.length) {
            throw new IllegalArgumentException("p is out of bound.");
        }
        return id[p];
    }

    @Override
    public int size() {
        return id.length;
    }
}
