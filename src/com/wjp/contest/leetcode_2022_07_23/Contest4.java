package com.wjp.contest.leetcode_2022_07_23;

import java.util.Arrays;

class Contest4 {
    public static void main(String[] args) {
        Solution solution = new Contest4().new Solution();
    }

    class Solution {
        public int shortestSequence(int[] rolls, int k) {
            int n = rolls.length;
            int[] f = new int[k + 1];
            int[] to = new int[k + 1];
            Arrays.fill(to,-1);
            int res = 0;
            while (true) {
                for (int i = 1; i <= k; i++) {
                    boolean find = false;
                    for (int j = f[i] + 1; j < n; j++) {
                        if (rolls[j] == i) {
                            to[i] = j;
                            find = true;
                            break;
                        }
                    }
                    if (!find) {
                        return res + 1;
                    }
                }
                System.arraycopy(to, 0, f, 0, f.length);
                System.out.println("find " + res);
                res++;
            }
        }
    }
}