package com.wjp.contest.leetcode_2021_11_28;

class Contest2 {
    public static void main(String[] args) {
        Solution solution = new Contest2().new Solution();
    }

    class Solution {
        public int[] getAverages(int[] nums, int k) {
            int n = nums.length;
            long[] prefix = new long[n];
            for (int i = 0; i < n; i++) {
                prefix[i] = i == 0 ? nums[i] : prefix[i - 1] + nums[i];
            }
            int[] res = new int[n];
            for (int i = 0; i < n; i++) {
                if (i - k < 0 || i + k >= n) {
                    res[i] = -1;
                }else{
                    res[i] = (int)(((long)prefix[i + k] - (long) prefix[i - k] + (long) nums[i - k]) / (2 * k + 1));
                }
            }
            return res;
        }
    }
}