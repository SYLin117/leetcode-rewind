// [146]
//Design a data structure that follows the constraints of a Least Recently Used 
//(LRU) cache. 
//
// Implement the LRUCache class: 
//
// 
// LRUCache(int capacity) Initialize the LRU cache with positive size capacity. 
//
// int get(int key) Return the value of the key if the key exists, otherwise 
//return -1. 
// void put(int key, int value) Update the value of the key if the key exists. 
//Otherwise, add the key-value pair to the cache. If the number of keys exceeds 
//the capacity from this operation, evict the least recently used key. 
// 
//
// The functions get and put must each run in O(1) average time complexity. 
//
// 
// Example 1: 
//
// 
//Input
//["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
//Output
//[null, null, null, 1, null, -1, null, -1, 3, 4]
//
//Explanation
//LRUCache lRUCache = new LRUCache(2);
//lRUCache.put(1, 1); // cache is {1=1}
//lRUCache.put(2, 2); // cache is {1=1, 2=2}
//lRUCache.get(1);    // return 1
//lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
//lRUCache.get(2);    // returns -1 (not found)
//lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
//lRUCache.get(1);    // return -1 (not found)
//lRUCache.get(3);    // return 3
//lRUCache.get(4);    // return 4
// 
//
// 
// Constraints: 
//
// 
// 1 <= capacity <= 3000 
// 0 <= key <= 10⁴ 
// 0 <= value <= 10⁵ 
// At most 2 * 10⁵ calls will be made to get and put. 
// 
//
// Related Topics Hash Table Linked List Design Doubly-Linked List 👍 14969 👎 6
//05


package leetcode.editor.en;

import sun.awt.image.ImageWatched;

import java.util.*;

public class LruCache {
    public static void main(String[] args) {
        LRUCache solution = new LruCache().new LRUCache(2);
        solution.put(2, 1);
        solution.put(1, 2);
        solution.put(2, 3);
        solution.put(4, 1);
        assert solution.get(1) == -1;
        assert solution.get(2) == 3;
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class LRUCache {

        class LinkedNode {
            public int key;
            public int value;

            public LinkedNode(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        private List<LinkedNode> list;
        private Map<Integer, LinkedNode> map;

        private int size;

        private final int CACHE_SIZE;

        public LRUCache(int capacity) {
            list = new ArrayList<>();
            map = new HashMap<>();
            CACHE_SIZE = capacity;
        }

        public int get(int key) {
            if (map.getOrDefault(key, null) != null) {
                LinkedNode node = map.get(key);
                moveFront(node);
                return node.value;
            } else {
                return -1;
            }
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                LinkedNode node = map.get(key);
                node.value = value;
                moveFront(node);
            } else {
                LinkedNode newNode = new LinkedNode(key, value);
                map.put(key, newNode);
                if (list.isEmpty()) list.add(newNode);
                else list.add(0, newNode);
                if (list.size() > CACHE_SIZE) {
                    remove();
                }
            }
        }

        private void moveFront(LinkedNode node) {
            int index = list.indexOf(node);
            list.remove(index);
            if (list.isEmpty()) list.add(node);
            else list.add(0, node);
        }

        public void remove() {
            LinkedNode lastNode = list.get(list.size() - 1);
            list.remove(list.size() - 1);
            map.remove(lastNode.key);
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