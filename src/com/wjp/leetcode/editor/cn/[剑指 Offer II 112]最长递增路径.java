//给定一个 m x n 整数矩阵 matrix ，找出其中 最长递增路径 的长度。 
//
// 对于每个单元格，你可以往上，下，左，右四个方向移动。 不能 在 对角线 方向上移动或移动到 边界外（即不允许环绕）。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：matrix = [[9,9,4],[6,6,8],[2,1,1]]
//输出：4 
//解释：最长递增路径为 [1, 2, 6, 9]。 
//
// 示例 2： 
//
// 
//
// 
//输入：matrix = [[3,4,5],[3,2,6],[2,2,1]]
//输出：4 
//解释：最长递增路径是 [3, 4, 5, 6]。注意不允许在对角线方向上移动。
// 
//
// 示例 3： 
//
// 
//输入：matrix = [[1]]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 200 
// 0 <= matrix[i][j] <= 2³¹ - 1 
// 
//
// 
//
// 注意：本题与主站 329 题相同： https://leetcode-cn.com/problems/longest-increasing-path-
//in-a-matrix/ 
// Related Topics 深度优先搜索 广度优先搜索 图 拓扑排序 记忆化搜索 动态规划 👍 7 👎 0


package com.wjp.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class FpTFWP {
    public static void main(String[] args) {
        Solution solution = new FpTFWP().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[][] mt;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int m = 0, n = 0;

        public int longestIncreasingPath(int[][] matrix) {
            this.mt = matrix;

            // 经典最长增序列问题，扩充二维而已
            m = matrix.length;
            n = matrix[0].length;
            // 维护每个点的后继
//            List<int[]>[][] g = new List[m][n];
//            for (int i = 0; i < m; i++) {
//                for (int j = 0; j < n; j++) {
//                    for (int[] dir : dirs) {
//                        if (g[i][j] == null) {
//                            g[i][j] = new ArrayList<>();
//                        }
//                        int ni = i + dir[0], nj = j + dir[1];
//                        if (ni >= 0 && ni < m && nj >= 0 && nj < n && matrix[ni][nj] > matrix[i][j]) {
//                            g[i][j].add(new int[]{ni, nj});
//                        }
//                    }
//                }
//            }

//            for (int i = 0; i < m; i++) {
//                for (int j = 0; j < n; j++) {
//                    System.out.println("[" + i + "," + j + "] " + mt[i][j] + " : " + format(g[i][j]));
//                }
//            }

            // 维护一当前点为起点的最长序列长度
            int[][] lens = new int[m][n];

            int max = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    max = Math.max(max, dfs(lens, i, j));
                }
            }
            return max;
        }

        private int dfs(int[][] lens,int i, int j) {
            // 要是已经计算过了，直接返回
            if (lens[i][j] != 0) {
                return lens[i][j];
            }
            int len = 1;
            int max = 0;
            for (int[] dir : dirs) {
                int ni = i + dir[0], nj = j + dir[1];
                if (ni >= 0 && ni < m && nj >= 0 && nj < n && mt[ni][nj] > mt[i][j]) {
                    max = Math.max(max, dfs(lens, ni, nj));
                }
            }
            len += max;
            lens[i][j] = len;
//            System.out.println("[" + i + "," + j + "] " + mt[i][j] + " ：" + len);
            return len;
        }

        public String format(List<int[]> arr) {
            return String.join(", ", arr.stream().map(o -> mt[o[0]][o[1]] + ",").collect(Collectors.joining()));
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}