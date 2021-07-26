//定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。 
//
// 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL 
//
// 
//
// 限制： 
//
// 0 <= 节点个数 <= 5000 
//
// 
//
// 注意：本题与主站 206 题相同：https://leetcode-cn.com/problems/reverse-linked-list/ 
// Related Topics 递归 链表 
// 👍 265 👎 0

  
package com.wjp.leetcode.editor.cn;

import java.util.List;

class FanZhuanLianBiaoLcof{
    public static void main(String[] args) {
        Solution solution = new FanZhuanLianBiaoLcof().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 迭代中，其关键在于，注意用三个指针,尤其开始时设置 prev=null
     */
    class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode next = head.next;
        ListNode right = reverseList(next);
        head.next=null;
        next.next = head;
        return right;
    }
}
//leetcode submit region end(Prohibit modification and deletion)



}