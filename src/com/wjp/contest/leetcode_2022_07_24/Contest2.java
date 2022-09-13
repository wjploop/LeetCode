package com.wjp.contest.leetcode_2022_07_24;

class Contest2 {
    public static void main(String[] args) {
        Solution solution = new Contest2().new Solution();
    }

    class Solution {
        public int equalPairs(int[][] grid) {
            int n = grid.length;
            int res = 0;
            for (int i = 0; i < n; i++) {
                for (int k = 0; k < n; k++) {
                    boolean same = true;
                    for (int j = 0; j < n; j++) {
                        if (grid[i][j] != grid[j][k]) {
                            same = false;
                            break;
                        }
                    }
                    if (same) {
                        res++;
                    }
                }
            }
            return res;
        }
    }
}