/**
 * Compare two version numbers version1 and version2.
 * If version1 > version2 return 1; if version1 < version2 return -1;otherwise return 0.
 *
 * You may assume that the version strings are non-empty and contain only digits and the . character.
 *
 * The . character does not represent a decimal point and is used to separate number sequences.
 *
 * For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.
 *
 * You may assume the default revision number for each level of a version number to be 0. For example, version number 3.4 has a revision number of 3 and 4 for its first and second level revision number. Its third and fourth level revision number are both 0.
 *
 *
 *
 * Example 1:
 *
 * Input: version1 = "0.1", version2 = "1.1"
 * Output: -1
 * Example 2:
 *
 * Input: version1 = "1.0.1", version2 = "1"
 * Output: 1
 * Example 3:
 *
 * Input: version1 = "7.5.2.4", version2 = "7.5.3"
 * Output: -1
 * Example 4:
 *
 * Input: version1 = "1.01", version2 = "1.001"
 * Output: 0
 * Explanation: Ignoring leading zeroes, both “01” and “001" represent the same number “1”
 * Example 5:
 *
 * Input: version1 = "1.0", version2 = "1.0.0"
 * Output: 0
 * Explanation: The first version number does not have a third level revision number, which means its third level revision number
 * is default to "0"
 * Note:
 *
 * Version strings are composed of numeric strings separated by dots . and this numeric strings may have leading zeroes.
 * Version strings do not start or end with dots, and they will not be two consecutive dots.
 */
public class CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        String [] version1s = splitVersion(version1);
        String [] version2s = splitVersion(version2);
        int length = Math.max(version1s.length, version2s.length);
        for(int i =0; i<length; i++) {
            //System.out.println(version1s[i]);
            int sub1 = i < version1s.length ? Integer.parseInt(version1s[i]) : 0;
            int sub2 = i < version2s.length ? Integer.parseInt(version2s[i]) : 0;
            if(sub1 > sub2) return 1;
            if(sub2 > sub1) return -1;
        }
        return 0;
    }

    public String [] splitVersion(String version) {
        String [] splitVersions = version.split("\\.");
        for(int i=0; i<splitVersions.length; i++) {
            String temp= splitVersions[i];
            int index=0;
            while(temp.charAt(index) == '0' && index < temp.length()-1) {
                temp = temp.replaceFirst("0", "");
            }
            splitVersions[i] = temp;
        }
        return splitVersions;
    }

    public static void main(String [] args) {
        String test1 = "00001.0021.111";
        String test2 = "1.1.1";
        CompareVersionNumbers compareVersionNumbers = new CompareVersionNumbers();
        compareVersionNumbers.compareVersion(test1, test2);
    }
}
