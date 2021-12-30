//有一棵特殊的苹果树，一连 n 天，每天都可以长出若干个苹果。在第 i 天，树上会长出 apples[i] 个苹果，这些苹果将会在 days[i] 天后（也就
//是说，第 i + days[i] 天时）腐烂，变得无法食用。也可能有那么几天，树上不会长出新的苹果，此时用 apples[i] == 0 且 days[i] =
//= 0 表示。 
//
// 你打算每天 最多 吃一个苹果来保证营养均衡。注意，你可以在这 n 天之后继续吃苹果。 
//
// 给你两个长度为 n 的整数数组 days 和 apples ，返回你可以吃掉的苹果的最大数目。 
//
// 
//
// 示例 1： 
//
// 输入：apples = [1,2,3,5,2], days = [3,2,1,4,2]
//输出：7
//解释：你可以吃掉 7 个苹果：
//- 第一天，你吃掉第一天长出来的苹果。
//- 第二天，你吃掉一个第二天长出来的苹果。
//- 第三天，你吃掉一个第二天长出来的苹果。过了这一天，第三天长出来的苹果就已经腐烂了。
//- 第四天到第七天，你吃的都是第四天长出来的苹果。
// 
//
// 示例 2： 
//
// 输入：apples = [3,0,0,0,0,2], days = [3,0,0,0,0,2]
//输出：5
//解释：你可以吃掉 5 个苹果：
//- 第一天到第三天，你吃的都是第一天长出来的苹果。
//- 第四天和第五天不吃苹果。
//- 第六天和第七天，你吃的都是第六天长出来的苹果。
// 
//
// 
//
// 提示： 
//
// 
// apples.length == n 
// days.length == n 
// 1 <= n <= 2 * 10⁴ 
// 0 <= apples[i], days[i] <= 2 * 10⁴ 
// 只有在 apples[i] = 0 时，days[i] = 0 才成立 
// 
// Related Topics 贪心 数组 堆（优先队列） 👍 70 👎 0


package com.wjp.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class MaximumNumberOfEatenApples {
    public static void main(String[] args) {
        Solution solution = new MaximumNumberOfEatenApples().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int eatenApples(int[] apples, int[] days) {
            // 每次我们都吃保质期最短的苹果
            // 如何保存唯一保质期排序的呢？
            // 由于我们可能还要更新当前保质期的苹果的个数
            int day = 0;
            int n = apples.length;
            int res = 0;
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

            while (day < n) {
                // 处理过期的
                while (!pq.isEmpty() && pq.peek()[0] <= day) {
                    pq.poll();
                }
                // 添加当日的苹果
                int rottenDay = day + days[day];
                int apple = apples[day];
                if (apple > 0) {
                    // 我们不合并同一天过期的苹果
                    pq.offer(new int[]{rottenDay, apple});
                }
                if (!pq.isEmpty()) {
                    int[] cur = pq.peek();
                    cur[1]--;
                    if (cur[1] == 0) {
                        pq.poll();
                    }
                    res++;
                }
                // 日子一天天过去
                day++;
            }
            while (!pq.isEmpty()) {
                while (!pq.isEmpty() && pq.peek()[0] <= day) {
                    pq.poll();
                }
                if (pq.isEmpty()) {
                    break;
                }
                int[] cur = pq.poll();
                // 对于最近过期的苹果堆，有多少个？
                // 能留到第几天吃
                int canEat = Math.min(cur[0] - day, cur[1]);
                day += canEat;
                res += canEat;
            }
            return res;
        }
    }
//    class Solution {
//        public int eatenApples(int[] apples, int[] days) {
//            // 每次我们都吃保质期最段的苹果
//            // 如何保存唯一保质期排序的呢？
//            // 由于我们可能还要更新当前保质期的苹果的个数
//            Map<Integer, Integer> map = new HashMap<>();
//            int day = 0;
//            int n = apples.length;
//            int res = 0;
//            while (true) {
//                // 昨天成为今天，所有的保质期都要减1
//                Map<Integer, Integer> newMap = new HashMap<>();
//                for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//                    if (entry.getKey() > 1) { // 只保留大于1天的
//                        newMap.put(entry.getKey() - 1, entry.getValue());
//                    }
//                }
//                if (day >= n && newMap.isEmpty()) {
//                    break;
//                }
//                // 添加今日的苹果
//                if (day < n && apples[day] != 0) {
//                    newMap.put(days[day], newMap.getOrDefault(days[day], 0) + apples[day]);
//                }
//                map = newMap;
//
////                System.out.println("day " + day + ": " + String.join(",", map.entrySet().stream().map(entry -> entry.getKey() + ":" + entry.getValue()).collect(Collectors.toList())));
//
//                // 吃掉保质期最短的苹果
//                int eat = Integer.MAX_VALUE;
//                for (int key : map.keySet()) {
//                    eat = Math.min(eat, key);
//                }
//                // 找到可以吃的苹果
//                if (eat != Integer.MAX_VALUE) {
//                    // 只有一个则吃掉
//                    if (map.get(eat) == 1) {
//                        map.remove(eat);
//                    }else{
//                        map.put(eat, map.get(eat) - 1);
//                    }
//                    res++;
//                }
//                // 日子一天天过去
//                day++;
//
//            }
//            return res;
//        }
//    }
//leetcode submit region end(Prohibit modification and deletion)

}