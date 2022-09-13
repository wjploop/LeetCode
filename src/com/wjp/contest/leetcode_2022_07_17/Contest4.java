package com.wjp.contest.leetcode_2022_07_17;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Contest4 {
    public static void main(String[] args) {
        Solution solution = new Contest4().new Solution();
    }

    class Solution {
        public int minOperations(int[] nums, int[] numsDivide) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int n : nums) {
                map.put(n, map.getOrDefault(n, 0) + 1);
            }
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for (int n : map.keySet()) {
                pq.add(n);
            }
            int count = 0;
            while (!pq.isEmpty()) {
                int a = pq.poll();
                boolean divide = true;
                for (int n : numsDivide) {
                    if (n % a != 0) {
                        divide = false;
                        break;
                    }
                }
                if (divide) {
                    return count;
                }
                System.out.println("remove:  "+ a + ":"+ map.get(a));
                count+= map.get(a);
            }
            return -1;
        }
    }
}