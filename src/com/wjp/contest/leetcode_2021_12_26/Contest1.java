package com.wjp.contest.leetcode_2021_12_26;

class Contest1 {
    public static void main(String[] args) {
        Solution solution = new Contest1().new Solution();
    }

    class Solution {
        public boolean isSameAfterReversals(int num) {
            if (num == 0) {
                return true;
            }
            String str = String.valueOf(num);
            return str.lastIndexOf('0') != str.length() - 1;

        }
    }
}