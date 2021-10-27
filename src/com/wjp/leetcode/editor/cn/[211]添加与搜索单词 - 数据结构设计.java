//请你设计一个数据结构，支持 添加新单词 和 查找字符串是否与任何先前添加的字符串匹配 。 
//
// 实现词典类 WordDictionary ： 
//
// 
// WordDictionary() 初始化词典对象 
// void addWord(word) 将 word 添加到数据结构中，之后可以对它进行匹配 
// bool search(word) 如果数据结构中存在字符串与 word 匹配，则返回 true ；否则，返回 false 。word 中可能包含一些 
//'.' ，每个 . 都可以表示任何一个字母。 
// 
//
// 
//
// 示例： 
//
// 
//输入：
//["WordDictionary","addWord","addWord","addWord","search","search","search",
//"search"]
//[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
//输出：
//[null,null,null,null,false,true,true,true]
//
//解释：
//WordDictionary wordDictionary = new WordDictionary();
//wordDictionary.addWord("bad");
//wordDictionary.addWord("dad");
//wordDictionary.addWord("mad");
//wordDictionary.search("pad"); // return False
//wordDictionary.search("bad"); // return True
//wordDictionary.search(".ad"); // return True
//wordDictionary.search("b.."); // return True
// 
//
// 
//
// 提示： 
//
// 
// 1 <= word.length <= 500 
// addWord 中的 word 由小写英文字母组成 
// search 中的 word 由 '.' 或小写英文字母组成 
// 最多调用 50000 次 addWord 和 search 
// 
// Related Topics 深度优先搜索 设计 字典树 字符串 👍 274 👎 0


package com.wjp.leetcode.editor.cn;

class DesignAddAndSearchWordsDataStructure {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class WordDictionary {

        Node trie;

        /**
         * Initialize your data structure here.
         */
        public WordDictionary() {
            trie = new Node();
        }

        public void addWord(String word) {
            trie.addWord(word);
        }

        public boolean search(String word) {
            return trie.searchNode(word, 0, trie);
        }

        class Node {
            Node[] chidren;
            boolean isEnd = false;

            public Node() {
                this.chidren = new Node[26];
            }

            void addWord(String word) {
                Node node = this;
                for (int i = 0; i < word.length(); i++) {
                    int k = word.charAt(i) - 'a';
                    if (node.chidren[k] == null) {
                        node.chidren[k] = new Node();
                    }
                    node = node.chidren[k];
                }
                node.isEnd = true;
            }


            boolean searchNode(String word, int i, Node from) {
                if (i == word.length()) {
                    return from != null && from.isEnd;
                }
                char ch = word.charAt(i);
                if (ch == '.') {
                    for (Node node : from.chidren) {
                        if (node != null) {
                            if (searchNode(word, i + 1, node)) {
                                return true;
                            }
                        }
                    }
                } else {
                    int k = ch - 'a';
                    if (from.chidren[k] == null) {
                        return false;
                    }
                    return searchNode(word, i + 1, from.chidren[k]);
                }
                return false;
            }
        }

    }


/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
//leetcode submit region end(Prohibit modification and deletion)

}
