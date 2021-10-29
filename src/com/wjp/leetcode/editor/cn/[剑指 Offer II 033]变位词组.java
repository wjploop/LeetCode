//给定一个字符串数组 strs ，将 变位词 组合在一起。 可以按任意顺序返回结果列表。
//
// 注意：若两个字符串中每个字符出现的次数都相同，则称它们互为变位词。
//
//
//
// 示例 1:
//
//
//输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
//
// 示例 2:
//
//
//输入: strs = [""]
//输出: [[""]]
//
//
// 示例 3:
//
//
//输入: strs = ["a"]
//输出: [["a"]]
//
//
//
// 提示：
//
//
// 1 <= strs.length <= 10⁴
// 0 <= strs[i].length <= 100
// strs[i] 仅包含小写字母
//
//
//
//
// 注意：本题与主站 49 题相同： https://leetcode-cn.com/problems/group-anagrams/
// Related Topics 哈希表 字符串 排序 👍 7 👎 0


package com.wjp.leetcode.editor.cn;

import java.util.*;

class Sfvd7V {
    public static void main(String[] args) {
        Solution solution = new Sfvd7V().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            // 正序后的字符作为key
            // 或计数比较
            int[] count = new int[26];
            Map<String, List<String>> map = new HashMap<>();
            for (String str : strs) {
                char[] chs = str.toCharArray();
                //
                Arrays.fill(count, 0);
                for (char ch : chs) {
                    count[ch - 'a']++;
                }
                StringBuilder keyBuilder = new StringBuilder();
                for (int i = 0; i < 26; i++) {
                    if (count[i] > 0) {
                        keyBuilder.append(('a' + i));
                        keyBuilder.append(count[i]);
                    }
                }
                String key = keyBuilder.toString();

                List<String> value = map.getOrDefault(key, new ArrayList<>());
                value.add(str);
                map.put(key, value);
            }
            return new ArrayList<>(map.values());
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}