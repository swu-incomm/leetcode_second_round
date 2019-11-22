/*
Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:

The number of elements initialized in nums1 and nums2 are m and n respectively.
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
Example:

Input:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

Output: [1,2,2,3,5,6]
 */
public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(nums2 == null || nums2.length == 0 || nums1 == null || nums1.length == 0) return;
        int l1 = m-1, l2 = n-1, index = m+n-1;
        while(l1 >=0 && l2>=0) {
           // System.out.println(index + " " + l1 + " " + l2 );
            nums1[index--] = (nums1[l1] >= nums2[l2]) ? nums1[l1--] : nums2[l2--];
        }
        if(l1 < 0) {
            for(int i = index; i>=0;i--)
                nums1[i] = nums2[l2--];
        }
        //for(int i : nums1) System.out.println(i);
    }

    public static void main(String [] args) {
        MergeSortedArray mergeTwoSortedLists = new MergeSortedArray();
        int [] nums1 = new int []{4,5,6,0,0,0};
        int [] nums2 = new int []{1,2,3};
        mergeTwoSortedLists.merge(nums1,3,nums2, 3);
    }
}
