//n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 给你一个整数 n ，返回 n 皇后问题 不同的解决方案的数量。 
//
// 
//
// 
// 
// 示例 1： 
//
// 
//输入：n = 4
//输出：2
//解释：如上图所示，4 皇后问题存在两个不同的解法。
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 9 
// 皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。 
// 
// 
// 
// Related Topics 回溯 
// 👍 278 👎 0

  
package com.wjp.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class NQueensIi{
    public static void main(String[] args) {
        Solution solution = new NQueensIi().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int totalNQueens(int n) {
        Set<Integer> columns = new HashSet<>();
        Set<Integer> leftDown = new HashSet<>();
        Set<Integer> rightDown = new HashSet<>();
        int[] queue = new int[n];
        Arrays.fill(queue, -1);
        int[] res = new int[1];
        backTrack(n, queue, res, 0, columns, leftDown, rightDown);
        return res[0];
    }

    private void backTrack(int n, int[] queue, int[] res, int row, Set<Integer> columns, Set<Integer> leftDown, Set<Integer> rightDown) {

        if (row == n) {
            res[0]++;
        }else{
            for (int i = 0; i < n; i++) {
                if (columns.contains(i)) {
                    continue;
                }
                int k1 = row - i;
                if (leftDown.contains(k1)) {
                    continue;
                }
                int k2 = row + i;
                if (rightDown.contains(k2)) {
                    continue;
                }
//                queue[row] = i;
                columns.add(i);
                leftDown.add(k1);
                rightDown.add(k2);
                backTrack(n, queue, res, row + 1, columns, leftDown, rightDown);
//                queue[row] = -1;
                columns.remove(i);
                leftDown.remove(k1);
                rightDown.remove(k2);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}