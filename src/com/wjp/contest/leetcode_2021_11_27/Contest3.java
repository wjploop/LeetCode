package com.wjp.contest.leetcode_2021_11_27;

import java.util.*;

class Contest3 {
    public static void main(String[] args) {
        Solution solution = new Contest3().new Solution();
        int res = solution.minCost(new int[]{1, 0}, new int[]{2, 3}, new int[]{5, 4, 3}, new int[]{8, 2, 6, 7});
        System.out.println(res);
    }

    class Solution {
        public int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
            if (startPos[0] == homePos[0] && startPos[1] == homePos[1]) {
                return 0;
            }

            int n = rowCosts.length, m = colCosts.length;
            Map<Integer, Integer> map = new HashMap<>();
            map.put(hash(startPos), 0);
            int target = hash(homePos);
            PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return map.getOrDefault(hash(o1), Integer.MAX_VALUE) - map.getOrDefault(hash(o2), Integer.MAX_VALUE);
                }
            }) ;
            pq.add(startPos);
            while (!pq.isEmpty()) {
                int[] cur = pq.peek();
                int[] min = null;
                int minValue = Integer.MAX_VALUE;
                for (int[] next : next(cur)) {
                    if (next[0] < 0 || next[0] >= n || next[1] < 0 || next[1] >= m || map.containsKey(hash(next))) {
                        continue;
                    }
                    int curValue = map.get(hash(cur));
                    if (cur[0] == next[0]) {
                        int value = curValue + colCosts[next[0]];
                        if (value < minValue) {
                            min = next;
                            minValue = value;
                        }
                    }else{
                        int value = curValue + rowCosts[next[1]];
                        if (value < minValue) {
                            min = next;
                            minValue = value;
                        }
                    }
                }
                if (min == null) {
                    pq.poll();
                    continue;
                }
                if (hash(min) == target) {
                    return minValue;
                }
                System.out.println("[" + min[0] + "," + min[1] + "] : " + minValue);
                map.put(hash(min), minValue);
                pq.offer(min);
            }
            return -1;
        }

        private int hash(int[] pos) {
            return pos[0] * 10000 + pos[1];
        }

        private int[][] next(int[] cur) {
            return new int[][]{
                    new int[]{cur[0] - 1, cur[1]},
                    new int[]{cur[0] + 1, cur[1]},
                    new int[]{cur[0], cur[1] - 1},
                    new int[]{cur[0], cur[1] + 1},
            };
        }

    }
}