//请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。 
//
// 数值（按顺序）可以分成以下几个部分： 
//
// 
// 若干空格 
// 一个 小数 或者 整数 
// （可选）一个 'e' 或 'E' ，后面跟着一个 整数 
// 若干空格 
// 
//
// 小数（按顺序）可以分成以下几个部分： 
//
// 
// （可选）一个符号字符（'+' 或 '-'） 
// 下述格式之一：
// 
// 至少一位数字，后面跟着一个点 '.' 
// 至少一位数字，后面跟着一个点 '.' ，后面再跟着至少一位数字 
// 一个点 '.' ，后面跟着至少一位数字 
// 
// 
// 
//
// 整数（按顺序）可以分成以下几个部分： 
//
// 
// （可选）一个符号字符（'+' 或 '-'） 
// 至少一位数字 
// 
//
// 部分数值列举如下： 
//
// 
// ["+100", "5e2", "-123", "3.1416", "-1E-16", "0123"] 
// 
//
// 部分非数值列举如下： 
//
// 
// ["12e", "1a3.14", "1.2.3", "+-5", "12e+5.4"] 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "0"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "e"
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：s = "."
//输出：false 
//
// 示例 4： 
//
// 
//输入：s = "    .1  "
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 20 
// s 仅含英文字母（大写和小写），数字（0-9），加号 '+' ，减号 '-' ，空格 ' ' 或者点 '.' 。 
// 
// Related Topics 字符串 
// 👍 218 👎 0


package com.wjp.leetcode.editor.cn;

class BiaoShiShuZhiDeZiFuChuanLcof {

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {

//            val s = "123.4"
            val s = "123e4"

            val res = Solution().isNumber(s)

            println("$s is $res")


        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun isNumber(s: String): Boolean {
            val str = s.trim();
            // input
            // ' ', 'd', 'e', '.', ’s'
            // state
            val states = listOf(
                // 前面为空格 0
                mapOf(
                    ' ' to 0,
                    's' to 1,
                    'd' to 2,
                    '.' to 8
                ),
                // 前面为正负号 1
                mapOf(
                    'd' to 2,
                    '.' to 8
                ),
                // .前面为数字，2
                mapOf(
                    'd' to 2,
                    '.' to 3,
                    'e' to 4,
                    ' ' to 5
                ),
                // 数字后遇到. 3
                mapOf(
                    'd' to 6,
                    'e' to 4
                ),
                // 遇到 e 4
                mapOf(
                    'd' to 7,
                    's' to 1
                ),
                // 遇到末尾空格结束 5
                mapOf(
                    ' ' to 5
                ),
                // 遇到.后的数字 6
                mapOf(
                    ' ' to 5,
                    'd' to 6,
                    'e' to 4
                ),
                // 遇到e后的数字 7
                mapOf(
                    ' ' to 5,
                    'd' to 7
                ),
                // 无数字遇到. 8
                mapOf(
                    'd' to 6
                )
            )
            var p = 0
            str.forEach { ch->
                val action = when (ch) {
                    ' ' -> ' '
                    'e','E' -> 'e'
                    in '0'..'9' -> 'd'
                    '+', '-' -> 's'
                    '.' -> '.'
                    else -> return false
                }
                val next = states[p][action]
                // 当前输入不合法
                if (next == null) {
                    println("error in $ch")
                    return false
                }else{
                    p = next
                }
            }
            return p in listOf(2,3,6,7)

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}