package com.wesley.growth.structures.uf;

/**
 * <p>
 * UnionFind 并查集
 * </p>
 * Email yani@uoko.com
 *
 * @author Created by Yani on 2019/09/12
 */
public interface UF {

    /**
     * 是否可以连接
     * @param p 集合索引
     * @param q 集合索引
     */
    boolean isConnected(int p, int q);

    void unionElements(int p, int q);

    int size();
}
