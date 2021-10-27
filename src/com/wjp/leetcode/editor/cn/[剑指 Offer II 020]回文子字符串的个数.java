//给定一个字符串 s ，请计算这个字符串中有多少个回文子字符串。 
//
// 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "abc"
//输出：3
//解释：三个回文子串: "a", "b", "c"
// 
//
// 示例 2： 
//
// 
//输入：s = "aaa"
//输出：6
//解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa" 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 由小写英文字母组成 
// 
//
// 
//
// 注意：本题与主站 647 题相同：https://leetcode-cn.com/problems/palindromic-substrings/ 
// Related Topics 字符串 动态规划 👍 10 👎 0


package com.wjp.leetcode.editor.cn;

class A7VOhD {
    public static void main(String[] args) {
        Solution solution = new A7VOhD().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countSubstrings(String s) {
            char[] chs = s.toCharArray();
            int res = 0;
            for (int k = 0; k < chs.length; k++) {
                res += countFrom(chs, k, k) + countFrom(chs, k, k + 1);
            }
            return res;
        }

        int countFrom(char[] chs, int i, int j) {
            if (i < 0 || j > chs.length - 1) {
                return 0;
            }
            if (chs[i] == chs[j]) {
                return 1 + countFrom(chs, i - 1, j + 1);
            } else {
                return 0;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}