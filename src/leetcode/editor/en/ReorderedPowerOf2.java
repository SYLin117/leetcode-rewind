// [869]
//You are given an integer n. We reorder the digits in any order (including the 
//original order) such that the leading digit is not zero. 
//
// Return true if and only if we can do this so that the resulting number is a 
//power of two. 
//
// 
// Example 1: 
//
// 
//Input: n = 1
//Output: true
// 
//
// Example 2: 
//
// 
//Input: n = 10
//Output: false
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 10⁹ 
// 
//
// Related Topics Math Sorting Counting Enumeration 👍 1891 👎 370


package leetcode.editor.en;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ReorderedPowerOf2 {
    public static void main(String[] args) {
        Solution solution = new ReorderedPowerOf2().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean reorderedPowerOf2(int N) {
            int[] A = count(N);
            for (int i = 0; i < 31; ++i) // 32因為機器只有32bit
                if (Arrays.equals(A, count(1 << i))) // 只要有存在相同的count即可
                    return true;
            return false;
        }

        // Returns the count of digits of N
        // Eg. N = 112223334, returns [0,2,3,3,1,0,0,0,0,0]
        // 分別表示每個digit有幾個 eg. 3有3個
        public int[] count(int N) {
            int[] ans = new int[10]; // digit只有0~9
            while (N > 0) {
                ans[N % 10]++; // count+1
                N /= 10;
            }
            return ans;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}