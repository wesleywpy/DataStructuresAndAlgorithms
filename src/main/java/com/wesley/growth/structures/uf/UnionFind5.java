package com.wesley.growth.structures.uf;

/**
 * 查找时,进行路径压缩
 * @author Created by Wesley on 2019/9/16
 */
public class UnionFind5 implements UF {

    private int[] parent;

    /**
     * rank[i] 表示 以i为根的集合 所表示的树的层数
     */
    private int[] rank;

    public UnionFind5(int size) {
        parent = new int[size];
        rank = new int[size];

        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            rank[i] = 1;
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

        // 根据两个元素所在树的rank不同判断合并的方向
        // 将 rank低 的集合合并到rank高的集合上
        if (rank[pRoot] < rank[qRoot]) {
            parent[pRoot] = qRoot;
        } else if (rank[pRoot] > rank[qRoot]) {
            parent[qRoot] = pRoot;
        } else {
            parent[qRoot] = pRoot;
            rank[pRoot] += 1;
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
        while (p != parent[p]) {
            // 查找时,进行路径压缩, 最上级节点肯定指向自己不存在越界的情况
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }

    @Override
    public int size() {
        return parent.length;
    }
}
