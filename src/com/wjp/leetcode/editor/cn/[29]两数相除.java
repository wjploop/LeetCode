//给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。 
//
// 返回被除数 dividend 除以除数 divisor 得到的商。 
//
// 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2 
//
// 
//
// 示例 1: 
//
// 输入: dividend = 10, divisor = 3
//输出: 3
//解释: 10/3 = truncate(3.33333..) = truncate(3) = 3 
//
// 示例 2: 
//
// 输入: dividend = 7, divisor = -3
//输出: -2
//解释: 7/-3 = truncate(-2.33333..) = -2 
//
// 
//
// 提示： 
//
// 
// 被除数和除数均为 32 位有符号整数。 
// 除数不为 0。 
// 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231, 231 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。 
// 
// Related Topics 位运算 数学 
// 👍 610 👎 0


package com.wjp.leetcode.editor.cn;

import java.util.Arrays;

class DivideTwoIntegers {
    public static void main(String[] args) {
        Solution solution = new DivideTwoIntegers().new Solution();
//        System.out.println(solution.isBeautiful(133));

    }
    class Solution {
        // 在 arr[]中寻找最大的连续子数组和
        // arr 是首尾相连的
        void findMaxSubArrayInCycleArray(int[] arr) {
            // 首尾相连，可以复制一份arr
            int n = arr.length;
            int[] arr1 = new int[n * 2];
            System.arraycopy(arr, 0, arr1, 0, n);
            System.arraycopy(arr, n, arr1, 0, n);
            // 限制 0 <= i <= n-1
            // 其子数组长度限制 <=n
            // 定义 以 i 为结尾最大的子数组为 sum[i]
            int[] dp = new int[n * 2];
            dp[0] = Math.max(arr[0], 0);
            int res = dp[0];

            for (int i = 1; i < n; i++) {
                dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);
                res = Math.max(res, dp[i]);
            }

            // [0,i] + [j,n-1] ( i<j)
            int[] dp1 = new int[n];

            dp1[n - 1] = arr[n - 1];
            int sum = dp[n - 1];
            for (int i = n - 2; i >= 0; i--) {
                sum += arr[i];
            }


        }
    }

}
