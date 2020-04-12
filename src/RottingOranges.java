import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * In a given grid, each cell can have one of three values:
 *
 * the value 0 representing an empty cell;
 * the value 1 representing a fresh orange;
 * the value 2 representing a rotten orange.
 * Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.
 *
 * Return the minimum number of minutes that must elapse until no cell has a fresh orange.  If this is impossible, return -1 instead.
 */
public class RottingOranges {
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0) return -1;
        int ans = 0;
        int m = grid.length, n = grid[0].length;
        Queue<Integer> queue = new LinkedList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<m;i++) {
            for(int j = 0; j<n;j++) {
                if(grid[i][j] == 2) {
                    int value = i * n + j;
                    queue.offer(value);
                    map.put(value, 0);
                }
            }
        }
        // breadth first search
        while(!queue.isEmpty()) {
            int value = queue.poll();
            int r = value/n;
            int c = value % n;
            int depth = map.get(value);
            if(isValid(r-1, c, grid)) {
                if(grid[r-1][c] == 1) {
                    grid[r-1][c] = 2;
                    int newValue = (r-1) * n + c;
                    queue.offer(newValue);
                    map.put(newValue, depth + 1);
                    ans = depth + 1;
                }
            }
            if(isValid(r+1, c, grid)) {
                if(grid[r+1][c] == 1) {
                    grid[r+1][c] = 2;
                    int newValue = (r+1) * n + c;
                    queue.offer(newValue);
                    map.put(newValue, depth + 1);
                    ans = depth + 1;
                }
            }
            if(isValid(r, c-1, grid)) {
                if(grid[r][c-1] == 1) {
                    grid[r][c-1] = 2;
                    int newValue = r * n + c -1;
                    queue.offer(newValue);
                    map.put(newValue, depth + 1);
                    ans = depth + 1;
                }
            }
            if(isValid(r, c+1, grid)) {
                if(grid[r][c+1] == 1) {
                    grid[r][c+1] = 2;
                    int newValue = r * n + c +1;
                    queue.offer(newValue);
                    map.put(newValue, depth + 1);
                    ans = depth + 1;
                }
            }
        }
        for(int i = 0; i<m; i++) {
            for(int j = 0; j<n; j++) {
                if(grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return ans;
    }

    public boolean isValid(int i, int j, int [][] grid) {
        if(i<0 || j <0 || i > grid.length-1 || j > grid[0].length-1) return false;
        return true;
    }

    public static void main(String [] args) {
        int [][] test = {
                {2,1,1},
                {1,1,0},
                {0,1,1}
        };
        RottingOranges rottingOranges = new RottingOranges();
        System.out.println(rottingOranges.orangesRotting(test));
    }
}
