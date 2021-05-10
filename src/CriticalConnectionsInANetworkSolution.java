/**
 * There are n servers numbered from 0 to n - 1 connected by undirected server-to-server connections forming
 * a network where connections[i] = [ai, bi] represents a connection between servers ai and bi. Any server can reach other
 * servers directly or indirectly through the network.
 *
 * A critical connection is a connection that, if removed, will make some servers unable to reach some other server.
 *
 * Return all critical connections in the network in any order.
 *
 *
 *
 * Example 1:
 *
 *
 *
 * Input: n = 4, connections = [[0,1],[1,2],[2,0],[1,3]]
 * Output: [[1,3]]
 * Explanation: [[3,1]] is also accepted.
 *
 *
 * Constraints:
 *
 * 2 <= n <= 105
 * n - 1 <= connections.length <= 105
 * 0 <= ai, bi <= n - 1
 * ai != bi
 * There are no repeated connections.
 */
import java.util.*;
public class CriticalConnectionsInANetworkSolution {
    private List<List<Integer>> graph;
    private Map<Integer, Integer> rank;
    private Map<int [], Boolean> connDict;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        this.formGraph(n, connections);
        this.dfs(0, 0);
        List<List<Integer>> result = new ArrayList<>();
        for(int [] edge : connDict.keySet()) {
            if(connDict.get(edge) == true)
            result.add(new ArrayList<Integer>(Arrays.asList(edge[0], edge[1])));
        }
        return result;
    }

    public void formGraph(int n, List<List<Integer>> connections) {
        this.graph = new ArrayList<>();
        this.rank = new HashMap<>();
        this.connDict = new HashMap<>();
        for(int i=0; i<n; i++) {
            List<Integer> subList = new ArrayList<>();
            graph.add(subList);
            rank.put(i, null);
        }
        for(List<Integer> edge : connections) {
            int u = edge.get(0);
            int v = edge.get(1);
            this.graph.get(u).add(v);
            this.graph.get(v).add(u);
            int sortedU = Math.min(u, v);
            int sortedV = Math.max(u, v);
            int [] newEdge = {sortedU, sortedV};
            this.connDict.put(newEdge, true);
        }
    }

    public int dfs(int node, int discoveryRank) {
        if(this.rank.get(node) != null) {
            return this.rank.get(node);
        }

        this.rank.put(node, discoveryRank);

        int minRank = discoveryRank + 1;

        for(Integer neighbor: this.graph.get(node)) {
            Integer neighborRank = this.rank.get(neighbor);
            //discard the parent
            if(neighborRank != null && neighborRank == discoveryRank - 1 ) {
                continue;
            }
            int recursiveRank = dfs(neighbor, discoveryRank + 1);

            if(recursiveRank <= discoveryRank) {
                int sortedU = Math.min(node, neighbor);
                int sortedV = Math.max(node, neighbor);
                for(int [] edge : this.connDict.keySet()) {
                    if(edge[0] == sortedU && edge[1] == sortedV) {
                        connDict.put(edge, false);
                    }
                }
            }
            minRank = Math.min(minRank, recursiveRank);
        }
        return minRank;
    }

    public static void main(String [] args) {
        List<List<Integer>> test = new ArrayList<>();
        List<Integer> sub1 = new ArrayList<>();
        List<Integer> sub2 = new ArrayList<>();
        List<Integer> sub3 = new ArrayList<>();
        List<Integer> sub4 = new ArrayList<>();
        sub1.add(0);
        sub1.add(1);
        sub2.add(1);
        sub2.add(2);
        sub3.add(2);
        sub3.add(0);
        sub4.add(1);
        sub4.add(3);
        test.add(sub1);
        test.add(sub2);
        test.add(sub3);
        test.add(sub4);
        CriticalConnectionsInANetworkSolution criticalConnectionsInANetworkSolution = new CriticalConnectionsInANetworkSolution();
        criticalConnectionsInANetworkSolution.criticalConnections(4, test);
    }
}
