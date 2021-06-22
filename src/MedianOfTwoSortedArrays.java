/**
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
 *
 * The overall run time complexity should be O(log (m+n)).
 *
 *
 *
 * Example 1:
 *
 * Input: nums1 = [1,3], nums2 = [2]
 * Output: 2.00000
 * Explanation: merged array = [1,2,3] and median is 2.
 * Example 2:
 *
 * Input: nums1 = [1,2], nums2 = [3,4]
 * Output: 2.50000
 * Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 * Example 3:
 *
 * Input: nums1 = [0,0], nums2 = [0,0]
 * Output: 0.00000
 * Example 4:
 *
 * Input: nums1 = [], nums2 = [1]
 * Output: 1.00000
 * Example 5:
 *
 * Input: nums1 = [2], nums2 = []
 * Output: 2.00000
 *
 * Constraints:
 *
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -106 <= nums1[i], nums2[i] <= 106
 */
public class MedianOfTwoSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2,nums1);
        }

        int left = 0, right = nums1.length;
        int len = nums1.length + nums2.length;
        int partitionMid = (len+ 1)/2;
        while(left <= right) {
            int mid = left + (right - left) /2;
            int partNums2 = partitionMid - mid;

            int maxNums1Left = (mid == 0) ? Integer.MIN_VALUE : nums1[mid-1];
            int minNums1Right = (mid == nums1.length) ? Integer.MAX_VALUE : nums1[mid];

            int maxNums2Left = (partNums2 == 0) ? Integer.MIN_VALUE : nums2[partNums2-1];
            int minNums2Right = (partNums2 == nums2.length) ? Integer.MAX_VALUE : nums2[partNums2];

            //found the partition point
            if(maxNums1Left <= minNums2Right && maxNums2Left <= minNums1Right ) {
                if(len%2 != 0) {
                    return Math.max(maxNums1Left, maxNums2Left);
                }
                return (double)(Math.max(maxNums1Left, maxNums2Left) + Math.min(minNums1Right, minNums2Right))/2;
            }
            else if(maxNums1Left > minNums2Right) {
                right = mid-1;
            } else if(maxNums2Left > minNums1Right) {
                left = mid + 1;
            }

        }
        return -1;
    }

    public static void main(String [] args) {
        int [] test1 = {};
        int [] test2 = {2};
        findMedianSortedArrays(test2, test1);
    }
}
