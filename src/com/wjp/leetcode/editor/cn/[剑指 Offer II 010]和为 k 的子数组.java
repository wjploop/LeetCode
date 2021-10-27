//给定一个整数数组和一个整数 k ，请找到该数组中和为 k 的连续子数组的个数。 
//
// 
//
// 示例 1 : 
//
// 
//输入:nums = [1,1,1], k = 2
//输出: 2
//解释: 此题 [1,1] 与 [1,1] 为两种不同的情况
// 
//
// 示例 2 : 
//
// 
//输入:nums = [1,2,3], k = 3
//输出: 2
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 2 * 10⁴ 
// -1000 <= nums[i] <= 1000 
// 
// -10⁷ <= k <= 10⁷ 
// 
// 
//
// 
//
// 注意：本题与主站 560 题相同： https://leetcode-cn.com/problems/subarray-sum-equals-k/ 
// Related Topics 数组 哈希表 前缀和 👍 17 👎 0


package com.wjp.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

class QTMn0o {
    public static void main(String[] args) {
        Solution solution = new QTMn0o().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int subarraySum(int[] nums, int k) {
            // 前缀和
            // 我们记录了前缀和的可能以及其次数
            // 若是得某子数组之和为k
            // 即需要 sum1 - sum2 = k
            // 当定了右边界后，我们只需判断前面是否存在前缀和为 k - sum
            int res = 0;
            int sum = 0;
            Map<Integer, Integer> map = new HashMap<>();
            map.put(0, 1);
            for (int num : nums) {
                sum += num;
                // 要是前面的前缀和中，存在前缀和为 sum - k
                // 即存在sum - sum1 = k ，即 sum - k
                if (map.containsKey(sum - k)) {

                    res += map.getOrDefault(sum - k, 0);
                }
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}