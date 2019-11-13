/*
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:

Input: ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
Note:

All given inputs are in lowercase letters a-z.
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder stringBuilder = new StringBuilder("");
        if(strs == null || strs.length == 0) return stringBuilder.toString();
        int minLength = Integer.MAX_VALUE;
        for(String str : strs) { if(str.length() <= minLength) minLength = str.length(); }
        outerloop:
        for(int i = 0; i<minLength;i++) {
            char comparedValue = strs[0].charAt(i);
            for(int j = 0; j<strs.length; j++) {
                if(strs[j].charAt(i) != comparedValue) break outerloop;
            }
            stringBuilder.append(comparedValue);
        }
        return stringBuilder.toString();
    }
}
