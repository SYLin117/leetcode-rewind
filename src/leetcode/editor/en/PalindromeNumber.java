// [9]
/**
 * Given an integer x, return true if x is palindrome integer.
 * <p>
 * An integer is a palindrome when it reads the same backward as forward.
 * <p>
 * <p>
 * For example, 121 is a palindrome while 123 is not.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: x = 121
 * Output: true
 * Explanation: 121 reads as 121 from left to right and from right to left.
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: x = -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 1
 * 21-. Therefore it is not a palindrome.
 * <p>
 * <p>
 * Example 3:
 * <p>
 * <p>
 * Input: x = 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * -2³¹ <= x <= 2³¹ - 1
 * <p>
 * <p>
 * <p>
 * Follow up: Could you solve it without converting the integer to a string?
 * <p>
 * Related Topics Math 👍 6957 👎 2271
 */

package leetcode.editor.en;

import java.util.Stack;

public class PalindromeNumber {
    public static void main(String[] args) {
        Solution solution = new PalindromeNumber().new Solution();
        int x = 12321;
        System.out.println(solution.isPalindrome(x));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPalindrome(int x) {
//            if (x < 0) return false;
//            int digit = (x % 10 == 0) ? (int) (Math.log10(x) + 1) : (int) (Math.ceil(Math.log10(x)));
//            boolean isOdd = digit % 2 != 0;
//            int mid = isOdd ? digit / 2 + 1 : digit / 2;
//
//            Stack<Integer> stack = new Stack<>();
//
//            int index = 1;
//            while (index <= digit) {
//                if (index <= mid) {
//                    if (!(isOdd && index == mid))
//                        stack.push(x % 10);
//                } else {
//                    if (x % 10 != stack.pop()) return false;
//                }
//                index++;
//                x /= 10;
//            }
//            return true;


            //special case
            if (x < 0 || (x % 10 == 0 && x != 0)) return false;

            int revertNumber = 0;
            while (x > revertNumber) {
                revertNumber = revertNumber * 10 + x % 10;
                x /= 10;
            }

            // When the length is an odd number, we can get rid of the middle digit by revertedNumber/10
            // For example when the input is 12321, at the end of the while loop we get x = 12, revertedNumber = 123,
            // since the middle digit doesn't matter in palidrome(it will always equal to itself), we can simply get rid of it.
            return (x == revertNumber) || (x == revertNumber / 10); // even or odd
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
