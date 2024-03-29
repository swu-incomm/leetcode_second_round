/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it can trap after raining.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 * Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
 * In this case, 6 units of rain water (blue section) are being trapped.
 * Example 2:
 *
 * Input: height = [4,2,0,3,2,5]
 * Output: 9
 *
 *
 * Constraints:
 *
 * n == height.length
 * 0 <= n <= 3 * 104
 * 0 <= height[i] <= 105
 */
public class TrapRainWater {
    public int trap(int[] height) {
        if(height == null || height.length == 0) return 0;
        int [] maxLeft = new int [height.length];
        int [] maxRight = new int [height.length];
        int max = height[0];
        for(int i=1; i<height.length; i++) {
            maxLeft[i] = max;
            max = Math.max(max, height[i]);
        }
        max = height[height.length -1];
        for(int i=height.length-2; i>=0; i--) {
            maxRight[i] = max;
            max = Math.max(height[i], max);
        }
        int res = 0;
        for(int i=1; i<height.length; i++) {
            int temp = Math.min(maxLeft[i], maxRight[i]) - height[i];
            res += temp > 0 ? temp : 0;
        }
        return res;
    }
}
