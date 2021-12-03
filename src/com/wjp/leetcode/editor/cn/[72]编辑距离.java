//给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。 
//
// 你可以对一个单词进行如下三种操作： 
//
// 
// 插入一个字符 
// 删除一个字符 
// 替换一个字符 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：word1 = "horse", word2 = "ros"
//输出：3
//解释：
//horse -> rorse (将 'h' 替换为 'r')
//rorse -> rose (删除 'r')
//rose -> ros (删除 'e')
// 
//
// 示例 2： 
//
// 
//输入：word1 = "intention", word2 = "execution"
//输出：5
//解释：
//intention -> inention (删除 't')
//inention -> enention (将 'i' 替换为 'e')
//enention -> exention (将 'n' 替换为 'x')
//exention -> exection (将 'n' 替换为 'c')
//exection -> execution (插入 'u')
// 
//
// 
//
// 提示： 
//
// 
// 0 <= word1.length, word2.length <= 500 
// word1 和 word2 由小写英文字母组成 
// 
// Related Topics 字符串 动态规划 👍 1951 👎 0

  
package com.wjp.leetcode.editor.cn;

class EditDistance{
    public static void main(String[] args) {
        Solution solution = new EditDistance().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minDistance(String from, String target) {
        // q : if from[0,i-1] to target[0,j-1] need k steps, then from[0,i] to target[0,j] need steps ？
        // a : if from[i] == target[j], then need k , else k+1. 替换
        // q : if from[0, i-1] to target[0,j] need k , then ?
        // a : just delete [i], then need k + 1。 删除
        // q : if from[0,i] to target[0, j-1] need k , then ?
        // a : just add target[j], then need k+1, 添加
        // 最后一步， from 即将变成 target, 我们应该选择哪一步操作？

        int m = from.length(), n = target.length();
        // 若是一个字符为空，则只要不断删、或不断增
        if (m * n == 0) {
            return n + m;
        }
        // dp[i][j] 表示
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            // 表示当target字符为空时，存在i个字符的from需要的操作就是删除i次
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            // 表示from字符为空时，target有j个字符，则需要增加j次
            dp[0][j] = j;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (from.charAt(i - 1) == target.charAt(j - 1)) {
                    dp[i][j] = dp[i -1][j - 1];
                }else{
                    // 换，删，增
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
            }
        }
        return dp[m][n];

    }


}
//leetcode submit region end(Prohibit modification and deletion)

}