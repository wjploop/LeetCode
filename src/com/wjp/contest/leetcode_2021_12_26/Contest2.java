package com.wjp.contest.leetcode_2021_12_26;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Contest2 {
    public static void main(String[] args) {
        Solution solution = new Contest2().new Solution();
    }

    class Solution {
        public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
            int n = recipes.length;
            Set<String> set = new HashSet<>();
            for (String s : supplies) {
                set.add(s);
            }

            while (true) {
                int add = 0;
                for (int i = 0; i < n; i++) {
                    if (set.contains(recipes[i])) {
                        continue;
                    }
                    boolean canAdd = true;
                    for (String need : ingredients.get(i)) {
                        if (!set.contains(need)) {
                            canAdd = false;
                            break;
                        }
                    }
                    if (canAdd) {
                        set.add(recipes[i]);
                        add++;
                    }
                }
                if (add == 0) {
                    break;
                }
            }
            List<String> res = new ArrayList<>();
            for (String r : recipes) {
                if (set.contains(r)) {
                    res.add(r);
                }
            }
            return res;
        }


    }
}