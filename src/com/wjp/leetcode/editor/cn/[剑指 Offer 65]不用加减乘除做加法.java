//写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。 
//
// 
//
// 示例: 
//
// 输入: a = 1, b = 1
//输出: 2 
//
// 
//
// 提示： 
//
// 
// a, b 均可能是负数或 0 
// 结果不会溢出 32 位整数 
// 
// Related Topics 位运算 数学 👍 220 👎 0

  
package com.wjp.leetcode.editor.cn;
  
class BuYongJiaJianChengChuZuoJiaFaLcof{
    public static void main(String[] args) {
        Solution solution = new BuYongJiaJianChengChuZuoJiaFaLcof().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int add(int a, int b) {
        // 初始处理

        // 当前 位和
        int sum = a ^ b;
        // 当前位的进位，需要 往前传送
        int carry = (a & b) << 1;

        // 处理来自上一位的进位和当前两位的和
        while(carry != 0){
            // 记录之前结果
            a = sum;
            // 记录之前的进位
            b = carry;
            // 计算完当前位更新结果
            sum = a ^ b;
            //  传送进位
            carry = (a & b) << 1;

        }
        return sum;

    }


    int addSameSign(int a, int b) {
        // 考虑 a b同号
        int res = 0;
        int more = 0;
        for (int i = 0; i < 32; i++) {
            int x = a >> i & 1;
            int y = b >> i & 1;
            int z = 0;
            if (more == 1 ) {
                if (x == 1 && y == 1) {
                    z = 1;
                    more = 1;
                } else if (x == 0 && y == 0) {
                    z = 1;
                    more = 0;
                }else{
                    z = 0;
                    more = 1;
                }
            }else {
                if (x == 1 && y == 1) {
                    z = 0;
                    more = 1;
                } else if (x == 0 && y == 0) {
                    z = 0;
                    more = 0;
                }else{
                    z = 1;
                    more = 0;
                }
            }
            if (z == 1) {
                res |= (z << i);
            }
        }
        return a > 0 ? res : -res;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
