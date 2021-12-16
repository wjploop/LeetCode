package com.wjp.contest.leetcode_2021_12_12;

import java.util.HashSet;
import java.util.Set;

class Contest1 {
    public static void main(String[] args) {
        Solution solution = new Contest1().new Solution();
        System.out.println(solution.countPoints("B0B6G0R6R0R6G9"));
    }

    class Solution {
        public int countPoints(String rings) {
            Set<Integer>[] sets = new Set[10];
            for (int i = 0; i < 10; i++) {
                sets[i] = new HashSet<>();
            }
            for (int i = 0; i < rings.length() / 2; i++) {
                int color = rings.charAt(2 * i);
                int index = Integer.parseInt(String.valueOf(rings.charAt(2 * i + 1)));
                sets[index].add(color);
            }
            int count = 0;
            for (Set<Integer> set : sets) {
                if (set.size() == 3) {
                    count++;
                }
            }
            return count;
        }
    }
}