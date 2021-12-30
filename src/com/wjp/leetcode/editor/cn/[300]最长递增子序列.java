//给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。 
//
// 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序
//列。 
// 
//
// 示例 1： 
//
// 
//输入：nums = [10,9,2,5,3,7,101,18]
//输出：4
//解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1,0,3,2,3]
//输出：4
// 
//
// 示例 3： 
//
// 
//输入：nums = [7,7,7,7,7,7,7]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2500 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// 
//
// 进阶： 
//
// 
// 你可以设计时间复杂度为 O(n²) 的解决方案吗？ 
// 你能将算法的时间复杂度降低到 O(n log(n)) 吗? 
// 
// Related Topics 数组 二分查找 动态规划 👍 2094 👎 0

  
package com.wjp.leetcode.editor.cn;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import javax.swing.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.IntUnaryOperator;
import java.util.stream.Collectors;

class LongestIncreasingSubsequence{
    public static void main(String[] args) {
        Solution solution = new LongestIncreasingSubsequence().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLIS(int[] nums) {
//        int len = 1, n = nums.length;
//        if (n == 0) {
//            return 0;
//        }
//        int[] d = new int[n + 1];
//        // 长度为 len 的递增序列中，最小的末端值为 dp[len]
//        d[len] = nums[0];
//        for (int i = 1; i < n; ++i) {
//            //
//            if (nums[i] > d[len]) {
//                d[++len] = nums[i];
//            } else {
//                int l = 1, r = len, pos = 0; // 如果找不到说明所有的数都比 nums[i] 大，此时要更新 d[1]，所以这里将 pos 设为 0
//                while (l <= r) {
//                    int mid = (l + r) >> 1;
//                    if (d[mid] < nums[i]) {
//                        pos = mid;
//                        l = mid + 1;
//                    } else {
//                        r = mid - 1;
//                    }
//                }
//                d[pos + 1] = nums[i];
//            }
//        }
//        return len;
        List<Integer> list = new ArrayList<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
        return lengthIncreaseSeq(list);
    }

    private int lengthIncreaseSeq(List<Integer> list) {
        // 将事dp[i] 视为长度i的增序列的最小末尾元素
        int[] dp = new int[list.size() + 1];
        int len = 1;
        // 长度为 1 的最小的末尾元素为第一元素
        dp[len] = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            // 若是新增的元素比序列的元素还要大，则我们的最长序列长度可以增加一位了，且末尾元素就是当前值
            int cur = list.get(i);
            System.out.println(String.join(",", Arrays.stream(dp).mapToObj(operand -> ""+ operand).collect(Collectors.toList())) +" >>> "+ cur);
            if (cur > dp[len]) {
                System.out.println("add " + cur);
                dp[++len] = cur;
            }else{
                // 否则，我们的最长序列长度不会变化
                // 只是，我们某些长度的末尾元素可以是更小的元素了
                // 由于当前 dp[1..len]是递增的数值，
                // 1,3,5 遇到 4
                // 则 >> 1,3,4
                int l = 1, r = len, pos = 0;
                while (l <= r) {
                    int mid = (l + r) / 2;
                    if (dp[mid] == cur) {
                        pos = mid;
                        break;
                    } else if (dp[mid] < cur) {
                        r = mid - 1;
                    }else{
                        l = mid + 1;
                    }
                }
                // 若没有找到，则 l 即是我们要插入 target 在dp的位置
                // 2,3,5,6 >> 4
                /// l == 2, 我们将 5 替换成4
                // 2,3,5,6 >> 1
                // l == 0 ，我们将 2 替换成1
                //
                pos = pos == 0 ? 0: l;
                dp[pos+1] = cur;

            }
        }
        return len;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}