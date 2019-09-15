package com.wesley.growth.structures.uf;

/**
 * @author Created by Wesley on 2019/9/15
 */
public class UnionFind3 implements UF {

    private int[] parent;

    /**
     * sz[i] 表示 以i为根的集合中元素个数
     */
    private int[] sz;

    public UnionFind3(int size) {
        parent = new int[size];
        sz = new int[size];

        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            sz[i] = 1;
        }
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    /**
     * 合并元素p 和 元素q 所属的集合
     * O(h) 复杂度, h为树的高度
     */
    @Override
    public void unionElements(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) {
            return;
        }

        // 根据两个元素所在树的元素个数不同 来判断合并方向
        if (sz[pRoot] < sz[qRoot]) {
            // 将元素个数少的合并到元素个数多的集合上
            parent[pRoot] = qRoot;
            sz[qRoot] += sz[pRoot];
        }
        else {
            // sz[qRoot] <= sz[pRoot]
            parent[qRoot] = pRoot;
            sz[pRoot] += sz[qRoot];
        }
    }

    /**
     * 查找元素p所对应的集合编号
     * O(h) 复杂度, h为树的高度
     */
    private int find(int p) {
        if (p < 0 || p >= parent.length) {
            throw new IllegalArgumentException("p is out of bound.");
        }

        // 不断去查询自己的父亲节点, 直到到达根节点
        // 根节点的特点: parent[p] == p
        while( p != parent[p] )
            p = parent[p];
        return p;
    }

    @Override
    public int size() {
        return parent.length;
    }
}
