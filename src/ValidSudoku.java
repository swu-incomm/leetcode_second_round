import java.util.HashSet;

/**
 * Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
 *
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 *
 * A partially filled sudoku which is valid.
 *
 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 *
 * Example 1:
 *
 * Input:
 * [
 *   ["5","3",".",".","7",".",".",".","."],
 *   ["6",".",".","1","9","5",".",".","."],
 *   [".","9","8",".",".",".",".","6","."],
 *   ["8",".",".",".","6",".",".",".","3"],
 *   ["4",".",".","8",".","3",".",".","1"],
 *   ["7",".",".",".","2",".",".",".","6"],
 *   [".","6",".",".",".",".","2","8","."],
 *   [".",".",".","4","1","9",".",".","5"],
 *   [".",".",".",".","8",".",".","7","9"]
 * ]
 * Output: true
 * Example 2:
 *
 * Input:
 * [
 *   ["8","3",".",".","7",".",".",".","."],
 *   ["6",".",".","1","9","5",".",".","."],
 *   [".","9","8",".",".",".",".","6","."],
 *   ["8",".",".",".","6",".",".",".","3"],
 *   ["4",".",".","8",".","3",".",".","1"],
 *   ["7",".",".",".","2",".",".",".","6"],
 *   [".","6",".",".",".",".","2","8","."],
 *   [".",".",".","4","1","9",".",".","5"],
 *   [".",".",".",".","8",".",".","7","9"]
 * ]
 * Output: false
 * Explanation: Same as Example 1, except with the 5 in the top left corner being
 *     modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
 * Note:
 *
 * A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 * Only the filled cells need to be validated according to the mentioned rules.
 * The given board contain only digits 1-9 and the character '.'.
 * The given board size is always 9x9.
 *
 *
 *
 * The key point is by how to use i, j to represent rows, columns and 3 x 3 matrix
 * for rows: hashset.contains(matrix[i][j])
 * for cols: hashset.contains(matrix[j][i])
 * for matrix:
 * block index.row = 3 * (i/3)
 * block index.col = 3 * (i%3)
 * then use index.row + j/3 to traverse row in the block
 * then use index.col + j%3 to traverse col in the block
 * 第一层9次循环 分别确定9 个row 9个col的起始点 和九个matrix的 起始坐标， 对于matrix来说， 第一层的9次循环每次扫描一个matrix， 第二层循环扫描matrix里的九个点
 * 第二层循环 一到九 对于row和col直接顺序遍历， 对于matrix， 运用% 与 / 进行行和列的遍历
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i<9;i++) {
            HashSet<Character> rowSet = new HashSet<>();
            HashSet<Character> colSet = new HashSet<>();
            HashSet<Character> matrixSet = new HashSet<>();
            for(int j = 0; j<9; j++) {
                //check i th row
                if(board[i][j] != '.' && !rowSet.add(board[i][j])) return false;
                //check ith col
                if(board[j][i] != '.' && !colSet.add(board[j][i])) return false;
                //check ith matrix
                //first step find the index row and col
                int indexRow = 3 * (i/3);
                int indexCol = 3 * (i%3);
                if(board[indexRow + j/3][indexCol + j % 3] != '.' && !matrixSet.add(board[indexRow + j/3][indexCol + j % 3])) return false;
            }
        }

        return true;
    }
}
