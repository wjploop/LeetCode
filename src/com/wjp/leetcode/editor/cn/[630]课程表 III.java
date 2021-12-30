//这里有 n 门不同的在线课程，按从 1 到 n 编号。给你一个数组 courses ，其中 courses[i] = [durationi, 
//lastDayi] 表示第 i 门课将会 持续 上 durationi 天课，并且必须在不晚于 lastDayi 的时候完成。 
//
// 你的学期从第 1 天开始。且不能同时修读两门及两门以上的课程。 
//
// 返回你最多可以修读的课程数目。 
//
// 
//
// 示例 1： 
//
// 
//输入：courses = [[100, 200], [200, 1300], [1000, 1250], [2000, 3200]]
//输出：3
//解释：
//这里一共有 4 门课程，但是你最多可以修 3 门：
//首先，修第 1 门课，耗费 100 天，在第 100 天完成，在第 101 天开始下门课。
//第二，修第 3 门课，耗费 1000 天，在第 1100 天完成，在第 1101 天开始下门课程。
//第三，修第 2 门课，耗时 200 天，在第 1300 天完成。
//第 4 门课现在不能修，因为将会在第 3300 天完成它，这已经超出了关闭日期。 
//
// 示例 2： 
//
// 
//输入：courses = [[1,2]]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：courses = [[3,2],[4,3]]
//输出：0
// 
//
// 
//
// 提示: 
//
// 
// 1 <= courses.length <= 10⁴ 
// 1 <= durationi, lastDayi <= 10⁴ 
// 
// Related Topics 贪心 数组 堆（优先队列） 👍 303 👎 0


package com.wjp.leetcode.editor.cn;

import java.util.Arrays;
import java.util.PriorityQueue;

class CourseScheduleIii {
    public static void main(String[] args) {
        Solution solution = new CourseScheduleIii().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int scheduleCourse(int[][] courses) {
            // duration, lastDay
            // 必须startDay <= lastDay - duration + 1
            // 我们尽可能选时长短的课程先上
            // 现在我们在 1 ， 在可选的课程中，选择lastDay最早的
            // 现在，我们在选择的lastDay+1, 那么，移除所有startDay <= lastDay的，继续选择
            Arrays.sort(courses, (a, b) -> a[1] - b[1]);
            PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> b - a);
            int total = 0;
            for (int[] c : courses) {
                int time = c[0], day = c[1];
                if (total + time <= day) {
                    total += time;
                    q.offer(time);
                    // 找到一个时长截至时间更小的，那么更换
                } else if (!q.isEmpty() && q.peek() > time) {
                    int cur = q.poll();
                    total = total - cur + time;
                    q.offer(time);
                }
            }
            return q.size();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}