package com.wesley.growth.leetcode.string;

/**
 * Solution844
 * 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
 * 注意：如果对空文本输入退格字符，文本继续为空。
 * @author WangPanYong
 * @since 2021/08/25 11:06
 */
public class Solution844 {

    public boolean backspaceCompare(String s, String t) {
        char[] sarray = s.toCharArray();
        char[] tarray = t.toCharArray();

        int r1 = remove(sarray);
        int r2 = remove(tarray);

        // 字符个数不同 直接返回false
        if (r1 != r2) {
            return false;
        }

        for (int i = 0; i < r1; i++) {
            if (sarray[i] != tarray[i]) {
                return false;
            }
        }
        return true;
    }

    private int remove(char[] chars) {
        int k = 0;
        for (int i = 0; i < chars.length; i++) {
            // 等于目标字符 指针k向前移 最小为0
            if (chars[i] == '#') {
                k = Math.max(--k, 0);
            } else {
                // 指针i向后 并与指针k 下标元素交换位置
                char tmp = chars[i];
                chars[i] = chars[k];
                chars[k] = tmp;
                k++;
            }
        }
        return k;
    }

    public static void main(String[] args) {
        boolean res = new Solution844().backspaceCompare("a#c", "b");
        System.out.println(res);
    }

}
