package com.wesley.growth.exam;

import org.junit.Assert;
import org.junit.Test;

/**
 * <p>
 *
 * </p>
 * Email yani@uoko.com
 *
 * @author Created by Yani on 2019/08/05
 */
public class ExamTest {

    @Test
    public void strTest() {
        String str = "bat345";
        String r1 = StringExam.reverse(str);
        String r2 = StringExam.reverseSimple(str);
        Assert.assertEquals(r1, r2);
    }

    @Test
    public void removeDuplicateCharTest() {
        String str = "abbbcdae";

        String r1 = StringExam.removeDuplicateChar(str);
        System.out.println(r1);
    }



}
