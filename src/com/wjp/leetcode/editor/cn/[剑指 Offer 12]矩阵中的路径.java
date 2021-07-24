//给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 例如，在下面的 3×4 的矩阵中包含单词 "ABCCED"（单词中的字母已标出）。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "AB
//CCED"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：board = [["a","b"],["c","d"]], word = "abcd"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= board.length <= 200 
// 1 <= board[i].length <= 200 
// board 和 word 仅由大小写英文字母组成 
// 
//
// 
//
// 注意：本题与主站 79 题相同：https://leetcode-cn.com/problems/word-search/ 
// Related Topics 数组 回溯 矩阵 
// 👍 368 👎 0


package com.wjp.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

class JuZhenZhongDeLuJingLcof {
    public static void main(String[] args) {
        Solution solution = new JuZhenZhongDeLuJingLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     *
     */
    class Solution {
        boolean[][] state;
        List<int[]> starts;
        int m , n;
        public boolean exist(char[][] board, String word) {
            m = board.length;
            n = board[0].length;
            state = new boolean[m][n];
            starts = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] == word.charAt(0)) {
                        starts.add(new int[]{i, j});
                    }
                }
            }
            for (int[] start : starts) {
                if (backTrace(board, start, 0, word)) {

                    return true;
                }
            }
            return false;
        }

        private boolean backTrace(char[][] board, int[] start, int k, String word) {

            if (k == word.length()) {
                return true;
            }
            int i = start[0], j = start[1];
            if ( state[i][j] || board[i][j] != word.charAt(k)) {
                return false;
            }
            // 后面没有其他方向了，
            if (k + 1 == word.length()) {
                return true;
            }
            state[i][j] = true;
            for (int[] dir : dirs) {
                int[] next = new int[]{start[0] + dir[0], start[1] + dir[1]};
                if (isValid(next)) {
                    System.out.println("start [" + start[0] + "," + start[1] + "], next [" + next[0] + "," + next[1] + "]");
                    boolean cur = backTrace(board, next, k + 1, word);
                    if (cur) {
                        return true;
                    }
                }
                System.out.println("start [" + start[0] + "," + start[1] + "]  end");
            }
            state[i][j] = false;

            return false;


        }

        private boolean isValid(int[] pos) {
            if (pos[0] < 0 || pos[1] < 0 || pos[0] >= m || pos[1] >= n) {
                return false;
            }
            return true;
        }

        int[][] dirs = {
                {0, 1},
                {0, -1},
                {1, 0},
                {-1, 0},
        };

    }
//leetcode submit region end(Prohibit modification and deletion)

}