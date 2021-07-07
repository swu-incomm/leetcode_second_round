/**
 * Given the edges of a directed graph where edges[i] = [ai, bi] indicates there is an edge between nodes ai and bi,
 * and two nodes source and destination of this graph, determine whether or not all paths starting from source eventually,
 * end at destination, that is:
 *
 * At least one path exists from the source node to the destination node
 * If a path exists from the source node to a node with no outgoing edges, then that node is equal to destination.
 * The number of possible paths from source to destination is a finite number.
 * Return true if and only if all roads from source lead to destination.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: n = 3, edges = [[0,1],[0,2]], source = 0, destination = 2
 * Output: false
 * Explanation: It is possible to reach and get stuck on both node 1 and node 2.
 * Example 2:
 *
 *
 * Input: n = 4, edges = [[0,1],[0,3],[1,2],[2,1]], source = 0, destination = 3
 * Output: false
 * Explanation: We have two possibilities: to end at node 3, or to loop over node 1 and node 2 indefinitely.
 * Example 3:
 *
 *
 * Input: n = 4, edges = [[0,1],[0,2],[1,3],[2,3]], source = 0, destination = 3
 * Output: true
 * Example 4:
 *
 *
 * Input: n = 3, edges = [[0,10],[1,1],[1,2]], source = 0, destination = 2
 * Output: false
 * Explanation: All paths from the source node end at the destination node, but there are an infinite number of paths,
 * such as 0-1-2, 0-1-1-2, 0-1-1-1-2, 0-1-1-1-1-2, and so on.
 * Example 5:
 *
 *
 * Input: n = 2, edges = [[0,1],[1,1]], source = 0, destination = 1
 * Output: false
 * Explanation: There is infinite self-loop at destination node.
 *
 *
 * Constraints:
 *
 * 1 <= n <= 104
 * 0 <= edges.length <= 104
 * edges.length == 2
 * 0 <= ai, bi <= n - 1
 * 0 <= source <= n - 1
 * 0 <= destination <= n - 1
 * The given graph may have self-loops and parallel edges.
 */
import java.util.*;
public class AllPathsFromSourceLeadToDestination {
    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        List<Integer> [] adjList = buildGraph(n, edges);
        return dfsThreeColor(adjList, source, destination, new int [n]);
    }

    public List<Integer> [] buildGraph(int n, int [][] edges) {
        List<Integer> [] adjList = new List[n];
        for(int i=0; i<n; i++) adjList[i] = new ArrayList<>();
        for(int [] edge : edges) {
            int source = edge[0];
            int destination = edge[1];
            adjList[source].add(destination);
        }
        return adjList;
    }

    /**
     *
     * @param adjList
     * @param source
     * @param destination
     * @param colors
     * @return
     *
     * three color algorithm runs in dfs
     * initially all nodes are marked as white(color == 0)
     * while you traverse, this current node will become 1(grey)
     * if in the recursion, you found any neighber node is already marked as grey(1)
     * it means their is a cycle in the directed graph we need to return false
     * otherwise, for any destination nodes (for which subnodes list is null in the adjList)
     * we only need to check if the destination node is equal to the value given in the problem
     */
    public boolean dfsThreeColor(List<Integer> [] adjList, int source, int destination, int [] colors) {
        if(colors[source] == 1) {
            return false;
        }

        if(adjList[source].size() == 0) {
            return source == destination;
        }

        List<Integer> subNodes = adjList[source];
        colors[source] = 1;
        boolean res = true;
        for(int i=0; i<subNodes.size(); i++) {
            if(!dfsThreeColor(adjList, subNodes.get(i), destination, colors)) {
                return false;
            }
        }
        colors[source] = 2;
        return res;
    }

}
