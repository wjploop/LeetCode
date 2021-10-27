//给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的某个变位词。 
//
// 换句话说，第一个字符串的排列之一是第二个字符串的 子串 。 
//
// 
//
// 示例 1： 
//
// 
//输入: s1 = "ab" s2 = "eidbaooo"
//输出: True
//解释: s2 包含 s1 的排列之一 ("ba").
// 
//
// 示例 2： 
//
// 
//输入: s1= "ab" s2 = "eidboaoo"
//输出: False
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s1.length, s2.length <= 10⁴ 
// s1 和 s2 仅包含小写字母 
// 
//
// 
//
// 注意：本题与主站 567 题相同： https://leetcode-cn.com/problems/permutation-in-string/ 
// Related Topics 哈希表 双指针 字符串 滑动窗口 👍 11 👎 0

  
package com.wjp.leetcode.editor.cn;

import java.util.Arrays;

class MPnaiL{
    public static void main(String[] args) {
        Solution solution = new MPnaiL().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // 滑动窗口
        // 维护一个窗口
        // 判断两个串排列相等
        // 一个串，只关系出现得字母，以及对应得次数
        int m = s1.length(),  n = s2.length();
        if (m > n) {
            return false;
        }
        int[] diffs = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            diffs[s1.charAt(i) - 'a']--;
        }
        int left = 0;
        for (int i = 0; i < s2.length(); i++) {
            int index = s2.charAt(i) - 'a';
            diffs[index]++;
            // 我们要使得diffs全部为0
            // 而对于 diffs[index]，若是其次数超出所需的次数，则必须要至少减少到与s1中含有的个数
            // 由于我们对于s1中某个字母的个数，比如'b'，用其的负数表示
            // 故，我们要令其满足 > 0
            while (left <= i && diffs[index] > 0) {
                diffs[s2.charAt(left) - 'a']--;
                left++;
            }
            // 在保证我们所遇到的所有的字符都满足条件后
            // (a,b,c,...) 比如我们判断了条件 a,b,都符合条件后，我们需要集合中 a,b,c,所有的条件都满足
            if (i - left + 1 == s1.length()) {
                     return true;
            }

        }
        return false;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}