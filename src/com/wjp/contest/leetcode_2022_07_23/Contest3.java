package com.wjp.contest.leetcode_2022_07_23;

import java.util.Arrays;

class Contest3 {
    public static void main(String[] args) {
        Solution solution = new Contest3().new Solution();
        System.out.println(solution.bestHand(new int[]{1, 1, 1, 4, 5}, new char[]{'a', 'b', 'a', 'a', 'a',}));
    }

    class Solution {
        String[] degree = new String[]{
                "Flush",
                "Three of a Kind",
                "Pair",
                "High Card"
        };
        public String bestHand(int[] ranks, char[] suits) {
            char s = suits[0];
            boolean same= true;
            for (int i = 1; i < suits.length; i++) {
                if (s != suits[i]) {
                    same = false;
                    break;
                }
            }
            if (same) {
                return degree[0];
            }

            int sameCountMax = 1;
            int sameCount = 1;
            Arrays.sort(ranks);
            for (int i = 1; i < ranks.length; i++) {
                if (ranks[i] != ranks[i - 1]) {
                    sameCount = 1;
                }else{
                    sameCount ++;
                    sameCountMax = Math.max(sameCountMax, sameCount);
                }
            }
            System.out.println("same count "+ sameCountMax);
            if (sameCountMax >= 3) {
                return degree[1];
            } else if (sameCountMax >= 2) {
                return degree[2];
            }else{
                return degree[3];
            }

        }
    }
}