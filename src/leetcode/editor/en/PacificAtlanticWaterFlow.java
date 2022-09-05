// [417]
//There is an m x n rectangular island that borders both the Pacific Ocean and 
//Atlantic Ocean. The Pacific Ocean touches the island's left and top edges, and 
//the Atlantic Ocean touches the island's right and bottom edges. 
//
// The island is partitioned into a grid of square cells. You are given an m x 
//n integer matrix heights where heights[r][c] represents the height above sea 
//level of the cell at coordinate (r, c). 
//
// The island receives a lot of rain, and the rain water can flow to 
//neighboring cells directly north, south, east, and west if the neighboring cell's height 
//is less than or equal to the current cell's height. Water can flow from any cell 
//adjacent to an ocean into the ocean. 
//
// Return a 2D list of grid coordinates result where result[i] = [ri, ci] 
//denotes that rain water can flow from cell (ri, ci) to both the Pacific and Atlantic 
//oceans. 
//
// 
// Example 1: 
// 
// 
//Input: heights = [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
//
//Output: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
//Explanation: The following cells can flow to the Pacific and Atlantic oceans, 
//as shown below:
//[0,4]: [0,4] -> Pacific Ocean 
//       [0,4] -> Atlantic Ocean
//[1,3]: [1,3] -> [0,3] -> Pacific Ocean 
//       [1,3] -> [1,4] -> Atlantic Ocean
//[1,4]: [1,4] -> [1,3] -> [0,3] -> Pacific Ocean 
//       [1,4] -> Atlantic Ocean
//[2,2]: [2,2] -> [1,2] -> [0,2] -> Pacific Ocean 
//       [2,2] -> [2,3] -> [2,4] -> Atlantic Ocean
//[3,0]: [3,0] -> Pacific Ocean 
//       [3,0] -> [4,0] -> Atlantic Ocean
//[3,1]: [3,1] -> [3,0] -> Pacific Ocean 
//       [3,1] -> [4,1] -> Atlantic Ocean
//[4,0]: [4,0] -> Pacific Ocean 
//       [4,0] -> Atlantic Ocean
//Note that there are other possible paths for these cells to flow to the 
//Pacific and Atlantic oceans.
// 
//
// Example 2: 
//
// 
//Input: heights = [[1]]
//Output: [[0,0]]
//Explanation: The water can flow from the only cell to the Pacific and 
//Atlantic oceans.
// 
//
// 
// Constraints: 
//
// 
// m == heights.length 
// n == heights[r].length 
// 1 <= m, n <= 200 
// 0 <= heights[r][c] <= 10⁵ 
// 
//
// Related Topics Array Depth-First Search Breadth-First Search Matrix 👍 5447 ?
//? 1036


package leetcode.editor.en;

import java.sql.Array;
import java.util.*;

public class PacificAtlanticWaterFlow {
    public static void main(String[] args) {
        Solution solution = new PacificAtlanticWaterFlow().new Solution();
        System.out.println(solution.pacificAtlantic(new int[][]{{1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5}, {5, 1, 1, 2, 4}}));

//        Set<Solution.Point> set = new HashSet<>();
//        set.add(new PacificAtlanticWaterFlow().new Solution().new Point<>(1, 2));
//        System.out.println(set.contains(new PacificAtlanticWaterFlow().new Solution().new Point(1, 2)));

    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int[][] heights;

        public List<List<Integer>> pacificAtlantic(int[][] heights) {
            List<List<Integer>> result = new ArrayList<>();
            this.heights = heights;

            Queue<int[]> queue = new LinkedList<>();
            int M = heights.length, N = heights[0].length;
            addRow(0, queue, N); // add first row
            addCol(0, queue, M); // add first col

            boolean[][] pac = BFS(queue, M, N);

            addRow(M - 1, queue, N);
            addCol(N - 1, queue, M);

            boolean[][] alt = BFS(queue, M, N);

            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (alt[i][j] && pac[i][j]) {
                        result.add(Arrays.asList(i, j));
                    }
                }
            }
            return result;
        }

        private boolean[][] BFS(Queue<int[]> queue, int M, int N) {
            boolean[][] visited = new boolean[M][N];

            while (!queue.isEmpty()) {
                int[] first = queue.poll();
                int row = first[0];
                int col = first[1];
                if (visited[row][col]) {
                    continue;
                }
                visited[row][col] = true;
                int curCellVal = heights[row][col];
                // move up
                if (0 <= row - 1 && heights[row - 1][col] >= curCellVal && !visited[row - 1][col]) {
                    queue.add(new int[]{row - 1, col});
                }
                // move down
                if (M > row + 1 && heights[row + 1][col] >= curCellVal && !visited[row + 1][col]) {
                    queue.add(new int[]{row + 1, col});
                }
                // move left
                if (0 <= col - 1 && heights[row][col - 1] >= curCellVal && !visited[row][col - 1]) {
                    queue.add(new int[]{row, col - 1});
                }
                // move right
                if (N > col + 1 && heights[row][col + 1] >= curCellVal && !visited[row][col + 1]) {
                    queue.add(new int[]{row, col + 1});
                }
            }
            return visited;
        }

        private void addRow(int row, Queue<int[]> queue, int totalCols) {
            for (int i = 0; i < totalCols; i++) {
                int col = i;
                int[] coor = {row, col};
                queue.add(coor);
            }
        }

        private void addCol(int col, Queue<int[]> queue, int totalRows) {
            for (int i = 0; i < totalRows; i++) {
                int row = i;
                int[] coor = {row, col};
                queue.add(coor);
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}