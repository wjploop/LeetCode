package com.wjp.contest.leetcode_2021_12_12;

class Contest3 {
    public static void main(String[] args) {
        Solution solution = new Contest3().new Solution();
    }

    class Solution {
        public int minimumRefill(int[] plants, int capacityA, int capacityB) {
            int n = plants.length;
            int i = 0, j = n - 1;
            int res = 0;
            int a = capacityA, b = capacityB;
            while (i < j) {
                if (a < plants[i]) {
                    res++;
                    a = capacityA - plants[i];
                }else {
                    a -= plants[i];
                }
                i++;

                if (b < plants[j]) {
                    res++;
                    b = capacityB - plants[j];
                } else {
                    b -= plants[j];
                }
                j--;
            }
            if (i == j) {
                if (Math.max(a, b) < plants[i]) {
                    res++;
                }
            }
            return res;
        }
    }
}