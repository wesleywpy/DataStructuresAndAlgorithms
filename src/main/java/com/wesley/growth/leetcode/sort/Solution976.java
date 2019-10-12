package com.wesley.growth.leetcode.sort;

import java.util.Arrays;

/**
 * <p>
 *
 * </p>
 * Email yani@uoko.com
 *
 * @author Created by Yani on 2019/10/12
 */
public class Solution976 {

    public int largestPerimeter(int[] A) {
        Arrays.sort(A);

        for (int i = A.length - 1; i >= 2; i--) {
            int edge1 = A[i];
            int edge2 = A[i-1];
            int edge3 = A[i-2];
            if ((edge3 + edge2) > edge1) {
                return edge1 + edge2 + edge3;
            }
        }
        return 0;
    }
}
