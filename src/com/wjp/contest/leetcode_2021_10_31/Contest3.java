package com.wjp.contest.leetcode_2021_10_31;

import com.wjp.leetcode.editor.cn.ListNode;

import javax.sound.sampled.Line;
import java.util.*;

class Contest3 {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 8, 16};
        int res = new Solution().minimumOperations(nums, 0, 1);
        System.out.println(res);
    }


    static class Solution {
        public int minimumOperations(int[] nums, int start, int goal) {
            LinkedList<int[]> queue = new LinkedList<>();
            Set<Integer> hasTry = new HashSet<>();
            hasTry.add(start);
            queue.add(new int[]{start, 0});
            while (!queue.isEmpty()) {
                int[] pair = queue.poll();
                System.out.println("pair " + pair[0] + "," + pair[1]);
                int x = pair[0];
                for (int num : nums) {
                    int z = x + num;
                    if (z == goal) {
                        return pair[1] + 1;
                    } else if (z >= 0 && z <= 1000) {
                        if (!hasTry.contains(z)) {
                            hasTry.add(z);
                            queue.offer(new int[]{z, pair[1] + 1});
                        }
                    }
                    int z1 = x - num;
                    if (z1 == goal) {
                        return pair[1] + 1;
                    } else if (z1 >= 0 && z1 <= 1000) {
                        if (!hasTry.contains(z1)) {
                            hasTry.add(z1);
                            queue.offer(new int[]{z1, pair[1] + 1});
                        }
                    }
                    int z2 = x ^ num;
                    if (z2 == goal) {
                        return pair[1] + 1;
                    } else if (z2 >= 0 && z2 <= 1000) {
                        if (!hasTry.contains(z2)) {
                            hasTry.add(z2);
                            queue.offer(new int[]{z2, pair[1] + 1});
                        }
                    }
                }
            }
            return -1;
        }
    }
}