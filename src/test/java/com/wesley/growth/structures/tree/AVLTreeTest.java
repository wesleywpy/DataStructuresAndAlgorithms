package com.wesley.growth.structures.tree;

import com.wesley.growth.support.FileOperation;
import org.junit.Test;

import java.util.ArrayList;

/**
 * <p>
 *
 * </p>
 * Email yani@uoko.com
 *
 * @author Created by Yani on 2019/09/20
 */
public class AVLTreeTest {

    @Test
    public void test() {
        System.out.println("Pride and Prejudice");

        ArrayList<String> words = new ArrayList<>();
        if(FileOperation.readFile("/pride-and-prejudice.txt", words)) {
            System.out.println("Total words: " + words.size());

            AVLTree<String, Integer> map = new AVLTree<>();
            for (String word : words) {
                if (map.contains(word))
                    map.set(word, map.get(word) + 1);
                else
                    map.add(word, 1);
            }

            System.out.println("Total different words: " + map.size());
            System.out.println("Frequency of PRIDE: " + map.get("pride"));
            System.out.println("Frequency of PREJUDICE: " + map.get("prejudice"));
            System.out.println("is BST: " + map.isBST());
            System.out.println("is Balanced: " + map.isBalanced());

            words.forEach(map::remove);
        }

        System.out.println();
    }
}
