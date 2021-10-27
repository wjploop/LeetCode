//给定两个字符串 s 和 t 。返回 s 中包含 t 的所有字符的最短子字符串。如果 s 中不存在符合条件的子字符串，则返回空字符串 "" 。 
//
// 如果 s 中存在多个符合条件的子字符串，返回任意一个。 
//
// 
//
// 注意： 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ADOBECODEBANC", t = "ABC"
//输出："BANC" 
//解释：最短子字符串 "BANC" 包含了字符串 t 的所有字符 'A'、'B'、'C' 
//
// 示例 2： 
//
// 
//输入：s = "a", t = "a"
//输出："a"
// 
//
// 示例 3： 
//
// 
//输入：s = "a", t = "aa"
//输出：""
//解释：t 中两个字符 'a' 均应包含在 s 的子串中，因此没有符合条件的子字符串，返回空字符串。 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length, t.length <= 10⁵ 
// s 和 t 由英文字母组成 
// 
//
// 
//
// 进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？ 
//
// 
//
// 注意：本题与主站 76 题相似（本题答案不唯一）：https://leetcode-cn.com/problems/minimum-window-
//substring/ 
// Related Topics 哈希表 字符串 滑动窗口 👍 8 👎 0


package com.wjp.leetcode.editor.cn;

import java.util.Arrays;
import java.util.stream.Collectors;

class M1oyTv {
    public static void main(String[] args) {
        Solution solution = new M1oyTv().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String minWindow(String s, String t) {
            if (s.length() < t.length()) {
                return "";
            }
            // 最小的字串包含t
            // 定右边界，找到符合条件的字串，左边缩小直至不满足未知，找到以有边界包含t的最小字串
            int i = 0;
            // 如何保证包含t?

            // 使用这个p来表示是否包含t
            int[] p = new int[127];
            for (int j = 0; j < t.length(); j++) {
                int index = t.charAt(j) - 'A';
                p[index]++;
            }

            int[] chs = new int[127];

            // 有效字母的个数
            int count = 0;
            // 使用 [start,end]记录已经找到符合条件的字串
            int start = 0;
            int end = s.length();

            for (int j = 0; j < s.length(); j++) {
                int index = s.charAt(j) - 'A';
                chs[index]++;
                if (p[index] == 0) {
                    // 若该字母不再t中，则跳过
                    continue;
                }
                if (chs[index] <= p[index]) {
                    // 有效个数+1
                    System.out.println("count " + s.charAt(j));
                    count++;
                }
                if (count == t.length()) {
                    // 找到了 [i,j]包含t
                    // 现在试图左移左边界
//                    System.out.println("find: " + i + "," + j);
                    while (i <= j && chs[s.charAt(i) - 'A'] > p[s.charAt(i) - 'A']) {
                        chs[s.charAt(i) - 'A']--;
                        i++;
                    }
//                    System.out.println("reduce: " + i + "," + j + "[" + s.charAt(i) + ".." + s.charAt(j) + "]");
//                    System.out.println("smaller "+ (j - i < end - start));
                    // 现在以 j 为右边界最小的字串
                    if (j - i < end - start) {
                        start = i;
                        end = j;
                    }

                    // 破坏条件继续寻找下一个满足条件的
                    // 由于当前 s[i,j]为以j为右边界最小的字串、且符合条件的，故，我们得知 s[i]是t中的一个字母，破坏即可
                    if (i <= j) {
//                        System.out.println("remove left " + s.charAt(i));
                        chs[s.charAt(i) - 'A']--;
                        i++;
                        count--;
                    }
                }
            }

            return (end - start) == s.length() ? "" : s.substring(start, end + 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
