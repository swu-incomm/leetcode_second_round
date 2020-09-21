/**
 * Given an array arr of 4 digits, find the latest 24-hour time that can be made using each digit exactly once.
 *
 * 24-hour times are formatted as "HH:MM", where HH is between 00 and 23, and MM is between 00 and 59. The earliest 24-hour time is 00:00,
 * and the latest is 23:59.
 *
 * Return the latest 24-hour time in "HH:MM" format.  If no valid time can be made, return an empty string.
 *
 *
 *
 * Example 1:
 *
 * Input: A = [1,2,3,4]
 * Output: "23:41"
 * Explanation: The valid 24-hour times are "12:34", "12:43", "13:24", "13:42", "14:23", "14:32", "21:34", "21:43", "23:14", and "23:41".
 * Of these times, "23:41" is the latest.
 * Example 2:
 *
 * Input: A = [5,5,5,5]
 * Output: ""
 * Explanation: There are no valid 24-hour times as "55:55" is not valid.
 * Example 3:
 *
 * Input: A = [0,0,0,0]
 * Output: "00:00"
 * Example 4:
 *
 * Input: A = [0,0,1,0]
 * Output: "10:00"
 *
 *
 * Constraints:
 *
 * arr.length == 4
 * 0 <= arr[i] <= 9
 */
import java.util.*;
public class LargestTimeForGivenDigits {
    public String largestTimeFromDigits(int[] arr) {
        int max = Integer.MIN_VALUE;
        String ans = "";
        for(int i=0; i<=3; i++) {
            for(int j=0; j<=3; j++) {
                for(int k=0; k<=3; k++) {
                    if(i==j || i==k || j==k) {
                        continue;
                    }
                    List<Integer> time = new ArrayList<>();
                    int temp = 6 - i- j- k;
                    time.add(arr[i]);
                    time.add(arr[j]);
                    time.add(arr[k]);
                    time.add(arr[temp]);
                    if(isValidTime(time)) {
                        int val = (time.get(0) * 10 + time.get(1)) * 60 + (time.get(2) * 10 + time.get(3));
                        if(val > max) {
                            max = val;
                            ans = new StringBuilder()
                                    .append(time.get(0))
                                    .append(time.get(1))
                                    .append(":")
                                    .append(time.get(2))
                                    .append(time.get(3))
                                    .toString();
                        }
                    }
                }
            }
        }
        return ans;
    }

    boolean isValidTime(List<Integer> time) {
        if(time == null || time.size() != 4) return false;
        int hour = time.get(0)*10 + time.get(1);
        int minutes = time.get(2) * 10 + time.get(3);
        if(hour >= 0 && hour < 24) {
            if(minutes >= 0 && minutes < 60) {
                return true;
            }
        }
        return false;
    }
}
