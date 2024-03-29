/**
 * We can shift a string by shifting each of its letters to its successive letter.
 *
 * For example, "abc" can be shifted to be "bcd".
 * We can keep shifting the string to form a sequence.
 *
 * For example, we can keep shifting "abc" to form the sequence: "abc" -> "bcd" -> ... -> "xyz".
 * Given an array of strings strings, group all strings[i] that belong to the same shifting sequence.
 * You may return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: strings = ["abc","bcd","acef","xyz","az","ba","a","z"]
 * Output: [["acef"],["a","z"],["abc","bcd","xyz"],["az","ba"]]
 * Example 2:
 *
 * Input: strings = ["a"]
 * Output: [["a"]]
 *
 *
 * Constraints:
 *
 * 1 <= strings.length <= 200
 * 1 <= strings[i].length <= 50
 * strings[i] consists of lowercase English letters.
 */
import java.util.*;
public class GroupShiftedStrings {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        Arrays.stream(strings).forEach(s->{
            char initial = s.charAt(0);
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<s.length();i++) {
                int offset = s.charAt(i) - initial;
                if(offset < 0) offset+=26;
                sb.append(offset).append(".");
            }
            System.out.println(sb.toString());
            if(!map.containsKey(sb.toString())) {
                map.put(sb.toString(), new ArrayList<>());
            }
            List<String> list = map.get(sb.toString());
            list.add(s);
            map.put(sb.toString(), list);
        });
        for(Map.Entry entry : map.entrySet()) {
            res.add((List<String>)entry.getValue());
        }
        return res;
    }
}
