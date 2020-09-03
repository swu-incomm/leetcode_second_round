import java.util.LinkedList;
import java.util.Queue;

public class RottingOrangesRewrite {
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return -1;
        int ans = 0;
        Queue<Box> queue = new LinkedList<>();
        for(int i=0; i<grid.length; i++) {
            for(int j = 0; j <grid[0].length; j++) {
                if(grid[i][j] == 2) {
                    Box box  =new Box(i, j, 0);
                    queue.offer(box);
                }
            }
        }
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i =0; i<size; i++) {
                Box temp = queue.poll();
                int r = temp.x;
                int c = temp.y;
                int time = temp.time;
                if(isValid(r -1, c, grid)) {
                    if(grid[r-1][c] == 1) {
                        grid[r-1][c] = 2;
                        Box box = new Box(r-1, c, time +1);
                        ans = Math.max(ans, time+1);
                        queue.offer(box);
                    }
                }
                if(isValid(r +1, c, grid)) {
                    if(grid[r+1][c] == 1) {
                        grid[r+1][c] = 2;
                        Box box = new Box(r+1, c, time +1);
                        ans = Math.max(ans, time+1);
                        queue.offer(box);
                    }
                }
                if(isValid(r, c-1, grid)) {
                    if(grid[r][c-1] == 1) {
                        grid[r][c-1] = 2;
                        Box box = new Box(r, c-1, time +1);
                        ans = Math.max(ans, time+1);
                        queue.offer(box);
                    }
                }
                if(isValid(r, c+1, grid)) {
                    if(grid[r][c+1] == 1) {
                        grid[r][c+1] = 2;
                        Box box = new Box(r, c+1, time +1);
                        ans = Math.max(ans, time+1);
                        queue.offer(box);
                    }
                }
            }
        }

        for(int i=0; i<grid.length; i++) {
            for(int j = 0; j <grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return ans;
    }

    public boolean isValid(int i, int j, int [][] grid) {
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length) return false;
        return true;
    }
}

class Box {
    int x;
    int y;
    int time;
    public Box(int x, int y, int time) {
        this.x = x;
        this.y = y;
        this.time = time;
    }
    public Box() {}
}
