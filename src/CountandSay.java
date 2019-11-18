/*
The count-and-say sequence is the sequence of integers with the first five terms as following:

1.     1
2.     11
3.     21
4.     1211
5.     111221
1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.

Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence.

Note: Each term of the sequence of integers will be represented as a string.



Example 1:

Input: 1
Output: "1"
Example 2:

Input: 4
Output: "1211"
 */
public class CountandSay {
    public String countAndSay(int n) {
      String res1 = "1", res2 = "11", prev = "11";
      if(n == 1) return res1;
      if(n == 2) return res2;
      StringBuilder stringBuilder = new StringBuilder("");

      for(int i = 2; i<n; i++) {
          int count = 1;
          for(int j = 0; j<prev.length(); j++) {
              if(j!= prev.length() -1 && prev.charAt(j) == prev.charAt(j+1)) {
                  count ++;
              }
              else if(j == prev.length() - 1 && prev.charAt(j) != prev.charAt(j-1)) {
                  stringBuilder.append(1).append(prev.charAt(j));
                  count = 1;
              } else {
                  stringBuilder.append(count).append(prev.charAt(j));
                  count = 1;
              }
          }
          prev = stringBuilder.toString();
          stringBuilder = new StringBuilder("");
      }
      return prev;
    }
    public static void main(String [] args) {
        CountandSay countandSay = new CountandSay();
        for(int i = 1; i<=6;i++) {
            System.out.println(countandSay.countAndSay(i));
        }
    }
}
