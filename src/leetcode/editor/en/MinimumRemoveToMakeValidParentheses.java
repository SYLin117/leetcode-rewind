// [1249]
//Given a string s of '(' , ')' and lowercase English characters. 
//
// Your task is to remove the minimum number of parentheses ( '(' or ')', in 
//any positions ) so that the resulting parentheses string is valid and return any 
//valid string. 
//
// Formally, a parentheses string is valid if and only if: 
//
// 
// It is the empty string, contains only lowercase characters, or 
// It can be written as AB (A concatenated with B), where A and B are valid 
//strings, or 
// It can be written as (A), where A is a valid string. 
// 
//
// 
// Example 1: 
//
// 
//Input: s = "lee(t(c)o)de)"
//Output: "lee(t(c)o)de"
//Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.
// 
//
// Example 2: 
//
// 
//Input: s = "a)b(c)d"
//Output: "ab(c)d"
// 
//
// Example 3: 
//
// 
//Input: s = "))(("
//Output: ""
//Explanation: An empty string is also valid.
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 10⁵ 
// s[i] is either'(' , ')', or lowercase English letter. 
// 
//
// Related Topics String Stack 👍 5239 👎 97
package leetcode.editor.en;

import java.util.Stack;

public class MinimumRemoveToMakeValidParentheses {
    public static void main(String[] args) {
        Solution solution = new MinimumRemoveToMakeValidParentheses().new Solution();
        System.out.println(solution.minRemoveToMakeValid("))(("));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String minRemoveToMakeValid(String s) {
            StringBuilder sb = new StringBuilder(s);
            Stack<Integer> stack = new Stack<>();
            Stack<Integer> stack2 = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    stack.push(i);
                } else if (s.charAt(i) == ')') {
                    if (!stack.isEmpty()) {
                        stack.pop();
                    } else {
                        stack2.push(i);
                    }
                } else {
                    continue;
                }
            }

            if (sb.length() >= stack2.size()) {
                for (int i = 0; i < stack2.size(); i++) {
                    sb.deleteCharAt(stack2.get(i) - i);
                }
            }

            if (sb.length() >= stack.size()) {
                for (int i = 0; i < stack.size(); i++) {
                    sb.deleteCharAt(stack.get(i) - i - stack2.size());
                }
            }
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}