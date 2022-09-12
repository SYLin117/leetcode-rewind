// [5]
//Given a string s, return the longest palindromic substring in s. 
//
// 
// Example 1: 
//
// 
//Input: s = "babad"
//Output: "bab"
//Explanation: "aba" is also a valid answer.
// 
//
// Example 2: 
//
// 
//Input: s = "cbbd"
//Output: "bb"
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 1000 
// s consist of only digits and English letters. 
// 
//
// Related Topics String Dynamic Programming 👍 21249 👎 1226


package leetcode.editor.en;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubstring().new Solution();
        System.out.println(solution.longestPalindrome("ccababa"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution { // DP
        public String longestPalindrome(String s) {
            String res = new String("");
            int resLen = 0;

            int cnt = 0;
            int sLen = s.length();
            for (int i = 0; i < s.length(); i++) {
                int l = i, r = i;
                while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                    if (r - l + 1 > resLen) {
                        resLen = r - l + 1;
                        res = s.substring(l, r + 1);
                    }
                    l -= 1;
                    r += 1;
                }

                l = i;
                r = i + 1;
                while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                    if (r - l + 1 > resLen) {
                        resLen = r - l + 1;
                        res = s.substring(l, r + 1);
                    }
                    l -= 1;
                    r += 1;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}