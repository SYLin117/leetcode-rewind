// [118]
/**
 * Given an integer numRows, return the first numRows of Pascal's triangle.
 * <p>
 * In Pascal's triangle, each number is the sum of the two numbers directly above
 * it as shown:
 * <p>
 * <p>
 * Example 1:
 * Input: numRows = 5
 * Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 * <p>
 * Example 2:
 * Input: numRows = 1
 * Output: [[1]]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * 1 <= numRows <= 30
 * <p>
 * <p>
 * Related Topics Array Dynamic Programming 👍 7634 👎 253
 */

package leetcode.editor.en;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public static void main(String[] args) {
        Solution solution = new PascalsTriangle().new Solution();
        System.out.println(solution.generate(5));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> triangle = new ArrayList<List<Integer>>();
            if (numRows < 1) return triangle;
            // Base case; first row is always [1].
            triangle.add(new ArrayList<>());
            triangle.get(0).add(1);

            for (int rowNum = 1; rowNum < numRows; rowNum++) {
                List<Integer> row = new ArrayList<>();
                List<Integer> prevRow = triangle.get(rowNum - 1);

                // The first row element is always 1.
                row.add(1);

                // Each triangle element (other than the first and last of each row)
                // is equal to the sum of the elements above-and-to-the-left and
                // above-and-to-the-right.
                for (int j = 1; j < rowNum; j++) {
                    row.add(prevRow.get(j - 1) + prevRow.get(j));
                }

                // The last row element is always 1.
                row.add(1);

                triangle.add(row);
            }

            return triangle;
        }
    }
}