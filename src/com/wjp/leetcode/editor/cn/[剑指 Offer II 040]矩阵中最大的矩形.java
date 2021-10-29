//给定一个由 0 和 1 组成的矩阵 matrix ，找出只包含 1 的最大矩形，并返回其面积。 
//
// 注意：此题 matrix 输入格式为一维 01 字符串数组。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：matrix = ["10100","10111","11111","10010"]
//输出：6
//解释：最大矩形如上图所示。
// 
//
// 示例 2： 
//
// 
//输入：matrix = []
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：matrix = ["0"]
//输出：0
// 
//
// 示例 4： 
//
// 
//输入：matrix = ["1"]
//输出：1
// 
//
// 示例 5： 
//
// 
//输入：matrix = ["00"]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// rows == matrix.length 
// cols == matrix[0].length 
// 0 <= row, cols <= 200 
// matrix[i][j] 为 '0' 或 '1' 
// 
//
// 
//
// 注意：本题与主站 85 题相同（输入参数格式不同）： https://leetcode-cn.com/problems/maximal-
//rectangle/ 
// Related Topics 栈 数组 动态规划 矩阵 单调栈 👍 8 👎 0


package com.wjp.leetcode.editor.cn;

class PLYXKQ {
    public static void main(String[] args) {
        Solution solution = new PLYXKQ().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximalRectangle(String[] matrix) {
            if (matrix.length == 0) {
                return 0;
            }
            int n = matrix.length, m = matrix[0].length();
            int[][] mat = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    mat[i][j] = matrix[i].charAt(j) == '0' ? 0 : 1;
                }
            }
            // cont[i][j][0]记录该位置左边的长度
            // cont[i][j][1]记录该位置上起的长度
            int[][][] count = new int[n][m][2];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (j == 0) {
                        count[i][j][0] = mat[i][j];
                    } else {
                        count[i][j][0] = mat[i][j] == 0 ? 0 : count[i][j - 1][0] + 1;
                    }
                }
            }
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (j == 0) {
                        count[j][i][1] = mat[j][i];
                    } else {
                        count[j][i][1] = mat[j][i] == 0 ? 0 : count[j - 1][i][1] + 1;
                    }
                }
            }
            // 定了一个点后，左边的长度为 w， h = 1
            // 往上遍历，
            int area = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    // 以该点为右下角可以围成的最大的面积
                    if (mat[i][j] == 0) {
                        continue;
                    }
                    int w = count[i][j][0];
                    for (int k = 0; k < count[i][j][1]; k++) {
                        w = Math.min(w, count[i-k][j][0]);
                        int h = k + 1;
                        area = Math.max(area, w * h);
                    }
                }
            }
            return area;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}