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

class DivideTwoIntegers {
    public static void main(String[] args) {
        Solution solution = new DivideTwoIntegers().new Solution();
//        int res = solution.divide(10, 3);
        int res = solution.divide(2147483647, 1);
        System.out.println(res);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int divide(int dividend, int divisor) {
            // 除数如何逼近被除数
            //


            // 处理溢出的情况
            if (dividend == Integer.MIN_VALUE && divisor == -1) {
                return Integer.MAX_VALUE;
            }
            if (divisor == 1) {
                return dividend;
            }

            int sign = (dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0) ? 1 : -1;
            int value = div(Math.abs((long) dividend), Math.abs((long) divisor));

            return sign == 1 ? value : -value;

        }

        private int div(long dividend, long divisor) {

            if (dividend < divisor) {
                return 0;
            }

            if (dividend == divisor) {
                return 1;
            }
            long count = 1;
            long sum = divisor;

            while (sum < dividend) {
                sum = sum << 1;
                count = count << 1;
            }

            sum = sum >> 1;
            count = count >> 1;

            System.out.println("count = " + count + ", sum = " + sum);

            long diff = dividend - sum;
            return (int)(count + div(diff, divisor));
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}