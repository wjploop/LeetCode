//给你一个整数方阵 arr ，定义「非零偏移下降路径」为：从 arr 数组中的每一行选择一个数字，且按顺序选出来的数字中，相邻数字不在原数组的同一列。 
//
// 请你返回非零偏移下降路径数字和的最小值。 
//
// 
//
// 示例 1： 
//
// 
//输入：arr = [[1,2,3],[4,5,6],[7,8,9]]
//输出：13
//解释：
//所有非零偏移下降路径包括：
//[1,5,9], [1,5,7], [1,6,7], [1,6,8],
//[2,4,8], [2,4,9], [2,6,7], [2,6,8],
//[3,4,8], [3,4,9], [3,5,7], [3,5,9]
//下降路径中数字和最小的是 [1,5,7] ，所以答案是 13 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length == arr[i].length <= 200 
// -99 <= arr[i][j] <= 99 
// 
// Related Topics 数组 动态规划 矩阵 👍 57 👎 0


package com.wjp.leetcode.editor.cn;

class MinimumFallingPathSumIi {
    public static void main(String[] args) {
        Solution solution = new MinimumFallingPathSumIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minFallingPathSum(int[][] grid) {
            // 对每一列使用dp
            int n = grid.length, m = grid[0].length;
            int[] dp = new int[m];
            int[] prev = new int[m];
            // 维护上一个行中第一小，及下标，以及第二小。
            // 对于下一行而言，若是当前下标不与上一行的第一下小的下标相同，则直接是 += firstSum
            // 否则，我们 += secondSum
            int firstSum = 0, secondSum = 0, firstSumPos = -1;

            for (int i = 0; i < n; i++) {
                int fs = Integer.MAX_VALUE, ss = Integer.MAX_VALUE, fp = -1;
                for (int j = 0; j < m; j++) {
                    int curSum = (firstSumPos == j ? secondSum : firstSum) + grid[i][j];
                    if (curSum < fs) {
                        ss = fs;    // 注意，保存上一个最小的，就是次小值
                        fs = curSum;
                        fp = j;
                    } else if (curSum < ss) {
                        ss = curSum;
                    }
                }
                firstSum = fs;
                secondSum = ss;
                firstSumPos = fp;
            }
            return firstSum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}