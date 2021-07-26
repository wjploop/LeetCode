//请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。 
//
// 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。 
//
// 1 
// / \ 
// 2 2 
// / \ / \ 
//3 4 4 3 
//但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的: 
//
// 1 
// / \ 
// 2 2 
// \ \ 
// 3 3 
//
// 
//
// 示例 1： 
//
// 输入：root = [1,2,2,3,4,4,3]
//输出：true
// 
//
// 示例 2： 
//
// 输入：root = [1,2,2,null,3,null,3]
//输出：false 
//
// 
//
// 限制： 
//
// 0 <= 节点个数 <= 1000 
//
// 注意：本题与主站 101 题相同：https://leetcode-cn.com/problems/symmetric-tree/ 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 
// 👍 213 👎 0


package com.wjp.leetcode.editor.cn;

import java.util.*;
import java.util.stream.Collectors;

class DuiChengDeErChaShuLcof {
    public static void main(String[] args) {
        Solution solution = new DuiChengDeErChaShuLcof().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public boolean isSymmetric(TreeNode root) {
            if (root == null) {
                return true;
            }
            return isSymmetric(root.left, root.right);
        }

        private boolean isSymmetric(TreeNode a, TreeNode b) {
            if (a == null && b == null) {
                return true;
            }
            if (a == null || b == null) {
                return false;
            }
            if (a.val != b.val) {
                return false;
            }
            return isSymmetric(a.left, b.right) && isSymmetric(a.right, b.left);
        }

        // 层序遍历
        public boolean isSymmetric2(TreeNode root) {
            if (root == null) {
                return true;
            }
            List<TreeNode> nodes = new ArrayList<>();
            List<TreeNode> nextLine;
            nodes.add(root);
            int line = 0;
            while (!nodes.isEmpty()) {
                if (!isSymmetric(nodes)) {
                    return false;
                }
//            System.out.println("add line " + line);
                line++;
                nextLine = new ArrayList<>();
                for (TreeNode node : nodes) {
                    if (node != null) {
                        nextLine.add(node.left);
                        nextLine.add(node.right);
                    }
                }
                nodes = nextLine;
            }
            return true;
        }

        private boolean isSymmetric(List<TreeNode> nodes) {
//        String str = nodes.stream().map(treeNode -> {
//            if (treeNode == null) {
//                return "null";
//            }else{
//                return String.valueOf(treeNode.val);
//            }
//        }).collect(Collectors.joining(","));
//        System.out.println("line: " + str);
            int i = 0, j = nodes.size() - 1;
            while (i < j) {
                TreeNode left = nodes.get(i), right = nodes.get(j);
                if (left == null && right == null) {
                    i++;
                    j--;
                    continue;
                }
                if (left == null || right == null) {
                    return false;
                }
                if (left.val != right.val) {
                    return false;
                } else {
                    i++;
                    j--;
                }
            }
//        System.out.println("true");
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
