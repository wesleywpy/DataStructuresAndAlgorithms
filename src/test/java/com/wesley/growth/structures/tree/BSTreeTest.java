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
}
