//给你一棵二叉树的根节点 root ，返回其节点值的 后序遍历 。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,null,2,3]
//输出：[3,2,1]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 深度优先搜索 二叉树 👍 878 👎 0


package com.wjp.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class BinaryTreePostorderTraversal {
    public static void main(String[] args) {
        Solution solution = new BinaryTreePostorderTraversal().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    /**
     * 中序遍历
     * 优先将所有左子树入栈，当到达最左下角时，弹出找到根节点
     * 此时，要先访问右子树
     * 若右子树为空，则可以直接访问根节点，访问后需要将root置空
     * 若是右子树不为空，则要将弹出的根节点重新入栈，目前还不能访问，root指向右节点，继续
     * <p>
     * 此时，会出现一个问题，访问完右子树后，再访问根节点,又会重新进入右节点，
     */
    class Solution {
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            Deque<TreeNode> stack = new ArrayDeque<>();
            //
            TreeNode prev = null;
            while (root != null || !stack.isEmpty()) {
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
                // 已经到了左子树的最左下角了
                root = stack.pop();

                // 若是右子树的为空,或者已经访问过，则可以访问root
                // 若是上次已经访问过右节点
                if (root.right == null || prev == root.right) {
                    res.add(root.val);
                    // 用来标记是否已经访问过
                    prev = root;
                    root = null;
                } else {
                    stack.push(root);
                    TreeNode temp = root.right;
                    // 断开的策略不可取，改变了原来的树，改为标记是否已经访问过
                    // 但是又不能在这里标记，而是在访问之后标记
//                    root.right = null;
                    root = temp;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}