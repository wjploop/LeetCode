//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 
//
// 示例 1： 
//
// 
//输入：strs = ["flower","flow","flight"]
//输出："fl"
// 
//
// 示例 2： 
//
// 
//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 200 
// 0 <= strs[i].length <= 200 
// strs[i] 仅由小写英文字母组成 
// 
// Related Topics 字符串 👍 2324 👎 0


package com.wjp.leetcode.editor.cn;

class LongestCommonPrefix {
    public static void main(String[] args) {
        Solution solution = new LongestCommonPrefix().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            String str = strs[0];
            int k = 0;
            boolean same = true;
            while (same && k < str.length()) {
                for (int i = 1; i < strs.length; i++) {
                    if (strs[i].length() - 1 < k || str.charAt(k) != strs[i].charAt(k)) {
                        same = false;
                        break;
                    }
                }
                if (!same) {
                    break;
                }
                k++;
            }
            return str.substring(0, k);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}