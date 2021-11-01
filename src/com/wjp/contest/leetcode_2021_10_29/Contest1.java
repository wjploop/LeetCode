package com.wjp.contest.leetcode_2021_10_29;

import com.wjp.leetcode.editor.cn.ListNode;

class Contest1 {
    public static void main(String[] args) {
        Solution solution = new Contest1().new Solution();
    }

    class Solution {
        public ListNode deleteListNode(ListNode head) {
            ListNode cur = head;
            ListNode next = null;
            while (cur != null && cur.next != null) {
                cur.next = cur.next.next;
                cur = cur.next;
            }
            return head;
        }
    }
}