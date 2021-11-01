//序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方
//式重构得到原数据。 
//
// 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反
//序列化为原始的树结构。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [1,2,3,null,null,4,5]
//输出：[1,2,3,null,null,4,5]
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
// 示例 4： 
//
// 
//输入：root = [1,2]
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，也可以采用其他的方法解决这
//个问题。 
// 树中结点数在范围 [0, 10⁴] 内 
// -1000 <= Node.val <= 1000 
// 
//
// 
//
// 注意：本题与主站 297 题相同：https://leetcode-cn.com/problems/serialize-and-deserialize-
//binary-tree/ 
// Related Topics 树 深度优先搜索 广度优先搜索 设计 字符串 二叉树 👍 8 👎 0


package com.wjp.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class H54YBf {
    public static void main(String[] args) {
        Codec solution = new H54YBf().new Codec();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        String res = solution.serialize(root);
        System.out.println(res);

        TreeNode de = solution.deserialize(res);
        System.out.println(solution.serialize(de));
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
    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            StringBuilder sb = new StringBuilder();
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    if (node == null) {
                        sb.append("null");
                    } else {
//                        System.out.println("node "+ node.val);
                        sb.append(node.val);
                        queue.add(node.left);
                        queue.add(node.right);
                    }
                    sb.append(",");
                }
            }
            return sb.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            String[] arr = data.split(",");
            Queue<TreeNode> queue = new LinkedList<>();
            TreeNode root = null;
            if (!arr[0].equals("null")) {
                root = new TreeNode(Integer.parseInt(arr[0]));
                queue.add(root);
            }
            int k = 1;
            while (!queue.isEmpty()) {

                TreeNode node = queue.poll();
                if (k > data.length()) {
                    break;
                }
                if (!arr[k].equals("null")) {
                    node.left = new TreeNode(Integer.parseInt(arr[k]));
                    queue.offer(node.left);
                }
                k++;
                if (k > data.length()) {
                    break;
                }
                if (!arr[k].equals("null")) {
                    node.right = new TreeNode(Integer.parseInt(arr[k]));
                    queue.offer(node.right);
                }
                k++;
            }
            return root;
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
//leetcode submit region end(Prohibit modification and deletion)

}