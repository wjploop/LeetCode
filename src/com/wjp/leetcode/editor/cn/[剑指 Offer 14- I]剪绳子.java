//给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。
//请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18
//。 
//
// 示例 1： 
//
// 输入: 2
//输出: 1
//解释: 2 = 1 + 1, 1 × 1 = 1 
//
// 示例 2: 
//
// 输入: 10
//输出: 36
//解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36 
//
// 提示： 
//
// 
// 2 <= n <= 58 
// 
//
// 注意：本题与主站 343 题相同：https://leetcode-cn.com/problems/integer-break/ 
// Related Topics 数学 动态规划 
// 👍 273 👎 0

  
package com.wjp.leetcode.editor.cn;
  
class JianShengZiLcof{
    public static void main(String[] args) {
        Solution solution = new JianShengZiLcof().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 长度2，有需要剪，则结果 1
     * 3，时，不剪，3
     * 4，时，不剪
     * 5，时，剪，2 * 3 = 6
     */
    class Solution {
    public int cuttingRope(int n) {

        if (n == 2) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            // 从长度为2开始，
            for (int j = 2; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), dp[j] * (i - j)));
            }
        }
        return dp[n];


    }
}
//leetcode submit region end(Prohibit modification and deletion)

}