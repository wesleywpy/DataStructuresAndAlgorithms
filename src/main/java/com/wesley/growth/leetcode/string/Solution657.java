package com.wesley.growth.leetcode.string;

/**
 * <p>
 *
 * </p>
 *
 * @author Created by Yani on 2019/10/22
 */
public class Solution657 {

    /**
     * 在二维平面上，有一个机器人从原点 (0, 0) 开始。给出它的移动顺序，判断这个机器人在完成移动后是否在 (0, 0) 处结束。
     *
     * 移动顺序由字符串表示。字符 move[i] 表示其第 i 次移动。机器人的有效动作有 R（右），L（左），U（上）和 D（下）。
     * 如果机器人在完成所有动作后返回原点，则返回 true。否则，返回 false。
     *
     */
    public boolean judgeCircle(String moves) {
        char[] chars = moves.toCharArray();
        int x = 0;
        int y = 0;
        for (int i = 0; i < chars.length; i++) {
            char move = chars[i];
            if ('R' == move) {
                x ++;
            } else if ('L' == move) {
                x --;
            } else if ('U' == move) {
                y ++;
            } else if ('D' == move) {
                y --;
            }
        }
        return x == 0 && y == 0;
    }

}
