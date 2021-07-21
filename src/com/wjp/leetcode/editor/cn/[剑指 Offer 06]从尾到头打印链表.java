//输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。 
//
// 
//
// 示例 1： 
//
// 输入：head = [1,3,2]
//输出：[2,3,1] 
//
// 
//
// 限制： 
//
// 0 <= 链表长度 <= 10000 
// Related Topics 栈 递归 链表 双指针 
// 👍 167 👎 0

  
package com.wjp.leetcode.editor.cn;
  
class CongWeiDaoTouDaYinLianBiaoLcof{
    public static void main(String[] args) {
        Solution solution = new CongWeiDaoTouDaYinLianBiaoLcof().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)
    /**
     * 有一道经典题是，不使用额外空间逆序单链表
     * 这道只是打印？
     */
    class Solution {
    public int[] reversePrint(ListNode head) {
        if (head == null) {
            return new int[0];
        }
        int size = 0;
        ListNode p = head;

        // 计算链表长度
        while (p != null) {
            size++;
            p = p.next;
        }

        int[] res = new int[size];
        p = head;
        int i = size - 1;
        while (p != null) {
            res[i--] = p.val;
            p = p.next;
        }
        return res;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}