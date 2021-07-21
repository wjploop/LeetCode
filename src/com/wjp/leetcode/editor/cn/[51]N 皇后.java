//n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。 
//
// 
// 
// 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 4
//输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
//解释：如上图所示，4 皇后问题存在两个不同的解法。
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[["Q"]]
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
// Related Topics 数组 回溯 
// 👍 936 👎 0


package com.wjp.leetcode.editor.cn;

import java.sql.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class NQueens {
    public static void main(String[] args) {

        Solution solution = new NQueens().new Solution();



    }

    private static void printBoard() {

    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int n = 0;
        List<List<String>> res;
        int[] queues;
        Set<Integer> columns;
        Set<Integer> leftDown;
        Set<Integer> rightDown;

        public List<List<String>> solveNQueens(int n) {
            this.n = n;
            // 用一个数组来表示第i行放置的皇后的位置为queue[i]
            queues = new int[n];
            // 表示第几列是否有皇后了
            columns = new HashSet<>();
            // 表示左下斜线是否有皇后了，如何表示这个斜线呢？
            // 可以用 row - col 表示，即行列的差值，
            leftDown = new HashSet<>();
            // 同上
            rightDown = new HashSet<>();

            res = new ArrayList<>();
            backtrack(0);
            return res;
        }

        private void backtrack(int row) {
            if (row == n) {
                List<String> board = generate();
                res.add(board);
            }else{
                for (int col = 0; col < n; col++) {
                    if (columns.contains(col)) {
                        continue;
                    }
                    int k1 = row - col;
                    if (leftDown.contains(k1)) {
                        continue;
                    }
                    int k2 = row + col;
                    if (rightDown.contains(k2)) {
                        continue;
                    }

                    queues[row] = col;
                    columns.add(col);
                    leftDown.add(k1);
                    rightDown.add(k2);
                    backtrack(row + 1);
                    queues[row] = -1;
                    columns.remove(col);
                    leftDown.remove(k1);
                    rightDown.remove(k2);
                }
            }
        }

        private List<String> generate() {
            List<String> board = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                char[] row = new char[n];
                Arrays.fill(row, '.');
                row[queues[i]] = 'Q';
                board.add(new String(row));
            }
            return board;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}