//把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2
//] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。 
//
// 示例 1： 
//
// 输入：[3,4,5,1,2]
//输出：1
// 
//
// 示例 2： 
//
// 输入：[2,2,2,0,1]
//输出：0
// 
//
// 注意：本题与主站 154 题相同：https://leetcode-cn.com/problems/find-minimum-in-rotated-sor
//ted-array-ii/ 
// Related Topics 数组 二分查找 
// 👍 360 👎 0

  
package com.wjp.leetcode.editor.cn;
  
class XuanZhuanShuZuDeZuiXiaoShuZiLcof{
    public static void main(String[] args) {
        Solution solution = new XuanZhuanShuZuDeZuiXiaoShuZiLcof().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 若是存在两个上升得子数组，则，第一个数组最小得元素也比 min(arr1) > max(arr2)
     * 遍历一次，需要O(n)
     * 二分查找
     * mid < end
     *
     */
    class Solution {
    public int minArray(int[] nums) {
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            // 1, 2, 3, 4, 5
            // 3, 4, 5, 1, 2
            // 起点和中点比较不能确定min在那边
//            if (nums[mid] > nums[start]) {
            //
            // 若是这是使用<=
            // 用例 3,3,1,3通不过了
            if (nums[mid] < nums[end]) {
                // 可以确定最小值在左边
                end = mid;
                // 由于可能 mid == start
            } else if (nums[mid] > nums[end]) {
                start = mid + 1;
            }else{
                // 直接忽略end，
                end--;
            }
        }
        return nums[start];
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}