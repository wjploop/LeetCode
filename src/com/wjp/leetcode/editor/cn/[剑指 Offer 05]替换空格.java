//请实现一个函数，把字符串 s 中的每个空格替换成"%20"。 
//
// 
//
// 示例 1： 
//
// 输入：s = "We are happy."
//输出："We%20are%20happy." 
//
// 
//
// 限制： 
//
// 0 <= s 的长度 <= 10000 
// Related Topics 字符串 
// 👍 143 👎 0

  
package com.wjp.leetcode.editor.cn;
  
class TiHuanKongGeLcof{
    public static void main(String[] args) {
        Solution solution = new TiHuanKongGeLcof().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 这个题考察东西不明显，
     * 若是给的是字符数组，且数组足够扩展的情况下
     * 可用高效的方法，不使用额外空间且从后往前处理
     *
     */

class Solution {
    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (ch == ' ') {
                sb.append("%20");
            }else{
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}