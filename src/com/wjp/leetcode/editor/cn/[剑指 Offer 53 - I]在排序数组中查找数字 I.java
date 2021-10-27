//统计一个数字在排序数组中出现的次数。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [5,7,7,8,8,10], target = 8
//输出: 2 
//
// 示例 2: 
//
// 
//输入: nums = [5,7,7,8,8,10], target = 6
//输出: 0 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// nums 是一个非递减数组 
// -10⁹ <= target <= 10⁹ 
// 
//
// 
//
// 注意：本题与主站 34 题相同（仅返回值不同）：https://leetcode-cn.com/problems/find-first-and-last-
//position-of-element-in-sorted-array/ 
// Related Topics 数组 二分查找 👍 214 👎 0


package com.wjp.leetcode.editor.cn;

class ZaiPaiXuShuZuZhongChaZhaoShuZiLcof {
    public static void main(String[] args) {
        Solution solution = new ZaiPaiXuShuZuZhongChaZhaoShuZiLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int search(int[] nums, int target) {
            int start = 0, end = nums.length - 1;
            int index = binarySearch(nums, target, start, end);
            if (index == -1) {
                return 0;
            }
            int count = 1;
            for (int i = index - 1; i >= 0; i--) {
                if (nums[i] == target) {
                    count++;
                } else {
                    break;
                }
            }
            for (int i = index + 1; i < end; i++) {
                if (nums[i] == target) {
                    count++;
                }else{
                    break;
                }
            }
            return count;
        }
    }

    int binarySearch(int[] nums, int target, int start, int end) {
        int mid = 0;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                break;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        if (start > end) {
            return -1;
        }
        return mid;
    }
//leetcode submit region end(Prohibit modification and deletion)

}
