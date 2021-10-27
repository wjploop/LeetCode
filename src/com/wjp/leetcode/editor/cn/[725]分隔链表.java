//给你一个头结点为 head 的单链表和一个整数 k ，请你设计一个算法将链表分隔为 k 个连续的部分。 
//
// 每部分的长度应该尽可能的相等：任意两部分的长度差距不能超过 1 。这可能会导致有些部分为 null 。 
//
// 这 k 个部分应该按照在链表中出现的顺序排列，并且排在前面的部分的长度应该大于或等于排在后面的长度。 
//
// 返回一个由上述 k 部分组成的数组。 
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3], k = 5
//输出：[[1],[2],[3],[],[]]
//解释：
//第一个元素 output[0] 为 output[0].val = 1 ，output[0].next = null 。
//最后一个元素 output[4] 为 null ，但它作为 ListNode 的字符串表示是 [] 。
// 
//
// 示例 2： 
//
// 
//输入：head = [1,2,3,4,5,6,7,8,9,10], k = 3
//输出：[[1,2,3,4],[5,6,7],[8,9,10]]
//解释：
//输入被分成了几个连续的部分，并且每部分的长度相差不超过 1 。前面部分的长度大于等于后面部分的长度。
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 1000] 
// 0 <= Node.val <= 1000 
// 1 <= k <= 50 
// 
// Related Topics 链表 👍 214 👎 0


package com.wjp.leetcode.editor.cn;

class SplitLinkedListInParts {
    public static void main(String[] args) {
        Solution solution = new SplitLinkedListInParts().new Solution();
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
        public ListNode[] splitListToParts(ListNode head, int k) {
            // 将列表分为K份
            // 假设长度n < k ，需要补足空链表
            // 假设 n > k
            // 保持两两子链表长度差小于等于1
            // 即，前面有一部分子链表长度大于后面部分

            // 先求出链表长度 n
            ListNode p = head;
            int n = 0;
            while (p != null) {
                n++;
                p = p.next;
            }
            ListNode[] res = new ListNode[k];
            int i = 0;
            if (n <= k) {
                p = head;
                while (i < n) {
                    res[i] = p;
                    p = p.next;
                    res[i].next = null;
                    i++;
                }
            } else {
                p = head;
                int len = n / k;
                int remain = n % k;
                while (i < k) {
                    int curLen = len + (i < remain ? 1 : 0);
                    res[i] = p;
                    for (int j = 0; j < curLen - 1; j++) {
                        p = p.next;
                    }
                    ListNode nextP = p.next;
                    p.next = null;
                    p = nextP;
                    i++;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
