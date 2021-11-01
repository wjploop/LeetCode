package com.wjp.contest.leetcode_2021_10_29;

import java.util.*;

class Contest3 {
    public static void main(String[] args) {
        Solution solution = new Contest3().new Solution();
    }

    class Solution {

        public int[] metroRouteDesignI(int[][] lines, int start, int end) {
            HashMap<List<Integer>, ArrayList<Integer>> lists = new HashMap<>();
            for (int i = 0; i < lines.length; i++) {
                for (int j = 1; j < lines[i].length; j++) {
                    lists.computeIfAbsent(List.of(lines[i][j - 1], i), t -> new ArrayList<>()).add(lines[i][j]);
                    lists.computeIfAbsent(List.of(lines[i][j], i), t -> new ArrayList<>()).add(lines[i][j - 1]);
                }
            }
            PriorityQueue<Map.Entry<int[], String>> queue = new PriorityQueue<>(
                    (o, p) -> o.getKey()[0] == p.getKey()[0] ? o.getValue().compareTo(p.getValue())
                            : o.getKey()[0] - p.getKey()[0]);
            queue.add(Map.entry(new int[]{0, start, -1, 0}, String.format("%09d", start)));
            for (HashMap<List<Integer>, String> set = new HashMap<>(); ; ) {
                Map.Entry<int[], String> poll = queue.poll();
                if (poll.getKey()[1] == end) {
                    String[] split = poll.getValue().split(" ");
                    int[] result = new int[split.length];
                    for (int i = 0; i < result.length; i++) {
                        result[i] = Integer.parseInt(split[i]);
                    }
                    return result;
                } else if (set.getOrDefault(List.of(poll.getKey()[1], poll.getKey()[2]), "")
                        .compareTo(poll.getValue()) < 0) {
                    set.put(List.of(poll.getKey()[1], poll.getKey()[2]), poll.getValue());
                    for (int i = 0; i < lines.length; i++) {
                        for (int j : lists.getOrDefault(List.of(poll.getKey()[1], i), new ArrayList<>())) {
                            if (!poll.getValue().substring(poll.getKey()[3]).contains(String.format("%09d", j))) {
                                queue.add(
                                        Map.entry(
                                                new int[]{poll.getKey()[0] + (i == poll.getKey()[2] ? 0 : 1), j, i,
                                                        i == poll.getKey()[2] ? poll.getKey()[3]
                                                                : poll.getValue().length() - 9},
                                                poll.getValue() + String.format(" %09d", j)));
                            }
                        }
                    }
                }
            }
        }
    }
}