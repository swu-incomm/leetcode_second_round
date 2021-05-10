/**
 * You have a graph of n nodes. You are given an integer n and an array edges where edges[i] = [ai, bi]
 * indicates that there is an edge between ai and bi in the graph.
 *
 * Return the number of connected components in the graph.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: n = 5, edges = [[0,1],[1,2],[3,4]]
 * Output: 2
 * Example 2:
 *
 *
 * Input: n = 5, edges = [[0,1],[1,2],[2,3],[3,4]]
 * Output: 1
 *
 *
 * Constraints:
 *
 * 1 <= n <= 2000
 * 1 <= edges.length <= 5000
 * edges[i].length == 2
 * 0 <= ai <= bi < n
 * ai != bi
 * There are no repeated edges.
 */
import java.util.*;
public class NumberOfConnectedComponents {
    //Solution one union and find
    public int countComponents(int n, int[][] edges) {
        int [] ids = new int [n];
        for(int i=0; i<n; i++) ids[i] = i;
        for(int [] edge : edges) {
            union(edge[0], edge[1], ids);
        }
        Set<Integer> set = new HashSet<>();
        for(int i : ids) set.add(find(ids[i], ids));
        return set.size();
    }

    public void union(int node1, int node2, int [] ids) {
        int parentOfNode1 = find(node1, ids);
        int parentOfNode2 = find(node2, ids);
        ids[parentOfNode1] = parentOfNode2;
    }

    public int find(int node, int [] ids) {
        if(ids[node] != node) return find(ids[node], ids);
        return node;
    }


    //solution 2 DFS
    public int countComponentsDFS(int n, int[][] edges) {
       int [] visited = new int [n];
       List<List<Integer>> adjList = new ArrayList<>();
       for(int i=0; i<n; i++) {
           List<Integer> list = new ArrayList<>();
           adjList.add(list);
       }
       for(int [] edge : edges) {
           int node1 = edge[0];
           int node2 = edge[1];
           adjList.get(node1).add(node2);
           adjList.get(node2).add(node1);
       }
       int ans= 0;
       for(int i=0; i<n; i++) {
           if(visited[i] == 0) {
               ans++;
               dfs(i, visited, adjList);
           }
       }
       return ans;
    }

    public void dfs(int node, int [] visited, List<List<Integer>> adjList) {
        visited[node] =1;
        List<Integer> subList = adjList.get(node);
        if(subList.size() > 0) {
            for(int i=0; i<subList.size(); i++) {
                int connectedNode = subList.get(i);
                if(visited[connectedNode] == 0) {
                    dfs(connectedNode, visited, adjList);
                }
            }
        }
    }
}
