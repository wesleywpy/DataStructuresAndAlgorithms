package com.wesley.growth.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author Created by Yani on 2019/10/30
 */
public class Solution412 {

    /**
     * 写一个程序，输出从 1 到 n 数字的字符串表示。
     * 1. 如果 n 是3的倍数，输出“Fizz”；
     *
     * 2. 如果 n 是5的倍数，输出“Buzz”；
     *
     * 3.如果 n 同时是3和5的倍数，输出 “FizzBuzz”。
     */
    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            int mod1 = i % 3;
            int mod2 = i % 5;
            String str = "";
            if (mod1 == 0) {
                str += "Fizz";
            }
            if (mod2 == 0) {
                str += "Buzz";
            }

            if (str.equals("")) {
                result.add(String.valueOf(i));
            } else {
                result.add(str);
            }
        }
        return result;
    }


}
