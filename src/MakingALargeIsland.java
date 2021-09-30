/**
 * You are given an n x n binary matrix grid. You are allowed to change at most one 0 to be 1.
 *
 * Return the size of the largest island in grid after applying this operation.
 *
 * An island is a 4-directionally connected group of 1s.
 *
 *
 *
 * Example 1:
 *
 * Input: grid = [[1,0],[0,1]]
 * Output: 3
 * Explanation: Change one 0 to 1 and connect two 1s, then we get an island with area = 3.
 * Example 2:
 *
 * Input: grid = [[1,1],[1,0]]
 * Output: 4
 * Explanation: Change the 0 to 1 and make the island bigger, only one island with area = 4.
 * Example 3:
 *
 * Input: grid = [[1,1],[1,1]]
 * Output: 4
 * Explanation: Can't change any 0 to 1, only one island with area = 4.
 *
 *
 * Constraints:
 *
 * n == grid.length
 * n == grid[i].length
 * 1 <= n <= 500
 * grid[i][j] is either 0 or 1.
 */
public class MakingALargeIsland {
    public int largestIsland(int[][] grid) {
        int res = 0;
        boolean flag = true;
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == 0) {
                    flag = false;
                    grid[i][j] = 1;
                    int area = calculateArea(grid);
                    res = Math.max(res, area);
                    grid[i][j] = 0;
                }
            }
        }
        return flag ? grid.length * grid[0].length : res;
    }

    int [][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int calculateArea(int [][] grid) {
        int [][] copy = new int [grid.length][grid.length];
        for(int i=0; i<copy.length; i++) {
            for(int j=0; j<copy[0].length; j++) {
                copy[i][j] = grid[i][j];
            }
        }
        int res = 0;
        for(int i=0; i<copy.length; i++) {
            for(int j=0; j<copy[0].length; j++) {
                if(copy[i][j] == 1) {
                    res = Math.max(res,dfs(copy, i, j));
                }
            }
        }
        return res;
    }

    public int dfs(int [][] grid, int i, int j) {
        grid[i][j] = 0;
        int res = 1;
        for(int [] direction : directions) {
            int x = i + direction[0];
            int y = j + direction[1];
            if(x >=0 && x < grid.length && y >=0 && y < grid[0].length && grid[x][y] == 1) {
              res += dfs(grid, x, y);
            }
        }
        return res;
    }
}
