/**
 * Given a non-empty string containing an out-of-order English representation of digits 0-9, output the digits in ascending order.
 *
 * Note:
 * Input contains only lowercase English letters.
 * Input is guaranteed to be valid and can be transformed to its original digits.
 * That means invalid inputs such as "abc" or "zerone" are not permitted.
 * Input length is less than 50,000.
 * Example 1:
 * Input: "owoztneoer"
 *
 * Output: "012"
 * Example 2:
 * Input: "fviefuro"
 *
 * Output: "45"
 */
public class ReconstructOriginalDigitsFromEnglish {
    public String originalDigits(String s) {
        if(s == null || s.length() == 0) return "";
        int count [] = new int[26];
        for(int i = 0; i<s.length(); i++) {
            count[s.charAt(i) - 'a'] ++;
        }
        //for(int i=0; i<26; i++) System.out.println( (char)(i + 'a') + ": " + count[i]);
        int [] ans = new int [10];
        ans[0] = count['z'-'a'];
        ans[2] = count['w'-'a'];
        ans[4] = count['u' -'a'];
        ans[6] = count['x' -'a'];
        ans[8] = count['g' -'a'];
        ans[3] = count['h' - 'a'] - ans[8];
        ans[5] = count['f' - 'a'] - ans[4];
        ans[7] = count['s' - 'a'] - ans[6];
        ans[9] = count['i' - 'a'] - ans[8] - ans[6] - ans[5];
        ans[1] = count['n' - 'a'] - ans[9] - ans[7] - ans[9];

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<=9; i++) {
            for(int j=0; j<ans[i]; j++) {
                sb.append(i);
            }
        }
        return sb.toString();
    }
    public static void main(String [] args) {
        ReconstructOriginalDigitsFromEnglish recon = new ReconstructOriginalDigitsFromEnglish();
        System.out.println(recon.originalDigits("nnei"));
    }
}
