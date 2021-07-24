//输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。 
//
// 示例 1: 
//
// 输入: n = 1
//输出: [1,2,3,4,5,6,7,8,9]
// 
//
// 
//
// 说明： 
//
// 
// 用返回一个整数列表来代替打印 
// n 为正整数 
// 
// Related Topics 数组 数学 
// 👍 138 👎 0


package com.wjp.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class DaYinCong1daoZuiDaDeNweiShuLcof {
    public static void main(String[] args) {
        Solution solution = new DaYinCong1daoZuiDaDeNweiShuLcof().new Solution();
        solution.printNumber(1);
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 这道题与书上要求不一致
     * 考虑大数问题，即用字符串存储数字
     * 字符串数字+1
     *
     */
    class Solution {
        public int[] printNumbers(int n) {
            // max = pow(10,n) -1
            int max = (int) Math.pow(10, n) - 1;
            int[] res = new int[max];
            for (int i = 0; i < max; i++) {
                res[i] = i + 1;
            }
            return res;
//            return printNumber(n).stream().mapToInt(Integer::valueOf).toArray();
        }

        public List<String> printNumber(int n) {
            StringBuilder start = new StringBuilder("0");
            List<String> list = new ArrayList<>();

            while (true) {
                start = plusOne(start);
                if (start.length() >= n + 1) {
                    break;
                }
                list.add(start.toString());
            }
            System.out.println("create list");
            for (String str : list) {
                System.out.println(str);
            }
            return list;
        }

        private StringBuilder plusOne(StringBuilder str) {
            int n = str.length();
            for (int i = n - 1; i >= 0; i--) {
                if (str.charAt(i) < '9') {
                    str.setCharAt(i, (char) (str.charAt(i) + 1));
                    return str;
                }else{
                    str.setCharAt(i, '0');
                }
            }
            char[] chs = new char[n + 1];
            Arrays.fill(chs, '0');
            chs[0] = '1';
            return new StringBuilder(new String(chs));
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}