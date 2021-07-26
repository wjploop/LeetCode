//输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如，序列 {1,2,3,4,5} 是某栈
//的压栈序列，序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。 
//
// 
//
// 示例 1： 
//
// 输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
//输出：true
//解释：我们可以按以下顺序执行：
//push(1), push(2), push(3), push(4), pop() -> 4,
//push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
// 
//
// 示例 2： 
//
// 输入：pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
//输出：false
//解释：1 不能在 2 之前弹出。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= pushed.length == popped.length <= 1000 
// 0 <= pushed[i], popped[i] < 1000 
// pushed 是 popped 的排列。 
// 
//
// 注意：本题与主站 946 题相同：https://leetcode-cn.com/problems/validate-stack-sequences/ 
// Related Topics 栈 数组 模拟 
// 👍 214 👎 0

  
package com.wjp.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

class ZhanDeYaRuDanChuXuLieLcof{
    public static void main(String[] args) {
        Solution solution = new ZhanDeYaRuDanChuXuLieLcof().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> stack = new ArrayDeque<>();
        int j = 0;
        // 以入栈序列角度，每入一次栈，即检查是否满足出栈
        for (int x : pushed) {
            stack.push(x);
            // 每当入栈一个数，便急切检查是否符合出栈需求
            while (!stack.isEmpty() && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
        }
        // 是否出栈完了
        return j == popped.length;


    }
    public boolean validateStackSequences2(int[] pushed, int[] popped) {
        Deque<Integer> stack = new ArrayDeque<>();
        int j = 0;
        // 以出栈序列的角度模拟
        // 遍历出栈序列，若是当前栈不满足期待值，则入栈
        for (int expect: popped) {
            // 当前栈顶符合期待值，直接下一个
            if (!stack.isEmpty() && stack.peek() == expect) {
                stack.pop();
                continue;
            }
            // 不满足期待值，则一直从入栈直到符合期待值，或者不能继续入栈为止
            while ((stack.isEmpty() || stack.peek() != expect) && j < pushed.length) {
                stack.push(pushed[j++]);
            }
            // 好了，符合期待值了
            if (stack.peek() == expect) {
                stack.pop();
            }
            // 入栈队列完了，还是没找到期待值，则可以判断错误了
            if (j == pushed.length) {
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}