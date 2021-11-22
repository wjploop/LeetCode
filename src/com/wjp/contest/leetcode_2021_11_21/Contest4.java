package com.wjp.contest.leetcode_2021_11_21;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Contest4 {
    public static void main(String[] args) {
        Solution solution = new Contest4().new Solution();
        System.out.println(solution.kMirror(3, 7));
        ;
    }

    class Solution {
        int[] arr = new int[100];
        public long kMirror(int k, int n) {
            int i = 0;
            int num = 1;
            int res = 0;
            while (i < n) {
                if ( isMirror(num,10) && isMirror(num, k)) {
                    res += num;
                    i++;
                }
                num++;
            }
            return res;
        }

        private boolean isMirror(int num, int k) {
            Arrays.fill(arr, 0);
            int end = 0;
            while (num != 0) {
                arr[end++] = num % k;
                num = num / k;
            }
            int i = 0, j = end - 1;
            while (i < j) {
                if (arr[i]!= arr[j]) {
                    return false;
                }
                i++;
                j--;
            }
//            System.out.println(source);

//            System.out.println(list.stream().map(integer -> integer+"").collect(Collectors.joining()));
            return true;
        }
    }

}