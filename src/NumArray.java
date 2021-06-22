/**
 * Given an integer array nums, handle multiple queries of the following types:
 *
 * Update the value of an element in nums.
 * Calculate the sum of the elements of nums between indices left and right inclusive where left <= right.
 * Implement the NumArray class:
 *
 * NumArray(int[] nums) Initializes the object with the integer array nums.
 * void update(int index, int val) Updates the value of nums[index] to be val.
 * int sumRange(int left, int right) Returns the sum of the elements of nums between indices left
 * and right inclusive (i.e. nums[left] + nums[left + 1] + ... + nums[right]).
 *
 *
 * Example 1:
 *
 * Input
 * ["NumArray", "sumRange", "update", "sumRange"]
 * [[[1, 3, 5]], [0, 2], [1, 2], [0, 2]]
 * Output
 * [null, 9, null, 8]
 *
 * Explanation
 * NumArray numArray = new NumArray([1, 3, 5]);
 * numArray.sumRange(0, 2); // return 1 + 3 + 5 = 9
 * numArray.update(1, 2);   // nums = [1, 2, 5]
 * numArray.sumRange(0, 2); // return 1 + 2 + 5 = 8
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 3 * 104
 * -100 <= nums[i] <= 100
 * 0 <= index < nums.length
 * -100 <= val <= 100
 * 0 <= left <= right < nums.length
 * At most 3 * 104 calls will be made to update and sumRange.
 */

/**
 *     private int [] nums;
 *     private int [] accumulativeSum;
 *     public NumArray(int[] nums) {
 *         this.nums = nums;
 *         this.accumulativeSum = new int [nums.length];
 *         this.accumulativeSum[0] = nums[0];
 *         for(int i=1; i<this.accumulativeSum.length; i++) {
 *             this.accumulativeSum[i] += nums[i] + accumulativeSum[i-1];
 *         }
 *     }
 *     public void update(int index, int val) {
 *         int temp = this.nums[index];
 *         this.nums[index] = val;
 *         int diff = temp - val;
 *         for(int i=index; i <this.accumulativeSum.length; i++) {
 *             accumulativeSum[i] -= diff;
 *         }
 *     }
 *
 *     public int sumRange(int left, int right) {
 *         if(left == 0) return this.accumulativeSum[right];
 *         return this.accumulativeSum[right] - this.accumulativeSum[left-1];
 *     }
 */
public class NumArray {
    SegmentTreeNode root;
    public NumArray(int[] nums) {
        this.root = this.buildSegmentTree(nums, 0, nums.length-1);
    }

    public void update(int index, int val) {
        SegmentTreeNode node = this.root;
        updateSegmentTree(node, index, val);
    }

    public int sumRange(int left, int right) {
        SegmentTreeNode node = this.root;
        return sumRangeHelper(node, left, right);
    }

    public SegmentTreeNode buildSegmentTree(int [] nums, int start, int end) {
        if(start > end) {
            return null;
        }
        //this step build the start and end field in the segment tree node
        SegmentTreeNode node = new SegmentTreeNode(start, end);
        if(start == end) {
            node.sum = nums[start];
        } else {
            int mid = start + (end - start)/2;
            node.left = buildSegmentTree(nums, start, mid);
            node.right = buildSegmentTree(nums, mid + 1, end);
            node.sum = node.left.sum + node.right.sum;
        }
        return node;
    }

    public void updateSegmentTree(SegmentTreeNode node, int pos, int val) {
        if(node.start == node.end) {
            node.sum = val;
        } else {
            int mid = node.start + (node.end - node.start)/2;
            if (pos <= mid) {

                updateSegmentTree(node.left, pos, val);
            } else {
                updateSegmentTree(node.right, pos, val);
            }
            node.sum = node.left.sum + node.right.sum;
        }
    }

    public int sumRangeHelper(SegmentTreeNode node, int st, int ed) {
        if(node.start == st && node.end == ed) {
            return node.sum;
        }
        int mid = node.start + (node.end - node.start)/2;
        //in the left sub tree
        if(ed <= mid) {
            return sumRangeHelper(node.left, st, ed);
        } else if(st >= mid + 1) {
            return sumRangeHelper(node.right, st, ed);
        } else {
            return sumRangeHelper(node.left, st, mid) + sumRangeHelper(node.right, mid + 1, ed);
        }
    }
}

class SegmentTreeNode {
    int start, end;
    SegmentTreeNode left, right;
    int sum;
    public SegmentTreeNode(int start, int end) {
        this.start = start;
        this.end = end;
        this.sum = 0;
        this.left = null;
        this.right = null;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
