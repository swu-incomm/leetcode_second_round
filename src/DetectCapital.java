/**
 * Given a word, you need to judge whether the usage of capitals in it is right or not.
 *
 * We define the usage of capitals in a word to be right when one of the following cases holds:
 *
 * All letters in this word are capitals, like "USA".
 * All letters in this word are not capitals, like "leetcode".
 * Only the first letter in this word is capital, like "Google".
 * Otherwise, we define that this word doesn't use capitals in a right way.
 */
public class DetectCapital {
    public boolean detectCapitalUse(String word) {
        String upperCaseWord = word.toUpperCase();
        if(upperCaseWord.equals(word)) {
            return true;
        }
        if(upperCaseWord.toLowerCase().equals(word)) {
            return true;
        }
        if(upperCaseWord.charAt(0) == word.charAt(0)) {
            for(int i =1; i<word.length(); i++) {
                if(word.charAt(i) == upperCaseWord.charAt(i)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
