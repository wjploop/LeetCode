package com.wjp.contest.leetcode_2021_12_26;

class Contest3 {
    public static void main(String[] args) {
        Solution solution = new Contest3().new Solution();
    }

    class Solution {
        public boolean canBeValid(String s, String lo) {
            StringBuffer ss = new StringBuffer(s);
            for (int i = 0; i < s.length(); ++i)
                if (lo.charAt(i) == '0') ss.setCharAt(i, '*');
            int l = 0, r = 0, w = 0;
            for (int i = 0; i < s.length(); ++i) {
                if (ss.charAt(i) == '(') ++l;
                else if (ss.charAt(i) == ')') ++r;
                else ++w;
                if (r - l > w) return false;
            }
            int a = r + l + w;
            if (a / 2 * 2 < a) return false;
            l = 0;
            r = 0;
            w = 0;
            for (int i = s.length() - 1; i >= 0; --i) {
                if (ss.charAt(i) == '(') ++l;
                else if (ss.charAt(i) == ')') ++r;
                else ++w;
                if (l - r > w) return false;
            }
            return true;
        }
    }
}