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
    public boolean exist(char[][] board, String word) {
        if(board == null || word == null || board.length==0 || word.length()==0) return false;
        for(int i = 0; i<board.length;i++) {
            for(int j = 0; j<board[0].length;j++) {
                if(dfs(board, word, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean dfs(char[][] board, String word, int index, int i, int j) {
        if(index > word.length()-1
                || i<0
                || j <0
                || i==board.length
                || j == board[0].length
                || word.charAt(index) != board[i][j]) return false;
        if(index == word.length() - 1) return true;
        //The other way to mark visited is a static 2-d array, mark as visited before dfs and mark as false after
        board[i][j] ^=256;
        boolean res = dfs(board,word,index+1,i-1,j)
                ||dfs(board,word,index+1,i+1,j)
                ||dfs(board,word,index+1,i,j+1)
                ||dfs(board,word,index+1,i,j-1);
        board[i][j] ^=256;
        return res;
    }
    public static void main(String [] args) {
        //change into some unknown char to avoid visit twice
        char test = 'b'^256;
        System.out.println(test);
        WordSearch wordSearch = new WordSearch();
        char [][] board = new char[][] {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        System.out.println(wordSearch.exist(board,"ABCESH"));
    }
}
