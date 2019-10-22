package com.wesley.growth.leetcode.string;

/**
 * <p>
 *
 * </p>
 *
 * @author Created by Yani on 2019/10/22
 */
public class Solution1108 {

    /**
     * 给你一个有效的 IPv4 地址 address，返回这个 IP 地址的无效化版本。
     * 所谓无效化 IP 地址，其实就是用 "[.]" 代替了每个 "."。
     */
    public String defangIPaddr(String address) {
        return address.replace(".", "[.]");
    }

    public String defangIPaddr2(String address) {
        char[] chars = address.toCharArray();
        StringBuilder sbl = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '.') {
                sbl.append("[.]");
            }else {
                sbl.append(chars[i]);
            }
        }
        return sbl.toString();
    }



    public static void main(String[] args) {
        String res = new Solution1108().defangIPaddr("1.1.1.1");
        System.out.println(res);
    }

}
