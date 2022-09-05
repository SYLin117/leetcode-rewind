/**
 * Given a string s, return true if the s can be palindrome after deleting at most
 * one character from it.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: s = "aba"
 * Output: true
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: s = "abca"
 * Output: true
 * Explanation: You could delete the character 'c'.
 * <p>
 * <p>
 * Example 3:
 * <p>
 * <p>
 * Input: s = "abc"
 * Output: false
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * 1 <= s.length <= 10⁵
 * s consists of lowercase English letters.
 * <p>
 * <p>
 * Related Topics Two Pointers String Greedy 👍 6203 👎 321
 */

package leetcode.editor.en;

public class ValidPalindromeIi {
    public static void main(String[] args) {
        Solution solution = new ValidPalindromeIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean validPalindrome(String s) {
            int start = 0, end = s.length() - 1;
            char[] chars = s.toCharArray();
            boolean remove = false;
            while (start < end) {
                if (chars[start] != chars[end] && !remove) {
                    remove = true;
                    return check(chars, start + 1, end) || check(chars, start, end - 1);
                }
                start++;
                end--;
            }
            return true;
        }

        private boolean check(char[] chars, int start, int end) {
            while (start < end) {
                if (chars[start] != chars[end]) return false;
                start++;
                end--;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}