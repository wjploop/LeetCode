//输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。 
//
// 
//
// 示例 1： 
//
// 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
//
// 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 限制： 
//
// 
// 0 <= matrix.length <= 100 
// 0 <= matrix[i].length <= 100 
// 
//
// 注意：本题与主站 54 题相同：https://leetcode-cn.com/problems/spiral-matrix/ 
// Related Topics 数组 矩阵 模拟 
// 👍 280 👎 0

  
package com.wjp.leetcode.editor.cn;
  
class ShunShiZhenDaYinJuZhenLcof{
    public static void main(String[] args) {
        Solution solution = new ShunShiZhenDaYinJuZhenLcof().new Solution();
        int[][] matrix = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
        };
        solution.spiralOrder(matrix);
    }
//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 这题只是的模拟题，
     * 为什么在每个方向上判断 k < m * n ?
     * 假设只有一行，m = 1, n = 3
     * left -> right 后，top++,
     * top -> bottom 由于 top == bottom，这个方向不走了，即不会进入for循环
     * 可是 right -> left 这个方向，还是会进入循环，而此时 k 已经等于m*n, 故操作 res[k++]就越界
     */
    class Solution {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[0];
        }
        int m = matrix.length, n = matrix[0].length;
        int top = 0, bottom = m-1, left = 0, right = n-1;
        int[] res = new int[m * n];
        int k = 0;
        // 4 2 3 1
        while (k < m * n) {
            System.out.println("k = " + k);
            if (k == m * n) {
                break;
            }
            for (int i = left; i <= right; i++) {
                res[k++] = matrix[top][i];
            }
            if (k == m * n) {
                break;
            }

            top++;
            for (int i = top; i <= bottom; i++) {
                res[k++] = matrix[i][right];
            }
            if (k == m * n) {
                break;
            }

            right--;
            for (int i = right; i >= left; i--) {
                res[k++] = matrix[bottom][i];
            }
            if (k == m * n) {
                break;
            }
            bottom--;
            for (int i = bottom; i >= top; i--) {
                res[k++] = matrix[i][left];
            }
            if (k == m * n) {
                break;
            }

            left++;
        }
        return res;
    }


}
//leetcode submit region end(Prohibit modification and deletion)

}