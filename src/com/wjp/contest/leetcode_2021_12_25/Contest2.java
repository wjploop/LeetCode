package com.wjp.contest.leetcode_2021_12_25;

import java.util.Arrays;

class Contest2 {
    public static void main(String[] args) {
        Solution solution = new Contest2().new Solution();
    }

    class Solution {
        public int[] executeInstructions(int n, int[] startPos, String s) {
            int[] res = new int[s.length()];
            for (int i = 0; i < s.length(); i++) {
                int len = 0;
                int y = startPos[0], x = startPos[1];
                for (int j = i; j < s.length(); j++) {
                    int ch = s.charAt(j);
                    if (ch == 'U') {
                        y--;
                    } else if (ch == 'D') {
                        y++;
                    } else if (ch == 'L') {
                        x--;
                    }else{
                        x++;
                    }
                    if (x < 0 || x >= n || y < 0 || y >= n) {
                        break;
                    }else{
                        len++;
                    }
                }
                res[i] = len;
            }
            return res;
        }
    }
}