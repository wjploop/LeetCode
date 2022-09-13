package com.wjp.contest.leetcode_2022_07_17;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Contest2 {
    public static void main(String[] args) {
        Solution solution = new Contest2().new Solution();
    }

    class Solution {
        public int maximumSum(int[] nums) {
            int n = nums.length;
            int[] f = new int[n];
            Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
            for (int num : nums) {
                int a = sum(num);
                if (!map.containsKey(a)) {
                    map.put(a, new PriorityQueue<>(((o1, o2) -> o2 - o1)));
                }
                map.get(a).offer(num);
            }
            int res = -1;
            for (PriorityQueue<Integer> queue : map.values()) {
                if (queue.size() > 1) {
                    int a = queue.poll();
                    int b = queue.poll();
                    res = Math.max(res, a+b);
                }
            }
            return res;
        }

        int sum(int num) {
            int res = 0;
            while (num > 0) {
                res += num % 10;
                num = num / 10;
            }
            return res;
        }
    }
}