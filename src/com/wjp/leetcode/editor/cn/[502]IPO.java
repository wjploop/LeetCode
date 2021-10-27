//假设 力扣（LeetCode）即将开始 IPO 。为了以更高的价格将股票卖给风险投资公司，力扣 希望在 IPO 之前开展一些项目以增加其资本。 由于资源有限
//，它只能在 IPO 之前完成最多 k 个不同的项目。帮助 力扣 设计完成最多 k 个不同项目后得到最大总资本的方式。 
//
// 给你 n 个项目。对于每个项目 i ，它都有一个纯利润 profits[i] ，和启动该项目需要的最小资本 capital[i] 。 
//
// 最初，你的资本为 w 。当你完成一个项目时，你将获得纯利润，且利润将被添加到你的总资本中。 
//
// 总而言之，从给定项目中选择 最多 k 个不同项目的列表，以 最大化最终资本 ，并输出最终可获得的最多资本。 
//
// 答案保证在 32 位有符号整数范围内。 
//
// 
//
// 示例 1： 
//
// 
//输入：k = 2, w = 0, profits = [1,2,3], capital = [0,1,1]
//输出：4
//解释：
//由于你的初始资本为 0，你仅可以从 0 号项目开始。
//在完成后，你将获得 1 的利润，你的总资本将变为 1。
//此时你可以选择开始 1 号或 2 号项目。
//由于你最多可以选择两个项目，所以你需要完成 2 号项目以获得最大的资本。
//因此，输出最后最大化的资本，为 0 + 1 + 3 = 4。
// 
//
// 示例 2： 
//
// 
//输入：k = 3, w = 0, profits = [1,2,3], capital = [0,1,2]
//输出：6
// 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= 10⁵ 
// 0 <= w <= 10⁹ 
// n == profits.length 
// n == capital.length 
// 1 <= n <= 10⁵ 
// 0 <= profits[i] <= 10⁴ 
// 0 <= capital[i] <= 10⁹ 
// 
// Related Topics 贪心 数组 排序 堆（优先队列） 👍 115 👎 0


package com.wjp.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Ipo {
    public static void main(String[] args) {
        Solution solution = new Ipo().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
            // 初始错误想法
            // 当前资本再投资某一个项目时，保证不亏，既保证 profits[i] - capital[i] > 0;
            // 对于当前资本，只能选择当前项目中，w >= capital[i]的项目
            // 假设我们可能投资无数项目，那么从可选项目中一个个选即可
            // 由于限定了k个项目，按理说，我们再可选中收获最多的，
            // 选完这个后，由于我们的成本变化了，故可选集合再次变化
            // 如何维护可选集合，选完i,后，原本的 w += (p - c)

            // 注意，资本不会变少，即投入某项目后，资本只会增加
            // 假设我们按照成本排序这些项目，那么我们的可选项只会不断增加
            // 在选择某项目后，可选项少了该项，然后因为资本的增加，我们又可以往可选项试图添加需要资本更大的项目
            int n = profits.length;

            int[][] arr = new int[n][2];
            for (int i = 0; i < n; i++) {
                arr[i][0] = capital[i];
                arr[i][1] = profits[i];
            }
            // 所需资本升序，即，我们在增加资本后，就可以维护一个当前选中的右边界，有边界只会往右移
            Arrays.sort(arr,(a, b) -> a[0] - b[0]);

            PriorityQueue<Integer> selects = new PriorityQueue<>((o1, o2) -> o2 - o1);


            int count = 0;
            int cur = 0;
            while (count++ < k) {
                // 每次改变w，我们试图尝试增加可选项
                while (cur < n && arr[cur][0] <= w){
                    selects.add(arr[cur][1]);
                    cur++;
                }

                if(selects.isEmpty()){
                    break;
                }

                // 每次都可以获取到最大利益的元素
                w += selects.poll();

            }
            return w;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}