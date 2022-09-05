// [867]
//Given a 2D integer array matrix, return the transpose of matrix. 
//
// The transpose of a matrix is the matrix flipped over its main diagonal, 
//switching the matrix's row and column indices. 
//
// 
//
// 
// Example 1: 
//
// 
//Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
//Output: [[1,4,7],[2,5,8],[3,6,9]]
// 
//
// Example 2: 
//
// 
//Input: matrix = [[1,2,3],[4,5,6]]
//Output: [[1,4],[2,5],[3,6]]
// 
//
// 
// Constraints: 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 1000 
// 1 <= m * n <= 10⁵ 
// -10⁹ <= matrix[i][j] <= 10⁹ 
// 
//
// Related Topics Array Matrix Simulation 👍 2293 👎 408


package leetcode.editor.en;

public class TransposeMatrix {
    public static void main(String[] args) {
        Solution solution = new TransposeMatrix().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] transpose(int[][] matrix) {
            int[][] result = new int[matrix[0].length][matrix.length];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    result[j][i] = matrix[i][j];
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}