package com.wesley.growth.leetcode;

import java.util.HashSet;

/**
 * <p>
 *
 * </p>
 * Email yani@uoko.com
 *
 * @author Created by Yani on 2019/08/28
 */
public class Solution804 {

    public int uniqueMorseRepresentations(String[] words) {

        String[] codes = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

        HashSet<String> sets = new HashSet<>();
        for (String word : words) {

            StringBuilder sbl = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                String code = codes[c - 'a'];
                sbl.append(code);
            }
            sets.add(sbl.toString());
        }

        return sets.size();
    }

    public static void main(String[] args) {
        String[] words = {"rwjje","aittjje","auyyn","lqtktn","lmjwn"};
        int result = new Solution804().uniqueMorseRepresentations(words);
        System.out.println(result);
    }

}
