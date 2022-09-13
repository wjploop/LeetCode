package com.wjp.contest.leetcode_2022_1_2;

class Contest1 {
    public static void main(String[] args) {
        Solution solution = new Contest1().new Solution();
    }

    class Solution {
        public int numberOfBeams(String[] bank) {
            int n = bank.length;
            int[] rows = new int[n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < bank[0].length(); j++) {
                    if (bank[i].charAt(j) == '1') {
                        rows[i]++;
                    }
                }
            }

            int res = 0;
            int prev = 0;
            for (int i = 0; i < n; i++) {
                if (rows[i] == 0) {
                    continue;
                }
                int cur = rows[i];
                res += cur * prev;
                prev = cur;
            }
            return res;
        }
    }
}