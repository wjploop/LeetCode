//如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，那么中位数就是所有数
//值排序之后中间两个数的平均值。 
//
// 例如， 
//
// [2,3,4] 的中位数是 3 
//
// [2,3] 的中位数是 (2 + 3) / 2 = 2.5 
//
// 设计一个支持以下两种操作的数据结构： 
//
// 
// void addNum(int num) - 从数据流中添加一个整数到数据结构中。 
// double findMedian() - 返回目前所有元素的中位数。 
// 
//
// 示例 1： 
//
// 输入：
//["MedianFinder","addNum","addNum","findMedian","addNum","findMedian"]
//[[],[1],[2],[],[3],[]]
//输出：[null,null,null,1.50000,null,2.00000]
// 
//
// 示例 2： 
//
// 输入：
//["MedianFinder","addNum","findMedian","addNum","findMedian"]
//[[],[2],[],[3],[]]
//输出：[null,null,2.00000,null,2.50000] 
//
// 
//
// 限制： 
//
// 
// 最多会对 addNum、findMedian 进行 50000 次调用。 
// 
//
// 注意：本题与主站 295 题相同：https://leetcode-cn.com/problems/find-median-from-data-strea
//m/ 
// Related Topics 设计 双指针 数据流 排序 堆（优先队列） 
// 👍 167 👎 0


package com.wjp.leetcode.editor.cn;

import java.util.*;

class ShuJuLiuZhongDeZhongWeiShuLcof {
    public static void main(String[] args) {
        MedianFinder solution = new ShuJuLiuZhongDeZhongWeiShuLcof().new MedianFinder();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MedianFinder {

        PriorityQueue<Integer> littleHeap;
        PriorityQueue<Integer> bigHeap;

        public MedianFinder() {
            littleHeap = new PriorityQueue<>();
            bigHeap = new PriorityQueue<>((o1, o2) -> -Integer.compare(o1, o2));
        }

        public void addNum(int num) {
            if (littleHeap.isEmpty() && bigHeap.isEmpty()) {
                littleHeap.add(num);
            } else if (littleHeap.size() == bigHeap.size() + 1) {
                littleHeap.add(num);
                bigHeap.add(littleHeap.poll());
            } else if (littleHeap.size() == bigHeap.size()) {
                bigHeap.add(num);
                littleHeap.add(bigHeap.poll());
            }
        }

        // 令小根堆大小为 m, 大根堆为 n
        // 小根堆保存较大的元素，大根堆保存小元素
        // 在较大的一边找到最小的元素，在小的一边找到最大的元素
        // 且，由于保持 m == n || m - 1 = n
        public double findMedian() {
            if (littleHeap.size() == bigHeap.size()) {
                return (littleHeap.peek() + bigHeap.peek()) / 2f;
            }else{
                return littleHeap.peek();
            }
        }
    }

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
//leetcode submit region end(Prohibit modification and deletion)

}