import java.util.Arrays;
import java.util.Comparator;

/**
 * Given a list of non negative integers, arrange them such that they form the largest number.
 *
 * Example 1:
 *
 * Input: [10,2]
 * Output: "210"
 * Example 2:
 *
 * Input: [3,30,34,5,9]
 * Output: "9534330"
 * Note: The result may be very large, so you need to return a string instead of an integer.
 */
public class LargestNumber {
    public String largestNumber(int[] nums) {
        if(nums == null || nums.length == 0) return "";
        String [] strArray = new String [nums.length];
        for(int i = 0; i<nums.length; i++) {
            strArray[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strArray, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String a = o1 + o2;
                String b = o2 + o1;
                return b.compareTo(a);
            }
        });
        if(strArray[0].equals("0")) return "0";
        StringBuilder sb = new StringBuilder();
        for(String i : strArray) {
            sb.append(i);
        }
        return sb.toString();
    }

    public String largestNumberNoComparator(int[] nums) {
        if(nums == null || nums.length == 0) return "";
        String [] strArray = new String [nums.length];
        for(int i = 0; i<nums.length; i++) {
            strArray[i] = String.valueOf(nums[i]);
        }

        for(int i =0; i<strArray.length-1; i++) {
            for(int j = i+1; j<strArray.length;j++) {
                String s1 = strArray[i] + strArray[j];
                String s2 = strArray[j] + strArray[i];
                if(s1.compareTo(s2) < 0) {
                    String temp = strArray[i];
                    strArray[i] = strArray[j];
                    strArray[j] = temp;
                }
            }
        }
        if(strArray[0].equals("0")) return "0";
        StringBuilder sb = new StringBuilder();
        for(String i : strArray) {
            sb.append(i);
        }
        return sb.toString();
    }

    public static void main(String [] args) {
    }

    public String largestNumberRrdo(int[] nums) {
        String [] stringArr = new String [nums.length];
        int j=0;
        for(int i : nums) {
            stringArr[j++] = String.valueOf(i);
        }
        Arrays.sort(stringArr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
               String a = o1 + o2;
               String b = o2 + o1;
               return b.compareTo(a);
            }
        });
        if(stringArr[0].equals("0")) return "0";
        String ans = "";
        for(String i : stringArr) {
            ans+=i;
        }
        return ans;
    }
}
