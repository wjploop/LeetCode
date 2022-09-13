package com.wjp.contest.leetcode_2021_12_25;

class Contest1 {
    public static void main(String[] args) {
        Solution solution = new Contest1().new Solution();
    }

    class Solution {
        public int mostWordsFound(String[] sentences) {
            int res =0;
            for (String s : sentences) {
                res = Math.max(res, s.split(" ").length);
            }
            return  res;
        }
    }
}