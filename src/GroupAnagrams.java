import java.util.*;


/**
 * Given an array of strings, group anagrams together.
 *
 * Example:
 *
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * Note:
 *
 * All inputs will be in lowercase.
 * The order of your output does not matter.
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> ans = new HashMap<>();
        if(strs == null || strs.length == 0) return new ArrayList<>();
        for(int i = 0; i<strs.length;i++) {
            char [] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String temp = String.valueOf(chars);
            if(!ans.containsKey(temp)) {
                ans.put(temp, new ArrayList<>());
            }
            ans.get(temp).add(strs[i]);
        }
        return new ArrayList(ans.values());
    }
}
