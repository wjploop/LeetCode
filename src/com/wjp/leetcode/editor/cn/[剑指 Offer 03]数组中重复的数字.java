//找出数组中重复的数字。 
//
// 
//在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请
//找出数组中任意一个重复的数字。 
//
// 示例 1： 
//
// 输入：
//[2, 3, 1, 0, 2, 5, 3]
//输出：2 或 3 
// 
//
// 
//
// 限制： 
//
// 2 <= n <= 100000 
// Related Topics 数组 哈希表 排序 
// 👍 486 👎 0

  
package com.wjp.leetcode.editor.cn;

import java.util.BitSet;

class ShuZuZhongZhongFuDeShuZiLcof{
    public static void main(String[] args) {
        Solution solution = new ShuZuZhongZhongFuDeShuZiLcof().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 使用hash，空间n,时间n
     * 原地排序，时间nlogn,空间1
     */
    class Solution {
    public int findRepeatNumber(int[] nums) {
        // boolean 在占多少字节？
        // 这个问题不固定，取决于虚拟机，可以是 1bit, 1 byte, 4byte
        // 使用bitset时位1位，
        // 使用boolean数组时可能为1字节
        // 单个boolean时，可能是4个字节

        BitSet bitSet = new BitSet(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (bitSet.get(nums[i])) {
                return nums[i];
            }
            bitSet.set(nums[i], true);
        }
        return -1;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}