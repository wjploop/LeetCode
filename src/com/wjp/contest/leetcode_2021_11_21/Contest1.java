package com.wjp.contest.leetcode_2021_11_21;

import java.util.HashMap;
import java.util.Map;

class Contest1 {
    public static void main(String[] args) {
        Solution solution = new Contest1().new Solution();
        int res = solution.maxDistance(new int[]{1, 1, 1, 6, 1, 1, 1});
        System.out.println(res);
    }

    class Solution {
        public int maxDistance(int[] colors) {
            int n = colors.length;
            int max = 0;
            for (int i = 0; i < n; i++) {
                int color = colors[i];
                for (int j = n - 1; j > i; j--) {
                    if (colors[j] != color) {
                        max = Math.max(max, j - i);
                    }
                }
            }
            return max;
        }
    }
}