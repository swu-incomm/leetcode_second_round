/**
 * There are n houses in a village. We want to supply water for all the houses by building wells and laying pipes.
 *
 * For each house i, we can either build a well inside it directly with cost wells[i - 1] (note the -1 due to 0-indexing),
 * or pipe in water from another well to it. The costs to lay pipes between houses are given by the array pipes, where each pipes[j] = [house1j, house2j, costj] represents the cost to connect house1j and house2j together using a pipe. Connections are bidirectional.
 *
 * Return the minimum total cost to supply water to all houses.
 *
 *
 *
 * Example 1:
 *
 *
 *
 * Input: n = 3, wells = [1,2,2], pipes = [[1,2,1],[2,3,1]]
 * Output: 3
 * Explanation:
 * The image shows the costs of connecting houses using pipes.
 * The best strategy is to build a well in the first house with cost 1 and connect the other houses to
 * it with cost 2 so the total cost is 3.
 *
 *
 * Constraints:
 *
 * 1 <= n <= 104
 * wells.length == n
 * 0 <= wells[i] <= 105
 * 1 <= pipes.length <= 104
 * pipes[j].length == 3
 * 1 <= house1j, house2j <= n
 * 0 <= costj <= 105
 * house1j != house2j
 */
import java.util.*;
public class OptimizeWaterDistributionInAVillage {
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        List<int []> edges = new ArrayList<>();
        for(int i=0; i<wells.length; i++) {
            edges.add(new int [] {0, i + 1, wells[i]});
        }
        for(int [] ed : pipes) {
            edges.add(ed);
        }
        Collections.sort(edges, Comparator.comparingInt(a -> a[2]));
        int res = 0;
        UnionFind unionFind = new UnionFind(n);
        for(int i=0; i<edges.size(); i++) {
            int [] tempEdge = edges.get(i);
            if(unionFind.union(tempEdge[0], tempEdge[1])) {
                res+= tempEdge[2];
            }
        }
        return res;
    }
}

class UnionFind {
    int [] group;
    int [] rank;

    public UnionFind(int n) {
        group = new int [n + 1];
        rank = new int [n + 1];
        for(int i=0; i<n + 1; i++) {
            group[i] = i;
            rank[i] = 0;
        }
    }

    public int find (int i) {
        if(group[i] == i) {
            return i;
        }
        return find(group[i]);
    }

    public boolean union(int a, int b) {
        int groupA = find(a);
        int groupB = find(b);
        if(groupA != groupB) {
            if(rank[groupA] > rank[groupB]) {
                group[groupB] = groupA;
            } else if (rank[groupB] > rank[groupA]) {
                group[groupA] = groupB;
            } else {
                group[groupA] = groupB;
                rank[groupB]++;
            }
            return true;
        }
        return false;
    }
}
