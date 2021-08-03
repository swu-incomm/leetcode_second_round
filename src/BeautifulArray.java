/**
 * An array nums of length n is beautiful if:
 *
 * nums is a permutation of the integers in the range [1, n].
 * For every 0 <= i < j < n, there is no index k with i < k < j where 2 * nums[k] == nums[i] + nums[j].
 * Given the integer n, return any beautiful array nums of length n. There will be at least one valid answer for the given n.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 4
 * Output: [2,1,4,3]
 * Example 2:
 *
 * Input: n = 5
 * Output: [3,1,2,5,4]
 *
 *
 * Constraints:
 *
 * 1 <= n <= 1000
 *
 * fomula: odd number: 2 * nums[i] -1
 *         even: 2* nums[i]
 */
import java.util.*;
public class BeautifulArray {
    public int[] beautifulArray(int n) {
        List<Integer> res = new ArrayList<>();
        res.add(1);
        if(n == 1) return new int [] {1};
        for(int i=2; i<=n; i++) {
            List<Integer> temp = new ArrayList<>();
            for(int j=0; j<res.size(); j++) {
                int val = 2 * res.get(j) -1;
                if(val <= n) temp.add(val);
            }
            for(int j=0; j<res.size(); j++) {
                int val = 2 * res.get(j);
                if(val <= n) temp.add(val);
            }
            res = temp;
        }
        int [] ret = new int [res.size()];
        int j=0;
        for(int i : res) ret[j++] = i;
        return ret;
    }
}
