//给你一个整数数组 nums 和一个整数 k ，找出三个长度为 k 、互不重叠、且 3 * k 项的和最大的子数组，并返回这三个子数组。 
//
// 以下标的数组形式返回结果，数组中的每一项分别指示每个子数组的起始位置（下标从 0 开始）。如果有多个结果，返回字典序最小的一个。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,1,2,6,7,5,1], k = 2
//输出：[0,3,5]
//解释：子数组 [1, 2], [2, 6], [7, 5] 对应的起始下标为 [0, 3, 5]。
//也可以取 [2, 1], 但是结果 [1, 3, 5] 在字典序上更大。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,1,2,1,2,1,2,1], k = 2
//输出：[0,2,4]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2 * 10⁴ 
// 1 <= nums[i] < 2¹⁶ 
// 1 <= k <= floor(nums.length / 3) 
// 
// Related Topics 数组 动态规划 👍 207 👎 0

  
package com.wjp.leetcode.editor.cn;
  
class MaximumSumOf3NonOverlappingSubarrays{
    public static void main(String[] args) {
        Solution solution = new MaximumSumOf3NonOverlappingSubarrays().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        // 否定贪心
        // 当前取了最大和子数组后，可能到导致最后得不到最优解了
        return  null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}