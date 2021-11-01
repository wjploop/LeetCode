//给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。 
//
// 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
//输出：3
//解释：和等于 8 的路径有 3 条，如图所示。
// 
//
// 示例 2： 
//
// 
//输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
//输出：3
// 
//
// 
//
// 提示: 
//
// 
// 二叉树的节点个数的范围是 [0,1000] 
// -10⁹ 
// -1000 <= targetSum <= 1000 
// 
//
// 
//
// 注意：本题与主站 437 题相同：https://leetcode-cn.com/problems/path-sum-iii/ 
// Related Topics 树 深度优先搜索 二叉树 👍 7 👎 0


package com.wjp.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class SixEUYwP {
    public static void main(String[] args) {
        Solution solution = new SixEUYwP().new Solution();
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
    class Solution {
        public int pathSum(TreeNode root, int targetSum) {
            // 一个树
            Map<Integer, Integer> map = new HashMap<>();
            map.put(0, 1);
            int[] count = new int[1];
            dfs(root, map, count, 0, targetSum);
            return count[0];
        }

        private void dfs(TreeNode root, Map<Integer, Integer> map, int[] count, int cur, int targetSum) {
            if (root == null) {
                return;
            }

            cur += root.val;
            count[0] += map.getOrDefault(cur - targetSum, 0);

            map.put(cur, map.getOrDefault(cur, 0) + 1);
            dfs(root.left, map, count, cur, targetSum);
            dfs(root.right, map, count, cur, targetSum);

            map.put(cur, map.getOrDefault(cur, 0) - 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}