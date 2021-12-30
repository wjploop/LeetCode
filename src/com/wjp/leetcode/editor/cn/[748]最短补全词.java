//给你一个字符串 licensePlate 和一个字符串数组 words ，请你找出并返回 words 中的 最短补全词 。 
//
// 补全词 是一个包含 licensePlate 中所有的字母的单词。在所有补全词中，最短的那个就是 最短补全词 。 
//
// 在匹配 licensePlate 中的字母时： 
//
// 
// 忽略 licensePlate 中的 数字和空格 。 
// 不区分大小写。 
// 如果某个字母在 licensePlate 中出现不止一次，那么该字母在补全词中的出现次数应当一致或者更多。 
// 
//
// 例如：licensePlate = "aBc 12c"，那么它的补全词应当包含字母 'a'、'b' （忽略大写）和两个 'c' 。可能的 补全词 有
//"abccdef"、"caaacab" 以及 "cbca" 。 
//
// 请你找出并返回 words 中的 最短补全词 。题目数据保证一定存在一个最短补全词。当有多个单词都符合最短补全词的匹配条件时取 words 中 最靠前的 
//那个。 
//
// 
//
// 示例 1： 
//
// 
//输入：licensePlate = "1s3 PSt", words = ["step", "steps", "stripe", "stepple"]
//输出："steps"
//解释：最短补全词应该包括 "s"、"p"、"s"（忽略大小写） 以及 "t"。
//"step" 包含 "t"、"p"，但只包含一个 "s"，所以它不符合条件。
//"steps" 包含 "t"、"p" 和两个 "s"。
//"stripe" 缺一个 "s"。
//"stepple" 缺一个 "s"。
//因此，"steps" 是唯一一个包含所有字母的单词，也是本例的答案。 
//
// 示例 2： 
//
// 
//输入：licensePlate = "1s3 456", words = ["looks", "pest", "stew", "show"]
//输出："pest"
//解释：licensePlate 只包含字母 "s" 。所有的单词都包含字母 "s" ，其中 "pest"、"stew"、和 "show" 三者最短。答案是 
//"pest" ，因为它是三个单词中在 words 里最靠前的那个。
// 
//
// 示例 3： 
//
// 
//输入：licensePlate = "Ah71752", words = ["suggest","letter","of","husband",
//"easy","education","drug","prevent","writer","old"]
//输出："husband"
// 
//
// 示例 4： 
//
// 
//输入：licensePlate = "OgEu755", words = ["enough","these","play","wide","wonder",
//"box","arrive","money","tax","thus"]
//输出："enough"
// 
//
// 示例 5： 
//
// 
//输入：licensePlate = "iMSlpe4", words = ["claim","consumer","student","camera",
//"public","never","wonder","simple","thought","use"]
//输出："simple"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= licensePlate.length <= 7 
// licensePlate 由数字、大小写字母或空格 ' ' 组成 
// 1 <= words.length <= 1000 
// 1 <= words[i].length <= 15 
// words[i] 由小写英文字母组成 
// 
// Related Topics 数组 哈希表 字符串 👍 105 👎 0

  
package com.wjp.leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class ShortestCompletingWord{
    public static void main(String[] args) {
        Solution solution = new ShortestCompletingWord().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] count = new int[26];
        int len = 0;
        for (char c : licensePlate.toLowerCase().toCharArray()) {
            int index = c - 'a';
            if (index < 0 || index >= 26) {
                continue;
            }
            count[index]++;
            len++;
        }
        // 该词是否符合？
        // 符合后其长度大小？
        // 其出现时间
        // wordIndex, len
        // 长度短的有限，出现前的有限
//        PriorityQueue<int[]> qp = new PriorityQueue<>((o1, o2) -> o1[1] == o2[1] ? o1[0] - o2[1] : o2[1] - o1[1]);
//        System.out.println("len " + len);
        int wordIndex = -1;
        for (int i = 0; i < words.length; i++) {
            if (isCompleteWord(words[i], Arrays.copyOf(count,count.length), len)) {
                if (wordIndex == -1) {
                    wordIndex = i;
                }else{
                    if (words[i].length() < words[wordIndex].length()) {
                        wordIndex = i;
                    }
                }
            }
        }
        return words[wordIndex];
    }

    private boolean isCompleteWord(String word, int[] count, int len) {
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (count[index] > 0) {
                count[index] --;
                len--;
            }
        }
//        System.out.println("is completed " + word +"  "+ (len ));
        return len == 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}