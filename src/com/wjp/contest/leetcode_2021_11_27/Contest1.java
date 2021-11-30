package com.wjp.contest.leetcode_2021_11_27;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Contest1 {
    public static void main(String[] args) {
        Solution solution = new Contest1().new Solution();
    }

    class Solution {
        public int countWords(String[] words1, String[] words2) {
            Map<String, Integer> map1 = new HashMap<>();
            Map<String, Integer> map2 = new HashMap<>();
            for (String word : words1) {
                map1.put(word, map1.getOrDefault(word, 0) + 1);
            }
            for (String word : words2) {
                map2.put(word, map2.getOrDefault(word, 0) + 1);
            }
            Set<String> set = new HashSet<>();
            map1.keySet().forEach(s -> {
                        if (map1.getOrDefault(s,0) == 1) {
                            set.add(s);
                        }
                    }

            );
            int res = 0;
            for (String word : set) {
                if (map2.getOrDefault(word, 0) == 1) {
                    res++;
                }
            }
            return res;
        }
    }
}