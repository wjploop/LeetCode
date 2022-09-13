package com.wjp.contest.leetcode_2022_07_24;

class Contest1 {
    public static void main(String[] args) {
        Solution solution = new Contest1().new Solution();
    }

    class Solution {
        public char repeatedCharacter(String s) {
            int[] chs = new int[26];
            for (char ch : s.toCharArray()) {
                int i = ch - 'a';
                chs[i]++;
                if (chs[i] > 1) {
                    return ch;
                }
            }
            return 'a';
        }
    }
}