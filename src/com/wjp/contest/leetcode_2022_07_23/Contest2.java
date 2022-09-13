package com.wjp.contest.leetcode_2022_07_23;

class Contest2 {
    public static void main(String[] args) {
        Solution solution = new Contest2().new Solution();
    }

    class Solution {
        public long zeroFilledSubarray(int[] nums) {
            long same = 0;
            long res = 0;
            for (int n : nums) {
                if (n == 0) {
                    same++;
                } else {
                    if (same == 0) {
                        continue;
                    } else {
                        res += ((1 + same) * same) / 2;
                        same = 0;
                    }
                }
            }
            if (same == 0) {
            } else {
                res += ((1 + same) * same) / 2;
                same = 0;
            }
            return res;
        }
    }
}