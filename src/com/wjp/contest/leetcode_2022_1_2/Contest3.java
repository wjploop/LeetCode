package com.wjp.contest.leetcode_2022_1_2;

import java.util.*;

class Contest3 {
    public static void main(String[] args) {
        Solution solution = new Contest3().new Solution();
    }

    class Solution {
        public boolean asteroidsDestroyed(int mass, int[] asteroids) {
            Arrays.sort(asteroids);
            long cur = mass;
            for (int as : asteroids) {
                if (cur < as) {
                    return false;
                }else{
                    cur += as;
                }
            }
            return true;
        }
    }
}