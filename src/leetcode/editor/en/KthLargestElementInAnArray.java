// [215]
//Given an integer array nums and an integer k, return the kᵗʰ largest element 
//in the array. 
//
// Note that it is the kᵗʰ largest element in the sorted order, not the kᵗʰ 
//distinct element. 
//
// You must solve it in O(n) time complexity. 
//
// 
// Example 1: 
// Input: nums = [3,2,1,5,6,4], k = 2
//Output: 5
// 
// Example 2: 
// Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
//Output: 4
// 
// 
// Constraints: 
//
// 
// 1 <= k <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// Related Topics Array Divide and Conquer Sorting Heap (Priority Queue) 
//Quickselect 👍 11743 👎 594


package leetcode.editor.en;

import com.apple.concurrent.Dispatch;

import java.util.PriorityQueue;

public class KthLargestElementInAnArray {
    public static void main(String[] args) {
        Solution solution = new KthLargestElementInAnArray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            // PriorityQueue預設是小到大
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
            // 保持裡面只有k的數，超過就移除最小的數
            for (int i = 0; i < nums.length; i++) {
                priorityQueue.add(nums[i]);
                if (priorityQueue.size() > k) priorityQueue.poll();
            }
            // 最後queue中最小的數極為第k大的數
            return priorityQueue.poll();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}