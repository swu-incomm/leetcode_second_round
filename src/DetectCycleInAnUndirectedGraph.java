/**
 * Given an undirected graph, how to check if there is a cycle in the graph?
 * Example,
 *
 * Input: n = 4, e = 4
 * Output: Yes
 * Explanation:
 * 0 1, 1 2, 2 3, 0 2
 * Diagram:
 *
 *
 *
 *
 * The diagram clearly shows a cycle 0 to 2 to 1 to 0
 * Input:n = 4, e = 3
 * 0 1, 1 2, 2 3
 * Output:No
 * Explanation:
 * Diagram:
 *
 *
 *
 *
 * adjacent list
 * adjacent matrix
 * The diagram clearly shows no cycle
 */
import java.util.*;
public class DetectCycleInAnUndirectedGraph {
    List<Integer> [] adjacentList;
    public boolean isCycle(int n, int [][] edges) {
         this.adjacentList= new ArrayList [n];
        for(int i=0; i<adjacentList.length; i++) {
            adjacentList[i] = new ArrayList<>();
        }
        for(int [] i: edges) {
            int start = i[0];
            int end = i[1];
            adjacentList[start].add(end);
            adjacentList[end].add(start);
        }

        boolean [] visited = new boolean[n];

        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                if(dfs(i, visited, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(int v, boolean [] visited, int parent ) {
        visited[v] = true;
        List<Integer> connectedVertex = this.adjacentList[v];
        for(int i=0; i<connectedVertex.size(); i++) {
            int node = connectedVertex.get(i);
            if(!visited[node]) {
                if(dfs(node, visited, v)) {
                    return true;
                }
            } else if(parent != node){
                return true;
            }
        }
        return false;
    }

    public static void main(String [] args) {
        int [][] test = {{1, 2}, {0, 1}, {0, 2}, {2, 3}};
        DetectCycleInAnUndirectedGraph detectCycleInAnUndirectedGraph = new DetectCycleInAnUndirectedGraph();
        System.out.println(detectCycleInAnUndirectedGraph.isCycle(4, test));
    }
}
