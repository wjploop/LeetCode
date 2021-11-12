//子字符串 是字符串中的一个连续（非空）的字符序列。 
//
// 元音子字符串 是 仅 由元音（'a'、'e'、'i'、'o' 和 'u'）组成的一个子字符串，且必须包含 全部五种 元音。 
//
// 给你一个字符串 word ，统计并返回 word 中 元音子字符串的数目 。 
//
// 
//
// 示例 1： 
//
// 
//输入：word = "aeiouu"
//输出：2
//解释：下面列出 word 中的元音子字符串（斜体加粗部分）：
//- "aeiouu"
//- "aeiouu"
// 
//
// 示例 2： 
//
// 
//输入：word = "unicornarihan"
//输出：0
//解释：word 中不含 5 种元音，所以也不会存在元音子字符串。
// 
//
// 示例 3： 
//
// 
//输入：word = "cuaieuouac"
//输出：7
//解释：下面列出 word 中的元音子字符串（斜体加粗部分）：
//- "cuaieuouac"
//- "cuaieuouac"
//- "cuaieuouac"
//- "cuaieuouac"
//- "cuaieuouac"
//- "cuaieuouac"
//- "cuaieuouac" 
//
// 示例 4： 
//
// 
//输入：word = "bbaeixoubb"
//输出：0
//解释：所有包含全部五种元音的子字符串都含有辅音，所以不存在元音子字符串。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= word.length <= 100 
// word 仅由小写英文字母组成 
// 
// 👍 1 👎 0


package com.wjp.leetcode.editor.cn;

import java.util.*;

class CountVowelSubstringsOfAString {
    public static void main(String[] args) {
        Solution solution = new CountVowelSubstringsOfAString().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int countVowelSubstrings(String word) {
            Map<Character, Integer> map = new HashMap<>();
            int i = 0, j = 0, count = 0, n = word.length();
            int res = 0;
            while (j < n) {
                char ch = word.charAt(j);
                if (isVowels(ch)) {
                    int value = map.getOrDefault(ch, 0);
                    if (value == 0) {
//                        System.out.println("count ++ " + ch);
                        count++;
                    }
                    map.put(ch, value + 1);
                    if (count == 5) {
                        res++;
                        int k = i;
                        HashMap<Character, Integer> map2 = new HashMap<>(map);
                        // 以 j 为右边界
                        while (count == 5) {
                            char ch2 = word.charAt(i);
                            int value2 = map.getOrDefault(ch2, 0);
                            if (isVowels(ch2)) {
                                if (value2 == 1) {
                                    count--;
                                }
                                map.put(ch2, value2 - 1);
                            }
                            if (count == 5) {
                                // [i+1, j]
                                res++;
                            }
                            i++;
                        }
                        i = k;
                        map = map2;
                        count = 5;
                    }
                }else{
                    i = j + 1;
                    count = 0;
                    map.clear();
                }
                j++;
            }
            return res;
        }

        private boolean isVowels(char ch) {
            return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}