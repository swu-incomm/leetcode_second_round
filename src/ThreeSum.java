import java.util.*;

/**
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all
 * unique triplets in the array which gives the sum of zero.
 *
 * Note:
 *
 * The solution set must not contain duplicate triplets.
 *
 * Example:
 *
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 *
 * A solution set is:
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 */
public class ThreeSum {
//    public List<List<Integer>> threeSum(int[] nums) {
//        List<List<Integer>> ans = new ArrayList<>();
//        if(nums == null || nums.length < 3) return ans;
//        Arrays.sort(nums);
//        for(int i = 0; i< nums.length - 2; i++) {
//            //check point 1
//            if(i == 0 || (i> 0 && nums[i] != nums[i-1])) {
//                int l = i + 1, r = nums.length -1;
//                while(l < r) {
//                    if(nums[i] + nums[l] + nums[r] == 0) {
//                        List<Integer> subList = new ArrayList<>();
//                        subList.add(nums[i]);
//                        subList.add(nums[l]);
//                        subList.add(nums[r]);
//                        ans.add(subList);
//                        //check point 2
//                        while(l < r && nums[l] == nums[l + 1]) l++;
//                        while(l < r && nums[r] == nums[r - 1]) r--;
//                        //now the value of nums[l] and nums[r] are still the same as previous answer, we need one more ++ and --
//                        l++;
//                        r--;
//                    } else if(nums[i] + nums[l] + nums[r] > 0) {
//                        r--;
//                    } else {
//                        l++;
//                    }
//                }
//            }
//        }
//        return ans;
//    }

    public static void main(String [] args) {
        int [] test = new int[] {-2,0,1,1,2};
        ThreeSum threeSum = new ThreeSum();
        List<List<Integer>> res = threeSum.threeSum(test);
        System.out.println(res.toString());
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if(nums == null || nums.length < 3) return ans;
        Arrays.sort(nums);
        for(int i = 0; i<nums.length; i++) {
            if(i == 0 || (i>0 && nums[i] != nums[i - 1])) {
                int l = i + 1;
                int r = nums.length -1;
                while(l < r) {
                    if(nums[l] + nums[r] + nums[i] == 0) {
                        List<Integer> subList = new ArrayList<>();
                        subList.add(nums[i]);
                        subList.add(nums[l]);
                        subList.add(nums[r]);
                        ans.add(subList);
                        while(l<r && nums[l] == nums[l+1]) l++;
                        while(l<r && nums[r] == nums[r-1]) r--;
                        l++;
                        r--;
                    }
                    else if(nums[l] + nums[r] + nums[i] < 0) {
                        l++;
                    }
                    else {
                        r--;
                    }
                }
            }
        }
        return ans;
    }
}
