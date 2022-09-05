/**
 * A string can be abbreviated by replacing any number of non-adjacent, non-empty
 * substrings with their lengths. The lengths should not have leading zeros.
 * <p>
 * For example, a string such as "substitution" could be abbreviated as (but not
 * limited to):
 * <p>
 * <p>
 * "s10n" ("s ubstitutio n")
 * "sub4u4" ("sub stit u tion")
 * "12" ("substitution")
 * "su3i1u2on" ("su bst i t u ti on")
 * "substitution" (no substrings replaced)
 * <p>
 * <p>
 * The following are not valid abbreviations:
 * <p>
 * <p>
 * "s55n" ("s ubsti tutio n", the replaced substrings are adjacent)
 * "s010n" (has leading zeros)
 * "s0ubstitution" (replaces an empty substring)
 * <p>
 * <p>
 * Given a string word and an abbreviation abbr, return whether the string
 * matches the given abbreviation.
 * <p>
 * A substring is a contiguous non-empty sequence of characters within a string.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: word = "internationalization", abbr = "i12iz4n"
 * Output: true
 * Explanation: The word "internationalization" can be abbreviated as "i12iz4n" (
 * "i nternational iz atio n").
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: word = "apple", abbr = "a2e"
 * Output: false
 * Explanation: The word "apple" cannot be abbreviated as "a2e".
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * 1 <= word.length <= 20
 * word consists of only lowercase English letters.
 * 1 <= abbr.length <= 10
 * abbr consists of lowercase English letters and digits.
 * All the integers in abbr will fit in a 32-bit integer.
 * <p>
 * <p>
 * Related Topics Two Pointers String 👍 519 👎 1793
 */

package leetcode.editor.en;

public class ValidWordAbbreviation {
    public static void main(String[] args) {
        Solution solution = new ValidWordAbbreviation().new Solution();
        String word = "internationalization";
        String abbr = "i5a11o1";
        System.out.println(solution.validWordAbbreviation(word, abbr));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean validWordAbbreviation(String word, String abbr) {
            int wordIdx = 0, abbrIdx = 0;
            boolean numStart = false;
            int start = 0;
            while (abbrIdx < abbr.length()) {
                if (!((abbr.charAt(abbrIdx) >= 'A' && abbr.charAt(abbrIdx) <= 'Z') ||
                        (abbr.charAt(abbrIdx) >= 'a' && abbr.charAt(abbrIdx) <= 'z'))) {
                    if (!numStart) {
                        numStart = true;
                        start = abbrIdx;
                    }
                    abbrIdx++;
                    continue;
                } else {
                    if (numStart) {
                        String nStr = abbr.substring(start, abbrIdx);
                        numStart = false;
                        if (!check(word, start, nStr)) return false;
                        wordIdx += Integer.parseInt(nStr);
                        continue;
                    }
                }
                if (wordIdx >= word.length() || (abbr.charAt(abbrIdx) != word.charAt(wordIdx))) {
                    return false;
                } else {
                    wordIdx++;
                    abbrIdx++;
                }

            }
            if (numStart) {
                String nStr = abbr.substring(start);
                numStart = false;
                if (!check(word, start, nStr)) return false;
                wordIdx += Integer.parseInt(nStr);
            }
            if (wordIdx != word.length() || abbrIdx != abbr.length()) return false;
            return true;
        }

        private boolean check(String s, int start, String nStr) {
            if (nStr.charAt(0) == '0') return false;
            int n = Integer.parseInt(nStr);
            if (start + n > s.length()) return false;
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}