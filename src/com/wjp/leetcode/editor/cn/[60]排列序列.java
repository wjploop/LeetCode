//给出集合 [1,2,3,...,n]，其所有元素共有 n! 种排列。 
//
// 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下： 
//
// 
// "123" 
// "132" 
// "213" 
// "231" 
// "312" 
// "321" 
// 
//
// 给定 n 和 k，返回第 k 个排列。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3, k = 3
//输出："213"
// 
//
// 示例 2： 
//
// 
//输入：n = 4, k = 9
//输出："2314"
// 
//
// 示例 3： 
//
// 
//输入：n = 3, k = 1
//输出："123"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 9 
// 1 <= k <= n! 
// 
// Related Topics 递归 数学 
// 👍 545 👎 0


package com.wjp.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

class PermutationSequence{
    public static void main(String[] args) {
        Solution solution = new PermutationSequence().new Solution();
        System.out.println(solution.getPermutation(3, 3));
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String getPermutation(int n, int k) {
        // 先列出全部排列，按从小到大顺序
        // 取处第k个
        //
        List<String> allPermutation = new ArrayList<>();
        StringBuilder path = new StringBuilder();
        // state[i] 是否已经放入 i+1
        boolean[] state = new boolean[n];
        dfs(n, k, 0, state, path, allPermutation);
        System.out.println("size: " + allPermutation.size());
        return allPermutation.get(allPermutation.size() - 1);
    }

    //
    private boolean dfs(int n,int k, int start, boolean[] state, StringBuilder path, List<String> allPermutation) {

        if (start == n) {
            allPermutation.add(path.toString());
            if (allPermutation.size() == k) {
                return true;
            }
        } else {
            for (int i = 0; i < n; i++) {
                if (state[i]) {
                    continue;
                }
                state[i] = true;
                path.append((char)(i + '1'));
//                System.out.println("current path:" + path + " and start = " + start);
                boolean finishTarget = dfs(n, k, start + 1, state, path, allPermutation);
                if (finishTarget) {
                    return true;
                }
                state[i] = false;
                path.delete(path.length() - 1, path.length());
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}