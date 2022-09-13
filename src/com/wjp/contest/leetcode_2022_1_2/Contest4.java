package com.wjp.contest.leetcode_2022_1_2;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

class Contest4 {
    public static void main(String[] args) {
        Solution solution = new Contest4().new Solution();
        solution.maximumInvitations(new int[]{2, 2, 1, 2});
    }

    class Solution {
        public int maximumInvitations(int[] favorite) {
            int n = favorite.length;
            int[] popular = new int[n];
            for (int i = 0; i < n; i++) {
                popular[favorite[i]]++;
            }
            PriorityQueue<Integer> pq = new PriorityQueue<>(((o1, o2) -> popular[o2] - popular[o1]));
            for (int i = 0; i < n; i++) {
                pq.add(i);
            }
            // 欢迎，＋　圈子
            int res = 0;
            Queue<Integer> q = new ArrayDeque<>();
            return 0;
        }
    }
}