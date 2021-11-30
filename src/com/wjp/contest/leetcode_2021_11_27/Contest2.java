package com.wjp.contest.leetcode_2021_11_27;

import java.util.ArrayList;
import java.util.List;

class Contest2 {
    public static void main(String[] args) {
        Solution solution = new Contest2().new Solution();
    }

    class Solution {
        public int minimumBuckets(String street) {
            List<Integer> arr = new ArrayList<>(street.length());
            for (char ch : street.toCharArray()) {
                arr.add(ch == 'H' ? 1 : 0);
            }
            if (arr.size() == 1) {
                if (arr.get(0) == 1) {
                    return -1;
                }else{
                    return 0;
                }
            }
            if (arr.get(0) == 1 && arr.get(1) == 1) {
                return -1;
            }
            if (arr.get(arr.size() - 1) == 1 && arr.get(arr.size() - 2) == 1) {
                return -1;
            }
            int count = 0;
            for (int num : arr) {
                if (num == 0) {
                    count = 0;
                }else{
                    count ++;
                }
                if (count == 3) {
                    return -1;
                }
            }

            int res = 0;
            // 消掉 h.h
            for (int i = 1; i < arr.size() - 1; i++) {
                if (arr.get(i - 1) == 1 && arr.get(i) == 0 && arr.get(i + 1) == 1) {
                    res++;
                    i++;
                    arr.set(i - 1, 0);
                    arr.set(i + 1, 0);
                }
            }
            for (int num : arr) {
                if (num == 1) {
                    res++;
                }
            }
            return res;

        }
    }
}