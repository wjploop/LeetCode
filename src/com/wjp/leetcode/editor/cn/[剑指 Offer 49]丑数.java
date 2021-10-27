//我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。 
//
// 
//
// 示例: 
//
// 输入: n = 10
//输出: 12
//解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
//
// 说明: 
//
// 
// 1 是丑数。 
// n 不超过1690。 
// 
//
// 注意：本题与主站 264 题相同：https://leetcode-cn.com/problems/ugly-number-ii/ 
// Related Topics 哈希表 数学 动态规划 堆（优先队列） 👍 220 👎 0

  
package com.wjp.leetcode.editor.cn;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

class ChouShuLcof{
    public static void main(String[] args) {
        Solution solution = new ChouShuLcof().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int nthUglyNumber(int n) {
        // 初始一个集合，取出任一个数 2x, 3x, 5x,都为丑数
        // 那么下一个是谁？
        // 依次尝试，2x,3x,5x，得到一个数，结果不在原来的集合中，即是下一个丑数，可加入
        // 由于，由于x尝试后，便不用再尝试，即可下次从下一个丑数开始
        PriorityQueue<Long> heap = new PriorityQueue<>();
        Set<Long> set = new HashSet<>();
        set.add(1L);
        heap.offer(1L);
        int ugly= 1;

        int[] factories = new int[]{2, 3, 5};
        for (int i = 0; i < n; i++) {
            long min = heap.poll();
            ugly = (int) min;
            for (int factory : factories) {
                long num = min * factory;
                if (!set.contains(num)) {
                    set.add(num);
                    heap.offer(num);
                }
            }
        }
        return ugly;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
