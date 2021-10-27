//输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。 
//
// 
//
// 示例: 
//给定如下二叉树，以及目标和 target = 22， 
//
// 
//              5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \    / \
//        7    2  5   1
// 
//
// 返回: 
//
// 
//[
//   [5,4,11,2],
//   [5,8,4,5]
//]
// 
//
// 
//
// 提示： 
//
// 
// 节点总数 <= 10000 
// 
//
// 注意：本题与主站 113 题相同：https://leetcode-cn.com/problems/path-sum-ii/ 
// Related Topics 树 深度优先搜索 回溯 二叉树 
// 👍 209 👎 0

  
package com.wjp.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

class ErChaShuZhongHeWeiMouYiZhiDeLuJingLcof{
    public static void main(String[] args) {
        Solution solution = new ErChaShuZhongHeWeiMouYiZhiDeLuJingLcof().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)

class Solution {

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        // 后序遍历，当左右为为空时，检验目标和是否为0
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, target, path,res);
        return res;
    }

    private void dfs(TreeNode root, int target, List<Integer> path, List<List<Integer>> res) {
        if (root == null) {
            return;
        }

        target = target - root.val;
        path.add(root.val);

        // 遇到叶子节点，且符合答案
        if (root.left == null && root.right == null && target == 0) {
            res.add(new ArrayList<>(path));
        }

        dfs(root.left, target, path, res);
        dfs(root.right, target, path, res);

        path.remove(path.size() - 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}