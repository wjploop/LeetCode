//地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一
//格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但
//它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？ 
//
// 
//
// 示例 1： 
//
// 输入：m = 2, n = 3, k = 1
//输出：3
// 
//
// 示例 2： 
//
// 输入：m = 3, n = 1, k = 0
//输出：1
// 
//
// 提示： 
//
// 
// 1 <= n,m <= 100 
// 0 <= k <= 20 
// 
// Related Topics 深度优先搜索 广度优先搜索 动态规划 
// 👍 327 👎 0


package com.wjp.leetcode.editor.cn;

class JiQiRenDeYunDongFanWeiLcof {
    public static void main(String[] args) {
        Solution solution = new JiQiRenDeYunDongFanWeiLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int movingCount(int m, int n, int k) {
            boolean[][] state = new boolean[m][n];
            int[] res = new int[1];
            dfs(state, m, n, 0, 0, k, res);
            return res[0];
        }

        private void dfs(boolean[][] state, int m, int n, int i, int j, int k, int[] res) {

            if (i < 0 || j < 0 || i >= m || j >= n) {
                return;
            }
            if (state[i][j]) {
                return;
            }
            if (sum(i) + sum(j) <= k) {
                state[i][j] = true;
                res[0]++;
            }else{
                return;
            }
            for (int[] dir : dirs) {
                dfs(state, m, n, i + dir[0], j + dir[1], k, res);
            }

        }

        private int sum(int x) {
            int sum = 0;
            while (x > 0) {
                sum += x % 10;
                x = x / 10;
            }
            return sum;
        }

        private int[][] dirs = {
                {0, 1},
                {0, -1},
                {1, 0},
                {-1, 0},
        };
    }
//leetcode submit region end(Prohibit modification and deletion)

}