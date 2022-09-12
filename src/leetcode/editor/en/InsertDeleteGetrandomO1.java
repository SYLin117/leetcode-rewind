// [380]
//Implement the RandomizedSet class: 
//
// 
// RandomizedSet() Initializes the RandomizedSet object. 
// bool insert(int val) Inserts an item val into the set if not present. 
//Returns true if the item was not present, false otherwise. 
// bool remove(int val) Removes an item val from the set if present. Returns 
//true if the item was present, false otherwise. 
// int getRandom() Returns a random element from the current set of elements (
//it's guaranteed that at least one element exists when this method is called). 
//Each element must have the same probability of being returned. 
// 
//
// You must implement the functions of the class such that each function works 
//in average O(1) time complexity. 
//
// 
// Example 1: 
//
// 
//Input
//["RandomizedSet", "insert", "remove", "insert", "getRandom", "remove", 
//"insert", "getRandom"]
//[[], [1], [2], [2], [], [1], [2], []]
//Output
//[null, true, false, true, 2, true, false, 2]
//
//Explanation
//RandomizedSet randomizedSet = new RandomizedSet();
//randomizedSet.insert(1); // Inserts 1 to the set. Returns true as 1 was 
//inserted successfully.
//randomizedSet.remove(2); // Returns false as 2 does not exist in the set.
//randomizedSet.insert(2); // Inserts 2 to the set, returns true. Set now 
//contains [1,2].
//randomizedSet.getRandom(); // getRandom() should return either 1 or 2 
//randomly.
//randomizedSet.remove(1); // Removes 1 from the set, returns true. Set now 
//contains [2].
//randomizedSet.insert(2); // 2 was already in the set, so return false.
//randomizedSet.getRandom(); // Since 2 is the only number in the set, 
//getRandom() will always return 2.
// 
//
// 
// Constraints: 
//
// 
// -2³¹ <= val <= 2³¹ - 1 
// At most 2 * 10⁵ calls will be made to insert, remove, and getRandom. 
// There will be at least one element in the data structure when getRandom is 
//called. 
// 
//
// Related Topics Array Hash Table Math Design Randomized 👍 5979 👎 316


package leetcode.editor.en;

import java.util.*;

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
public class InsertDeleteGetrandomO1 {
    public static void main(String[] args) {
        RandomizedSet solution = new InsertDeleteGetrandomO1().new RandomizedSet();
        solution.insert(0);
        solution.insert(1);
        solution.remove(0);
        solution.insert(2);
        solution.remove(1);
        solution.getRandom();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class RandomizedSet {

        List<Integer> list;
        Map<Integer, Integer> dict;
        Random rand = new Random();

        public RandomizedSet() {
            list = new ArrayList<>();
            dict = new HashMap<>();
        }

        public boolean insert(int val) {
            if (dict.containsKey(val)) {
                return false;
            }
            dict.put(val, list.size());
            list.add(list.size(), val);
            return true;
        }

        public boolean remove(int val) {
            if (!dict.containsKey(val)) return false;
            int lastElement = list.get(list.size() - 1);
            int removeIdx = dict.get(val);
            list.set(removeIdx, lastElement); // 用lastElement覆蓋要刪除了val
            dict.put(lastElement, removeIdx);
            list.remove(list.size() - 1);
            dict.remove(val);
            return true;
        }

        public int getRandom() {
            return list.get(rand.nextInt(list.size()));
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}