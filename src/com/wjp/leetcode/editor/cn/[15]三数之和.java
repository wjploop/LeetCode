//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
//复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 3000 
// -10⁵ <= nums[i] <= 10⁵ 
// 
// Related Topics 数组 双指针 排序 👍 4209 👎 0


package com.wjp.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ThreeSum {
    public static void main(String[] args) {
        Solution solution = new ThreeSum().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            int n = nums.length;
            List<List<Integer>> res = new ArrayList<>();
            for (int k = 0; k < n - 2; k++) {
                if (nums[k] > 0) {
                    // 可以直接返回了
                    return res;
                }
                if (k > 0 && nums[k] == nums[k - 1]) {
                    continue;
                }
                // 在 [k+1,n)中寻找两数和为 expect
                // 对于已经排序好得数组
                int i = k + 1, j = n - 1;
                while (i < j) {
//                    if (i > k + 1 && nums[i] == nums[i - 1]) {
//                        i++;
//                        continue;
//                    }
//                    if (j < n - 1 && nums[j] == nums[j + 1]) {
//                        j--;
//                        continue;
//                    }
                    int sum = nums[k] + nums[i] + nums[j];
                    if (sum < 0) {
                        i++;
                    } else if (sum > 0) {
                        j--;
                    } else {
                        res.add(Arrays.asList(nums[k], nums[i], nums[j]));
                        // 去重放到找到符合条件的之后
                        while (i < j && nums[i] == nums[i + 1]) {
                            i++;
                        }
                        while (i < j && nums[j] == nums[j - 1]) {
                            j--;
                        }
                        i++;
                        j--;
                    }
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}