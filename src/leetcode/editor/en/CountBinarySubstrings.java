// [696]
//Given a binary string s, return the number of non-empty substrings that have 
//the same number of 0's and 1's, and all the 0's and all the 1's in these 
//substrings are grouped consecutively. 
//
// Substrings that occur multiple times are counted the number of times they 
//occur. 
//
// 
// Example 1: 
//
// 
//Input: s = "00110011"
//Output: 6
//Explanation: There are 6 substrings that have equal number of consecutive 1's 
//and 0's: "0011", "01", "1100", "10", "0011", and "01".
//Notice that some of these substrings repeat and are counted the number of 
//times they occur.
//Also, "00110011" is not a valid substring because all the 0's (and 1's) are 
//not grouped together.
// 
//
// Example 2: 
//
// 
//Input: s = "10101"
//Output: 4
//Explanation: There are 4 substrings: "10", "01", "10", "01" that have equal 
//number of consecutive 1's and 0's.
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 10âµ 
// s[i] is either '0' or '1'. 
// 
//
// Related Topics Two Pointers String ð 3215 ð 699


package leetcode.editor.en;

public class CountBinarySubstrings {
    public static void main(String[] args) {
        Solution solution = new CountBinarySubstrings().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countBinarySubstrings(String s) {
            // ans: ç­æ¡æ¸, prev: åé¢çé£çºå­ç¬¦æ¸, cur:ç¶åçé£çºå­ç¬¦æ¸
            int ans = 0, prev = 0, cur = 1;
            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i - 1) != s.charAt(i)) {
                    ans += Math.min(prev, cur); // å çºprevècurè¦ç¸åæ¸éæå¯ä»¥æ»¿è¶³
                    prev = cur;
                    cur = 1;
                } else {
                    cur++;
                }
            }
            return ans + Math.min(prev, cur);// æå¾ççµåæ²ç®å°
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}