//数组的每个下标作为一个阶梯，第 i 个阶梯对应着一个非负数的体力花费值 cost[i]（下标从 0 开始）。 
//
// 每当你爬上一个阶梯你都要花费对应的体力值，一旦支付了相应的体力值，你就可以选择向上爬一个阶梯或者爬两个阶梯。 
//
// 请你找出达到楼层顶部的最低花费。在开始时，你可以选择从下标为 0 或 1 的元素作为初始阶梯。 
//
// 
//
// 示例 1： 
//
// 
//输入：cost = [10, 15, 20]
//输出：15
//解释：最低花费是从 cost[1] 开始，然后走两步即可到阶梯顶，一共花费 15 。
// 
//
// 示例 2： 
//
// 
//输入：cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
//输出：6
//解释：最低花费方式是从 cost[0] 开始，逐个经过那些 1 ，跳过 cost[3] ，一共花费 6 。
// 
//
// 
//
// 提示： 
//
// 
// cost 的长度范围是 [2, 1000]。 
// cost[i] 将会是一个整型数据，范围为 [0, 999] 。 
// 
// Related Topics 数组 动态规划 
// 👍 597 👎 0


package com.wjp.leetcode.editor.cn;

class MinCostClimbingStairs {
    public static void main(String[] args) {
        Solution solution = new MinCostClimbingStairs().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 入门动态规划
     * 为了达到整体最优解，当前的选择依赖前面的结果
     * 越过所有台阶的代价设为 f(n)，站到右边界的位置
     * 跳到该位置的只有两个前置步骤，跳到 f(n-1) 或 f(n-2)
     * 那么该选择哪一个？选小的
     * f(n-1) = f(n-3) + cost[n-1]
     */
    class Solution {
        public int minCostClimbingStairs(int[] cost) {
            int f1 = cost[0];
            int f2 = cost[1];
            for (int i = 2; i < cost.length; i++) {
                int t = f2;
                f2 = Math.min(f1, f2) + cost[i];
                f1 = t;
            }
            return Math.min(f1, f2);
        }



    }
//leetcode submit region end(Prohibit modification and deletion)

}