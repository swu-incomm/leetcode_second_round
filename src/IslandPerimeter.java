import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water.
 *
 * Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly
 * one island (i.e., one or more connected land cells).
 *
 * The island doesn't have "lakes" (water inside that isn't connected to the water around the island).
 * One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100.
 * Determine the perimeter of the island.
 *
 *
 *
 * Example:
 *
 * Input:
 * [[0,1,0,0],
 *  [1,1,1,0],
 *  [0,1,0,0],
 *  [1,1,0,0]]
 *
 * Output: 16
 *
 * Explanation: The perimeter is the 16 yellow stripes in the image below:
 */
public class IslandPerimeter {

    int global;

    public int islandPerimeter(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        label:
        for(int i = 0; i<grid.length;i++) {
            for(int j = 0; j<grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    dfs(i, j, grid);
                    break label;
                }
            }
        }

        return global;
    }
    public void dfs(int i, int j, int [][] grid) {
        if(i<0 || j<0 || i > grid.length -1 || j > grid[0].length - 1 || grid[i][j] != 1) return;
        grid[i][j] = 2;
        dfs(i-1, j, grid);
        dfs(i+1, j, grid);
        dfs(i, j-1, grid);
        dfs(i, j+1, grid);
        //探索完了之后 已经visited过的岛屿此时值已经变为2， 此时检查四周， 只有在边界或者周围是0的情况，才能算作有效边
        //为什么不将已经visited过的岛屿设置为0？ 因为此时检查有效边必须要排除相邻岛屿存在的情况
        int up = addEdge(i-1, j, grid) ? 1 : 0;
        int down = addEdge(i+1, j, grid) ? 1 : 0;
        int left = addEdge(i, j-1, grid) ? 1 : 0;
        int right = addEdge(i, j+1, grid) ? 1 : 0;
        global += left + right + up + down;
    }
    public boolean addEdge(int i, int j, int [][] grid) {
        if(i<0 || j<0 || i > grid.length -1 || j > grid[0].length - 1 || grid[i][j] == 0) return true;
        return false;
    }
    public static void main(String [] args) {
        int [][] test = {
                {0,1,0,0},
                {1,1,1,0},
                {0,1,0,0},
                {1,1,0,0}
        };

        IslandPerimeter islandPerimeter = new IslandPerimeter();
        System.out.println(islandPerimeter.islandPerimeterSimple(test));

    }

    public int islandPerimeterSimple(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int num = 0, edge = 0;
        for(int i = 0; i<grid.length;i++) {
            for(int j = 0; j<grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    num ++;
                    if(i-1 >=0 && grid[i-1][j] == 1) edge ++;
                    if(j-1 >=0 && grid[i][j-1] == 1) edge ++;
                }
            }
        }
        return num * 4 - edge *2;
    }
}
