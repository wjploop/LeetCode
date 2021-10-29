//给定一个 24 小时制（小时:分钟 "HH:MM"）的时间列表，找出列表中任意两个时间的最小时间差并以分钟数表示。 
//
// 
//
// 示例 1： 
//
// 
//输入：timePoints = ["23:59","00:00"]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：timePoints = ["00:00","23:59","00:00"]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 2 <= timePoints <= 2 * 10⁴ 
// timePoints[i] 格式为 "HH:MM" 
// 
//
// 
//
// 注意：本题与主站 539 题相同： https://leetcode-cn.com/problems/minimum-time-difference/ 
// Related Topics 数组 数学 字符串 排序 👍 1 👎 0

  
package com.wjp.leetcode.editor.cn;

import java.util.List;
import java.util.stream.Collectors;

class Five69nqc{
    public static void main(String[] args) {
        Solution solution = new Five69nqc().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findMinDifference(List<String> timePoints) {
        if (timePoints.size() > 24 * 60) {
            return 0;
        }
        List<Integer> times = timePoints.stream().map(s -> minute(s)).sorted().collect(Collectors.toList());
        int min = times.get(0) + 24 * 60 - times.get(times.size() - 1);
        min = min > 12 * 60 ? 24 * 60 - min : min;
        for (int i = 0; i < times.size() - 1; i++) {
            int min1 = times.get(i);
            int min2 = times.get(i + 1);
            int diff = min2 - min1;
            diff = diff > 12 * 60 ? 24 * 60 - diff : diff;
//            System.out.println("diff "+ diff);
            min = Math.min(min, diff);
        }
        return min;
    }

    private int minute(String time) {
        String[] hourMinute = time.split(":");
        return Integer.parseInt(hourMinute[0]) * 60 + Integer.parseInt(hourMinute[1]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}