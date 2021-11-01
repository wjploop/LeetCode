//给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。 
//
// 假设二叉树中至少有一个节点。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: root = [2,1,3]
//输出: 1
// 
//
// 示例 2: 
//
// 
//
// 
//输入: [1,2,3,4,null,5,6,null,null,7]
//输出: 7
// 
//
// 
//
// 提示: 
//
// 
// 二叉树的节点个数的范围是 [1,10⁴] 
// -2³¹ <= Node.val <= 2³¹ - 1 
// 
//
// 
//
// 注意：本题与主站 513 题相同： https://leetcode-cn.com/problems/find-bottom-left-tree-
//value/ 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 5 👎 0

  
package com.wjp.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

class LwUNpT{
    public static void main(String[] args) {
        Solution solution = new LwUNpT().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int findBottomLeftValue(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(root, 0, list);
        return list.get(list.size() - 1);
    }

    private void dfs(TreeNode root, int height, List<Integer> list) {
        if (root == null) {
            return;
        }
        if (height == list.size()) {
            list.add(root.val);
        }
        dfs(root.left, height + 1, list);
        dfs(root.right, height + 1, list);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}