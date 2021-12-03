package com.wjp.contest.leetcode_2021_11_28;

import java.util.*;

class Contest4 {
    public static void main(String[] args) {
        Solution solution = new Contest4().new Solution();
    }

    class Solution {

        public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
            ArrayList<int[]>[] lists = new ArrayList[n];
            for (int i = 0; i < n; i++) {
                lists[i] = new ArrayList<>();
            }
            for (int[] meeting : meetings) {
                // person在时间
                lists[meeting[0]].add(new int[]{meeting[1], meeting[2]});
                lists[meeting[1]].add(new int[]{meeting[0], meeting[2]});
            }
            ArrayList<Integer> list = new ArrayList<>();
            PriorityQueue<int[]> queue = new PriorityQueue<>((o, p) -> o[1] - p[1]);
            // 开始 firstPerson 和 0 知道
            // 下次会议
            // 对于此会议的参与者，a,b
            // 对于a, 查看b是否知道秘密，
            // 如何查看？
            //
//            for (queue.addAll(Set.of(new int[2], new int[]{firstPerson, 0})); !queue.isEmpty(); ) {
//                int[] poll = queue.poll();
//                if (lists[poll[0]] != null) {
//                    list.add(poll[0]);
//                    for (int[] i : lists[poll[0]]) {
//                        if (i[1] >= poll[1]) {
//                            queue.offer(i);
//                        }
//                    }
//                    lists[poll[0]] = null;
//                }
//            }
            return list;
        }
    }

}