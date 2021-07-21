//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 
// 
//
// 示例 2： 
//
// 
//输入：height = [4,2,0,3,2,5]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// n == height.length 
// 0 <= n <= 3 * 104 
// 0 <= height[i] <= 105 
// 
// Related Topics 栈 数组 双指针 动态规划 单调栈 
// 👍 2469 👎 0


package com.wjp.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

class TrappingRainWater {
    public static void main(String[] args) {
        Solution solution = new TrappingRainWater().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
//    class Solution {
//        public int trap(int[] height) {
//            if (height == null || height.length == 0) {
//                return 0;
//            }
//            // 找到最大的 max，
//            // 左边开始向max遍历，记录当前最大高度，计算当前可以
//            int maxI = 0;
//            for (int i = 1; i < height.length; i++) {
//                if (height[i] >= height[maxI]) {
//                    maxI = i;
//                }
//            }
//            int res = 0;
//            int max = height[0];
//            for (int i = 1; i < maxI; i++) {
//                if (height[i] < max) {
//                    res += max - height[i];
//                }else{
//                    max = height[i];
//                }
//            }
//            max = height[height.length - 1];
//            for (int i = height.length - 2; i > maxI; i--) {
//                if (height[i] < max) {
//                    res += max - height[i];
//                }else{
//                    max = height[i];
//                }
//            }
//            return res;
//        }
//    }
    class Solution {
        public int trap(int[] height) {
            // 假设输入的是一个流，我们需要尽快对结果进行计算
            // 或者说，假设只给我们一次遍历的机会
            // 从左往右，若是发现当前高度比之前的更高，那么前面的就计算完成了
            // 思路可以是，维护一个单调减的栈
            if (height == null || height.length == 0) {
                return 0;
            }
            Deque<Integer> stack = new ArrayDeque<>();
            stack.push(0);
            int res = 0;
            for (int i = 1; i < height.length; i++) {
                if(stack.isEmpty()){
                    stack.push(i);
                }else{
                    if(height[i] <= height[stack.peek()]){
                        stack.push(i);
                    }else{
                        // 发现栈顶的元素比遇到元素要小，则要出栈
                        while(!stack.isEmpty() && height[i] > height[stack.peek()]){
                            int k = stack.pop();
                            if(!stack.isEmpty()){
                                int j = stack.peek();
                                int min = Math.min(height[j], height[i]);
                                res += (min - height[k]) * (i - j - 1);
                            }else{
                                break;
                            }
                        }
                        stack.push(i);

                    }
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}