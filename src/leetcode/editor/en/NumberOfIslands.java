// [200]
//Given an m x n 2D binary grid grid which represents a map of '1's (land) and 
//'0's (water), return the number of islands. 
//
// An island is surrounded by water and is formed by connecting adjacent lands 
//horizontally or vertically. You may assume all four edges of the grid are all 
//surrounded by water. 
//
// 
// Example 1: 
//
// 
//Input: grid = [
//  ["1","1","1","1","0"],
//  ["1","1","0","1","0"],
//  ["1","1","0","0","0"],
//  ["0","0","0","0","0"]
//]
//Output: 1
// 
//
// Example 2: 
//
// 
//Input: grid = [
//  ["1","1","0","0","0"],
//  ["1","1","0","0","0"],
//  ["0","0","1","0","0"],
//  ["0","0","0","1","1"]
//]
//Output: 3
// 
//
// 
// Constraints: 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 300 
// grid[i][j] is '0' or '1'. 
// 
//
// Related Topics Array Depth-First Search Breadth-First Search Union Find 
//Matrix 👍 16774 👎 386


package leetcode.editor.en;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
    public static void main(String[] args) {
        Solution solution = new NumberOfIslands().new Solution();
        char[][] grid = new char[][]{{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};
        System.out.println(solution.numIslands(grid));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numIslands(char[][] grid) {
            int M = grid.length, N = grid[0].length;
            boolean[][] visited = new boolean[M][N];
            int cnt = 0;
            Queue<int[]> queue = new LinkedList<>();
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (grid[i][j] == '1' && !visited[i][j]) {
                        queue.add(new int[]{i, j});
                        BFS(queue, grid, visited);
                        cnt++;
                    }
                }
            }
            return cnt;
        }

        private void BFS(Queue<int[]> queue, char[][] grid, boolean[][] visited) {
            int M = visited.length, N = visited[0].length;
            while (!queue.isEmpty()) {
                int[] node = queue.poll();
                int row = node[0], col = node[1];

                if (!visited[row][col]) {
                    visited[row][col] = true;
                    if (0 <= row - 1 && !visited[row - 1][col] && grid[row - 1][col] == '1') {
                        queue.add(new int[]{row - 1, col});
                    }
                    if (M > row + 1 && !visited[row + 1][col] && grid[row + 1][col] == '1') {
                        queue.add(new int[]{row + 1, col});
                    }
                    if (0 <= col - 1 && !visited[row][col - 1] && grid[row][col - 1] == '1') {
                        queue.add(new int[]{row, col - 1});
                    }
                    if (N > col + 1 && !visited[row][col + 1] && grid[row][col + 1] == '1') {
                        queue.add(new int[]{row, col + 1});
                    }
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}