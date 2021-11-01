package com.wjp.contest.leetcode_2021_10_29;

import java.util.*;

class Contest2 {
    public static void main(String[] args) {
        Solution solution = new Contest2().new Solution();
    }

    class Solution {
        public int[] analysisHistogram(int[] heights, int cnt) {
            Arrays.sort(heights);
            reverse(heights);
            int min = Integer.MAX_VALUE;
            int start = 0;
            for (int i = 0; i < heights.length - cnt + 1; i++) {
                int diff = heights[i] - heights[i + cnt - 1];
                if (diff <= min) {
                    min = diff;
                    start = i;
                }
            }
            int[] res = new int[cnt];
            System.arraycopy(heights, start, res, 0, cnt);
            reverse(res);
            return  res;
        }

        void reverse(int[] nums) {
            int i = 0, j = nums.length - 1;
            while (i < j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j--;
            }
        }
    }
}