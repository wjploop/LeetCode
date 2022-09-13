package com.wjp.contest.leetcode_2022_07_17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Contest1 {
    public static void main(String[] args) {
        Solution solution = new Contest1().new Solution();
    }

    class Solution {
        public int[] numberOfPairs(int[] nums) {
            int n = nums.length;
            int[] res = new int[2];
            int[] visited = new int[nums.length];
            for (int i = 0; i < n; i++) {
                if (visited[i] == 1) {
                    continue;
                }
                int len = 1;
                for (int j = i + 1; j < n; j++) {
                    if (nums[i] == nums[j]) {
                        len++;
                        visited[j] = 1;
                    }
                }
                if (len > 1) {
                    visited[i] = 1;
                }
                res[0] += len / 2;
            }
            for (int i = 0; i < nums.length; i++) {
                if (visited[i] == 0) {
                    res[1] += 1;
                }
            }
            return res;
        }
    }
}