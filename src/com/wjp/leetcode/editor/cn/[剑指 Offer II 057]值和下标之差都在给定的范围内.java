//给你一个整数数组 nums 和两个整数 k 和 t 。请你判断是否存在 两个不同下标 i 和 j，使得 abs(nums[i] - nums[j]) <= 
//t ，同时又满足 abs(i - j) <= k 。 
//
// 如果存在则返回 true，不存在返回 false。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3,1], k = 3, t = 0
//输出：true 
//
// 示例 2： 
//
// 
//输入：nums = [1,0,1,1], k = 1, t = 2
//输出：true 
//
// 示例 3： 
//
// 
//输入：nums = [1,5,9,1,5,9], k = 2, t = 3
//输出：false 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 2 * 10⁴ 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// 0 <= k <= 10⁴ 
// 0 <= t <= 2³¹ - 1 
// 
//
// 
//
// 注意：本题与主站 220 题相同： https://leetcode-cn.com/problems/contains-duplicate-iii/ 
// Related Topics 数组 桶排序 有序集合 排序 滑动窗口 👍 8 👎 0


package com.wjp.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

class SevenWqeDu {
    public static void main(String[] args) {
        Solution solution = new SevenWqeDu().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
            TreeSet<Long> treeSet = new TreeSet<>();
            // 维护k+1个数
            for (int i = 0; i < nums.length; i++) {
                long cur = nums[i];
                // 地板，最近得更小数
                Long floor = treeSet.floor(cur);
                // 天花板，最近得更大数
                Long ceiling = treeSet.ceiling(cur);
                if (floor != null && cur - floor <= t) {
                    return true;
                }
                if (ceiling != null && ceiling - cur <= t) {
                    return true;
                }
                treeSet.add(cur);
                if (i > k) {
                    treeSet.remove((long) nums[i - k - 1]);
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}