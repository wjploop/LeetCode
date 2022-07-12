//给定一个单链表 L 的头节点 head ，单链表 L 表示为： 
//
// 
//L0 → L1 → … → Ln - 1 → Ln
// 
//
// 请将其重新排列后变为： 
//
// 
//L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → … 
//
// 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：head = [1,2,3,4]
//输出：[1,4,2,3] 
//
// 示例 2： 
//
// 
//
// 
//输入：head = [1,2,3,4,5]
//输出：[1,5,2,4,3] 
//
// 
//
// 提示： 
//
// 
// 链表的长度范围为 [1, 5 * 10⁴] 
// 1 <= node.val <= 1000 
// 
// Related Topics 栈 递归 链表 双指针 👍 723 👎 0

  
package com.wjp.leetcode.editor.cn;
  
class ReorderList{
    public static void main(String[] args) {
        Solution solution = new ReorderList().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        // 找中点，mid
        // 逆序后面一半的节点
        // 拼接两部分
        ListNode dumpy = new ListNode(-1);
        dumpy.next = head;
        ListNode slow = dumpy, fast = dumpy;
        // 1,2,3
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow.next;
//        System.out.println("mid: "+ mid.val);
        slow.next = null;
        ListNode right = reverse(mid);
        ListNode left = head;
        ListNode tail = dumpy;

        while (left != null && right != null) {
            tail.next = left;
            left = left.next;
            tail.next.next = right;
            right = right.next;
            tail = tail.next.next;
        }
        if (left != null) {
            tail.next = left;
        }

    }

    private ListNode reverse(ListNode head) {
        ListNode dumpy = new ListNode(-1);
        while (head != null) {
            ListNode next = head.next;
            head.next = dumpy.next;
            dumpy.next = head;
            head = next;
        }
        return dumpy.next;
    }

    private void print(ListNode head) {
        while (head != null) {
            System.out.print(head.val + ", ");
        }
        System.out.println("");
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}