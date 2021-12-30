//给你一个 m * n 的网格，其中每个单元格不是 0（空）就是 1（障碍物）。每一步，您都可以在空白单元格中上、下、左、右移动。 
//
// 如果您 最多 可以消除 k 个障碍物，请找出从左上角 (0, 0) 到右下角 (m-1, n-1) 的最短路径，并返回通过该路径所需的步数。如果找不到这样
//的路径，则返回 -1。 
//
// 
//
// 示例 1： 
//
// 输入： 
//grid = 
//[[0,0,0],
// [1,1,0],
// [0,0,0],
// [0,1,1],
// [0,0,0]], 
//k = 1
//输出：6
//解释：
//不消除任何障碍的最短路径是 10。
//消除位置 (3,2) 处的障碍后，最短路径是 6 。该路径是 (0,0) -> (0,1) -> (0,2) -> (1,2) -> (2,2) -> (3
//,2) -> (4,2).
// 
//
// 
//
// 示例 2： 
//
// 输入：
//grid = 
//[[0,1,1],
// [1,1,1],
// [1,0,0]], 
//k = 1
//输出：-1
//解释：
//我们至少需要消除两个障碍才能找到这样的路径。
// 
//
// 
//
// 提示： 
//
// 
// grid.length == m 
// grid[0].length == n 
// 1 <= m, n <= 40 
// 1 <= k <= m*n 
// grid[i][j] == 0 or 1 
// grid[0][0] == grid[m-1][n-1] == 0 
// 
// Related Topics 广度优先搜索 数组 矩阵 👍 152 👎 0


package com.wjp.leetcode.editor.cn;

import com.wjp.util.ArrayUtil;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.stream.Collectors;

class ShortestPathInAGridWithObstaclesElimination {
    public static void main(String[] args) {
        Solution solution = new ShortestPathInAGridWithObstaclesElimination().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int shortestPath(int[][] grid, int k) {
            // 最多可以消除 k
            // 任意两点的距离为

            // 假设k = 0

            return path(grid, k);
        }

        private int path(int[][] grid, int k) {
            int n = grid.length, m = grid[0].length;

            if (n == 1 && m == 1) {
                return 0;
            }

            // -1 表示没访问过，否则记录访问过后，该位置剩余的k，
            int[][] visited = new int[n][m];
            for (int i = 0; i < n; i++) {
                Arrays.fill(visited[i], -1);
            }
            Queue<int[]> q = new ArrayDeque<>();
            q.offer(new int[]{0, 0, k});
            visited[0][0] = k;
            int step = 0;
            while (!q.isEmpty()) {
                // 上次移动步数为 step 的位置个数
                int size = q.size();
                // 移动下一步
                step++;
                // 这些下一步的移动步数都是 step + 1
                for (int i = 0; i < size; i++) {
                    int[] cur = q.poll();
                    // 我们不仅记录了上次的位置，而且还记录了移动到该位置消剩余的子弹
                    int y = cur[0], x = cur[1], curK = cur[2];
                    for (int[] dir : dirs) {
                        int ny = y + dir[0], nx = x + dir[1];
                        if (ny < 0 || ny >= n || nx < 0 || nx >= m) {
                            continue;
                        }

                        // 我们试图从 cur 移动到 next
                        // 如果 next 位置无障碍，那么我们移动到该位置的后剩余的子弹数不变，否则消耗 1 子弹到达 next

                        int remainK = grid[ny][nx] == 1 ? curK - 1 : curK;



                        if (ny == n - 1 && nx == m - 1) {
                            return step;
                        }

//                        System.out.println(format(cur) + " >>> " + format(new int[]{ny, nx, remainK}));


                        // 若是超过了消耗的子弹，我们不可能到达该位置
                        if (remainK < 0) {
                            continue;
                        }

                        // 若是没访问过该位置，我们将其添加到下一步中
                        if (visited[ny][nx] == -1) {
                            q.offer(new int[]{ny, nx, remainK});
                            visited[ny][nx] = remainK;
                        }

                        // 已经访问过该位置了
                        // 按理我们不再取访问试图从它访问它，但是我们发现从现在的路径走，剩余的子弹更多，我们就添加一个更好的路径
                        // 注意噢，原先的路径我们仍保留着，因为它显然消耗的 step 更少
                        // 这里的更好路径，是指剩余的子弹尽可能多
                        if (visited[ny][nx] != -1 && remainK > visited[ny][nx]) {
                            q.offer(new int[]{ny, nx, remainK});
                            visited[ny][nx] = remainK;

                        }
                    }
                }

            }
            return -1;
        }

        int[][] dirs = {
                {1, 0},
                {-1, 0},
                {0, 1},
                {0, -1},
        };
        public  String format(int[] arr) {
            return String.join(", ", Arrays.stream(arr).mapToObj(String::valueOf).collect(Collectors.joining()));
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}