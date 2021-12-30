package com.wjp.contest.leetcode_2021_12_23;

class Contest3 {
    public static void main(String[] args) {
        Solution solution = new Contest3().new Solution();
    }

    class Solution {
        public long getDescentPeriods(int[] prices) {
            // dp[i] 记录当天为终点，前面子数组是否是严格减一的个数
            int n = prices.length;
            int[] dp = new int[n];
            for (int i = 1; i < n; i++) {
                dp[i] = prices[i - 1] == prices[i] + 1 ? dp[i - 1] + 1 : 0;  
            }
            long res = n;
            for (int i = 0; i < n; i++) {
                res += dp[i];
            }
            return res;
        }
    }
}