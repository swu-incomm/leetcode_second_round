import java.util.PriorityQueue;

/**
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 * Example 1:
 *
 * Input: [3,2,1,5,6,4] and k = 2
 * Output: 5
 * Example 2:
 *
 * Input: [3,2,3,1,2,4,5,5,6] and k = 4
 * Output: 4
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ array's length.
 */
public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length == 0) return Integer.MAX_VALUE;
        return quickSelect(nums, nums.length - k, 0, nums.length -1);
    }

    public int quickSelect(int [] nums, int k, int start, int end) {
        if(start > end) return Integer.MAX_VALUE;
        int startTemp = start;
        int pivot = nums[end];
        int left = start;
        while(start < end) {
            if(nums[start] < pivot) {
                swap(nums, left++, start);
            }
            start++;
        }
        swap(nums, left, end);
        if(left == k) return nums[left];
        if(left < k) return quickSelect(nums, k, left +1 , end);
        return quickSelect(nums, k, startTemp,left-1 );
    }
    public void swap(int [] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public int findKthLargestHeap(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(k+1);
        for(int i = 0; i<nums.length;i++) {
            heap.add(nums[i]);
            if(heap.size() > k) {
                heap.poll();
            }
        }
        return heap.peek();
    }
    public static void main(String [] args) {
        int [] test = new int [] {3, 5, 7, 2, 4, 11, 19, 16};
        KthLargestElementInAnArray kthLargestElementInAnArray =new KthLargestElementInAnArray();
        System.out.println(kthLargestElementInAnArray.findKthLargest(test, 4));
    }
}
