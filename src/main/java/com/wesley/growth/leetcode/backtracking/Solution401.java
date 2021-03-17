package com.wesley.growth.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution401
 *
 * @author WangPanYong
 * @since 2021/03/16 15:31
 */
public class Solution401 {
    private int[] hours = new int[]{1, 2, 4, 8, 0, 0, 0, 0, 0, 0};
    private int[] minutes = new int[]{0, 0, 0, 0, 1, 2, 4, 8, 16, 32};
    private List<String> res = new ArrayList<>();

    public List<String> readBinaryWatch(int num) {
        dfs(num, 0, 0, 0);
        return res;
    }

    /**
     *
     * @param num 亮灯数
     * @param start
     * @param curHour 当前小时
     * @param curMin 当前分钟
     */
    private void dfs(int num, int start, int curHour, int curMin) {
        // 当前小时数和分钟数 不符合要求 直接return
        if (curHour > 11 || curMin > 59) {
            return;
        }

        // 目标亮灯数, 记录时间
        if (num == 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(curHour).append(':');
            if (curMin < 10) {
                sb.append('0');
            }
            sb.append(curMin);
            res.add(sb.toString());
            return;
        }

        // 最多10个灯
        for (int i = start; i < 10; i++) {
            // num -1 : 减少一个亮灯数
            // i + 1 : 从当前已点亮的灯后面选取下一个要点亮的灯 (排除已经点亮的灯)
            // 在curHour中增加当前点亮灯的小时数，如果i大于3，当前灯是分钟灯而不是小时灯，则加上0个小时
            // 在curMin中增加当前点亮灯的分钟数，如果i没有大于3，当前灯是小时灯而不是分钟灯，则加上0分钟
            dfs(num - 1, i + 1, curHour + hours[i], curMin + minutes[i]);
        }
    }

    public static void main(String[] args) {
        List<String> times = new Solution401().readBinaryWatch(2);
        System.out.println(times);
    }

}
