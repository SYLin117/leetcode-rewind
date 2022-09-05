// [217]
/**
 * Given an integer array nums, return true if any value appears at least twice in
 * the array, and return false if every element is distinct.
 * <p>
 * <p>
 * Example 1:
 * Input: nums = [1,2,3,1]
 * Output: true
 * <p>
 * Example 2:
 * Input: nums = [1,2,3,4]
 * Output: false
 * <p>
 * Example 3:
 * Input: nums = [1,1,1,3,3,4,3,2,4,2]
 * Output: true
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * 1 <= nums.length <= 10⁵
 * -10⁹ <= nums[i] <= 10⁹
 * <p>
 * <p>
 * Related Topics Array Hash Table Sorting 👍 6340 👎 1018
 */

package leetcode.editor.en;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public static void main(String[] args) {
        Solution solution = new ContainsDuplicate().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean containsDuplicate(int[] nums) {
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < nums.length; i++) {
                if (set.contains(nums[i])) return true;
                else set.add(nums[i]);
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}