//给你一个链表数组，每个链表都已经按升序排列。 
//
// 请你将所有链表合并到一个升序链表中，返回合并后的链表。 
//
// 
//
// 示例 1： 
//
// 输入：lists = [[1,4,5],[1,3,4],[2,6]]
//输出：[1,1,2,3,4,4,5,6]
//解释：链表数组如下：
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//将它们合并到一个有序链表中得到。
//1->1->2->3->4->4->5->6
// 
//
// 示例 2： 
//
// 输入：lists = []
//输出：[]
// 
//
// 示例 3： 
//
// 输入：lists = [[]]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// k == lists.length 
// 0 <= k <= 10^4 
// 0 <= lists[i].length <= 500 
// -10^4 <= lists[i][j] <= 10^4 
// lists[i] 按 升序 排列 
// lists[i].length 的总和不超过 10^4 
// 
// Related Topics 链表 分治 堆（优先队列） 归并排序 👍 2043 👎 0

  
package com.wjp.leetcode.editor.cn;

import java.util.PriorityQueue;

class MergeKSortedLists{
    public static void main(String[] args) {
        Solution solution = new MergeKSortedLists().new Solution();
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
    public ListNode mergeKLists(ListNode[] lists) {
        // 每次从多个链表头选择最小的，移除头节点后，后面没有了，则移除
        // 重要的是，为了避免每次都要避免选择最小的，O（n），可以用堆，每次调整只要 O(logN)
        PriorityQueue<ListNode> heap = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);
        for (ListNode node : lists) {
            if (node != null) {
                heap.offer(node);
            }
        }
        ListNode dumpy = new ListNode(-1);
        ListNode tail = dumpy;
        while (!heap.isEmpty()) {
            ListNode node = heap.poll();
            if (node.next != null) {
                heap.offer(node.next);
            }
            node.next = null;
            tail.next = node;
            tail = tail.next;
        }
        return dumpy.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}