//输入一个字符串，打印出该字符串中字符的所有排列。 
//
// 
//
// 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。 
//
// 
//
// 示例: 
//
// 输入：s = "abc"
//输出：["abc","acb","bac","bca","cab","cba"]
// 
//
// 
//
// 限制： 
//
// 1 <= s 的长度 <= 8 
// Related Topics 字符串 回溯 
// 👍 395 👎 0


package com.wjp.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ZiFuChuanDePaiLieLcof {
    public static void main(String[] args) {
        Solution solution = new ZiFuChuanDePaiLieLcof().new Solution();
        String[] res = solution.permutation("abc");
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + ", ");
        }

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String[] permutation(String s) {
            char[] charArr = s.toCharArray();
            Arrays.sort(charArr);
            List<String> resList = new ArrayList<>();
            do {
                resList.add(new String(charArr));
            } while (nextPermutation(charArr));
            String[] res = new String[resList.size()];
            for (int i = 0; i < res.length; i++) {
                res[i] = resList.get(i);
            }
            return res;
        }

        boolean nextPermutation(char[] charArr) {
            // 若是全部都是倒序的，则说明不存在下一个更大的全排列
            int i = charArr.length - 1;
            //
            while (i - 1 >= 0 && charArr[i - 1] >= charArr[i]) {
               i--;
            }
            if (i == 0) {
                // 整体全部都是倒序的
                return false;
            }
            // 此时，charArr[i-1] < charArr[i]
            // 交换 i-1 和 i 肯定可以得到一个更大的，但不是下一个更大的
            // 下一个更大的
            // 在 [i,len) 中，找出第一个比 [i-1] 大的数 k, 交换 i-1, k
            // ，此时，[i,len]只要是最小的即可，且此时，[i,len]是完全倒序的，逆序即可得到一个完全正序的排序，即保持 [i,len) 最小
            int k = charArr.length-1;
            // 根据上面，肯定存在一个比 charArr[i-1]大的元素
            while (charArr[k] <= charArr[i - 1]) {
                k--;
            }
            swap(charArr, i - 1, k);

            // 逆序 [i,len)
            for (int l = i, r = charArr.length - 1; l < r; l++, r--) {
                swap(charArr, l, r);
            }
            return true;
        }

        private void swap(char[] charArr, int i, int j) {
            char tmp = charArr[i];
            charArr[i] = charArr[j];
            charArr[j] = tmp;
        }

        public String[] permutation2(String s) {
            char[] chs = s.toCharArray();
            Arrays.sort(chs);
            List<Character> charList = new ArrayList<>();
            for (int i = 0; i < chs.length; i++) {
                charList.add(chs[i]);
            }
            List<String> res = new ArrayList<>();
            StringBuilder sb = new StringBuilder();
            backtrack(charList, sb, res);
            String[] result = new String[res.size()];
            for (int i = 0; i < result.length; i++) {
                result[i] = res.get(i);
            }
            return result;
        }


        private void backtrack(List<Character> charList, StringBuilder sb, List<String> res) {
            if (charList.isEmpty()) {
                res.add(sb.toString());
                return;
            }
            for (int i = 0; i < charList.size(); i++) {
                // 在 剩余的[i,len) 集合中选择字符
                // 若发现 chs[i] == chs[i-1]，以该字符的字符串已经选过了
                if (i > 0 && charList.get(i) == charList.get(i - 1)) {
                    continue;
                }
                Character ch = charList.get(i);
                sb.append(ch);
                charList.remove(ch);
                backtrack(charList, sb, res);
                sb.deleteCharAt(sb.length() - 1);
                charList.add(i, ch);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}