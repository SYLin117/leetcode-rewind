// [1275]
//Tic-tac-toe is played by two players A and B on a 3 x 3 grid. The rules of 
//Tic-Tac-Toe are: 
//
// 
// Players take turns placing characters into empty squares ' '. 
// The first player A always places 'X' characters, while the second player B 
//always places 'O' characters. 
// 'X' and 'O' characters are always placed into empty squares, never on filled 
//ones. 
// The game ends when there are three of the same (non-empty) character filling 
//any row, column, or diagonal. 
// The game also ends if all squares are non-empty. 
// No more moves can be played if the game is over. 
// 
//
// Given a 2D integer array moves where moves[i] = [rowi, coli] indicates that 
//the iᵗʰ move will be played on grid[rowi][coli]. return the winner of the game 
//if it exists (A or B). In case the game ends in a draw return "Draw". If there 
//are still movements to play return "Pending". 
//
// You can assume that moves is valid (i.e., it follows the rules of Tic-Tac-
//Toe), the grid is initially empty, and A will play first. 
//
// 
// Example 1: 
// 
// 
//Input: moves = [[0,0],[2,0],[1,1],[2,1],[2,2]]
//Output: "A"
//Explanation: A wins, they always play first.
// 
//
// Example 2: 
// 
// 
//Input: moves = [[0,0],[1,1],[0,1],[0,2],[1,0],[2,0]]
//Output: "B"
//Explanation: B wins.
// 
//
// Example 3: 
// 
// 
//Input: moves = [[0,0],[1,1],[2,0],[1,0],[1,2],[2,1],[0,1],[0,2],[2,2]]
//Output: "Draw"
//Explanation: The game ends in a draw since there are no moves to make.
// 
//
// 
// Constraints: 
//
// 
// 1 <= moves.length <= 9 
// moves[i].length == 2 
// 0 <= rowi, coli <= 2 
// There are no repeated elements on moves. 
// moves follow the rules of tic tac toe. 
// 
//
// Related Topics Array Hash Table Matrix Simulation 👍 1024 👎 264


package leetcode.editor.en;

import java.util.Arrays;

public class FindWinnerOnATicTacToeGame {
    public static void main(String[] args) {
        Solution solution = new FindWinnerOnATicTacToeGame().new Solution();
        int[][] moves = {{0, 0}, {1, 1}};
        System.out.println(solution.tictactoe(moves));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String tictactoe(int[][] moves) {
            char[][] board = new char[3][3];
//            Arrays.fill(board,' ');
            boolean turn = true;
            for (int i = 0; i < moves.length; i++) {
                int[] move = moves[i];
                if (turn) {
                    board[move[0]][move[1]] = 'X';
                } else {
                    board[move[0]][move[1]] = 'O';
                }
                turn = !turn;
            }
            int result = check(board);
            if (result == 1) {
                return "A";
            } else if (result == -1) {
                return "B";
            } else if (result == -2) {
                return "Pending";
            } else {
                return "Draw";
            }
        }

        private int check(char[][] board) {


            COL_OUTER_LOOP:
            for (int i = 0; i < board[0].length; i++) { // check column
                char first = board[0][i];
                for (int j = 1; j < board.length; j++) {
                    if (first != board[j][i]) continue COL_OUTER_LOOP;
                }
                if (first == 'X') return 1;
                if (first == 'O') return -1;
            }

            ROW_OUTER_LOOP:
            for (int i = 0; i < board.length; i++) { // check column
                char first = board[i][0];
                for (int j = 1; j < board[i].length; j++) {
                    if (first != board[i][j]) continue ROW_OUTER_LOOP;
                }
                if (first == 'X') return 1;
                if (first == 'O') return -1;
            }

            char first = board[0][0];
            for (int i = 1; i < 3; i++) {
                if (first != board[i][i]) break;
                if (i == 2 && first == 'X') return 1;
                if (i == 2 && first == 'O') return -1;
            }

            first = board[0][2];
            for (int i = 1; i < 3; i++) {
                if (first != board[i][2 - i]) break;
                if (i == 2 && first == 'X') return 1;
                if (i == 2 && first == 'O') return -1;
            }

            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j] == '\u0000') return -2;
                }
            }
            return 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}