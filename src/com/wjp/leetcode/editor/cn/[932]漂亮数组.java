//对于某些固定的 N，如果数组 A 是整数 1, 2, ..., N 组成的排列，使得： 
//
// 对于每个 i < j，都不存在 k 满足 i < k < j 使得 A[k] * 2 = A[i] + A[j]。 
//
// 那么数组 A 是漂亮数组。 
//
// 
//
// 给定 N，返回任意漂亮数组 A（保证存在一个）。 
//
// 
//
// 示例 1： 
//
// 输入：4
//输出：[2,1,4,3]
// 
//
// 示例 2： 
//
// 输入：5
//输出：[3,1,2,5,4] 
//
// 
//
// 提示： 
//
// 
// 1 <= N <= 1000 
// 
//
// 
// Related Topics 数组 数学 分治 👍 155 👎 0


package com.wjp.leetcode.editor.cn;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class BeautifulArray {
    public static void main(String[] args) {
        Solution solution = new BeautifulArray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] beautifulArray(int n) {
            // 使得 A[k] * 2 != A[i] + A[j]
            // 左边是偶数，右边, 一个奇数 + 一个偶数，那么就一定不等
            // 左边是奇数的漂亮数，右边是偶数的漂亮数，凑起来也一定是
            // 若是 A 是票联数，a * A + b 也一定是
            // 1 2
            // 1 3 2 4
            // 1 5 3 7 2 6 4 8|
            int[] res = new int[n];
            List<Integer> list = beautiful(n);
            for (int i = 0; i < n; i++) {
                res[i] = list.get(i);
            }
            return res;
        }

        private List<Integer> beautiful(int n) {
            if (n == 1) {
                return Collections.singletonList(1);
            }
            int left = n / 2;
            int right = (n + 1) / 2;
            List<Integer> leftArr = beautiful(left);
            List<Integer> rightArr = beautiful(right);

            List<Integer> list = new ArrayList<>();
            for (int v : leftArr) {
                list.add(v * 2);
            }
            for (int v : rightArr) {
                list.add(v * 2 -1);
            }
            return list;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)
}
