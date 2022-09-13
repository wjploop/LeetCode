package com.wjp.contest.leetcode_2022_1_2;

class Contest2 {
    public static void main(String[] args) {
        Solution solution = new Contest2().new Solution();
    }

    class Solution {
        public boolean checkString(String s) {
            boolean seeB = false;
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (seeB && ch == 'a') {
                    return false;
                }
                if (ch == 'b') {
                    seeB = true;
                }
            }
            return true;
        }
    }
}