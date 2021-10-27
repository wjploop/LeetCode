//给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [0,1]
//输出: 2
//说明: [0, 1] 是具有相同数量 0 和 1 的最长连续子数组。 
//
// 示例 2: 
//
// 
//输入: nums = [0,1,0]
//输出: 2
//说明: [0, 1] (或 [1, 0]) 是具有相同数量 0 和 1 的最长连续子数组。 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// nums[i] 不是 0 就是 1 
// 
//
// 
//
// 注意：本题与主站 525 题相同： https://leetcode-cn.com/problems/contiguous-array/ 
// Related Topics 数组 哈希表 前缀和 👍 17 👎 0

  
package com.wjp.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

class A1NYOS{
    public static void main(String[] args) {
        Solution solution = new A1NYOS().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findMaxLength(int[] nums) {
        // 个数相同，把0视为-1,前缀和就可以用前缀和表示0的个数信息
        // 当再不同的位置上存在相同的前缀和时，中间的子数组前缀和为0，符合条件
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += (nums[i] == 1 ? 1 : -1);
            if(map.containsKey(sum)){
                res = Math.max(res, i - map.get(sum));
            }else{
                map.put(sum, i);
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}