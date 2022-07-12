//给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。 
//
// 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 
//
// 示例 1: 
//
// 
//输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 
//输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= nums.length <= 10⁴ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 👍 1451 👎 0


package com.wjp.leetcode.editor.cn;

import java.util.Random;

class KthLargestElementInAnArray {
    public static void main(String[] args) {
        Solution solution = new KthLargestElementInAnArray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            // 快速排序的过程中
            // 选中一个中轴后，将原数组划分为两部分，左部分比其小，右部分比其大
            // 换过来，左大右小
            // 第一划分时，假设发现左边有 j 个元素
            // 若是 j >= k 那么第k大的元素必须在左边
            // 若是，恰好左边的元素有k-1个，那么可以确定第k大的元素就是nums[j]
            // 假设确定在左边后, 继续在左边找，若是在右边，去左边的 j 个元素，那么令 k = k - j, 继续在左边找

            return select(nums, 0, nums.length - 1, nums.length - k);
        }

        // 寻找数组中第 k 个最小的的元素
        int select(int[] nums, int left, int right, int k) {
            // 随机在 [left,right]中找一个下标
            int p = new Random().nextInt(right - left + 1) + left;
            // 查看nums[p]是在nums[l,r]中第几个最小的元素
            swap(nums, left, p);
            int q = partition(nums, left, right);
            // System.out.printf("search %s %s", nums[q], q);
            if (q == k) {
                return nums[q];
            } else if (q < k) {
                // 寻找的元素在右边
                return select(nums, q + 1, right, k);
            } else {
                // 目标元素在左边
                return select(nums, left, q - 1, k);
            }

        }

        int partition(int[] nums, int left, int right) {
            if (left >= right) {
                return left;
            }
            int p = nums[left];
            while (left < right) {
                // 右起找到第一个比pivot小的元素，移动到左边
                while (left < right && nums[right] > p) {
                    right--;
                }
                nums[left] = nums[right];
                // 左起找到第一个严格大于pivot的元素，
                while (left < right && nums[left] <= p) {
                    left++;
                }
                nums[right] = nums[left];
            }
            nums[left] = p;
            // 此时，pivot应该在的位置为 left
            return left;
        }

        void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        // 堆化该子树，调整该根节点是该树的最大值
        void heapify(int[] nums, int root, int len) {
            int left = root * 2 + 1, right = root * 2 + 2;
            int max = root;
            if (left < len && nums[max] < nums[left]) {
                max = left;
            }
            if (right < len && nums[max] < nums[right]) {
                max = right;
            }
            if (root != max) {
                swap(nums, max, root);
                heapify(nums, max, len);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}