package com.wjp.contest.leetcode_2022_07_24;

import kotlin.Pair;

import java.util.*;

class Contest3 {
    public static void main(String[] args) {
        Solution solution = new Contest3().new Solution();
    }

    class Solution {

    }

    class FoodRatings {
        Map<String, String> f2c = new HashMap<>();
        Map<String, Integer> f2r = new HashMap<>();
        Map<String, PriorityQueue<String>> c2f = new HashMap<>();

        Map<String, Pair<String,Integer>> map;

        public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
            for (int i = 0; i < foods.length; i++) {
                f2r.put(foods[i], ratings[i]);
                f2c.put(foods[i], cuisines[i]);
            }
            for (int i = 0; i < foods.length; i++) {
                if (!c2f.containsKey(cuisines[i])) {
                    c2f.put(cuisines[i], new PriorityQueue<String>((o1, o2) -> {
                        if (f2r.get(o1).compareTo(f2r.get(o2)) == 0) {
                            return o1.compareTo(o2);
                        } else {
                            return f2r.get(o1) - f2r.get(o2);
                        }
                    }));
                }
                c2f.get(cuisines[i]).add(foods[i]);
            }
        }

        public void changeRating(String food, int newRating) {
            String c = f2c.get(food);
            c2f.get(c).remove(food);

            f2r.put(food, newRating);
            c2f.get(c).add(food);
        }

        public String highestRated(String cuisine) {
            return c2f.get(cuisine).peek();
        }

        int bigger(String a, String b) {
            int m = a.length(), n = b.length(), k = Math.min(m, n);
            for (int i = 0; i < k; i++) {
                char x = a.charAt(i), y = b.charAt(i);
                if (x == y) {
                } else {
                    int res = x - y;
                    System.out.println(a + ",  " + b + ",  " + res);
                    return res;
                }
            }
            return m - n;
        }
    }
}