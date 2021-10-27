//给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。 
//
// 示例: 
//
// 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
//输出: [3,3,5,5,6,7] 
//解释: 
//
//  滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7 
//
// 
//
// 提示： 
//
// 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。 
//
// 注意：本题与主站 239 题相同：https://leetcode-cn.com/problems/sliding-window-maximum/ 
// Related Topics 队列 滑动窗口 单调队列 堆（优先队列） 👍 329 👎 0

  
package com.wjp.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

class HuaDongChuangKouDeZuiDaZhiLcof{
    public static void main(String[] args) {
        Solution solution = new HuaDongChuangKouDeZuiDaZhiLcof().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // 维护一个单调递减的栈就行
        int n = nums.length;
        int[] res = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < k; i++) {
            if (deque.isEmpty()) {
                deque.offerLast(nums[i]);
            }else{
                if (nums[i] <= deque.peekLast()) {
                    deque.offerLast(nums[i]);
                }else{
                    // 将无效的数字剔除
                    while (!deque.isEmpty() && nums[i] > deque.peekLast()) {
                        deque.pollLast();
                    }
                    deque.offerLast(nums[i]);
                }
            }
        }
        res[0] = deque.peekFirst();
        for (int i = k; i < n; i++) {
            // 添加 num[i] 移除 nums[i-k]
            if (nums[i] <= deque.peekLast()) {
                deque.offerLast(nums[i]);
            }else{
                // 将无效的数字剔除
                while (!deque.isEmpty() && nums[i] > deque.peekLast()) {
                    deque.pollLast();
                }
                deque.offerLast(nums[i]);
            }
            // 移除 num[i-k]
            // 是否影响 递减栈 ？
            // 队头的最大值，可能是num[i-k]贡献的，也可能是后面的元素贡献的
            // 处理方案
            // 修改递减栈，保持重复元素
            if (deque.peekFirst() == nums[i - k]) {
                deque.pollFirst();
            }
            res[i - k + 1] = deque.peekFirst();

        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
