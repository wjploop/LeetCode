//输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。 
//
// 
//
// 示例 1: 
//
// 输入: [10,2]
//输出: "102" 
//
// 示例 2: 
//
// 输入: [3,30,34,5,9]
//输出: "3033459" 
//
// 
//
// 提示: 
//
// 
// 0 < nums.length <= 100 
// 
//
// 说明: 
//
// 
// 输出结果可能非常大，所以你需要返回一个字符串而不是整数 
// 拼接起来的数字可能会有前导 0，最后结果不需要去掉前导 0 
// 
// Related Topics 贪心 字符串 排序 👍 300 👎 0


package com.wjp.leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;

class BaShuZuPaiChengZuiXiaoDeShuLcof {
    public static void main(String[] args) {
        Solution solution = new BaShuZuPaiChengZuiXiaoDeShuLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String minNumber(int[] nums) {
            // 3 和 30 谁应该放前面？
            // 330 or 303 ？可知30放前面
            // 即比较两个数时，需要拼凑后决定谁放前面，即更小
            quickSort(nums, 0, nums.length - 1);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < nums.length; i++) {
                sb.append(nums[i]);
            }
            return sb.toString();
        }

        void quickSort(int[] nums, int start, int end) {
            if (start >= end) {
                return;
            }
            int pivot = nums[start];
            int i = start, j = end;
            while (i < j) {
                while (i < j && compare(nums[j], pivot) > 0) { // 右起找到第一个比pivot小的数
                    j--;
                }
                // 将这个小的值放到左边
                // 同时，左边nums[j]可以作为空坑
                nums[i] = nums[j];

                while (i < j && compare(nums[i], pivot) <= 0) { // 左边起找到第一个大于pivot的数
                    i++;
                }
                nums[j] = nums[i];
            }
            // 此时 i==j
            nums[i] = pivot;
            quickSort(nums, start, i - 1);
            quickSort(nums, i + 1, end);
        }

        private int compare(int a, int b) {

            String ab = a + "" + b;
            String ba = b + "" + a;
            return String.CASE_INSENSITIVE_ORDER.compare(ab, ba);
//            return ab == ba ? 0 : ab > ba ? 1 : 0;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
