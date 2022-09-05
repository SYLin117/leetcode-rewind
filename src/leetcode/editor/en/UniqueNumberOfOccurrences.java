// [1207]
/**
 * Given an array of integers arr, return true if the number of occurrences of
 * each value in the array is unique, or false otherwise.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: arr = [1,2,2,1,1,3]
 * Output: true
 * Explanation: The value 1 has 3 occurrences, 2 has 2 and 3 has 1. No two values
 * have the same number of occurrences.
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: arr = [1,2]
 * Output: false
 * <p>
 * <p>
 * Example 3:
 * <p>
 * <p>
 * Input: arr = [-3,0,1,-3,1,1,1,-3,10,0]
 * Output: true
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * 1 <= arr.length <= 1000
 * -1000 <= arr[i] <= 1000
 * <p>
 * <p>
 * Related Topics Array Hash Table 👍 1856 👎 45
 */

package leetcode.editor.en;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueNumberOfOccurrences {
    public static void main(String[] args) {
        Solution solution = new UniqueNumberOfOccurrences().new Solution();
        System.out.println(solution.uniqueOccurrences(new int[]{1, 2, 2, 1, 1, 3}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean uniqueOccurrences(int[] arr) {
            // HashMap
//            Map<Integer, Integer> map = new HashMap<>();
//            for (int num : arr) {
//                if (map.containsKey(num)) {
//                    map.put(num, map.get(num) + 1);
//                } else {
//                    map.put(num, 1);
//                }
//            }
//            Set<Integer> set = new HashSet<>();
//            for (int cnt : map.values()) {
//                if (set.contains(cnt)) return false;
//                else set.add(cnt);
//            }
//            return true;

            int currentVal = 0;
            int[] anArr = new int[arr.length];
            for (int i = 0; i < arr.length; i++) {
                int counter = 0;
                if (arr[i] != -1001) {
                    currentVal = arr[i];
                } else { // this number already count
                    continue;
                }
                for (int j = i + 1; j < arr.length; j++) { // because i is arr[i] first appear, start from i+1
                    if (arr[i] == arr[j]) {
                        counter++;
                    }
                }
                if (anArr[counter] == -1) { // encounter same count
                    return false;
                }
                anArr[counter] = -1; // mark this count
                for (int k = 0; k < arr.length; k++) {
                    if (arr[k] == currentVal) {
                        arr[k] = -1001; // mark this number
                    }
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}