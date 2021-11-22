package com.wjp.contest.leetcode_2021_11_21;

class Contest2 {
    public static void main(String[] args) {
        Solution solution = new Contest2().new Solution();
        System.out.println(solution.wateringPlants(new int[]{1,1,1,4,2,3}, 4));
    }

    class Solution {
        public int wateringPlants(int[] plants, int capacity) {
            int n = plants.length;
            int[] prefix = new int[n];
            for (int i = 0; i < n; i++) {
                prefix[i] = i == 0 ? plants[i] : prefix[i - 1] + plants[i];
            }
            int prev = 0;
            int prevIndex = -1;
            int res = 0;
            for (int i = 0; i < n; i++) {
                while (i < n && prefix[i] - prev <= capacity) {
                    i++;
                }
                System.out.println("return " + (i - 1));
                res += (i);
                prevIndex = i - 1;
                prev = prefix[prevIndex];
                i = i - 1;
            }
            return res * 2 - n;

        }
    }
}