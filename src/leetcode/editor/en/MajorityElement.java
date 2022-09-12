// [169]
//Given an array nums of size n, return the majority element. 
//
// The majority element is the element that appears more than ⌊n / 2⌋ times. 
//You may assume that the majority element always exists in the array. 
//
// 
// Example 1: 
// Input: nums = [3,2,3]
//Output: 3
// 
// Example 2: 
// Input: nums = [2,2,1,1,1,2,2]
//Output: 2
// 
// 
// Constraints: 
//
// 
// n == nums.length 
// 1 <= n <= 5 * 10⁴ 
// -10⁹ <= nums[i] <= 10⁹ 
// 
//
// 
//Follow-up: Could you solve the problem in linear time and in 
//O(1) space?
//
// Related Topics Array Hash Table Divide and Conquer Sorting Counting 👍 11778 
//👎 378


package leetcode.editor.en;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public static void main(String[] args) {
        Solution solution = new MajorityElement().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int majorityElement(int[] nums) {
            // HashMap
//            int maj = nums.length / 2;
//            Map<Integer, Integer> cnt = new HashMap<>();
//            for (int i = 0; i < nums.length; i++) {
//                cnt.put(nums[i], cnt.getOrDefault(nums[i], 0) + 1);
//                if (cnt.get(nums[i]) > maj) return nums[i];
//            }
//            return -1;

            //使用Sort
            // 題目假設一定有解，因此中間的值必為解答
            Arrays.sort(nums);
            return nums[nums.length / 2];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}