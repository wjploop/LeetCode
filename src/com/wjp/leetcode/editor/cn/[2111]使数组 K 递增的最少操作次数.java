//给你一个下标从 0 开始包含 n 个正整数的数组 arr ，和一个正整数 k 。 
//
// 如果对于每个满足 k <= i <= n-1 的下标 i ，都有 arr[i-k] <= arr[i] ，那么我们称 arr 是 K 递增 的。 
//
// 
// 比方说，arr = [4, 1, 5, 2, 6, 2] 对于 k = 2 是 K 递增的，因为：
//
// 
// arr[0] <= arr[2] (4 <= 5) 
// arr[1] <= arr[3] (1 <= 2) 
// arr[2] <= arr[4] (5 <= 6) 
// arr[3] <= arr[5] (2 <= 2) 
// 
// 
// 但是，相同的数组 arr 对于 k = 1 不是 K 递增的（因为 arr[0] > arr[1]），对于 k = 3 也不是 K 递增的（因为 arr[
//0] > arr[3] ）。 
// 
//
// 每一次 操作 中，你可以选择一个下标 i 并将 arr[i] 改成任意 正整数。 
//
// 请你返回对于给定的 k ，使数组变成 K 递增的 最少操作次数 。 
//
// 
//
// 示例 1： 
//
// 输入：arr = [5,4,3,2,1], k = 1
//输出：4
//解释：
//对于 k = 1 ，数组最终必须变成非递减的。
//可行的 K 递增结果数组为 [5,6,7,8,9]，[1,1,1,1,1]，[2,2,3,4,4] 。它们都需要 4 次操作。
//次优解是将数组变成比方说 [6,7,8,9,10] ，因为需要 5 次操作。
//显然我们无法使用少于 4 次操作将数组变成 K 递增的。
// 
//
// 示例 2： 
//
// 输入：arr = [4,1,5,2,6,2], k = 2
//输出：0
//解释：
//这是题目描述中的例子。
//对于每个满足 2 <= i <= 5 的下标 i ，有 arr[i-2] <= arr[i] 。
//由于给定数组已经是 K 递增的，我们不需要进行任何操作。 
//
// 示例 3： 
//
// 输入：arr = [4,1,5,2,6,2], k = 3
//输出：2
//解释：
//下标 3 和 5 是仅有的 3 <= i <= 5 且不满足 arr[i-3] <= arr[i] 的下标。
//将数组变成 K 递增的方法之一是将 arr[3] 变为 4 ，且将 arr[5] 变成 5 。
//数组变为 [4,1,5,4,6,5] 。
//可能有其他方法将数组变为 K 递增的，但没有任何一种方法需要的操作次数小于 2 次。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 10⁵ 
// 1 <= arr[i], k <= arr.length 
// 
// Related Topics 数组 二分查找 👍 26 👎 0


package com.wjp.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class MinimumOperationsToMakeTheArrayKIncreasing {
    public static void main(String[] args) {
        Solution solution = new MinimumOperationsToMakeTheArrayKIncreasing().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int kIncreasing(int[] arr, int k) {
            // 差值 k 的序列，可以视为 k 个子序列
            // 若是不是该子序列不是递增的，则找出当前最长的子序列，改动剩余的即可
            // len - lis
            int res = 0;
            for (int i = 0; i < k; i++) {
                List<Integer> list = new ArrayList<>();
                int j = i;
                while (j < arr.length) {
                    list.add(arr[j]);
                    j += k;
                }
                int lis = lengthIncreaseSeq(list);
                System.out.println("form seq start " + arr[i] + " size " + list.size() + "  lis : " + lis);
                res += list.size() - lis;
            }
            return res;
        }

        private int lengthIncreaseSeq(List<Integer> list) {
            // 将事dp[i] 视为长度i的增序列的最小末尾元素
            int[] dp = new int[list.size() + 1];
            int len = 1;
            // 长度为 1 的最小的末尾元素为第一元素
            dp[len] = list.get(0);
            for (int i = 1; i < list.size(); i++) {
                // 若是新增的元素比序列的元素还要大，则我们的最长序列长度可以增加一位了，且末尾元素就是当前值
                if (list.get(i) >= dp[len]) {
                    dp[++len] = list.get(i);
                }else{
                    // 否则，我们的最长序列长度不会变化
                    // 只是，我们某些长度的末尾元素可以是更小的元素了
                    // 由于当前 dp[1..len]是递增的数值，
                    // 1,3,5 遇到 4
                    // 则 >> 1,3,4
                    int l = 1, r = len, pos = 0;
                    int target = list.get(i);
                    while (l <= r) {
                        int mid = (l + r) / 2;
                        if (list.get(mid) <= target) {
                            pos = mid;
                            l = mid + 1;
                        }else{
                            r = mid - 1;
                        }
                    }
                    dp[pos + 1] = target;
                }
            }
            return len;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}