/**
 * Given an integer array arr, and an integer target, return the number of tuples i, j, k such that i < j < k and arr[i] + arr[j] + arr[k] == target.
 *
 * As the answer can be very large, return it modulo 109 + 7.
 *
 *
 *
 * Example 1:
 *
 * Input: arr = [1,1,2,2,3,3,4,4,5,5], target = 8
 * Output: 20
 * Explanation:
 * Enumerating by the values (arr[i], arr[j], arr[k]):
 * (1, 2, 5) occurs 8 times;
 * (1, 3, 4) occurs 8 times;
 * (2, 2, 4) occurs 2 times;
 * (2, 3, 3) occurs 2 times.
 * Example 2:
 *
 * Input: arr = [1,1,2,2,2,2], target = 5
 * Output: 12
 * Explanation:
 * arr[i] = 1, arr[j] = arr[k] = 2 occurs 12 times:
 * We choose one 1 from [1,1] in 2 ways,
 * and two 2s from [2,2,2,2] in 6 ways.
 *
 *
 * Constraints:
 *
 * 3 <= arr.length <= 3000
 * 0 <= arr[i] <= 100
 * 0 <= target <= 300
 *
 *We consider 3 numbers between 0-100, instead of index
 * case 1: i==j==k
 * case2: i < j == k
 * case3: i ==j <k
 * case4: i<j<k
 *
 */
public class _3SumWithMultiplicity {
    //Brute Force strategy
    public int threeSumMultiBruteForce(int[] arr, int target) {
        int mod = 1_000_000_007;
        int result = 0;
        for(int i=0; i<arr.length; i++) {
            int [] count = new int [101];
            for(int j=i+1; j<arr.length;j++) {
                int temp = target - arr[i] - arr[j];
                if(temp >= 0 && temp <=100 && count[temp] > 0) {
                    result += count[temp];
                    result %= mod;
                }
                count[arr[j]]++;
            }
        }
        return result;
    }
    public int threeSumMulti(int[] arr, int target) {
        int mod = 1_000_000_007;
        long result = 0;
        long [] count = new long[101];
        for(int i : arr) {
            count[i] ++;
        }
//        for(int i=1; i<=5; i++) {
//            System.out.println(count[i]);
//        }
        for(int i=0; i<=100; i++) {
            for(int j=i; j<=100; j++) {
                int temp = target - i - j;
                if(temp >=0 && temp <= 100) {
                    if(i ==j && j==temp && count[i]>=3) {
                        //System.out.println("i=" + i + ", j=" + j + ", k=" + temp);
                        result += (count[i] * (count[i]-1) * (count[i]-2)) /6;
                    }
                    else if(i==j && j != temp && count[i] >=2 && count[temp] >0) {
                        //System.out.println("i=" + i + ", j=" + j + ", k=" + temp);
                        result+=0.5 *count[i] * (count[i]-1) * count[temp];
                    }
                    else if(i < j && j <temp && count[i] >0 && count[j] >0 && count[temp] >0) {
                        //.out.println("i=" + i + ", j=" + j + ", k=" + temp);
                        result += count[i] * count[j] * count[temp];
                    }
                }
            }
        }
        return (int)(result%mod);
    }
    public static void main(String [] args) {
        int [] arr = {1, 1, 2, 2, 3, 3, 4, 4, 5, 5};
        _3SumWithMultiplicity threeSum = new _3SumWithMultiplicity();
        threeSum.threeSumMulti(arr, 8);
    }
}
