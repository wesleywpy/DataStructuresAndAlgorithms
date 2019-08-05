package com.wesley.growth.structures.tree;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.io.File;
import java.util.List;
import java.util.Objects;

/**
 * <p>
 *
 * </p>
 * Email yani@uoko.com
 *
 * @author Created by Yani on 2018/10/18
 */
public class BSTreeTest {

    @Test
    public void search() throws Exception{
        List<String> bible = FileUtils.readLines(new File("G:\\Learingspaces\\wesley\\bible.txt"), "utf-8");

        BSTree<String,Integer> sbTree = new BSTree<>();
        bible.forEach(line -> {
            for (String word : StringUtils.split(line, " ")) {
                Integer count = sbTree.search(word);
                if(Objects.isNull(count)){
                    sbTree.insert(word, 1);
                }else{
                    sbTree.insert(word, count+1);
                }
            }
        });

        Integer count = sbTree.search("God");
        System.out.println(count);
    }

    @Test
    public void traverse() throws Exception{
        BSTree<Integer,Integer> sbTree = new BSTree<>();
        sbTree.insert(28,28);
        sbTree.insert(16,16);
        sbTree.insert(30,30);
        sbTree.insert(13,13);
        sbTree.insert(22,22);
        sbTree.insert(29,29);
        sbTree.insert(42,42);

        sbTree.traverse();
        System.out.println("remove maxNode ...");;
        sbTree.traverse();
    }

    @Test
    public void testFloorAndCeil() throws Exception {
        BSTree<Integer,Integer> bsTree = new BSTree<>();
        bsTree.insert(41, 41);
        bsTree.insert(22, 22);
        bsTree.insert(58, 58);
        bsTree.insert(15, 15);
        bsTree.insert(50, 50);
        bsTree.insert(63, 63);
        bsTree.insert(42, 42);

        System.out.println(bsTree.floor(45));
        System.out.println(bsTree.ceil(45));
    }


}
