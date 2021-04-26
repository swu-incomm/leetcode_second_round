import java.util.HashMap;

/**
 * Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.
 *
 * Example 1:
 *
 * Input:nums = [1,1,1], k = 2
 * Output: 2
 *
 *
 * Constraints:
 *
 * The length of the array is in range [1, 20,000].
 * The range of numbers in the array is [ e range of the integer k is [-1e7, 1e7].
 */
public class SubarraySumEqualsK {

    //solution 1, cumulative sum
    public int subarraySumCumulativeSumMemo(int[] nums, int k) {
        int [] cumulativeSum = new int [nums.length];
        int count = 0;
        cumulativeSum[0] = nums[0];
        for(int i = 1; i<cumulativeSum.length; i++) {
           cumulativeSum[i] += nums[i] + cumulativeSum[i-1];
        }
        for(int i : cumulativeSum) {
            System.out.println(i);
        }
        for(int i=0; i<nums.length; i++) {
            for(int j=i; j<nums.length; j++) {
                int tempSum;
                if(i != j) {
                    if(i != 0) {
                        tempSum = cumulativeSum[j] - cumulativeSum[i-1];
                    } else {
                        tempSum = cumulativeSum[j];
                    }
                } else {
                    tempSum = nums[i];
                }
                if(tempSum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    //solution 2, cumulative sum no memo
    public int subarraySumCumulativeSumNoMemo(int[] nums, int k) {
        int count = 0;
        for(int i=0; i<nums.length; i++) {
            int cumuBase = 0;
            for(int j=i; j<nums.length; j++) {
                cumuBase+=nums[j];
                if (cumuBase == k)
                    count++;
            }
        }
        return count;
    }

    //hash map
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> accumulativeSumMap = new HashMap<>();
        int ans = 0, temp = 0;
        accumulativeSumMap.put(0, 1);
        for(int i = 0; i<nums.length; i++) {
            temp += nums[i];
            if(accumulativeSumMap.containsKey(temp - k)) {
                ans += accumulativeSumMap.get(temp - k);
            }
            accumulativeSumMap.put(temp, accumulativeSumMap.getOrDefault(temp, 0) + 1);
        }
        return ans;
    }
    public static void main(String [] args) {
        SubarraySumEqualsK subarraySumEqualsK = new SubarraySumEqualsK();
        int [] test = {1, 1, 1};
        System.out.println(subarraySumEqualsK.subarraySumCumulativeSumMemo(test, 2));
    }
}
