package com.wjp.contest.leetcode_2021_12_25;

import java.util.*;

class Contest3 {
    public static void main(String[] args) {
        Solution solution = new Contest3().new Solution();
    }

    class Solution {
        public long[] getDistances(int[] arr) {
            Map<Integer, List<Integer>> map = new HashMap<>();
            for (int i = 0; i < arr.length; i++) {
                int key = arr[i];
                if (map.containsKey(key)) {
                    map.get(key).add(i);
                }else{
                    List<Integer> set = new ArrayList<>();
                    set.add(i);
                    map.put(key, set);
                }
            }
            long[] res = new long[arr.length];
            for (List<Integer> list : map.values()) {
                for (int i : list) {
                    res[list.get(0)] += i - list.get(0);
                }
                for (int i = 1; i < list.size(); i++) {
                    res[list.get(i)] = res[list.get(i - 1)] + (2 * i - list.size()) * (list.get(i) - list.get(i - 1));
                }
            }
            return res;
        }
    }
}