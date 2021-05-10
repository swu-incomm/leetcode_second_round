/**
 * Given an array of integers target. From a starting array, A consisting of all 1's,
 * you may perform the following procedure :
 *
 * let x be the sum of all elements currently in your array.
 * choose index i, such that 0 <= i < target.size and set the value of A at index i to x.
 * You may repeat this procedure as many times as needed.
 * Return True if it is possible to construct the target array from A otherwise return False.
 *
 *
 *
 * Example 1:
 *
 * Input: target = [9,3,5]
 * Output: true
 * Explanation: Start with [1, 1, 1]
 * [1, 1, 1], sum = 3 choose index 1
 * [1, 3, 1], sum = 5 choose index 2
 * [1, 3, 5], sum = 9 choose index 0
 * [9, 3, 5] Done
 * Example 2:
 *
 * Input: target = [1,1,1,2]
 * Output: false
 * Explanation: Impossible to create target array from [1,1,1,1].
 * Example 3:
 *
 * Input: target = [8,5]
 * Output: true
 *
 *
 * Constraints:
 *
 * N == target.length
 * 1 <= target.length <= 5 * 10^4
 * 1 <= target[i] <= 10^9
 */
public class ConstructTargetArrayWithMultipleSums {
    public boolean isPossible(int[] target) {
        int max = 0;
        long sum = 0;
        for(int i=0; i<target.length; i++) {
            sum += target[i];
            if(target[i] > target[max]) {
                max=i;
            }
        }
        long diff = sum - target[max];
        //if the maximum number in the array is 1, which means all values are one ([0, 1] is not gonna happen in the first round)
        //if the diff is 1, which means the situation is like [1, 99].
        //if diff > target[max] then after substraction, the value is minus integer return false
        // diff == 0 is happening for [2, 4] or [2]
        //target[max] % diff is for optimization, we don't want to substract in each recursive call, if (target[max] > diff), we can simplly
        //using mod, and if the mod result is 0, the final situation will be like [2, 4] -> [2, 0]
        if(target[max] == 1 || diff == 1) return true;
        if(diff > target[max] || diff == 0 || target[max]%diff==0) return false;
        target[max] %= diff;

        return isPossible(target);
    }

    public boolean checkAllOnes(int [] target) {
        for(int i:target) {
            if(i != 1) return false;
        }
        return true;
    }

    public static void main(String [] args) {
        int [] test = {9, 3, 5};
        ConstructTargetArrayWithMultipleSums c = new ConstructTargetArrayWithMultipleSums();
        c.isPossible(test);
    }
}
