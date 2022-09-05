// [1523]
/**
 * Given two non-negative integers low and high. Return the count of odd numbers
 * between low and high (inclusive).
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: low = 3, high = 7
 * Output: 3
 * Explanation: The odd numbers between 3 and 7 are [3,5,7].
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: low = 8, high = 10
 * Output: 1
 * Explanation: The odd numbers between 8 and 10 are [9].
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * 0 <= low <= high <= 10^9
 * <p>
 * <p>
 * Related Topics Math 👍 985 👎 73
 */

package leetcode.editor.en;

public class CountOddNumbersInAnIntervalRange {
    public static void main(String[] args) {
        Solution solution = new CountOddNumbersInAnIntervalRange().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countOdds(int low, int high) {
            boolean isLowOdd = low % 2 != 0;
            boolean isHighOdd = high % 2 != 0;
            int cnt;
            if (isLowOdd && isHighOdd) {
                cnt = (high - low) / 2 - 1;
            } else {
                cnt = (high - low) / 2;
            }
            if (isLowOdd) cnt++;
            if (isHighOdd) cnt++;
            return cnt;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}