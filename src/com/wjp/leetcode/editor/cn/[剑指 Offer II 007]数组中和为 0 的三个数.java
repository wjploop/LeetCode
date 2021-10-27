//给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a ，b ，c ，使得 a + b + c = 0 ？请找出所有和为 0 且 
//不重复 的三元组。 
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
//
// 
//
// 注意：本题与主站 15 题相同：https://leetcode-cn.com/problems/3sum/ 
// Related Topics 数组 双指针 排序 👍 17 👎 0


package com.wjp.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class OneFGaJU {
    public static void main(String[] args) {
        Solution solution = new OneFGaJU().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            // 枚举取三个数的位n的三次方
            // 注意去重
            // 先排序
            List<List<Integer>> res = new ArrayList<>();
            Arrays.sort(nums);
            for (int k = 0; k < nums.length - 2; k++) {
                if (k > 0 && nums[k] == nums[k - 1]) {
                    continue;
                }
                int expected = -nums[k];
                int i = k + 1, j = nums.length - 1;
                while (i < j) {
                    if (i > k + 1 && nums[i] == nums[i - 1]) {
                        i++;
                        continue;
                    }
                    if (j < nums.length-1 && nums[j] == nums[j + 1]) {
                        j--;
                        continue;
                    }

                    int sum = nums[i] + nums[j];
                    if (sum < expected) {
                        i++;
                    } else if (sum > expected) {
                        j--;
                    } else {
                        res.add(Arrays.asList(nums[k], nums[i], nums[j]));
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