//给定一个字符串 s ，验证 s 是否是 回文串 ，只考虑字母和数字字符，可以忽略字母的大小写。 
//
// 本题中，将空字符串定义为有效的 回文串 。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "A man, a plan, a canal: Panama"
//输出: true
//解释："amanaplanacanalpanama" 是回文串 
//
// 示例 2: 
//
// 
//输入: s = "race a car"
//输出: false
//解释："raceacar" 不是回文串 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 2 * 10⁵ 
// 字符串 s 由 ASCII 字符组成 
// 
//
// 
//
// 注意：本题与主站 125 题相同： https://leetcode-cn.com/problems/valid-palindrome/ 
// Related Topics 双指针 字符串 👍 5 👎 0


package com.wjp.leetcode.editor.cn;

class XltzEq {
    public static void main(String[] args) {
        Solution solution = new XltzEq().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPalindrome(String s) {
            s = s.toLowerCase();
            int i = 0, j = s.length() - 1;
            while (i <= j) {
                while (i <= j && !isConsider(s.charAt(i))) {
                    i++;
                }
                boolean findLeft = i <= j;
                while (i <= j && !isConsider(s.charAt(j))) {
                    j--;
                }
                boolean findRight = i <= j;
                if (findLeft && findRight) {
                    if (s.charAt(i) != s.charAt(j)) {
                        System.out.println(s.charAt(i) + "," + s.charAt(j));
                        return false;
                    }
                    i++;
                    j--;
                }
            }
            return true;
        }

        private boolean isConsider(char ch) {
            return (ch >= '0' && ch <= '9') || (ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z');
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}