import java.util.*;

/**
 * There are a total of n courses you have to take, labeled from 0 to n-1.
 *
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1,
 * which is expressed as a pair: [0,1]
 *
 * Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take
 * to finish all courses.
 *
 * There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all
 * courses, return an empty array.
 *
 * Example 1:
 *
 * Input: 2, [[1,0]]
 * Output: [0,1]
 * Explanation: There are a total of 2 courses to take. To take course 1 you should have finished
 *              course 0. So the correct course order is [0,1] .
 * Example 2:
 *
 * Input: 4, [[1,0],[2,0],[3,1],[3,2]]
 * Output: [0,1,2,3] or [0,2,1,3]
 * Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both
 *              courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
 *              So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3] .
 * Note:
 *
 * The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how
 * a graph is represented.
 * You may assume that there are no duplicate edges in the input prerequisites.
 */
public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if(numCourses <=0) return new int[0];
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int [] counts = new int [numCourses];
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i<prerequisites.length; i++) {
            ++counts[prerequisites[i][0]];
           if(!map.containsKey(prerequisites[i][1])) {
               List<Integer> list = new ArrayList<>();
               map.put(prerequisites[i][1], list);
           }
           map.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i<counts.length; i++) {
            if(counts[i] == 0) {
                queue.offer(i);
            }
        }

        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i<size; i++) {
                int preCourse = queue.poll();
                ans.add(preCourse);
                List<Integer> subCourses = map.get(preCourse);
                if(subCourses == null || subCourses.size() == 0) continue;
                for(int j : subCourses) {
                    --counts[j];
                    if(counts[j] == 0) {
                        queue.offer(j);
                    }
                }
            }
        }

        for(int i : counts) {
            if(i != 0) {
                return new int[0];
            }
        }
        //list of Integer to array of int
        return ans.stream().mapToInt(i->i).toArray();
    }

    public static void main(String [] args) {
        int [][] test = {{1, 0}};
        CourseScheduleII courseScheduleII = new CourseScheduleII();
        courseScheduleII.findOrder(2, test);
    }
}
