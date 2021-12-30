package com.wjp.contest.leetcode_2021_12_23;

class Contest2 {
    public static void main(String[] args) {
        Solution solution = new Contest2().new Solution();
    }

    class Solution {
        public String addSpaces(String s, int[] spaces) {
            StringBuilder sb = new StringBuilder();
            int start = 0;
            for (int end : spaces) {
                sb.append(s.substring(start, end));
                start = end;
                sb.append(" ");
            }
            sb.append(s.substring(start, s.length()));
            return sb.toString();
        }
    }
}