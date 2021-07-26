//输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构) 
//
// B是A的子结构， 即 A中有出现和B相同的结构和节点值。 
//
// 例如: 
//给定的树 A: 
//
// 3 
// / \ 
// 4 5 
// / \ 
// 1 2 
//给定的树 B： 
//
// 4 
// / 
// 1 
//返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。 
//
// 示例 1： 
//
// 输入：A = [1,2,3], B = [3,1]
//输出：false
// 
//
// 示例 2： 
//
// 输入：A = [3,4,5,1,2], B = [4,1]
//输出：true 
//
// 限制： 
//
// 0 <= 节点个数 <= 10000 
// Related Topics 树 深度优先搜索 二叉树 
// 👍 311 👎 0


package com.wjp.leetcode.editor.cn;

class ShuDeZiJieGouLcof {
    public static void main(String[] args) {
        Solution solution = new ShuDeZiJieGouLcof().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)

    /**
     *
     */
    class Solution {
        public boolean isSubStructure(TreeNode A, TreeNode B) {
            // 例外情况,题目要求
            if (B == null) {
                return false;
            }
            // A为空时，其他数不会是其子结构了
            if (A == null) {
                return false;
            }
            // B树与复印在A树上了
            if (isSub(A, B)) {
                return true;
            }
            return isSubStructure(A.left, B) || isSubStructure(A.right, B);

        }


        // 判断B是否为A的子树
        // 相同时，要求B根节点与A根节点重合
        private boolean isSub(TreeNode A, TreeNode B) {
            if (B == null) {
                return true;
            }
            if (A == null) {
                return false;
            }
            if (A.val != B.val) {
                return false;
            }
            return isSub(A.left, B.left) && isSub(A.right, B.right);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
