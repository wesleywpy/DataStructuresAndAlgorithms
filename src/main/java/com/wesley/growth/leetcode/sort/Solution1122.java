package com.wesley.growth.leetcode.sort;

import com.wesley.growth.algorithms.sort.util.SortTestHelper;

/**
 * <p>
 *  给你两个数组，arr1 和 arr2，
 *      arr2 中的元素各不相同
 *      arr2 中的每个元素都出现在 arr1 中
 *  对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
 *
 * 示例:
 *  输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 *  输出：[2,2,2,1,4,3,3,9,6,7,19]
 *
 * 提示:
 *  arr1.length, arr2.length <= 1000
 *  0 <= arr1[i], arr2[i] <= 1000
 *  arr2 中的元素 arr2[i] 各不相同
 *  arr2 中的每个元素 arr2[i] 都出现在 arr1 中
 * </p>
 *
 * @author Created by Yani on 2020/06/23
 */
public class Solution1122 {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] map = new int[1001];
        // 记录每个元素的出现次数
        for (int i : arr1) {
            map[i] = ++map[i];
        }

        // arr2 中的每个元素都出现在 arr1 中
        // 所以通过map查找
        int idx=0;
        for (int i = 0; i < arr2.length; i++) {
            while (map[arr2[i]] > 0) {
                arr1[idx] = arr2[i];
                idx++;
                map[arr2[i]]--;
            }
        }

        // 未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
        for (int i = 0; i < map.length; i++) {
            while (map[i] > 0) {
                arr1[idx] = i;
                idx++;
                map[i]--;
            }
        }

        return arr1;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{2,3,1,3,2,4,6,7,9,2,19};
        int[] arr2 = new int[]{2,1,4,3,9,6};
        int[] res = new Solution1122().relativeSortArray(arr1, arr2);
        SortTestHelper.print(res);
    }

}
