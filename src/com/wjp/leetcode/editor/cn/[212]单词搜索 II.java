//给定一个 m x n 二维字符网格 board 和一个单词（字符串）列表 words，找出所有同时在二维网格和字典中出现的单词。 
//
// 单词必须按照字母顺序，通过 相邻的单元格 内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使
//用。 
//
// 
//
// 示例 1： 
//
// 
//输入：board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f",
//"l","v"]], words = ["oath","pea","eat","rain"]
//输出：["eat","oath"]
// 
//
// 示例 2： 
//
// 
//输入：board = [["a","b"],["c","d"]], words = ["abcb"]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n == board[i].length 
// 1 <= m, n <= 12 
// board[i][j] 是一个小写英文字母 
// 1 <= words.length <= 3 * 10⁴ 
// 1 <= words[i].length <= 10 
// words[i] 由小写英文字母组成 
// words 中的所有字符串互不相同 
// 
// Related Topics 字典树 数组 字符串 回溯 矩阵 👍 486 👎 0


package com.wjp.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class WordSearchIi {
    public static void main(String[] args) {
        Solution solution = new WordSearchIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> findWords(char[][] board, String[] words) {
            int n = board.length, m = board[0].length;
            boolean[][] visited = new boolean[n][m];

            List<String> res = new ArrayList<>();
            for (String word : words) {
                boolean find = false;
                for (int i = 0; i < n; i++) {
                    if (find) {
                        break;
                    }
                    for (int j = 0; j < m; j++) {
                        clear(visited);
                        boolean contain = dfs(board,i,j,visited,word,0);
                        if (contain) {
                            find = true;
                            break ;
                        }
                    }
                }
                if (find) {
                    res.add(word);
                }
            }
            return res;
        }

        private boolean dfs(char[][] board, int i, int j, boolean[][] visited, String word, int k) {
            if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] || word.charAt(k) != board[i][j]) {
                return false;
            }
            visited[i][j] = true;
            k++;
            if (k == word.length()) {
                return true;
            }
            for (int[] dir : dirs) {
                if(dfs(board, i + dir[0], j + dir[1], visited, word, k)){
                    return true;
                }
            }
            visited[i][j] = false;
            return false;
        }

        private int[][] dirs = new int[][]{
                {1, 0},
                {-1, 0},
                {0, 1},
                {0, -1},
        };

        private void clear(boolean[][] visited) {
            for (boolean[] v : visited) {
                Arrays.fill(v, false);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
