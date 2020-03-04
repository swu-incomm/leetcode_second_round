/**
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 *
 * Example 1:
 *
 * Input:
 * 11110
 * 11010
 * 11000
 * 00000
 *
 * Output: 1
 * Example 2:
 *
 * Input:
 * 11000
 * 11000
 * 00100
 * 00011
 *
 * Output: 3
 */
public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int ans = 0;
        if(grid == null || grid.length == 0) return ans;
        int m = grid.length;
        int n = grid[0].length;
        for(int i = 0; i<m;i++) {
            for(int j = 0; j<n;j++) {
                if(grid[i][j] != '0') {
                    dfs(grid, i, j);
                    ans ++;
                }
            }
        }
        return ans;
    }
    public void dfs(char[][] grid, int i, int j) {
        if(i<0 || i >grid.length-1 || j <0 || j>grid[0].length-1 || grid[i][j] == '0') return;
        grid[i][j] = '0';
        dfs(grid, i-1, j);
        dfs(grid, i+1, j);
        dfs(grid, i, j-1);
        dfs(grid, i, j+1);
    }
}
