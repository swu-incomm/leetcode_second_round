/**
 * In some array arr, the values were in arithmetic progression: the values arr[i + 1] - arr[i] are all equal for
 * every 0 <= i < arr.length - 1.
 *
 * A value from arr was removed that was not the first or last value in the array.
 *
 * Given arr, return the removed value.
 *
 *
 *
 * Example 1:
 *
 * Input: arr = [5,7,11,13]
 * Output: 9
 * Explanation: The previous array was [5,7,9,11,13].
 * Example 2:
 *
 * Input: arr = [15,13,12]
 * Output: 14
 * Explanation: The previous array was [15,14,13,12].
 *
 *
 * Constraints:
 *
 * 3 <= arr.length <= 1000
 * 0 <= arr[i] <= 105
 * The given array is guaranteed to be a valid array
 */
public class MissingNumberInArithmeticProgression {
    public int missingNumber(int[] arr) {
        int len = arr.length + 1;
        int sum = (arr[0] + arr[arr.length-1]) * len / 2;
        int curSum = 0;
        for(int i: arr) curSum += i;
        return sum - curSum;
    }
}
