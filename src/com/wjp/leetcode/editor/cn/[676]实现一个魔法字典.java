//设计一个使用单词列表进行初始化的数据结构，单词列表中的单词 互不相同 。 如果给出一个单词，请判定能否只将这个单词中一个字母换成另一个字母，使得所形成的新单
//词存在于你构建的字典中。 
//
// 实现 MagicDictionary 类： 
//
// 
// MagicDictionary() 初始化对象 
// void buildDict(String[] dictionary) 使用字符串数组 dictionary 设定该数据结构，dictionary 中的字
//符串互不相同 
// bool search(String searchWord) 给定一个字符串 searchWord ，判定能否只将字符串中 一个 字母换成另一个字母，使得
//所形成的新字符串能够与字典中的任一字符串匹配。如果可以，返回 true ；否则，返回 false 。 
// 
//
// 
//
// 
// 
// 
// 示例： 
//
// 
//输入
//["MagicDictionary", "buildDict", "search", "search", "search", "search"]
//[[], [["hello", "leetcode"]], ["hello"], ["hhllo"], ["hell"], ["leetcoded"]]
//输出
//[null, null, false, true, false, false]
//
//解释
//MagicDictionary magicDictionary = new MagicDictionary();
//magicDictionary.buildDict(["hello", "leetcode"]);
//magicDictionary.search("hello"); // 返回 False
//magicDictionary.search("hhllo"); // 将第二个 'h' 替换为 'e' 可以匹配 "hello" ，所以返回 True
//magicDictionary.search("hell"); // 返回 False
//magicDictionary.search("leetcoded"); // 返回 False
// 
//
// 
//
// 提示： 
//
// 
// 1 <= dictionary.length <= 100 
// 1 <= dictionary[i].length <= 100 
// dictionary[i] 仅由小写英文字母组成 
// dictionary 中的所有字符串 互不相同 
// 1 <= searchWord.length <= 100 
// searchWord 仅由小写英文字母组成 
// buildDict 仅在 search 之前调用一次 
// 最多调用 100 次 search 
// 
// 
// 
// 
// Related Topics 设计 字典树 哈希表 字符串 👍 148 👎 0


package com.wjp.leetcode.editor.cn;

import com.wjp.problems.collection.Solution;

import java.util.HashMap;
import java.util.Map;

class ImplementMagicDictionary {
    //leetcode submit region begin(Prohibit modification and deletion)
    class MagicDictionary {

        // 构建前缀树？
        // 搜索时，给一次机会替换
        // dfs
        class Node {
            Map<Character, Node> children;

            public Node() {
                this.children = new HashMap<>();
            }
        }

        Node tree;

        public MagicDictionary() {
            tree = new Node();
        }

        String[] dic;

        public void buildDict(String[] dictionary) {
            this.dic = dictionary;

        }

        public boolean search(String searchWord) {
            for (String w : dic) {
                if (w.length() != searchWord.length()) {
                    continue;
                }
                int diff = 0;
                for (int i = 0; i < w.length(); i++) {
                    if (w.charAt(i) != searchWord.charAt(i)) {
                        diff++;
                    }
                    if (diff > 1) {
                        break;
                    }
                }
                if (diff == 1) {
                    return true;
                }
            }
            return false;
        }

        private boolean search(String searchWord, int i, Node cur, int change) {

            // 每次dfs,
            if (change == -1) {
                return false;
            }
            if (i == searchWord.length()) {
                if (cur.children.containsKey('#') && change == 0) {
                    return true;
                }
                return false;
            }
            for (Map.Entry<Character, Node> entry : cur.children.entrySet()) {
                boolean res = false;
                if (entry.getKey() == searchWord.charAt(i)) {
                    res = search(searchWord, i + 1, entry.getValue(), change);
                } else {
                    res = search(searchWord, i + 1, entry.getValue(), change - 1);
                }
                if (res) {
                    return true;
                }
            }
            return false;
        }
    }

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */
//leetcode submit region end(Prohibit modification and deletion)

}