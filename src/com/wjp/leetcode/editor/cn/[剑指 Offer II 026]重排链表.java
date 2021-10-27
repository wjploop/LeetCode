//给定一个单链表 L 的头节点 head ，单链表 L 表示为： 
//
// L0 → L1 → … → Ln-1 → Ln 
//请将其重新排列后变为： 
//
// L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → … 
//
// 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: head = [1,2,3,4]
//输出: [1,4,2,3] 
//
// 示例 2: 
//
// 
//
// 
//输入: head = [1,2,3,4,5]
//输出: [1,5,2,4,3] 
//
// 
//
// 提示： 
//
// 
// 链表的长度范围为 [1, 5 * 10⁴] 
// 1 <= node.val <= 1000 
// 
//
// 
//
// 注意：本题与主站 143 题相同：https://leetcode-cn.com/problems/reorder-list/ 
// Related Topics 栈 递归 链表 双指针 👍 13 👎 0

  
package com.wjp.leetcode.editor.cn;
  
class LGjMqU{
    public static void main(String[] args) {
        Solution solution = new LGjMqU().new Solution();
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
        // 找到中点
        // 翻转后部分
        // 并联两部分

        ListNode dumpy = new ListNode(-1);
        dumpy.next = head;
        ListNode p = dumpy, q = dumpy;
        while (q != null && q.next != null) {
            p = p.next;
            q = q.next.next;
        }
        // 1,2,3
        ListNode middle = reverse(p.next);
        p.next = null;

        p = head;
        q = middle;
        while (q != null) {
            ListNode pNext = p.next, qNext = q.next;
            p.next = q;
            q.next = pNext;
            p = pNext;
            q = qNext;
        }

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