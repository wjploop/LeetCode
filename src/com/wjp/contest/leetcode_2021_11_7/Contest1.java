package com.wjp.contest.leetcode_2021_11_7;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Contest1 {
    public static void main(String[] args) {
        Solution solution = new Contest1().new Solution();
        System.out.println(solution.countVowelSubstrings("cuaieuouac"));
    }

    class Solution {

        public int countVowelSubstrings(String word) {
            Set<Character> set = new HashSet<>();
            set.add('a');
            set.add('e');
            set.add('i');
            set.add('o');
            set.add('u');
            word = word + " ";
            int count = 0;
            Map<Character,Integer> map = new HashMap<>();
            int i = 0, j = 0;
            int res = 0;
            while (j < word.length()) {
                char ch = word.charAt(j);
                if (set.contains(ch)) {
                    int value = map.getOrDefault(ch, 0);
                    if (value == 0) {
                        count++;
                    }
                    map.put(ch, value + 1);

                    if (count == 5) {
//                        System.out.println("right " + word.substring(i, j+1));
                        res++;
                        var map2 = new HashMap<>(map);
                        int k = i;
                        int count2 = count;
                        while (count2 == 5) {
                            char ch2 = word.charAt(k);
                            int value2 = map2.getOrDefault(ch2, 0);
                            if (map2.getOrDefault(ch2, 0) == 1) {
                                count2--;
                            }
                            map2.put(ch2, value2 - 1);
                            if (count2 == 5) {
                                res++;
                            }
                            k++;
                        }
                    }



                }else{
                    count = 0;
                    map.clear();
                    i = j + 1;
                }
                j++;
            }
            return res;
        }

    }
}