//输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。 
//
// 
//
// 参考以下这颗二叉搜索树： 
//
//      5
//    / \
//   2   6
//  / \
// 1   3 
//
// 示例 1： 
//
// 输入: [1,6,3,2,5]
//输出: false 
//
// 示例 2： 
//
// 输入: [1,3,2,6,5]
//输出: true 
//
// 
//
// 提示： 
//
// 
// 数组长度 <= 1000 
// 
// Related Topics 栈 树 二叉搜索树 递归 二叉树 单调栈 
// 👍 312 👎 0


package com.wjp.leetcode.editor.cn;

class ErChaSouSuoShuDeHouXuBianLiXuLieLcof {
    public static void main(String[] args) {
        Solution solution = new ErChaSouSuoShuDeHouXuBianLiXuLieLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean verifyPostorder(int[] postorder) {
            return check(postorder, 0, postorder.length - 1);
        }

        private boolean check(int[] postorder, int start, int end) {
            // 一个节点或没有
            if (start >= end) {
                return true;
            }
            int root = postorder[end];
            // left right root
            // 左边开始找到第一个比root大的，即为右子树root
            // 寻找右子树的根节点
            int k = start;
            while (k < end && postorder[k] < root) {
                k++;
            }
            // 没有右子树
            if (k == end) {
                return check(postorder, start, end - 1);
            }else{
                for (int i = k; i < end; i++) {
                    if (postorder[i] < root) {
                        return false;
                    }
                }
                return check(postorder, start, k - 1) && check(postorder, k, end - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}