//给你一个整数数组 nums，请你将该数组升序排列。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,2,3,1]
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：nums = [5,1,1,2,0,0]
//输出：[0,0,1,1,2,5]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5 * 10⁴ 
// -5 * 10⁴ <= nums[i] <= 5 * 10⁴ 
// 
// Related Topics 数组 分治 桶排序 计数排序 基数排序 排序 堆（优先队列） 归并排序 👍 462 👎 0


package com.wjp.leetcode.editor.cn;

class SortAnArray {
    public static void main(String[] args) {
        Solution solution = new SortAnArray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] sortArray(int[] nums) {
            quickSort(nums);
            return nums;
        }

        void quickSort(int[] nums){
            partition(nums, 0, nums.length - 1);
        }

        void partition(int[] nums, int left, int right){
            int i = left, j = right;
            if (i >= j) {
                return ;
            }
            int pivot = nums[i];
            while (i < j) {
                while (i < j && nums[j] > pivot) {
                    j--;
                }
                nums[i] = nums[j];
                while (i < j && nums[i] <= pivot) {
                    i++;
                }
                nums[j] = nums[i];
            }
            nums[i] = pivot;
            partition(nums, left, i - 1);
            partition(nums, i + 1, right);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}