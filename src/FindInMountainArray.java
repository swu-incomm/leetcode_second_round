/**
 * (This problem is an interactive problem.)
 *
 * You may recall that an array A is a mountain array if and only if:
 *
 * A.length >= 3
 * There exists some i with 0 < i < A.length - 1 such that:
 * A[0] < A[1] < ... A[i-1] < A[i]
 * A[i] > A[i+1] > ... > A[A.length - 1]
 * Given a mountain array mountainArr, return the minimum index such that mountainArr.get(index) == target.
 * If such an index doesn't exist, return -1.
 *
 * You can't access the mountain array directly.  You may only access the array using a MountainArray interface:
 *
 * MountainArray.get(k) returns the element of the array at index k (0-indexed).
 * MountainArray.length() returns the length of the array.
 * Submissions making more than 100 calls to MountainArray.get will be judged Wrong Answer.
 * Also, any solutions that attempt to circumvent the judge will result in disqualification.
 *
 *
 *
 * Example 1:
 *
 * Input: array = [1,2,3,4,5,3,1], target = 3
 * Output: 2
 * Explanation: 3 exists in the array, at index=2 and index=5. Return the minimum index, which is 2.
 * Example 2:
 *
 * Input: array = [0,1,2,4,2,1], target = 3
 * Output: -1
 * Explanation: 3 does not exist in the array, so we return -1.
 *
 *
 * Constraints:
 *
 * 3 <= mountain_arr.length() <= 10000
 * 0 <= target <= 10^9
 * 0 <= mountain_arr.get(index) <= 10^9
 */
public class FindInMountainArray {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int start = 0, end = mountainArr.length() -1;
        //1st step, find peak
        //bs search in left
        //bs search in right
        while(start < end) {
            int mid = start + (end - start)/2;
            if(mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        int resLeft = findLeft(target, mountainArr, start);
        int resRight = findRight(target, mountainArr, start + 1);
        if(resLeft != -1) return resLeft;
        if(resRight != -1) return resRight;
        return -1;
    }

    public int findLeft(int target, MountainArray mountainArr, int p) {
        int start = 0, end = p;
        while(start <= end) {
            int mid = start + (end - start)/2;
            if(mountainArr.get(mid) == target) {
                return mid;
            }
            else if(mountainArr.get(mid) < target) {
                start = mid + 1;
            }else {
                end = mid - 1;
            }
        }
        return -1;
    }

    public int findRight(int target, MountainArray mountainArr, int p) {
        int start = p, end = mountainArr.length() -1;
        while(start <= end) {
            int mid = start + (end - start)/2;
            if(mountainArr.get(mid) == target) {
                return mid;
            }
            else if(mountainArr.get(mid) < target) {
                end = mid - 1;
            }else {
                start = mid + 1;
            }
        }
        return -1;
    }
}
interface MountainArray {
    public int get(int index);
    public int length();
}