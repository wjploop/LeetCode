package com.wjp.problems.常见问题;

public class 无序数组中找最大值和最小值 {
    int[] minAndMax(int[] nums) {
        // 若是用俩个数记录，则比较次数为 2*n次，
        // 若是一次遍历过程中，我们先比较相邻的两个数，决定哪个是大的，则，在下一步中，再比较大的，
        int n = nums.length;
        for (int i = 0; i < n; i += 2) {
            if (nums[i] > nums[i + 1]) {
                swap(nums, i, i + 1);
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i += 2) {
            min = Math.min(min, nums[i]);
        }
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < n; i += 2) {
            max = Math.max(max, nums[i]);
        }
        return new int[]{min, max};
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
