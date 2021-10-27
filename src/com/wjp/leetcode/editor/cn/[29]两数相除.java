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
        System.out.println(solution.nextBeautifulNumber(100000));

    }
    class Solution {
        int[] count = new int[10];
        public int nextBeautifulNumber(int n) {
            while (true) {
                if (isBeautiful(++n)) {
                    return n;
                }
            }
        }

        boolean isBeautiful(int n) {
            Arrays.fill(count, 0);
            while (n > 0) {
                int k = n % 10;
                count[k]++;
                n = n / 10;
            }

            for (int i = 0; i < 10; i++) {
//                System.out.println(i + "," + count[i]);
                if (count[i] != 0) {
                    if (count[i] != i) {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
//    class Solution {
//        public int countValidWords(String sentence) {
//            String[] words = sentence.split(" ");
//            int res = 0;
//            for (String word : words) {
//                word = word.trim();
//                if (word.isEmpty()) {
//                    continue;
//                }
//                boolean hasTwoSplit = false;
//                boolean containsSplit = false;
//                boolean valid = true;
//                for (int i = 0; i < word.length(); i++) {
//                    char ch = word.charAt(i);
//                    if (ch >= '0' && ch <= '9') {
//                        continue;
//                    }
//                    if (ch == '-') {
//                        if (containsSplit) {
//                            hasTwoSplit = true;
//                        }else{
//                            containsSplit = true;
//                        }
//                    }
//                    if (ch == '!' || ch == '.' || ch == ',') {
//                        if (i != word.length() - 1) {
//                            valid = false;
//                        }
//                    }
//                }
//                if (!valid) {
//                    continue;
//                }
//                if (hasTwoSplit) {
//                    continue;
//                }
//                if (!containsSplit) {
//                    if (isWord(word, false)) {
//                        res++;
//                    }
//                }else{
//                    String[] pair = word.split("-");
//                    int index = word.indexOf('-');
//                    if (index == 0 || index ==word.length() - 1) {
//                        continue;
//                    }
//                    if (isWord(pair[0], true) && isWord(pair[1], true)) {
//                        res++;
//                    }
//                }
//            }
//            return res;
//
//        }
//
//        Boolean isWord(String word,boolean force) {
//            if (word.length() == 0) {
//                return false;
//            }
//
//            for (int i = 0; i < word.length(); i++) {
//                char ch = word.charAt(i);
//                if (force) {
//                    if (ch >= 'a' && ch <= 'z') {
//                        force = false;
//                    }
//                }
//                if (ch == '-') {
//                    return false;
//                }
//                if (ch >= '0' && ch <= '9') {
//                    return false;
//                }
//                if (ch == '!' || ch == '.' || ch == ',') {
//                    if (i != word.length() - 1) {
//                        return false;
//                    }
//                }
//            }
//            System.out.println("check: "+word);
//            return !force;
//        }
//    }//leetcode submit region end(Prohibit modification and deletion)

}
