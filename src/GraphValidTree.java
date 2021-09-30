/**
 * You have a graph of n nodes labeled from 0 to n - 1. You are given an integer n and a list of edges where edges[i] = [ai, bi]
 * indicates that there is an undirected edge between nodes ai and bi in the graph.
 *
 * Return true if the edges of the given graph make up a valid tree, and false otherwise.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: n = 5, edges = [[0,1],[0,2],[0,3],[1,4]]
 * Output: true
 * Example 2:
 *
 *
 * Input: n = 5, edges = [[0,1],[1,2],[2,3],[1,3],[1,4]]
 * Output: false
 *
 *
 * Constraints:
 *
 * 1 <= 2000 <= n
 * 0 <= edges.length <= 5000
 * edges[i].length == 2
 * 0 <= ai, bi < n
 * ai != bi
 * There are no self-loops or repeated edges.
 */
import java.util.*;
public class GraphValidTree {
    public boolean validTreeUnionAndFind(int n, int[][] edges) {
        int [] table = new int [n];
        for(int i=0; i<n;i++) {
            table[i] = i;
        }

        for(int [] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            if(!union(table, a, b)) {
              return false;
            }
        }
        Set <Integer> set = new HashSet<>();
        for(int i : table) {
            set.add(find(table, i));
        }
        return set.size() == 1 ? true : false;
    }

    public int find(int [] table, int a) {
        if(table[a] == a) return a;
        return find(table, table[a]);
    }

    public boolean union (int [] table, int a, int b) {
        int parentA = find(table, a);
        int parentB = find(table, b);
        if(parentA == parentB) return false;
        table[parentB] = parentA;
        return true;
    }

    public static void main(String [] args) {
        int [][] edges = {{0, 1}, {2, 3}, {1, 2}};
        GraphValidTree g = new GraphValidTree();
        g.validTree(4, edges);
    }

    // Recursive DFS
    public boolean validTreeRec(int n, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0; i<n; i++) adjList.add(new ArrayList<>());
        for(int [] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        boolean [] visited = new boolean[n];
        if(!dfs(adjList, -1, visited, 0)) {
            for(boolean i : visited) {
                if(!i)return false;
            }
            return true;
        }
        return false;
    }

    public boolean dfs(List<List<Integer>> adjList, int parent, boolean[] visited, int node) {
        visited[node] = true;
        List<Integer> list = adjList.get(node);
        for(int i=0; i<list.size(); i++) {
            int temp = list.get(i);
            if(parent != temp && visited[temp]) return true;
            if(!visited[temp] && dfs(adjList, node, visited, temp)) {
                return true;
            }
        }
        return false;
    }

    //iterative solution
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0; i<n; i++) adjList.add(new ArrayList<>());
        for(int [] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        Map<Integer, Integer> parent = new HashMap<>();
        parent.put(0, -1);

        while(!stack.isEmpty()) {
            int node = stack.pop();
            List<Integer> list = adjList.get(node);
            for(int i : list) {
                if(parent.get(node) == i) {
                    continue;
                }
                if(parent.containsKey(i)) {
                    return false;
                }
                stack.push(i);
                parent.put(i, node);
            }
        }
        return parent.size() == n;
    }
}
