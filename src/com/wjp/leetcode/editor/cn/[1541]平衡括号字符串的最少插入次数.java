//给你一个括号字符串 s ，它只包含字符 '(' 和 ')' 。一个括号字符串被称为平衡的当它满足： 
//
// 
// 任何左括号 '(' 必须对应两个连续的右括号 '))' 。 
// 左括号 '(' 必须在对应的连续两个右括号 '))' 之前。 
// 
//
// 比方说 "())"， "())(())))" 和 "(())())))" 都是平衡的， ")()"， "()))" 和 "(()))" 都是不平衡的。 
//
// 你可以在任意位置插入字符 '(' 和 ')' 使字符串平衡。 
//
// 请你返回让 s 平衡的最少插入次数。 
//
// 
//
// 示例 1： 
//
// 输入：s = "(()))"
//输出：1
//解释：第二个左括号有与之匹配的两个右括号，但是第一个左括号只有一个右括号。我们需要在字符串结尾额外增加一个 ')' 使字符串变成平衡字符串 "(())))
//" 。
// 
//
// 示例 2： 
//
// 输入：s = "())"
//输出：0
//解释：字符串已经平衡了。
// 
//
// 示例 3： 
//
// 输入：s = "))())("
//输出：3
//解释：添加 '(' 去匹配最开头的 '))' ，然后添加 '))' 去匹配最后一个 '(' 。
// 
//
// 示例 4： 
//
// 输入：s = "(((((("
//输出：12
//解释：添加 12 个 ')' 得到平衡字符串。
// 
//
// 示例 5： 
//
// 输入：s = ")))))))"
//输出：5
//解释：在字符串开头添加 4 个 '(' 并在结尾添加 1 个 ')' ，字符串变成平衡字符串 "(((())))))))" 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10^5 
// s 只包含 '(' 和 ')' 。 
// 
// Related Topics 栈 贪心 字符串 👍 35 👎 0


package com.wjp.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class MinimumInsertionsToBalanceAParenthesesString {
    public static void main(String[] args) {
        Solution solution = new MinimumInsertionsToBalanceAParenthesesString().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minInsertions(String s) {
            int n = s.length();
            Stack<Character> stack = new Stack<>();
            int res = 0;
            for (int i = n - 1; i >= 0; i--) {
                char ch = s.charAt(i);
                if (ch == ')') {
                    stack.push(ch);
                } else {
                    // 遇到 ( ，只需判断栈中是否存在两个元素
                    if (stack.isEmpty()) {
                        //
                        res += 2;
                    } else if (stack.size() == 1) {
                        res += 1;
                        stack.pop();
                    } else {
                        stack.pop();
                        stack.pop();
                    }
                }
            }
            // 栈中剩下的))
            // (()))(()))()())))
            // ()()))
            System.out.println("size ");
            return stack.size() / 2 + stack.size() % 2 * 2 + res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}