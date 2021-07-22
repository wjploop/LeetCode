//输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。 
//
// 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。 
//
// 
//
// 示例 1: 
//
// 
//Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//Output: [3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
//Input: preorder = [-1], inorder = [-1]
//Output: [-1]
// 
//
// 
//
// 限制： 
//
// 0 <= 节点个数 <= 5000 
//
// 
//
// 注意：本题与主站 105 题重复：https://leetcode-cn.com/problems/construct-binary-tree-from-
//preorder-and-inorder-traversal/ 
// Related Topics 树 数组 哈希表 分治 二叉树 
// 👍 513 👎 0


package com.wjp.leetcode.editor.cn;

class ZhongJianErChaShuLcof {
    public static void main(String[] args) {
        Solution solution = new ZhongJianErChaShuLcof().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 先序，root, left, right
     * 中序，left, root, right
     */
    class Solution {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length-1);
        }

        private TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inOrder, int inStart, int inEnd) {
//            System.out.println("build [" + preStart + "," + preEnd + "], [" + inStart + "," + inEnd + "]");

            if (preStart > preEnd) {
                return null;
            }
            int rootVal = preorder[preStart];
            TreeNode root = new TreeNode(rootVal);
            int leftLen = 0;
            for (int i = inStart; i <= inEnd; i++) {
                if (inOrder[i] == rootVal) {
                    //1,2,3,4
                    leftLen = i - inStart;
                    break;

                }
            }
            root.left = buildTree(preorder, preStart + 1, preStart + leftLen, inOrder, inStart, inStart + leftLen - 1);
            root.right = buildTree(preorder, preStart + 1 + leftLen, preEnd, inOrder, inStart + leftLen + 1, inEnd);

            return root;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}