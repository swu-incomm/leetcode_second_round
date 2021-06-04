import java.util.HashMap;

/**
 * There is a row of n houses, where each house can be painted one of three colors: red, blue, or green.
 * The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.
 *
 * The cost of painting each house with a certain color is represented by an n x 3 cost matrix costs.
 *
 * For example, costs[0][0] is the cost of painting house 0 with the color red; costs[1][2] is the cost of painting house
 * 1 with color green, and so on...
 * Return the minimum cost to paint all houses.
 *
 *
 *
 * Example 1:
 *
 * Input: costs = [[17,2,17],[16,16,5],[14,3,19]]
 * Output: 10
 * Explanation: Paint house 0 into blue, paint house 1 into green, paint house 2 into blue.
 * Minimum cost: 2 + 5 + 3 = 10.
 * Example 2:
 *
 * Input: costs = [[7,6,2]]
 * Output: 2
 *
 *
 * Constraints:
 *
 * costs.length == n
 * costs[i].length == 3
 * 1 <= n <= 100
 * 1 <= costs[i][j] <= 20
 */
public class PaintHouse {
    public int minCost(int[][] costs) {
        int row = costs.length-2;
        for(int i = row; i>=0; i--) {
            costs[i][0] += Math.min(costs[i+1][1], costs[i+1][2]);
            costs[i][1] += Math.min(costs[i+1][0], costs[i+1][2]);
            costs[i][2] += Math.min(costs[i+1][0], costs[i+1][1]);
        }
        return Math.min(Math.min(costs[0][0], costs[0][1]), costs[0][2]);
    }

    HashMap<String, Integer> memo = new HashMap<>();
    public int minCostDFS(int[][] costs) {
        int ans;
        ans = Math.min(Math.min(backtrack(costs, 0, 0),backtrack(costs, 0, 1)),backtrack(costs, 0,  2));
        return ans;
    }

    public int backtrack(int [][] costs,int row, int index) {
        if (memo.containsKey(getKey(row, index))) {
            return memo.get(getKey(row, index));
        }
        int totalCost = costs[row][index];
        if(row != costs.length-1) {
            if(index == 0) {
                totalCost+= Math.min(backtrack(costs,  row + 1, 1), backtrack(costs,  row + 1, 2));
            }
            else if(index == 1) {
                totalCost +=  Math.min(backtrack(costs,  row + 1, 0), backtrack(costs,  row + 1, 2));
            }
            else if(index == 2) {
                totalCost +=  Math.min(backtrack(costs,  row + 1, 0), backtrack(costs,  row + 1, 1));
            }
            memo.put(getKey(row, index), totalCost);
        }
        return totalCost;
    }
    private String getKey(int n, int color) {
        return n + " " + color;
    }

}
