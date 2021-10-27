//「快乐前缀」是在原字符串中既是 非空 前缀也是后缀（不包括原字符串自身）的字符串。 
//
// 给你一个字符串 s，请你返回它的 最长快乐前缀。 
//
// 如果不存在满足题意的前缀，则返回一个空字符串。 
//
// 
//
// 示例 1： 
//
// 输入：s = "level"
//输出："l"
//解释：不包括 s 自己，一共有 4 个前缀（"l", "le", "lev", "leve"）和 4 个后缀（"l", "el", "vel", 
//"evel"）。最长的既是前缀也是后缀的字符串是 "l" 。
// 
//
// 示例 2： 
//
// 输入：s = "ababab"
//输出："abab"
//解释："abab" 是最长的既是前缀也是后缀的字符串。题目允许前后缀在原字符串中重叠。
// 
//
// 示例 3： 
//
// 输入：s = "leetcodeleet"
//输出："leet"
// 
//
// 示例 4： 
//
// 输入：s = "a"
//输出：""
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10^5 
// s 只含有小写英文字母 
// 
// Related Topics 字符串 字符串匹配 哈希函数 滚动哈希 👍 67 👎 0


package com.wjp.leetcode.editor.cn;

class LongestHappyPrefix {
    public static void main(String[] args) {
        Solution solution = new LongestHappyPrefix().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 字符串哈希
        // 判断字符串出现字符的可能的范围，字符集的大小size，选一个大于size的整数为基数base
        // 那么任意一个字串都可能用一个数字表示了，基数不同的数字而已
        // 由于字符串可能比较长，故其数值取模，以一个比较大的质数即可。
        public String longestPrefix(String s) {
            int n = s.length();
            int prefix = 0, suffix = 0, mod = 100000007, base = 31;
            int currentBase = 1;
            int happy = 0;
            for (int i = 0; i < n; i++) {
                prefix = (prefix * base + s.charAt(i) - 'a') % mod;
                suffix = (s.charAt(n - 1 - i) * currentBase + suffix) % mod;
                currentBase = (currentBase * base) % mod;
                if(prefix == suffix){
                    happy = i+1;
                }
            }
            return s.substring(0,happy);
        }

        // time limit
        public String longestPrefix1(String s) {
            int n = s.length();
            for (int i = n - 1; i >= 1; i--) {
                boolean same = true;
                for (int j = 0; j < i; j++) {
                    if (s.charAt(j) != s.charAt(n - i + j)) {
                        same = false;
                        break;
                    }
                }
                if (same) {
                    return s.substring(0, i);
                }
            }
            return "";
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}