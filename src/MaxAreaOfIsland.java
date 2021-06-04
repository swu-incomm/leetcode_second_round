/**
 * Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally
 * (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
 *
 * Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)
 *
 * Example 1:
 *
 * [[0,0,1,0,0,0,0,1,0,0,0,0,0],
 *  [0,0,0,0,0,0,0,1,1,1,0,0,0],
 *  [0,1,1,0,1,0,0,0,0,0,0,0,0],
 *  [0,1,0,0,1,1,0,0,1,0,1,0,0],
 *  [0,1,0,0,1,1,0,0,1,1,1,0,0],
 *  [0,0,0,0,0,0,0,0,0,0,1,0,0],
 *  [0,0,0,0,0,0,0,1,1,1,0,0,0],
 *  [0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * Given the above grid, return 6. Note the answer is not 11, because the island must be connected 4-directionally.
 * Example 2:
 *
 * [[0,0,0,0,0,0,0,0]]
 * Given the above grid, return 0.
 * Note: The length of each dimension in the given grid does not exceed 50.
 */
import java.util.*;
public class MaxAreaOfIsland {
    /*
    int ans = 0;
    public int maxAreaOfIsland(int[][] grid) {
        if(grid == null || grid.length == 0) return ans;
        for(int i = 0; i< grid.length; i++) {
            for(int j = 0; j<grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    int temp = dfs(i, j, grid);
                    if(temp > ans) {
                        ans = temp;
                    }
                }
            }
        }
        return ans;
    }
    public int dfs(int i, int j, int [][] grid) {
        if(i < 0 || j < 0 || i > grid.length-1 || j > grid[0].length-1 || grid[i][j] == 0) return 0;
        grid[i][j] = 0;
        int up = dfs(i-1, j, grid);
        int down = dfs(i+1, j, grid);
        int left = dfs(i, j-1, grid);
        int right = dfs(i, j + 1, grid);
        return up + down + left + right + 1;
    }
     */
    int ans;
    int [][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int maxAreaOfIsland(int[][] grid) {
        for(int i=0; i<grid.length; i++) {
            for(int j= 0; j<grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    ans = Math.max(ans, dfs(grid, i, j));
                }
            }
        }
        return ans;
    }

    public int dfs(int [][] grid, int row, int col) {
        grid[row][col] = 0;
        int temp = 1;
        for(int [] direction : directions) {
            int x = row + direction[0];
            int y = col + direction[1];
            if(x >= 0 && x < grid.length && y >=0 && y < grid[0].length && grid[x][y] == 1) {
                temp += dfs(grid, x, y);
            }
        }
        return temp;
    }


    public int maxAreaOfIslandMain(int [][]grid) {
        for(int i=0; i<grid.length; i++) {
            for(int j= 0; j<grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    ans = Math.max(ans, maxAreaOfIslandBFS(grid, i, j));
                }
            }
        }
        return ans;
    }
    public int maxAreaOfIslandBFS(int[][] grid, int row, int col) {
        int res = 0;
        Queue <Co>queue = new LinkedList<>();
        grid[row][col] = 0;
        queue.offer(new Co(row, col));
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0; i<size; i++) {
                res++;
                Co temp = queue.poll();
                int x = temp.x;
                int y = temp.y;
                for(int [] direction : directions) {
                    int newX = x + direction[0];
                    int newY = y + direction[1];
                    if(newX >= 0 && newX < grid.length && newY >=0 && newY < grid[0].length && grid[newX][newY] == 1) {
                        queue.offer(new Co(newX, newY));
                        grid[newX][newY] = 0;
                    }
                }
            }
        }
        return res;
    }
    class Co {
        int x;
        int y;

        public Co(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
