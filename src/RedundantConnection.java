import java.util.Objects;

/**
 * In this problem, a tree is an undirected graph that is connected and has no cycles.
 *
 * You are given a graph that started as a tree with n nodes labeled from 1 to n,
 * with one additional edge added. The added edge has two different vertices chosen from 1 to n,
 * and was not an edge that already existed. The graph is represented as an array edges of length n where edges[i] = [ai, bi]
 * indicates that there is an edge between nodes ai and bi in the graph.
 *
 * Return an edge that can be removed so that the resulting graph is a tree of n nodes.
 * If there are multiple answers, return the answer that occurs last in the input.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: edges = [[1,2],[1,3],[2,3]]
 * Output: [2,3]
 * Example 2:
 *
 *
 * Input: edges = [[1,2],[2,3],[3,4],[1,4],[1,5]]
 * Output: [1,4]
 *
 *
 * Constraints:
 *
 * n == edges.length
 * 3 <= n <= 1000
 * edges[i].length == 2
 * 1 <= ai < bi <= edges.length
 * ai != bi
 * There are no repeated edges.
 * The given graph is connected.
 */
public class RedundantConnection {
    public int[] findRedundantConnection(int[][] edges) {
        int [] ans = {-1, -1};
        int [] table = new int [edges.length+1];
        for(int i=1; i<=edges.length;i++) table[i] = i;
        for(int edge [] : edges) {
            int node1 = edge[0];
            int node2 = edge[1];
            int parent1 = find(table, node1);
            int parent2 = find(table, node2);
            if(parent1 == parent2) {
                ans = edge;
            }
            union(table, parent1, parent2);
        }
        return ans;
    }

    public int find(int [] table, int node) {
        if(table[node] == node) return node;
        return find(table, table[node]);
    }
    public void union(int []table, int node1, int node2) {
        int parent1 = find(table, node1);
        int parent2 = find(table, node2);
        table[parent2] = parent1;
    }

    private String a;
    private String b;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RedundantConnection that = (RedundantConnection) o;
        return Objects.equals(a, that.a) &&
                Objects.equals(b, that.b);
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b);
    }
}
