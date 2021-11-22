package com.wjp.contest.leetcode_2021_11_21;

import java.util.HashMap;
import java.util.Map;

class Contest3 {
    public static void main(String[] args) {
    }

    class RangeFreqQuery {
        int[] prefix;
        int[] arr;
        int n;
        public RangeFreqQuery(int[] arr) {
            this.n = arr.length;
            this.arr = arr;
            this.prefix = new int[n];
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                prefix[i] = map.getOrDefault(arr[i], 0) + 1;
                map.put(arr[i], prefix[i]);
            }
        }

        public int query(int left, int right, int value) {
            int j = right;
            while (j >= left && arr[j] != value) {
                j--;
            }
            if (j == left - 1) {
                return 0;
            }
            int i = left -1;
            while (i >= 0 && arr[i] != value) {
                i--;
            }
            if (i == -1) {
                return prefix[j];
            }else{
                return prefix[j] - prefix[i];
            }
        }
    }
}