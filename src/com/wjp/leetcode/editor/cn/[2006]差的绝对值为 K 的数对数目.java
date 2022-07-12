//给你一个整数数组 nums 和一个整数 k ，请你返回数对 (i, j) 的数目，满足 i < j 且 |nums[i] - nums[j]| == k 。
// 
//
// |x| 的值定义为： 
//
// 
// 如果 x >= 0 ，那么值为 x 。 
// 如果 x < 0 ，那么值为 -x 。 
// 
//
// 
//
// 示例 1： 
//
// 输入：nums = [1,2,2,1], k = 1
//输出：4
//解释：差的绝对值为 1 的数对为：
//- [1,2,2,1]
//- [1,2,2,1]
//- [1,2,2,1]
//- [1,2,2,1]
// 
//
// 示例 2： 
//
// 输入：nums = [1,3], k = 3
//输出：0
//解释：没有任何数对差的绝对值为 3 。
// 
//
// 示例 3： 
//
// 输入：nums = [3,2,1,5,4], k = 2
//输出：3
//解释：差的绝对值为 2 的数对为：
//- [3,2,1,5,4]
//- [3,2,1,5,4]
//- [3,2,1,5,4]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// 1 <= nums[i] <= 100 
// 1 <= k <= 99 
// 
// Related Topics 数组 哈希表 计数 👍 31 👎 0


package com.wjp.leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

class CountNumberOfPairsWithAbsoluteDifferenceK {
    public static void main(String[] args) {
        Solution solution = new CountNumberOfPairsWithAbsoluteDifferenceK().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countKDifference(int[] nums, int k) {
            // 对于nums, 找出俩个数，其差值 == k , 求这组合的个数？
            Map<Integer, Integer> map = new HashMap<>();
            // 对于任意 a, 来说，期待存在 |a - b| = k，即存在 (a - k) or (k + a)
            // 遍历此后的数，发现是目标值，则体征
            int res = 0;
            for (int i = 0; i < nums.length; i++) {
//                System.out.println("add " + map.getOrDefault(nums[i], 0));
                res += map.getOrDefault(nums[i], 0);
                // 1 0 2
                // 2 1 3 res = 1
                // 2 1 3 res = 2
                // 1
                // 对于 cur, 其期盼后面有一个数， abs(cur - expect) = k
                map.put(nums[i] - k, map.getOrDefault(nums[i] - k, 0) + 1);
                map.put(k + nums[i], map.getOrDefault(k + nums[i], 0) + 1);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}