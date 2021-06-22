/**
 * Given a 2D board and a word, find if the word exists in the grid.
 *
 * The word can be constructed from letters of sequentially adjacent cell,
 * where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
 *
 * Example:
 *
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * Given word = "ABCCED", return true.
 * Given word = "SEE", return true.
 * Given word = "ABCB", return false.
 */
public class WordSearch {
//    public boolean exist(char[][] board, String word) {
//        if(board == null || word == null || board.length==0 || word.length()==0) return false;
//        for(int i = 0; i<board.length;i++) {
//            for(int j = 0; j<board[0].length;j++) {
//                if(dfs(board, word, 0, i, j)) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
//    public boolean dfs(char[][] board, String word, int index, int i, int j) {
//        if(index > word.length()-1
//                || i<0
//                || j <0
//                || i==board.length
//                || j == board[0].length
//                || word.charAt(index) != board[i][j]) return false;
//        if(index == word.length() - 1) return true;
//        //The other way to mark visited is a static 2-d array, mark as visited before dfs and mark as false after
//        board[i][j] ^=256;
//        boolean res = dfs(board,word,index+1,i-1,j)
//                ||dfs(board,word,index+1,i+1,j)
//                ||dfs(board,word,index+1,i,j+1)
//                ||dfs(board,word,index+1,i,j-1);
//        board[i][j] ^=256;
//        return res;
//    }
//    public static void main(String [] args) {
//        //change into some unknown char to avoid visit twice
//        char test = 'b'^256;
//        System.out.println(test);
//        WordSearch wordSearch = new WordSearch();
//        char [][] board = new char[][] {
//                {'A','B','C','E'},
//                {'S','F','C','S'},
//                {'A','D','E','E'}
//        };
//        System.out.println(wordSearch.exist(board,"ABCESH"));
//    }
    /**
     * Constraints:
     *
     * m == board.length
     * n = board[i].length
     * 1 <= m, n <= 6
     * 1 <= word.length <= 15
     * board and word consists of only lowercase and uppercase English letters.
     */
    int [][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public boolean exist(char[][] board, String word) {
        int ROWS = board.length;
        int COLS = board[0].length;
        for (int row = 0; row < ROWS; ++row)
            for (int col = 0; col < COLS; ++col) {
                boolean [][] visited = new boolean[ROWS][COLS];
                if (this.backtrack(row, col, "", word, board, visited))
                    return true;
            }
        return false;
    }
    public boolean backtrack(int i, int j, String cur, String word, char[][] board, boolean [][] visited) {
        if (cur.equalsIgnoreCase(word))
            return true;

        //very important
        if(i < 0 || i == board.length || j<0 || j==board[0].length || visited[i][j] || word.indexOf(cur) < 0) {
            return false;
        }
        boolean res = false;
        visited[i][j] = true;
        for(int [] direction : directions) {
            if(backtrack(i + direction[0], j + direction[1], cur + board[i][j], word, board, visited)) {
                res = true;
                break;
            }
        }
        visited[i][j] = false;
        return res;
    }
}
