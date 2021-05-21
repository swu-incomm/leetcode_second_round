/**
 * In an infinite chess board with coordinates from -infinity to +infinity, you have a knight at square [0, 0].
 *
 * A knight has 8 possible moves it can make, as illustrated below. Each move is two squares in a cardinal direction,
 * then one square in an orthogonal direction.
 *
 *
 *
 * Return the minimum number of steps needed to move the knight to the square [x, y].  It is guaranteed the answer exists.
 *
 *
 *
 * Example 1:
 *
 * Input: x = 2, y = 1
 * Output: 1
 * Explanation: [0, 0] → [2, 1]
 * Example 2:
 *
 * Input: x = 5, y = 5
 * Output: 4
 * Explanation: [0, 0] → [2, 1] → [4, 2] → [3, 4] → [5, 5]
 *
 *
 * Constraints:
 *
 * |x| + |y| <= 300
 *
 * tricky part:
 * 1. we need to use boolean[x + 302][y + 302] to map the visited node since we have condition
 * that |x| + |y| <= 300
 * 2. just regular bfs will get us result
 */
import java.util.*;
public class MinimumKnightMoves {
    class Coordinate {
        private int x;
        private int y;

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    int [][] directions = {{-1, 2}, {-2, 1}, {-2, -1}, {-1, -2}, {1, -2}, {2, -1}, {2, 1}, {1, 2}};
    int ans;
    public int minKnightMoves(int x, int y) {
        if(x==0 && y==0) return ans;
        Queue <Coordinate> queue = new LinkedList<>();
        queue.offer(new Coordinate(0, 0));
        boolean [][] visited = new boolean [605][605];
        while(!queue.isEmpty()) {
            int size = queue.size();
            ans++;
            for(int j= 0; j<size; j++) {
                Coordinate temp = queue.poll();
                int curX = temp.getX();
                int curY = temp.getY();
                for(int [] i : directions) {
                    Coordinate coordinate = new Coordinate(curX + i[0], curY + i[1]);
                    if(!visited[coordinate.getX() + 302][coordinate.getY() + 302]) {
                        if(coordinate.getX() == x && coordinate.getY() == y) return ans;
                        visited[coordinate.getX() + 302][coordinate.getY() + 302] = true;
                        queue.offer(coordinate);
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String [] args) {
        MinimumKnightMoves minimumKnightMoves = new MinimumKnightMoves();
        System.out.println(minimumKnightMoves.minKnightMoves(5, 5));
    }
}
