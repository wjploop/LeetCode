//给定一个非空字符串 s，请判断如果 最多 从字符串中删除一个字符能否得到一个回文字符串。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "aba"
//输出: true
// 
//
// 示例 2: 
//
// 
//输入: s = "abca"
//输出: true
//解释: 可以删除 "c" 字符 或者 "b" 字符
// 
//
// 示例 3: 
//
// 
//输入: s = "abc"
//输出: false 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length <= 10⁵ 
// s 由小写英文字母组成 
// 
//
// 
//
// 注意：本题与主站 680 题相同： https://leetcode-cn.com/problems/valid-palindrome-ii/ 
// Related Topics 贪心 双指针 字符串 👍 9 👎 0

  
package com.wjp.leetcode.editor.cn;
  
class RQku0D{
    public static void main(String[] args) {
        Solution solution = new RQku0D().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean validPalindrome(String s) {
        // 最多去掉一个字母的可能右 n+1种
        // 暴力法，则是，枚举所有的字串的判断是否为回文，复杂度为 n平方

        char[] chs = s.toCharArray();
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (chs[i] == chs[j]) {
                i++;
                j--;
            }else{
                return isPalindrome(chs, i, j - 1) || isPalindrome(chs, i + 1, j);
            }
        }
        return true;
    }

    private boolean isPalindrome(char[] chs, int i, int j) {
        while (i < j) {
            if (chs[i] != chs[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}