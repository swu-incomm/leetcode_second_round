import java.util.*;

/**
 * You are given a m x n 2D grid initialized with these three possible values.
 *
 * -1 - A wall or an obstacle.
 * 0 - A gate.
 * INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume
 * that the distance to a gate is less than 2147483647.
 * Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.
 *
 * Example:
 *
 * Given the 2D grid:
 *
 * INF  -1  0  INF
 * INF INF INF  -1
 * INF  -1 INF  -1
 *   0  -1 INF INF
 * After running your function, the 2D grid should be:
 *
 *   3  -1   0   1
 *   2   2   1  -1
 *   1  -1   2  -1
 *   0  -1   3   4
 */
public class WallsAndGates {

    //深度优先 方法是正确的 但是 效率很低 本题应该采用广度优先搜索算法
    public void wallsAndGatesDFS(int[][] rooms) {
        if(rooms == null || rooms.length == 0) return;
        int [][] visited = new int[rooms.length][rooms[0].length];
        for(int i = 0; i<rooms.length; i++) {
            for(int j = 0; j<rooms[0].length; j++) {
                if(rooms[i][j] == 0) {
                    dfs(i, j, rooms, 0, visited);
                }
            }
        }
    }
    public void dfs(int i, int j, int [][] rooms, int distance, int [][] visited) {
        if(i < 0 || i > rooms.length-1 || j<0 || j>rooms[0].length -1 ||rooms[i][j] == -1 || visited[i][j] == 1) return;
        if(rooms[i][j] > (distance)) {
            rooms[i][j] = distance;
           // System.out.println(i + "-" + j + ": " + rooms[i][j]);
        }
        visited[i][j] = 1;
        dfs(i-1, j, rooms, distance + 1, visited);
        dfs(i+1, j, rooms, distance + 1, visited);
        dfs(i, j-1, rooms, distance + 1, visited);
        dfs(i, j+1, rooms, distance + 1, visited);
        visited[i][j] = 0;
    }

    //BFS
    public void wallsAndGates(int[][] rooms) {
        if(rooms == null || rooms.length == 0) return;
        Queue<List<Integer>> queue = new LinkedList<>();
        for(int i = 0; i<rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    List<Integer> subList = new ArrayList<>();
                    subList.add(i);
                    subList.add(j);
                    queue.offer(subList);
                }
            }
        }
        while(!queue.isEmpty()) {
            List<Integer> subList = queue.poll();
            int r = subList.get(0);
            int c = subList.get(1);
            for(int [] direction : DIRECTIONS) {
                int nr = direction[0] + r;
                int nc = direction[1] + c;
                if(nr < 0 || nc <0 || nr > rooms.length -1 || nc > rooms[0].length -1 || rooms[nr][nc] == -1) {
                    continue;
                }
                if(rooms[nr][nc] > rooms[r][c]) {
                    rooms[nr][nc] = rooms[r][c] + 1;
                    List<Integer> newSubList = new ArrayList<>();
                    newSubList.add(nr);
                    newSubList.add(nc);
                    queue.offer(newSubList);
                }
            }
        }
    }

    private static final List<int[]> DIRECTIONS = Arrays.asList(
            new int[] { 1,  0},
            new int[] {-1,  0},
            new int[] { 0,  1},
            new int[] { 0, -1}
    );

    public static void main(String [] args) {
        int [][] test = {
                {9999, -1, 0, 9999},
                {9999,9999,9999,-1},
                {9999,-1,9999,-1},
                {0, -1, 9999, 9999}
        };
        WallsAndGates wallsAndGates = new WallsAndGates();
        wallsAndGates.wallsAndGates(test);
        for(int i = 0; i< test.length; i++) {
            for(int j = 0; j<test[0].length; j++) {
                System.out.printf("%d ",test[i][j]);
            }
            System.out.println();
        }
    }
}
