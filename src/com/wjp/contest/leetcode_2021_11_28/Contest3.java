package com.wjp.contest.leetcode_2021_11_28;

class Contest3 {
    public static void main(String[] args) {
        Solution solution = new Contest3().new Solution();
    }

    class Solution {
        public int minimumDeletions(int[] nums) {
            if (nums.length == 1) {
                return 1;
            }
            int min = nums[0], max = nums[0];
            int minIndex = 0, maxIndex = 0;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] < min) {
                    min = nums[i];
                    minIndex = i;
                }
                if (nums[i] > max) {
                    max = nums[i];
                    maxIndex = i;
                }
            }
            int start = Math.min(minIndex, maxIndex);
            int end = Math.max(minIndex, maxIndex);
            if (start + 1 < nums.length - end) {
                return start + 1 + Math.min(nums.length - end, end - start);
            }else{
                return nums.length - end + Math.min(end - start, start + 1);
            }
        }
    }
}