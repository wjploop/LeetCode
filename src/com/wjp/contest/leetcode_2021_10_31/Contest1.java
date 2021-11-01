package com.wjp.contest.leetcode_2021_10_31;

import com.wjp.leetcode.editor.cn.ListNode;

import java.util.ArrayList;
import java.util.List;

class Contest2 {
    public static void main(String[] args) {

    }

    class Solution {
        public int[] nodesBetweenCriticalPoints(ListNode head) {
            List<Integer> list = new ArrayList<>();
            ListNode p = head;
            while (p != null) {
                list.add(p.val);
                p = p.next;
            }
            List<Integer> limit = new ArrayList<>();
            for (int i = 1; i < list.size() - 1; i++) {
                if (list.get(i) < list.get(i - 1) && list.get(i) < list.get(i + 1)) {
                    limit.add(i);
                }
                if (list.get(i) > list.get(i - 1) && list.get(i) > list.get(i + 1)) {
                    limit.add(i);
                }
            }
            if (limit.size() < 2) {
                return new int[]{-1, -1};
            }
            int max = limit.get(limit.size() - 1) - limit.get(0);
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < limit.size() - 1; i++) {
                min = Math.min(limit.get(i + 1) - limit.get(i), min);
            }
            return new int[]{min, max};
        }
    }
}