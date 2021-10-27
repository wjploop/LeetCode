//给定两个 01 字符串 a 和 b ，请计算它们的和，并以二进制字符串的形式输出。 
//
// 输入为 非空 字符串且只包含数字 1 和 0。 
//
// 
//
// 示例 1: 
//
// 
//输入: a = "11", b = "10"
//输出: "101" 
//
// 示例 2: 
//
// 
//输入: a = "1010", b = "1011"
//输出: "10101" 
//
// 
//
// 提示： 
//
// 
// 每个字符串仅由字符 '0' 或 '1' 组成。 
// 1 <= a.length, b.length <= 10^4 
// 字符串如果不是 "0" ，就都不含前导零。 
// 
//
// 
//
// 注意：本题与主站 67 题相同：https://leetcode-cn.com/problems/add-binary/ 
// Related Topics 位运算 数学 字符串 模拟 👍 6 👎 0

  
package com.wjp.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

class JFETK5{
    public static void main(String[] args) {
        Solution solution = new JFETK5().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String addBinary(String a, String b) {
        char[] aChs = a.toCharArray(), bChs = b.toCharArray();
        int i = a.length() - 1, j = b.length() - 1;
        int carry = 0;
        List<Character> resultChs = new ArrayList<>();
        while (i >= 0 || j >= 0 || carry > 0) {
            int x = i >= 0 ? aChs[i--] - '0' : 0;
            int y = j >= 0 ? bChs[j--] - '0' : 0;
            int z = x + y + carry;
//            System.out.println("add " + x + "," + y + "," + carry);

            resultChs.add(0, (z == 1 || z == 3) ? '1' : '0');
            carry = z >= 2 ? 1 : 0;
        }
        char[] res = new char[resultChs.size()];
        for (int k = 0; k < res.length; k++) {
            res[k] = resultChs.get(k);
        }
        return new String(res);

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}