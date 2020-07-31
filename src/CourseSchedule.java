

import java.util.*;


/**
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses-1.
 *
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1,
 * which is expressed as a pair: [0,1]
 *
 * Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
 *
 *
 *
 * Example 1:
 *
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: true
 * Explanation: There are a total of 2 courses to take.
 *              To take course 1 you should have finished course 0. So it is possible.
 * Example 2:
 *
 * Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
 * Output: false
 * Explanation: There are a total of 2 courses to take.
 *              To take course 1 you should have finished course 0, and to take course 0 you should
 *              also have finished course 1. So it is impossible.
 *
 *
 * Constraints:
 *
 * The input prerequisites is a graph represented by a list of edges, not adjacency matrices.
 * Read more about how a graph is represented.
 * You may assume that there are no duplicate edges in the input prerequisites.
 * 1 <= numCourses <= 10^5
 */
public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites == null || prerequisites.length == 0) return true;
        HashMap<Integer, List<Integer>> relations = new HashMap<>();
        int [] courseDependence = new int [numCourses];
        for(int [] pre : prerequisites) {
            if(!relations.containsKey(pre[1])) {
                List<Integer> list = new ArrayList<>();
                relations.put(pre[1], list);
            }
            relations.get(pre[1]).add(pre[0]);
            ++courseDependence[pre[0]];
        }
        //for(int i : courseDependence) System.out.println(i);
        Queue <Integer> queue = new LinkedList();
        for(int i = 0; i<numCourses;i++) {
            if(courseDependence[i] == 0) {
                queue.offer(i);
            }
        }
        while(!queue.isEmpty()) {
            int temp = queue.poll();
            List<Integer> courses = relations.get(temp);
            if(courses == null) continue;
            for(int i: courses) {
                courseDependence[i]--;
                if(courseDependence[i] == 0) {
                    queue.offer(i);
                }
            }
        }
        for(int i:courseDependence) if(i!=0) return false;
        return true;
    }

    public static void main(String [] args) {
        int [][] coursesprerequisites = {{1, 0}};
        int num = 2;
        CourseSchedule courseSchedule = new CourseSchedule();
        courseSchedule.canFinish(num, coursesprerequisites);
    }
}
