//你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。 
//
// 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表
//示如果要学习课程 ai 则 必须 先学习课程 bi 。 
//
// 
// 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。 
// 
//
// 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：numCourses = 2, prerequisites = [[1,0]]
//输出：true
//解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。 
//
// 示例 2： 
//
// 
//输入：numCourses = 2, prerequisites = [[1,0],[0,1]]
//输出：false
//解释：总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0 ；并且学习课程 0 之前，你还应先完成课程 1 。这是不可能的。 
//
// 
//
// 提示： 
//
// 
// 1 <= numCourses <= 10⁵ 
// 0 <= prerequisites.length <= 5000 
// prerequisites[i].length == 2 
// 0 <= ai, bi < numCourses 
// prerequisites[i] 中的所有课程对 互不相同 
// 
// Related Topics 深度优先搜索 广度优先搜索 图 拓扑排序 👍 1063 👎 0


package com.wjp.leetcode.editor.cn;

import java.util.*;

class CourseSchedule {
    public static void main(String[] args) {
        Solution solution = new CourseSchedule().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canFinish(int n, int[][] prerequisites) {
                     // 判断是否有环？有环则不可能修完

            int[] inDegree = new int[n];
            // 表示谁依赖课程 i
            List<Integer>[] g = new List[n];
            for (int i = 0; i < n; i++) {
                g[i] = new ArrayList<>();
            }
            for (int[] edge : prerequisites) {
                int a = edge[0], b = edge[1];
                inDegree[a]++;
                g[b].add(a);
            }
            Queue<Integer> queue = new ArrayDeque<>();
            for (int i = 0; i < n; i++) {
                if (inDegree[i] == 0) {
                    // 将入度为 0 的课程添加进入，表示可以直接修
                    queue.add(i);
                }
            }
            int count = n;
            while (!queue.isEmpty()) {
                int cur = queue.poll();
//                System.out.println(" finish " + cur);
                count--;
                for (int next : g[cur]) {
                    inDegree[next]--;
                    if (inDegree[next] == 0) {
                        queue.offer(next);
                    }
                }
            }
            return count == 0;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}