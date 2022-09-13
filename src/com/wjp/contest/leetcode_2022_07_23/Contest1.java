package com.wjp.contest.leetcode_2022_07_23;

import java.util.*;

class Contest1 {
    public static void main(String[] args) {
        Solution solution = new Contest1().new Solution();
        TreeSet<Integer> set = new TreeSet<>();
        set.add(2);
        System.out.println(set.remove(1));
    }

    class Solution {

    }

    class NumberContainers {

        Map<Integer, SortedSet<Integer>> map;
        Map<Integer,Integer> indexToNumber;
        public NumberContainers() {
            map = new HashMap<>();
            indexToNumber = new HashMap<>();
        }

        public void change(int index, int number) {
            if (indexToNumber.containsKey(index)) {
                int num = indexToNumber.get(index);
                // 移除原来的index
                System.out.println(num + ": contain:");
                SortedSet<Integer> set = map.get(num);
                for (int k : set) {
                    System.out.print(k+",");
                }
                System.out.println();
                set.remove((Integer) index);
            }

            SortedSet<Integer> list = map.getOrDefault(number, new TreeSet<>());
            list.add(index);
            map.put(number, list);
            indexToNumber.put(index, number);
        }

        public int find(int number) {
            if (map.containsKey(number)) {
                return map.get(number).first();
            }
            return -1;
        }
    }
}