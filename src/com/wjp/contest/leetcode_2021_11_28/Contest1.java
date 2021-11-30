package com.wjp.contest.leetcode_2021_11_28;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Contest1 {
    public static void main(String[] args) {
        Solution solution = new Contest1().new Solution();
    }

    class Solution {
        public List<Integer> targetIndices(int[] nums, int target) {
            Arrays.sort(nums);
            int start = -1;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == target) {
                    start = i;
                    break;
                }
            }
            if (start == -1) {
                return new ArrayList<>();
            }
            int end = start;
            for (int i = end; i < nums.length; i++) {
                if (nums[i] != target) {
                    break;
                }
                end = i;
            }
            List<Integer> res = new ArrayList<>();
            for (int i = start; i < end; i++) {
                res.add(i);
            }
            return res;
        }
    }
}