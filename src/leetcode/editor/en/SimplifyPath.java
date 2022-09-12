// [71]
//Given a string path, which is an absolute path (starting with a slash '/') to 
//a file or directory in a Unix-style file system, convert it to the simplified 
//canonical path. 
//
// In a Unix-style file system, a period '.' refers to the current directory, a 
//double period '..' refers to the directory up a level, and any multiple 
//consecutive slashes (i.e. '//') are treated as a single slash '/'. For this problem, 
//any other format of periods such as '...' are treated as file/directory names. 
//
// The canonical path should have the following format: 
//
// 
// The path starts with a single slash '/'. 
// Any two directories are separated by a single slash '/'. 
// The path does not end with a trailing '/'. 
// The path only contains the directories on the path from the root directory 
//to the target file or directory (i.e., no period '.' or double period '..') 
// 
//
// Return the simplified canonical path. 
//
// 
// Example 1: 
//
// 
//Input: path = "/home/"
//Output: "/home"
//Explanation: Note that there is no trailing slash after the last directory 
//name.
// 
//
// Example 2: 
//
// 
//Input: path = "/../"
//Output: "/"
//Explanation: Going one level up from the root directory is a no-op, as the 
//root level is the highest level you can go.
// 
//
// Example 3: 
//
// 
//Input: path = "/home//foo/"
//Output: "/home/foo"
//Explanation: In the canonical path, multiple consecutive slashes are replaced 
//by a single one.
// 
//
// 
// Constraints: 
//
// 
// 1 <= path.length <= 3000 
// path consists of English letters, digits, period '.', slash '/' or '_'. 
// path is a valid absolute Unix path. 
// 
//
// Related Topics String Stack 👍 2851 👎 565


package leetcode.editor.en;

import java.util.Stack;

public class SimplifyPath {
    public static void main(String[] args) {
        Solution solution = new SimplifyPath().new Solution();
        System.out.println(solution.simplifyPath("/home//foo"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String simplifyPath(String path) {
            StringBuilder sb = new StringBuilder("");
            Stack<String> stack = new Stack<>();
            int left = 1, right = 1;
            while (right < path.length()) {
                if (path.charAt(right) == '/') {
                    String subPath = path.substring(left, right);
                    if (subPath.isEmpty()) {
                        // do nothing
                    } else if (subPath.equals("..")) {
                        if (!stack.isEmpty()) stack.pop();
                    } else if (subPath.equals(".")) {
                        // do nothing
                    } else {
                        stack.push(subPath);
                    }
                    left = right + 1;
                }
                right++;
            }
            if (path.charAt(right - 1) != '/') {
                String subPath = path.substring(left, right);
                if (subPath.isEmpty()) {
                    // do nothing
                } else if (subPath.equals("..")) {
                    if (!stack.isEmpty()) stack.pop();
                } else if (subPath.equals(".")) {
                    // do nothing
                } else {
                    stack.push(subPath);
                }
            }

            if (!stack.isEmpty()) {
                while (!stack.isEmpty()) {
                    sb.insert(0, "/" + stack.pop());
                }
            } else {
                sb.insert(0, "/");
            }

            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}