//给定非负整数数组 heights ，数组中的数字用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。 
//
// 求在该柱状图中，能够勾勒出来的矩形的最大面积。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入：heights = [2,1,5,6,2,3]
//输出：10
//解释：最大的矩形为图中红色区域，面积为 10
// 
//
// 示例 2： 
//
// 
//
// 
//输入： heights = [2,4]
//输出： 4 
//
// 
//
// 提示： 
//
// 
// 1 <= heights.length <=10⁵ 
// 0 <= heights[i] <= 10⁴ 
// 
//
// 
//
// 注意：本题与主站 84 题相同： https://leetcode-cn.com/problems/largest-rectangle-in-
//histogram/ 
// Related Topics 栈 数组 单调栈 👍 8 👎 0


package com.wjp.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class ZeroYnMMM {
    public static void main(String[] args) {
        Solution solution = new ZeroYnMMM().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int largestRectangleArea(int[] heights) {
            int[] hs = new int[heights.length + 2];
            System.arraycopy(heights, 0, hs, 1, heights.length);
            Deque<Integer> stack = new ArrayDeque<>();
            int res = 0;
            for (int i = 0; i < hs.length; i++) {

                // 维护一个单调递增的栈
                // 遇到 h[i]时，寻找左边第一个比它小的元素
                //
                // 0 2, 1, 2, 0
                while (!stack.isEmpty() && hs[stack.peek()] > hs[i]) {
                    // 弹出所有比当前的元素更大的元素
                    int h = hs[stack.pop()];
                    int w = i - stack.peek() - 1;
                    System.out.println("get " + hs[i] + " and pop left " + hs[stack.peek()] + " width:" + w);
                    res = Math.max(res, w * h);
                }
                stack.push(i);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}