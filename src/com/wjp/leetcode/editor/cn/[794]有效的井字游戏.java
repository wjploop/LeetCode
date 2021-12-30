//给你一个字符串数组 board 表示井字游戏的棋盘。当且仅当在井字游戏过程中，棋盘有可能达到 board 所显示的状态时，才返回 true 。 
//
// 井字游戏的棋盘是一个 3 x 3 数组，由字符 ' '，'X' 和 'O' 组成。字符 ' ' 代表一个空位。 
//
// 以下是井字游戏的规则： 
//
// 
// 玩家轮流将字符放入空位（' '）中。 
// 玩家 1 总是放字符 'X' ，而玩家 2 总是放字符 'O' 。 
// 'X' 和 'O' 只允许放置在空位中，不允许对已放有字符的位置进行填充。 
// 当有 3 个相同（且非空）的字符填充任何行、列或对角线时，游戏结束。 
// 当所有位置非空时，也算为游戏结束。 
// 如果游戏结束，玩家不允许再放置字符。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：board = ["O  ","   ","   "]
//输出：false
//解释：玩家 1 总是放字符 "X" 。
// 
//
// 示例 2： 
//
// 
//输入：board = ["XOX"," X ","   "]
//输出：false
//解释：玩家应该轮流放字符。 
//
// 示例 3： 
//
// 
//输入：board = ["XXX","   ","OOO"]
//输出：false
// 
//
// Example 4: 
//
// 
//输入：board = ["XOX","O O","XOX"]
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// board.length == 3 
// board[i].length == 3 
// board[i][j] 为 'X'、'O' 或 ' ' 
// 
// Related Topics 数组 字符串 👍 103 👎 0


package com.wjp.leetcode.editor.cn;

class ValidTicTacToeState {
    public static void main(String[] args) {
        Solution solution = new ValidTicTacToeState().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[] finished = new int[1];
        public boolean validTicTacToe(String[] board) {
            int[][] b = new int[3][3];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    char ch = board[i].charAt(j);
                    b[i][j] = ch == ' ' ? 0 : ch == 'X' ? 1 : -1;
                }
            }
            for (int i = 0; i < 3; i++) {
                // row
                if (sameAndNotEmpty(b[i][0], b[i][1], b[i][2])) {
                    return false;
                }
                // col
                if (sameAndNotEmpty(b[0][i], b[1][i], b[2][i])) {
                    return false;
                }
            }
            // 正对角
            if (sameAndNotEmpty(b[0][0], b[1][1], b[2][2])) {
                return false;
            }
            // 斜对角
            if (sameAndNotEmpty(b[0][2], b[1][1], b[2][0])) {
                return false;
            }
            System.out.println("无输赢");
            // 差值小于1
            int f = 0, m = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (b[i][j] == 0) {
                        continue;
                    }
                    if (b[i][j] == 1) {
                        f++;
                    }else{
                        m++;
                    }
                }
            }
            if (f - m >= 2 || f - m < 0) {
                return false;
            }
            System.out.println("差值正确");


            return false;
        }

        private boolean sameAndNotEmpty(int a, int b, int c) {
            boolean same = a == b && b == c && a != 0;
            return same;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}