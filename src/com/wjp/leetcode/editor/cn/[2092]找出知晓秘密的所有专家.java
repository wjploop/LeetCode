//给你一个整数 n ，表示有 n 个专家从 0 到 n - 1 编号。另外给你一个下标从 0 开始的二维整数数组 meetings ，其中 meetings[
//i] = [xi, yi, timei] 表示专家 xi 和专家 yi 在时间 timei 要开一场会。一个专家可以同时参加 多场会议 。最后，给你一个整数 
//firstPerson 。 
//
// 专家 0 有一个 秘密 ，最初，他在时间 0 将这个秘密分享给了专家 firstPerson 。接着，这个秘密会在每次有知晓这个秘密的专家参加会议时进行传
//播。更正式的表达是，每次会议，如果专家 xi 在时间 timei 时知晓这个秘密，那么他将会与专家 yi 分享这个秘密，反之亦然。 
//
// 秘密共享是 瞬时发生 的。也就是说，在同一时间，一个专家不光可以接收到秘密，还能在其他会议上与其他专家分享。 
//
// 在所有会议都结束之后，返回所有知晓这个秘密的专家列表。你可以按 任何顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 6, meetings = [[1,2,5],[2,3,8],[1,5,10]], firstPerson = 1
//输出：[0,1,2,3,5]
//解释：
//时间 0 ，专家 0 将秘密与专家 1 共享。
//时间 5 ，专家 1 将秘密与专家 2 共享。
//时间 8 ，专家 2 将秘密与专家 3 共享。
//时间 10 ，专家 1 将秘密与专家 5 共享。
//因此，在所有会议结束后，专家 0、1、2、3 和 5 都将知晓这个秘密。
// 
//
// 示例 2： 
//
// 
//输入：n = 4, meetings = [[3,1,3],[1,2,2],[0,3,3]], firstPerson = 3
//输出：[0,1,3]
//解释：
//时间 0 ，专家 0 将秘密与专家 3 共享。
//时间 2 ，专家 1 与专家 2 都不知晓这个秘密。
//时间 3 ，专家 3 将秘密与专家 0 和专家 1 共享。
//因此，在所有会议结束后，专家 0、1 和 3 都将知晓这个秘密。
// 
//
// 示例 3： 
//
// 
//输入：n = 5, meetings = [[3,4,2],[1,2,1],[2,3,1]], firstPerson = 1
//输出：[0,1,2,3,4]
//解释：
//时间 0 ，专家 0 将秘密与专家 1 共享。
//时间 1 ，专家 1 将秘密与专家 2 共享，专家 2 将秘密与专家 3 共享。
//注意，专家 2 可以在收到秘密的同一时间分享此秘密。
//时间 2 ，专家 3 将秘密与专家 4 共享。
//因此，在所有会议结束后，专家 0、1、2、3 和 4 都将知晓这个秘密。 
//
// 示例 4： 
//
// 
//输入：n = 6, meetings = [[0,2,1],[1,3,1],[4,5,1]], firstPerson = 1
//输出：[0,1,2,3]
//解释：
//时间 0 ，专家 0 将秘密与专家 1 共享。
//时间 1 ，专家 0 将秘密与专家 2 共享，专家 1 将秘密与专家 3 共享。
//因此，在所有会议结束后，专家 0、1、2 和 3 都将知晓这个秘密。
// 
//
// 
//
// 提示： 
//
// 
// 2 <= n <= 10⁵ 
// 1 <= meetings.length <= 10⁵ 
// meetings[i].length == 3 
// 0 <= xi, yi <= n - 1 
// xi != yi 
// 1 <= timei <= 10⁵ 
// 1 <= firstPerson <= n - 1 
// 
// 👍 16 👎 0


package com.wjp.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

class FindAllPeopleWithSecret{
    public static void main(String[] args) {
        Solution solution = new FindAllPeopleWithSecret().new Solution();
        }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
            ArrayList<int[]>[] lists = new ArrayList[n];
            for (int i = 0; i < n; i++) {
                lists[i] = new ArrayList<>();
            }
            for (int[] meeting : meetings) {
                lists[meeting[0]].add(new int[] { meeting[1], meeting[2] });
                lists[meeting[1]].add(new int[] { meeting[0], meeting[2] });
            }
            ArrayList<Integer> list = new ArrayList<>();
            PriorityQueue<int[]> queue = new PriorityQueue<>((o, p) -> o[1] - p[1]);
            for (queue.addAll(Set.of(new int[2], new int[] { firstPerson, 0 })); !queue.isEmpty();) {
                int[] poll = queue.poll();
                int a = poll[0];
                int t = poll[1];
                // 下一次会议的成员
                // 知道会议的成员有队列中　element[0]，即ａ
                // 对于该成员，与其联系的人员有 list[a]
                if (lists[a] != null) {
                    //　该成员在 t　时间获取密码
                    list.add(a);
                    // 对于 a 对应的联系人，若是其知道密码的世界时间 大于 t，
                    // 说明该会议是在 a 获知密码后开的，则该联系人最后必定知道密码
                    // 这里，不是直接加入密码，因为该人获知秘密的时间后可能还会通知其他人
                    // 而且，我们是按时间遍历将获知密码对应的联系人遍历的

                    for (int[] pair : lists[a]) {
                        if (pair[1] >= t) {
                            queue.offer(pair);
                        }
                    }
                    // 由 a　能通知到的人我们已经放入到队列了
                    // 换句话说，由a为入口的点我们已经处理了
                    // 下次　由 b > a 时，我们就不能考虑了
                    lists[a] = null;
                }
            }
            return list;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}