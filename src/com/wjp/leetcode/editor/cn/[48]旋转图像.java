//给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。 
//
// 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[[7,4,1],[8,5,2],[9,6,3]]
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
//输出：[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
// 
//
// 示例 3： 
//
// 
//输入：matrix = [[1]]
//输出：[[1]]
// 
//
// 示例 4： 
//
// 
//输入：matrix = [[1,2],[3,4]]
//输出：[[3,1],[4,2]]
// 
//
// 
//
// 提示： 
//
// 
// matrix.length == n 
// matrix[i].length == n 
// 1 <= n <= 20 
// -1000 <= matrix[i][j] <= 1000 
// 
// Related Topics 数组 数学 矩阵 
// 👍 935 👎 0

  
package com.wjp.leetcode.editor.cn;

import java.util.Arrays;

class RotateImage{
    public static void main(String[] args) {
        Solution solution = new RotateImage().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public void rotate1(int[][] matrix) {
        // 顺时针旋转90度
        // 相当于第一行成为了右边第一列
        // start  = [0,0] temp = num;
        // 1,2
        // 3,4
        // >>
        // 3,1
        // 4,2

        // 1,2,3
        // 4,5,6,
        // 7,8,9
        // >>
        // 7,4,1
        // 8,5,2
        // 9,6,3

        // 即 res[j][n-1-i] = matrix[i][j]

        int n = matrix.length;
        int[][] res = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                res[j][n - 1 - i] = matrix[i][j];
            }
        }
        for (int i = 0; i <n; i++) {
            System.arraycopy(res[i], 0, matrix[i], 0, n);
        }

    }

    public void rotate(int[][] matrix) {
        // 既然得出 matrix[j][n-1-i] = matrix[i][j]
        // 我们记录 tmp = matrix[j][n-1-i]
        // 那么，这个 matrix[j][n-1-i] 转移到了哪呢
        // 既然每个点都符合这个要求，故
        // matrix[n-1-i][n-1-j] = matrix[j][n-1-i]
        // 继续
        // matrix[n-1-j][n-1 - (n-1-i] == matrix[n-1-j][i]
        // matrix[i][j] = matrix[n-1-j][i]
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < (n + 1) / 2; j++) {

                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
//                matrix[j][n - 1 - i] = matrix[i][j];
                matrix[j][n - 1 - i] = tmp;
            }
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}