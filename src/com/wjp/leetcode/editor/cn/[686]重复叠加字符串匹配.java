//给定两个字符串 a 和 b，寻找重复叠加字符串 a 的最小次数，使得字符串 b 成为叠加后的字符串 a 的子串，如果不存在则返回 -1。 
//
// 注意：字符串 "abc" 重复叠加 0 次是 ""，重复叠加 1 次是 "abc"，重复叠加 2 次是 "abcabc"。 
//
// 
//
// 示例 1： 
//
// 输入：a = "abcd", b = "cdabcdab"
//输出：3
//解释：a 重复叠加三遍后为 "abcdabcdabcd", 此时 b 是其子串。
// 
//
// 示例 2： 
//
// 输入：a = "a", b = "aa"
//输出：2
// 
//
// 示例 3： 
//
// 输入：a = "a", b = "a"
//输出：1
// 
//
// 示例 4： 
//
// 输入：a = "abc", b = "wxyz"
//输出：-1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= a.length <= 10⁴ 
// 1 <= b.length <= 10⁴ 
// a 和 b 由小写英文字母组成 
// 
// Related Topics 字符串 字符串匹配 👍 212 👎 0


package com.wjp.leetcode.editor.cn;

class RepeatedStringMatch {
    public static void main(String[] args) {
        Solution solution = new RepeatedStringMatch().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int repeatedStringMatch(String a, String b) {
            // abcd     cd adbcd ab
            // 可以把 b 分为三部分 a的右部分 + n * a + a的左部分
            // 那么，我们遍历b, 找到 n * a 的部分，
            // 若是 n == 0 ,即中间没有完整的 a, 那就要求，我们遍历末尾的部分，刚好为右部分
            // 若是右部分不存在，
            int m = a.length(), n = b.length();
            int maxLen = m * 2 + n;
            StringBuilder sb = new StringBuilder();
            int res = 0;
            while (sb.length() < maxLen) {
                sb.append(a);
                res++;
                if (sb.toString().contains(b)) {
                    return res;
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}