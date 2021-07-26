//请实现一个函数用来匹配包含'. '和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（含0次）。在本题中，匹配
//是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但与"aa.a"和"ab*a"均不匹配。 
//
// 示例 1: 
//
// 输入:
//s = "aa"
//p = "a"
//输出: false
//解释: "a" 无法匹配 "aa" 整个字符串。
// 
//
// 示例 2: 
//
// 输入:
//s = "aa"
//p = "a*"
//输出: true
//解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
// 
//
// 示例 3: 
//
// 输入:
//s = "ab"
//p = ".*"
//输出: true
//解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
// 
//
// 示例 4: 
//
// 输入:
//s = "aab"
//p = "c*a*b"
//输出: true
//解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
// 
//
// 示例 5: 
//
// 输入:
//s = "mississippi"
//p = "mis*is*p*."
//输出: false 
//
// 
// s 可能为空，且只包含从 a-z 的小写字母。 
// p 可能为空，且只包含从 a-z 的小写字母以及字符 . 和 *，无连续的 '*'。 
// 
//
// 注意：本题与主站 10 题相同：https://leetcode-cn.com/problems/regular-expression-matching/
// 
// Related Topics 递归 字符串 动态规划 
// 👍 246 👎 0


package com.wjp.leetcode.editor.cn;

class ZhengZeBiaoDaShiPiPeiLcof {
    public static void main(String[] args) {
        Solution solution = new ZhengZeBiaoDaShiPiPeiLcof().new Solution();
        boolean res = solution.isMatch("aa", "a*");
        System.out.println(res);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isMatch(String s, String p) {
            // 定了 f[i][j] 表示的 s[i] 和 p[j] 之前的字符能否匹配
            // 即 s[0,i) 和 p[0,j)能否匹配
            // 这样，f[0][0] = true, f[n][m] 为所求，n = s.length, m = p.length

            // if p[j-1] != *
            //      f[i][j] = f[i-1][j-1] , s[i-1] == p[j-1]
            // else if p[j-1] == *
            //      假设 s[i-1] == p[j-2], 即 p前面一个字符可以与s当前字符匹配
            //          f[i][j] = f[i-1][j] || f[i][j-2]
            //      else
            //          f[i][j] = f[i][j-2], 即需要删除 *号，和前面一个字符，再检查剩余是否可以匹配
            return match(s, p, 0, 0);
        }

        // s[0,i) 与 p[0,j) 是否可以匹配

        private boolean match(String s, String p, int i, int j) {
            // 唯一可以成功的终点
            if(i == s.length() && j == p.length())
                return true;

            // 若是遇到 p中有 *,则，只有两种情况可以继续推进
            // 忽略 当前的*以及前面一个字符，
            // 或者，要求*前面的字符匹配，
            if (j + 1 < p.length() && p.charAt(j + 1) == '*') {

                return
                        // a* 匹配0次
                        match(s, p, i, j + 2)
                                // 匹配1..n次
                        || (i != s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') && match(s, p, i + 1, j));
            } else {
                return i != s.length() && j != p.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') && match(s, p, i + 1, j + 1);
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}