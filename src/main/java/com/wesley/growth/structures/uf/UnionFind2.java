package com.wesley.growth.structures.uf;

/**
 * @author Created by Wesley on 2019/9/15
 */
public class UnionFind2 implements UF {

    private int[] parent;

    public UnionFind2(int size) {
        parent = new int[size];

        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public void unionElements(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) {
            return;
        }

        parent[pRoot] = qRoot;
    }

    /**
     * 查找元素p所对应的集合编号
     * O(h) 复杂度, h为树的高度
     */
    private int find(int p) {
        if (p < 0 || p >= parent.length) {
            throw new IllegalArgumentException("p is out of bound.");
        }

        int r = p;
        while (r != parent[r]) {
            r = parent[r];
        }

        return r;
    }

    @Override
    public int size() {
        return parent.length;
    }
}
