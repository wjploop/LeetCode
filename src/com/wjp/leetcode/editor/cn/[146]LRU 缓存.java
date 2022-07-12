//请你设计并实现一个满足 LRU (最近最少使用) 缓存 约束的数据结构。 
//
// 实现 LRUCache 类： 
//
// 
// 
// 
// LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存 
// int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。 
// void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 
//key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。 
// 
//
// 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。 
// 
// 
//
// 
//
// 示例： 
//
// 
//输入
//["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
//输出
//[null, null, null, 1, null, -1, null, -1, 3, 4]
//
//解释
//LRUCache lRUCache = new LRUCache(2);
//lRUCache.put(1, 1); // 缓存是 {1=1}
//lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
//lRUCache.get(1);    // 返回 1
//lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
//lRUCache.get(2);    // 返回 -1 (未找到)
//lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
//lRUCache.get(1);    // 返回 -1 (未找到)
//lRUCache.get(3);    // 返回 3
//lRUCache.get(4);    // 返回 4
// 
//
// 
//
// 提示： 
//
// 
// 1 <= capacity <= 3000 
// 0 <= key <= 10000 
// 0 <= value <= 10⁵ 
// 最多调用 2 * 10⁵ 次 get 和 put 
// 
// Related Topics 设计 哈希表 链表 双向链表 👍 1846 👎 0


package com.wjp.leetcode.editor.cn;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

class LruCache {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Node {
        int key;
        int val;
        Node prev;
        Node next;
    }

    /**
     * LRU 最近使用原则
     * 固定一个大小，超出大小后，移除最旧的元素
     *
     * 按照新旧，最左到右放置，
     * 添加元素 a，
     *      若是缓存已存在要添加的元素a，找出该元素，更新新的值，移动到队头
     *      若没有，且超出缓存大小，则先删除最右的元素，再添加新元素到队头
     * 存在一个问题，查找一个元素是否存在，若是放在一个数组中，需要 O(N)
     * 我们可以使用hash表来解决是否存在，O（1）
     * 而删除队列中的一个元素，时间复杂度也要O(N)，但若是我们已经定位到该元素，且用链表保存，那么可以O(1)复杂度删除
     * 这样，我们就可以构造一个链表，因为我可能会在队尾删除，所以直接构造双向链表
     *
     */
    class LRUCache {

        // 删除一个元素
        // 访问之后将其放到队头
        // 若是其大小超出我们的预定的大小，则删除最后面的一个元素

        Node head, tail;
        Map<Integer, Node> map;
        int capacity;

        // 维护一个
        public LRUCache(int capacity) {
            this.capacity = capacity;
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.prev = head;
            map = new HashMap<>();
        }

        public int get(int key) {
            if (!map.containsKey(key)) {
                return -1;
            }
            // 将该元素移到队头
            Node node = map.get(key);
            remove(node);
            insertToHead(node);
            return node.val;
        }

        private void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        private void insertToHead(Node node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
        }

        public void put(int key, int value) {
            Node node = map.getOrDefault(key, null);
            if (node != null) {
                node.val = value;
                remove(node);
            } else {
                if (map.size() == capacity) {
//                    System.out.println("remove " + tail.prev.key);
                    map.remove(tail.prev.key);
                    remove(tail.prev);
                }
                node = new Node();
                node.key = key;
                node.val = value;
                map.put(key, node);
            }
            insertToHead(node);
//            System.out.println(String.join(",", map.values().stream().map(o -> o.val + "").collect(Collectors.toList())));
        }


    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)

}