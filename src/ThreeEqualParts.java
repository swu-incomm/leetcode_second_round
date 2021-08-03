/**
 * You are given an array arr which consists of only zeros and ones, divide the array into
 * three non-empty parts such that all of these parts represent the same binary value.
 *
 * If it is possible, return any [i, j] with i + 1 < j, such that:
 *
 * arr[0], arr[1], ..., arr[i] is the first part,
 * arr[i + 1], arr[i + 2], ..., arr[j - 1] is the second part, and
 * arr[j], arr[j + 1], ..., arr[arr.length - 1] is the third part.
 * All three parts have equal binary values.
 * If it is not possible, return [-1, -1].
 *
 * Note that the entire part is used when considering what binary value it represents.
 * For example, [1,1,0] represents 6 in decimal, not 3. Also, leading zeros are allowed,
 * so [0,1,1] and [1,1] represent the same value.
 *
 *
 *
 * Example 1:
 *
 * Input: arr = [1,0,1,0,1]
 * Output: [0,3]
 * Example 2:
 *
 * Input: arr = [1,1,0,1,1]
 * Output: [-1,-1]
 * Example 3:
 *
 * Input: arr = [1,1,0,0,1]
 * Output: [0,2]
 *
 *
 * Constraints:
 *
 * 3 <= arr.length <= 3 * 104
 * arr[i] is 0 or 1
 *
 *
 *
 * key to solve this problem
 * 1. leading zeroes doesn't effect the value of a binary number
 * 2. only trailing zeroes matters
 * 3. three parts should have equal nums of 1's
 * 4. we find the first occurance of 1's in three parts and start processing from there
 * 5. use three pointers to move forward and "we should see every value in the three pointer should be identical "until the third pointer reached the end of the array
 */
public class ThreeEqualParts {
    public int[] threeEqualParts(int[] arr) {
        int countOfOnes = 0;
        int [] res = {-1, -1};
        for(int i : arr) {
            countOfOnes+=i;
        }
        //no ones
        if(countOfOnes == 0) {
            res [0] = 0;
            res[1] = arr.length-1;
            return res;
        }
        //not multiply by three
        if(countOfOnes%3 != 0) {
            return res;
        }
        countOfOnes/=3;
        int start0 = -1;
        int start1 = -1;
        int start2 = -1;
        int count = 0;
        for(int i=0; i<arr.length; i++) {
            if(arr[i] == 1) {
                count++;
                if(count == 1) {
                    start0 = i;
                } else if(count == countOfOnes + 1) {
                    start1 = i;
                } else if(count == 2 * countOfOnes + 1) {
                    start2 = i;
                }
            }
        }

        while(start2 < arr.length) {
            if(arr[start0] != arr[start1] || arr[start0] != arr[start2]) return res;
            start0++;
            start1++;
            start2++;
        }
        res[0] = start0-1;
        res[1] = start1;
        return res;
    }
}
