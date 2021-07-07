/**
 * Given a sorted integer array arr, two integers k and x,
 * return the k closest integers to x in the array. The result should also be sorted in ascending order.
 *
 * An integer a is closer to x than an integer b if:
 *
 * |a - x| < |b - x|, or
 * |a - x| == |b - x| and a < b
 *
 *
 * Example 1:
 *
 * Input: arr = [1,2,3,4,5], k = 4, x = 3
 * Output: [1,2,3,4]
 * Example 2:
 *
 * Input: arr = [1,2,3,4,5], k = 4, x = -1
 * Output: [1,2,3,4]
 *
 *
 * Constraints:
 *
 * 1 <= k <= arr.length
 * 1 <= arr.length <= 104
 * arr is sorted in ascending order.
 * -104 <= arr[i], x <= 104
 */
import java.lang.reflect.Array;
import java.util.*;
public class FindKClosestElements {

    public static List<Integer> findClosestElementsTwoPointers(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        int [] diffArr = new int [arr.length];
        for(int i=0; i<arr.length; i++) {
            diffArr[i] = Math.abs(arr[i] - x);
        }
        int left = 0, right = arr.length-1;
        while(right - left >= k) {
            if(diffArr[right] >= diffArr[left]) {
                right--;
            } else {
                left++;
            }
        }
        for(int i=left; i<=right; i++) res.add(arr[i]);
        return res;
    }

    public static List<Integer> findClosestElementsCustomSort(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        List<Integer> sortedArr = new ArrayList<Integer>();
        for (int num: arr) {
            sortedArr.add(num);
        }

        // Sort using custom comparator
        Collections.sort(sortedArr, Comparator.comparingInt(num -> Math.abs(num - x)));
        for(int i=0; i<k;i++)res.add(sortedArr.get(i));
        Collections.sort(sortedArr);
        return res;
    }

    public static void main (String [] args) {
        int [] test = {1,2,3,4,5};
        List<Integer> res = findClosestElementsTwoPointers(test, 4, 3);
        for(int i: res) {
            System.out.println(i);
        }
        int [][] test2  = {{1, 2}, {-3, 5}, {6, 10}, {4, 7}, {-4, 3}};
        Arrays.sort(test2, (a, b) -> b[0] - a[0]);
    }
}
