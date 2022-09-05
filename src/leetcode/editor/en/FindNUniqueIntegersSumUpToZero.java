// [1304]
//Given an integer n, return any array containing n unique integers such that 
//they add up to 0. 
//
// 
// Example 1: 
//
// 
//Input: n = 5
//Output: [-7,-1,1,3,4]
//Explanation: These arrays also are accepted [-5,-1,1,2,3] , [-3,-1,2,-2,4].
// 
//
// Example 2: 
//
// 
//Input: n = 3
//Output: [-1,0,1]
// 
//
// Example 3: 
//
// 
//Input: n = 1
//Output: [0]
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 1000 
// 
//
// Related Topics Array Math 👍 1332 👎 499


package leetcode.editor.en;

import java.util.Arrays;

public class FindNUniqueIntegersSumUpToZero {
    public static void main(String[] args) {
        Solution solution = new FindNUniqueIntegersSumUpToZero().new Solution();
        System.out.println(Arrays.toString(solution.sumZero(4)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] sumZero(int n) {
            int[] result = new int[n];
            boolean isOdd = n % 2 != 0;
            if (isOdd) {
                for (int i = 0; i <= n / 2; i++) {
                    result[n / 2 + i] = i;
                    result[n / 2 - i] = -i;
                }
            } else {
                for (int i = 1; i <= n / 2; i++) {
                    result[n / 2 + i - 1] = i;
                    result[n / 2 - i] = -i;
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}