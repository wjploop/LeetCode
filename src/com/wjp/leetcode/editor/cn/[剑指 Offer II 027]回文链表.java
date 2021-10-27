//给定一个链表的 头节点 head ，请判断其是否为回文链表。 
//
// 如果一个链表是回文，那么链表节点序列从前往后看和从后往前看是相同的。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入: head = [1,2,3,3,2,1]
//输出: true 
//
// 示例 2： 
//
// 
//
// 
//输入: head = [1,2]
//输出: false
// 
//
// 
//
// 提示： 
//
// 
// 链表 L 的长度范围为 [1, 10⁵] 
// 0 <= node.val <= 9 
// 
//
// 
//
// 进阶：能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
//
// 
//
// 注意：本题与主站 234 题相同：https://leetcode-cn.com/problems/palindrome-linked-list/ 
// Related Topics 栈 递归 链表 双指针 👍 10 👎 0


package com.wjp.leetcode.editor.cn;

class AMhZSa {
    public static void main(String[] args) {
        Solution solution = new AMhZSa().new Solution();
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
        public boolean isPalindrome(ListNode head) {
            if (head.next == null) {
                return true;
            }
            if (head.next.next == null) {
                return head.val == head.next.val;
            }
            // 至少三个节点
            ListNode middlePrev = middle(head);
//            System.out.println("middle " + middlePrev.next.val);
            ListNode rightPart = reverse(middlePrev.next);
            middlePrev.next = null;
            // 比较左右部分是否相同
            // 由于右部分可能比左边少一个，故仅判断右边即可
            ListNode p = head, q = rightPart;
            boolean res = true;
            while (q != null) {
//                System.out.println("check " + p.val + "," + q.val);
                if (p.val != q.val) {
                    res = false;
                    break;
                }
                p = p.next;
                q = q.next;
            }
            // 恢复链表
//            middlePrev.next = reverse(rightPart);
            return res;

        }

        // 获取到中间节点的前一个节点
        private ListNode middle(ListNode head) {
            // 一个节点时，中点不存在？
            // 两个节点时，应该也是不存在
            // 三个节点时，返回第一个节点
            ListNode p = head, q = head;
            while (q != null && q.next != null && q.next.next != null) {
                p = p.next;
                q = q.next.next;
            }
            return p;
        }

        private ListNode reverse(ListNode head) {
            ListNode prev = null, curr = head, next;
            while (curr != null) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            return prev;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}