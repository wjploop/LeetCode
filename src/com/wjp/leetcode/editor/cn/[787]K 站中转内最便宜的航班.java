//有 n 个城市通过一些航班连接。给你一个数组 flights ，其中 flights[i] = [fromi, toi, pricei] ，表示该航班都从城
//市 fromi 开始，以价格 pricei 抵达 toi。 
//
// 现在给定所有的城市和航班，以及出发城市 src 和目的地 dst，你的任务是找到出一条最多经过 k 站中转的路线，使得从 src 到 dst 的 价格最便
//宜 ，并返回该价格。 如果不存在这样的路线，则输出 -1。 
//
// 
//
// 示例 1： 
//
// 
//输入: 
//n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
//src = 0, dst = 2, k = 1
//输出: 200
//解释: 
//城市航班图如下
//
//
//从城市 0 到城市 2 在 1 站中转以内的最便宜价格是 200，如图中红色所示。 
//
// 示例 2： 
//
// 
//输入: 
//n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
//src = 0, dst = 2, k = 0
//输出: 500
//解释: 
//城市航班图如下
//
//
//从城市 0 到城市 2 在 0 站中转以内的最便宜价格是 500，如图中蓝色所示。 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 100 
// 0 <= flights.length <= (n * (n - 1) / 2) 
// flights[i].length == 3 
// 0 <= fromi, toi < n 
// fromi != toi 
// 1 <= pricei <= 10⁴ 
// 航班没有重复，且不存在自环 
// 0 <= src, dst, k < n 
// src != dst 
// 
// Related Topics 深度优先搜索 广度优先搜索 图 动态规划 最短路 堆（优先队列） 👍 335 👎 0


package com.wjp.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

class CheapestFlightsWithinKStops {
    public static void main(String[] args) {
        Solution solution = new CheapestFlightsWithinKStops().new Solution();
        int res = solution.findCheapestPrice(3, new int[][]{
                {0,1,100},
                {1,2,200},
                {0,2,300},
        }, 0, 2, 1);
        System.out.println("res " + res);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
            // 找出所有可以 src to dst 的路径
            // 求出路径长度小于等于k
            // 取路径费用最小的

            // src to dst 可以由 src > dst1 > dst2
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{-1, src, 0});
            int res = Integer.MAX_VALUE;
            k++;
            while (k > 0) {
                int prevSize = queue.size();
                if (prevSize == 0) {
                    break;
                }
                System.out.println("k = " + k);
                while (prevSize--> 0) {
                    var current = queue.poll();
                    for (int[] flight : flights) {
                        if (flight[0] == current[1]) {
                            System.out.println("from "+ current[1] + " find "+ flight[1]);
                            int price = current[2] + flight[2];
                            if (flight[1] == dst) {
                                res = Math.min(res, price);
                                System.out.println("find a res" + price);
                            }else{
                                queue.add(new int[]{src, flight[1], price});
                            }
                        }
                    }
                }
                k--;
            }
            return res == Integer.MAX_VALUE ? -1 : res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}