//输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。 
//
// 
//
// 示例： 
//
// 
//输入：nums = [1,2,3,4]
//输出：[1,3,2,4] 
//注：[3,1,2,4] 也是正确的答案之一。 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 50000 
// 1 <= nums[i] <= 10000 
// 
// Related Topics 数组 双指针 排序 
// 👍 145 👎 0

  
package com.wjp.leetcode.editor.cn;
  
class DiaoZhengShuZuShunXuShiQiShuWeiYuOuShuQianMianLcof{
    public static void main(String[] args) {
        Solution solution = new DiaoZhengShuZuShunXuShiQiShuWeiYuOuShuQianMianLcof().new Solution();
        System.out.println((-132 & 1) == 1);

    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] exchange(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            // 找到偶数
            while (i < j && (nums[i] & 1) != 0) {
                i++;
            }
            while (i < j && (nums[j] & 1) != 1) {
                j--;
            }
            if (i < j) {
                nums[i] ^= nums[j];
                nums[j] ^= nums[i];
                nums[i] ^= nums[j];
//                int t = nums[i];
//                nums[i] = nums[j];
//                nums[j] = t;
            }
        }
        return nums;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}