//给你一个只包含 0 和 1 的 rows * columns 矩阵 mat ，请你返回有多少个 子矩形 的元素全部都是 1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：mat = [[1,0,1],
//         [1,1,0],
//         [1,1,0]]
//输出：13
//解释：
//有 6 个 1x1 的矩形。
//有 2 个 1x2 的矩形。
//有 3 个 2x1 的矩形。
//有 1 个 2x2 的矩形。
//有 1 个 3x1 的矩形。
//矩形数目总共 = 6 + 2 + 3 + 1 + 1 = 13 。
// 
//
// 示例 2： 
//
// 
//输入：mat = [[0,1,1,0],
//         [0,1,1,1],
//         [1,1,1,0]]
//输出：24
//解释：
//有 8 个 1x1 的子矩形。
//有 5 个 1x2 的子矩形。
//有 2 个 1x3 的子矩形。
//有 4 个 2x1 的子矩形。
//有 2 个 2x2 的子矩形。
//有 2 个 3x1 的子矩形。
//有 1 个 3x2 的子矩形。
//矩形数目总共 = 8 + 5 + 2 + 4 + 2 + 2 + 1 = 24 。
// 
//
// 示例 3： 
//
// 
//输入：mat = [[1,1,1,1,1,1]]
//输出：21
// 
//
// 示例 4： 
//
// 
//输入：mat = [[1,0,1],[0,1,0],[1,0,1]]
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// 1 <= rows <= 150 
// 1 <= columns <= 150 
// 0 <= mat[i][j] <= 1 
// 
// Related Topics 栈 数组 动态规划 矩阵 单调栈 
// 👍 109 👎 0


package com.wjp.leetcode.editor.cn;

class CountSubmatricesWithAllOnes {
    public static void main(String[] args) {
        Solution solution = new CountSubmatricesWithAllOnes().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numSubmat(int[][] mat) {
            int n = mat.length, m = mat[0].length;
            // row[i][j] 记录第 i 行 以 j 为终点，左边为1的长度
            int[][] row = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (j == 0) {
                        row[i][j] = mat[i][j];
                    } else if (mat[i][j] == 1) {
                        row[i][j] = row[i][j - 1] + 1;
                    }else{
                        row[i][j] = 0;
                    }
                }
            }

            int res = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    // 以mat[i][j] 为右下角，检查能够组成的矩形有多少个
                    // 如何检查？
                    // 查看当前行以[j]为终点，左边的全是1的长度col
                    // 若col > 0 , 即找到高 = 1， w = (col .. 1) 的矩形，总共为 col个高度为1的矩形
                    // 检查 h = 2 时，至少要求 mat[i-1][j] == 1, w  = （两个以 j 为终点的长度的最小值）,令此时的宽度为 w
                    //      此时 h = 2的矩形个数就是 w 个
                    //
                    int w = row[i][j];
                    // 往上寻找以该点为右下角的矩形
                    for (int k = i; k >= 0 && w > 0; k--) {
                        // 以 j为边界，看下左边的为1的宽度
                        // 每遍历一次，高度加1，矩形个数
                        // w 单调递减
                        w = Math.min(w, row[k][j]);
                        res += w;
                    }
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}