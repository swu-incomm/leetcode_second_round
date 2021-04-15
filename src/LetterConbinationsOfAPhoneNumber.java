import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
 *
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 * Example:
 *
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * Note:
 *
 * Although the above answer is in lexicographical order, your answer could be in any order you want.
 */
public class LetterConbinationsOfAPhoneNumber {
//    HashMap<String,String> map = new HashMap<String, String>() {
//        {
//            put("2", "abc");
//            put("3", "def");
//            put("4", "ghi");
//            put("5", "jkl");
//            put("6", "mno");
//            put("7", "pqrs");
//            put("8", "tuv");
//            put("9", "wxyz");
//        }
//    };
//    List<String> output = new ArrayList<String>();
//    public List<String> letterCombinations(String digits) {
//        if(digits!= null && digits.length()>0) {
//            backtrack("", digits);
//        }
//        return output;
//    }
//
//    private void backtrack(String s, String nextDigits){
//        if(nextDigits.length() == 0) {
//            output.add(s);
//            return;
//        }
//        String currentDigit = Character.toString(nextDigits.charAt(0));
//        String currentString = map.get(currentDigit);
//        for(int i=0; i<currentString.length();i++) {
//            backtrack(s+Character.toString(currentString.charAt(i)), nextDigits.substring(1));
//        }
//    }

    public static void main(String [] args) {
        String test = "23";
        LetterConbinationsOfAPhoneNumber letterConbinationsOfAPhoneNumber = new LetterConbinationsOfAPhoneNumber();
        List<String> result = letterConbinationsOfAPhoneNumber.letterCombinations(test);
        result.stream().forEach(
                System.out::println
        );
    }
    char [][] pad = new char [][] {
            {},
            {},
            {'a', 'b', 'c'},
            {'d', 'e', 'f'},
            {'g', 'h', 'i'},
            {'j', 'k', 'l'},
            {'m', 'n', 'o'},
            {'p', 'q', 'r', 's'},
            {'t', 'u', 'v'},
            {'w', 'x', 'y', 'z'}
    };
    List<String> ans = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.length() == 0) return ans;
        backtrack(digits, 0, "");
        return ans;
    }

    public void backtrack(String digits, int index, String cur) {
        if(index > digits.length()) {
            return;
        }
        if(cur.length() == digits.length()) {
            ans.add(cur);
            return;
        }
        int num = digits.charAt(index) - '0';
        char [] chars = pad[num];
        for(char c : chars) {
            backtrack(digits, index + 1, cur + c);
        }
    }

}
