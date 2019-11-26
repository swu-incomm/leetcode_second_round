/*
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Note: For the purpose of this problem, we define empty string as valid palindrome.

Example 1:

Input: "A man, a plan, a canal: Panama"
Output: true
Example 2:

Input: "race a car"
Output: false
 */

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if(s==null || s.length() == 0) return true;
        s = s.trim().toLowerCase().replaceAll("[^0-9a-zA-Z]", "");
        int l = 0;
        int r=s.length()-1;
        while(l < r) {
            if(s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }

    public static void main(String [] args) {
        String test = "A man, a plan, a canal: Panamas";
        test = test.trim().replaceAll(" ", "").toLowerCase().replaceAll("[^0-9a-zA-Z]", "");
        ValidPalindrome validPalindrome = new ValidPalindrome();
        System.out.println(validPalindrome.isPalindrome(test));
    }
}
