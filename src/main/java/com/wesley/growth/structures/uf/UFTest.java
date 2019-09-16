package com.wesley.growth.structures.uf;

import java.util.Random;

/**
 * @author Created by Wesley on 2019/9/15
 */
public class UFTest {

    public static void main(String[] args) {
        int size = 5000000;
        int m = 5000000;

//        UF uf1 = new UnionFind1(size);
//        System.out.println("UF1: " + testUF(uf1, m) + " ms");

        // 对于UF2来说, 其时间性能是O(n*h)的, h为并查集表达的树的最大高度
//        UF uf2 = new UnionFind2(size);
//        System.out.println("UF2: " + testUF(uf2, m) + " ms");

        // 对于UF3来说, 其时间性能依然是O(n*h)的, h为并查集表达的树的最大高度
        // 但由于UF3能更高概率的保证树的平衡, 所以性能更优
        UF uf3 = new UnionFind3(size);
        System.out.println("UF3: " + testUF(uf3, m) + " ms");

        UF uf4 = new UnionFind4(size);
        System.out.println("UF4: " + testUF(uf4, m) + " ms");

        UF uf5 = new UnionFind5(size);
        System.out.println("UF5: " + testUF(uf5, m) + " ms");
    }

    private static double testUF(UF uf, int m) {
        int size = uf.size();

        Random random = new Random();

        long start = System.currentTimeMillis();

        // 每次随机选择两个元素进行合并操作, 进行m次操作
        for( int i = 0 ; i < m ; i ++ ){
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            uf.unionElements(a,b);
        }

        // 进行m次操作, 每次随机选择两个元素, 查询他们是否同属一个集合
        for(int i = 0 ; i < m ; i ++ ){
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            uf.isConnected(a,b);
        }

        long end = System.currentTimeMillis();
        return (end - start);
    }
}
