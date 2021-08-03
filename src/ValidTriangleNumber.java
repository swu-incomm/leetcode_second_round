/**
 * Given an integer array nums, return the number of triplets chosen from the array that
 * can make triangles if we take them as side lengths of a triangle.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,2,3,4]
 * Output: 3
 * Explanation: Valid combinations are:
 * 2,3,4 (using the first 2)
 * 2,3,4 (using the second 2)
 * 2,2,3
 * Example 2:
 *
 * Input: nums = [4,2,3,4]
 * Output: 4
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 1000
 * 0 <= nums[i] <= 1000
 */
import java.util.*;
public class ValidTriangleNumber {
    /**
    Map<String, Integer> dp = new HashMap<>();
    public int triangleNumber(int[] nums) {
        if(nums.length < 3) {
            return 0;
        }
        return backtrack(new ArrayList<>(), 0, nums);
    }

    public int backtrack(List<Integer> cur, int index, int [] nums) {
        if(cur.size() == 3) {
            return isTriangle(cur) ? 1 : 0;
        }
        String key = "";
        for(int i : cur) {
            key += i;
        }
        key += ","+index;
        if(dp.containsKey(key)) {
            return dp.get(key);
        }
        int res = 0;
        for(int i=index; i<nums.length; i++) {
            cur.add(nums[i]);
            res += backtrack(cur, i+1, nums);
            cur.remove(cur.size()-1);
        }
        dp.put(key, res);
        return res;
    }

    public boolean isTriangle(List<Integer> list) {
        if(list.size() != 3) return false;
        int a = list.get(0);
        int b = list.get(1);
        int c = list.get(2);
        if(a + b <= c) return false;
        if(b + c <=a) return false;
        if(a + c <= b) return false;
        return true;
    }**/
    /**
     *
     * @param nums
     * @return
     *
     * binary search
     */
    public int triangleNumber(int[] nums) {
        if(nums.length < 3) return 0;
        int res = 0;
        Arrays.sort(nums);
        for(int i=0; i<nums.length; i++) {
            if(nums[i] == 0) continue;
            for(int j= i+1; j<nums.length-1; j++) {
                int cur = nums[i] + nums[j];
                int start = j + 1;
                int end = nums.length-1;
                while(start <= end) {
                    int mid = start + (end - start)/2;
                    if(nums[mid] >= cur) {
                        end = mid-1;
                    } else {
                        start= mid+1;
                    }
                }
                res+= start - j -1;
            }
        }
        return res;
    }
}
