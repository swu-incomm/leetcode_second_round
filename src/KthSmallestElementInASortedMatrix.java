import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.
 *
 * Note that it is the kth smallest element in the sorted order, not the kth distinct element.
 *
 * Example:
 *
 * matrix = [
 *    [ 1,  5,  9],
 *    [10, 11, 13],
 *    [12, 13, 15]
 * ],
 * k = 8,
 *
 * return 13.
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ n2.
 */
public class KthSmallestElementInASortedMatrix {
    /**
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Cube> priorityQueue = new PriorityQueue<>();
        for(int i = 0; i<matrix.length; i++) priorityQueue.offer(new Cube(0, i, matrix[0][i]));
        for(int i = 0; i<k-1; i++) {
            Cube temp = priorityQueue.poll();
            if(temp.x < matrix.length-1) {
                priorityQueue.offer(new Cube(temp.x+1, temp.y, matrix[temp.x+1][temp.y]));
            }
        }
        return priorityQueue.poll().val;
    }

    class Cube implements Comparable<Cube> {
        int x;
        int y;
        int val;
        public Cube(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
        @Override
        public int compareTo(Cube cube) {
            return this.val - cube.val;
        }
    }
     **/

    public int kthSmallestMaxHeap(int[][] matrix, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(p -> -p));
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[0].length; j++) {
                pq.offer(matrix[i][j]);
                if(pq.size() == k + 1) {
                    pq.poll();
                }
            }
        }
        return pq.poll();
    }
    public int kthSmallestMinHeap(int[][] matrix, int k) {
        PriorityQueue<int []> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for(int i=0; i<matrix.length; i++) {
            pq.offer(new int[] {matrix[i][0], i, 0});
        }
        while(k > 1) {
            int [] temp = pq.poll();
            k--;
            if(temp[2] < matrix[0].length-1) {
                pq.offer(new int [] {matrix[temp[1]][temp[2] + 1], temp[1], temp[2] + 1});
            }
        }
        return pq.poll()[0];
    }

}
