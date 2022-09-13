package com.wjp.contest.leetcode_2022_07_17;

import java.util.Arrays;
import java.util.SortedSet;
import java.util.TreeSet;
//["64333639502","65953866768","17845691654","87148775908","58954177897","70439926174","48059986638","47548857440","18418180516","06364956881","01866627626","36824890579","14672385151","71207752868"]
//        [[9,4],[6,1],[3,8],[12,9],[11,4],[4,9],[2,7],[10,3],[13,1],[13,1],[6,1],[5,10]]
class Contest3 {
    public static void main(String[] args) {
        Solution solution = new Contest3().new Solution();
    }

    class Solution {
        public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
            int n = queries.length;
            int[] res = new int[n];
            int l = nums[0].length();
            for (int k = 0; k< n; k++) {
                int[] q  =  queries[k];

                String[][] arr = new String[nums.length][2];
                for (int i = 0; i < nums.length; i++) {
                    String str = nums[i].substring(l - q[1], l);
                    arr[i] = new String[]{String.valueOf(i), str};
                }
                Arrays.sort(arr, ((o1, o2) -> {
                    String a = o1[1] , b = o2[1];
                    if (a.length() > b.length()) {
                        return 1;
                    }else if(a.length() < b.length()){
                        return -1;
                    }else{
                        for (int i = 0; i < a.length(); i++) {
                            int aa = a.charAt(i) - '0';
                            int bb = b.charAt(i) - '0';
                            System.out.println("com "+ aa +", "+ bb);
                            if(aa == bb){
                                continue;
                            }else{
                                return aa -bb;
                            }
                        }
                        return Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]);
                    }
                }));
                for (int i = 0; i < arr.length; i++) {
                    System.out.print(arr[1][1] + ",");
                }
                System.out.println();
                res[k] = Integer.parseInt(arr[q[0]-1][0]);
            }
            return res;
        }
    }
}