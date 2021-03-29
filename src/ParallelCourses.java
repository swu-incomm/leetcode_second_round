/**
 * You are given an integer n which indicates that we have n courses, labeled from 1 to n. You are also given an array
 * relations where relations[i] = [a, b], representing a prerequisite relationship between course a and course b: course a
 * has to be studied before course b.
 *
 * In one semester, you can study any number of courses as long as you have studied all the prerequisites for the course
 * you are studying.
 *
 * Return the minimum number of semesters needed to study all courses. If there is no way to study all the courses, return -1.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: n = 3, relations = [[1,3],[2,3]]
 * Output: 2
 * Explanation: In the first semester, courses 1 and 2 are studied. In the second semester, course 3 is studied.
 * Example 2:
 *
 *
 * Input: n = 3, relations = [[1,2],[2,3],[3,1]]
 * Output: -1
 * Explanation: No course can be studied because they depend on each other.
 *
 *
 * Constraints:
 *
 * 1 <= n <= 5000
 * 1 <= relations.length <= 5000
 * 1 <= a, b <= n
 * a != b
 * All the pairs [a, b] are unique.
 */
import java.util.*;
public class ParallelCourses {
    public int minimumSemesters(int n, int[][] relations) {
        int ans = 0;
        int [] inDegrees = new int [n+1];
        //key will be pre-requested courses, value will be the orders
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0; i<relations.length; i++) {
            if(!map.containsKey(relations[i][0])) {
                List<Integer> subList = new ArrayList<>();
                subList.add(relations[i][1]);
                map.put(relations[i][0], subList);
            } else {
                map.get(relations[i][0]).add(relations[i][1]);
            }
            inDegrees[relations[i][1]] ++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i=1; i<=n;i++) {
            if(inDegrees[i] == 0){
                queue.offer(i);
            }
        }
        while(!queue.isEmpty()) {
            ans++;
            int size = queue.size();
            for(int i=0; i<size; i++) {
                int temp = queue.poll();
                List<Integer> subList = map.get(temp);
                if(subList != null) {
                    for(int j=0; j<subList.size(); j++) {
                        int index = subList.get(j);
                        inDegrees[index]--;
                        if(inDegrees[index] == 0) {
                            queue.offer(index);
                        }
                    }
                }
            }
        }
        for(int i=0; i<inDegrees.length;i++) {
            if(inDegrees[i] > 0) {
                return -1;
            }
        }
        return ans;
    }
    public static void main(String [] args) {
        int [][]test = {
                {1,2},
                {2,3},
                {3,1}
        };
        ParallelCourses parallelCourses = new ParallelCourses();
        System.out.println(parallelCourses.minimumSemesters(3, test));
    }
}
