package com.wjp.contest.leetcode_2021_12_11;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Contest1 {
    public static void main(String[] args) {
        Solution solution = new Contest1().new Solution();
    }
    class Solution {
        public int[] maxSubsequence(int[] nums, int k) {
            PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o1 - o2);
            for (int i = 0; i < nums.length; i++) {
                pq.offer(nums[i]);
                if (i >= k) {
                    pq.poll();
                }
            }
            List<Integer> list = new ArrayList<>(pq);
            int[] res = new int[k];
            int i = 0;
            for (int num : nums) {
                if (list.contains(num)) {
                    list.remove((Integer) num);
                    res[i++] = num;
                }
            }
            return res;
        }
    }

}