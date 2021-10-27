//给定两个 非空链表 l1和 l2 来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。 
//
// 可以假设除了数字 0 之外，这两个数字都不会以零开头。 
//
// 
//
// 示例1： 
//
// 
//
// 
//输入：l1 = [7,2,4,3], l2 = [5,6,4]
//输出：[7,8,0,7]
// 
//
// 示例2： 
//
// 
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[8,0,7]
// 
//
// 示例3： 
//
// 
//输入：l1 = [0], l2 = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 链表的长度范围为 [1, 100] 
// 0 <= node.val <= 9 
// 输入数据保证链表代表的数字无前导 0 
// 
//
// 
//
// 进阶：如果输入链表不能修改该如何处理？换句话说，不能对列表中的节点进行翻转。 
//
// 
//
// 注意：本题与主站 445 题相同：https://leetcode-cn.com/problems/add-two-numbers-ii/ 
// Related Topics 栈 链表 数学 👍 13 👎 0


package com.wjp.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

class LMSNwu {
    public static void main(String[] args) {
        Solution solution = new LMSNwu().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode r1 = reverse(l1), r2 = reverse(l2);

            ListNode dumpy = new ListNode(-1);
            int carry = 0;
            while (r1 != null || r2 != null || carry != 0) {
                int x = r1 == null ? 0 : r1.val;
                int y = r2 == null ? 0 : r2.val;
                r1 = r1 == null ? null : r1.next;
                r2 = r2 == null ? null : r2.next;
                int z = x + y + carry;
//                System.out.println(x + "+" + y);
                ListNode newNode = new ListNode(z % 10);
                newNode.next = dumpy.next;
                dumpy.next = newNode;
                carry = z / 10;
            }
            return dumpy.next;
        }

        private ListNode reverse(ListNode head) {
            ListNode prev = null, cur = head, next = null;
            while (cur != null) {
                next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
            }
            return prev;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}