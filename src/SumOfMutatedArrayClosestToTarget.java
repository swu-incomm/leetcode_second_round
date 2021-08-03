public class SumOfMutatedArrayClosestToTarget {
    public int findBestValue(int[] arr, int target) {
        int sum = 0, max = arr[0];
        for(int i: arr) {
            sum+=i;
            max = Math.max(max, i);
        }
        if(sum == target) return max;
        int start = 0, end = max;
        int minDiff = Integer.MAX_VALUE;
        int res = 1;
        while(start <= end) {
            int mid = start + (end - start)/2;
            int temp = calculateSum(arr, mid);
            if(temp > target) {
                end = mid-1;
            } else {
                start = mid+1;
            }
            int diff = Math.abs(temp - target);
            if(diff < minDiff || (diff == minDiff && mid < res)) {
                res = mid;
                minDiff = diff;
            }
        }
        return res;
    }

    public int calculateSum(int [] nums, int mutate) {
        int sum = 0;
        for(int i: nums) {
            if(i > mutate) {
                sum+=mutate;
            } else {
                sum+=i;
            }
        }
        return sum;
    }
}
