//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。 
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 
//
// 注意：给定 n 是一个正整数。 
//
// 示例 1： 
//
// 输入： 2
//输出： 2
//解释： 有两种方法可以爬到楼顶。
//1.  1 阶 + 1 阶
//2.  2 阶 
//
// 示例 2： 
//
// 输入： 3
//输出： 3
//解释： 有三种方法可以爬到楼顶。
//1.  1 阶 + 1 阶 + 1 阶
//2.  1 阶 + 2 阶
//3.  2 阶 + 1 阶
// 
// Related Topics 记忆化搜索 数学 动态规划 👍 2046 👎 0

  
package com.wjp.leetcode.editor.cn;
  
class ClimbingStairs{
    public static void main(String[] args) {
        Solution solution = new ClimbingStairs().new Solution();
        System.out.println(solution.climb(3,1));
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int climbStairs(int n) {
        // 0 >> n
        return climb(n, 1);
    }

    private int climb(int n, int back) {
        if (back == 0) {
            if (n == 1 || n == 0) {
                return 1;
            }
            return climb(n - 1,0) + climb(n - 2,0);
        }else{
            // 0 > 3
            if (n == 0) {
                return 1;
            }
            return climb(n, 0) + climb(n - 1, 0);
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}