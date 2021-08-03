/**
 * Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k,
 * return the k closest points to the origin (0, 0).
 *
 * The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).
 *
 * You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).
 *
 *
 *
 * Example 1:
 *
 *
 * Input: points = [[1,3],[-2,2]], k = 1
 * Output: [[-2,2]]
 * Explanation:
 * The distance between (1, 3) and the origin is sqrt(10).
 * The distance between (-2, 2) and the origin is sqrt(8).
 * Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
 * We only want the closest k = 1 points from the origin, so the answer is just [[-2,2]].
 * Example 2:
 *
 * Input: points = [[3,3],[5,-1],[-2,4]], k = 2
 * Output: [[3,3],[-2,4]]
 * Explanation: The answer [[-2,4],[3,3]] would also be accepted.
 *
 *
 * Constraints:
 *
 * 1 <= k <= points.length <= 104
 * -104 < xi, yi < 104
 */

import java.util.*;
public class KClosestPointsToOrigin {
    class Pair {
        private int [] point;
        private double distance;

        public int[] getPoint() {
            return point;
        }

        public void setPoint(int[] point) {
            this.point = point;
        }

        public double getDistance() {
            return distance;
        }

        public void setDistance(double distance) {
            this.distance = distance;
        }

        public Pair(int[] point, double distance) {
            this.point = point;
            this.distance = distance;
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((o1, o2) -> o1.distance > o2.distance ? -1 : 1);
        int [][] res = new int [k][2];
        for(int [] point : points) {
            double distance = Math.sqrt(Math.pow(point[0], 2) + Math.pow(point[1], 2));
            Pair temp = new Pair(point, distance);
            pq.add(temp);
            if(pq.size() == k + 1) pq.poll();
        }
        int j=0;
        while(pq.size() > 0) {
            res[j++] = pq.poll().getPoint();
        }
        return res;
    }
}
