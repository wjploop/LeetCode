//一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。 
//
// 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。 
//
// 示例 1： 
//
// 输入：n = 2
//输出：2
// 
//
// 示例 2： 
//
// 输入：n = 7
//输出：21
// 
//
// 示例 3： 
//
// 输入：n = 0
//输出：1 
//
// 提示： 
//
// 
// 0 <= n <= 100 
// 
//
// 注意：本题与主站 70 题相同：https://leetcode-cn.com/problems/climbing-stairs/ 
//
// 
// Related Topics 记忆化搜索 数学 动态规划 
// 👍 184 👎 0

  
package com.wjp.leetcode.editor.cn;
  
class QingWaTiaoTaiJieWenTiLcof{
    public static void main(String[] args) {
        Solution solution = new QingWaTiaoTaiJieWenTiLcof().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 跳到第i个台阶，可以从第 i-1 或 i-2 跳入
     * 跳法即是 f(n) = f(n-1) + f(n-2)
     */
    class Solution {
    public int numWays(int n) {
        if (n < 2) {
            return 1;
        }
        int f1 = 1;
        int f2 = 1;
        for (int i = 2; i <= n; i++) {
            int t = f2;
            f2 = (f1 + f2)%1000000007;
            f1 = t;
        }
        return f2;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}