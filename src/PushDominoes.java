/**
 * There are n dominoes in a line, and we place each domino vertically upright. In the beginning, we simultaneously push some of the dominoes either to the left or to the right.
 *
 * After each second, each domino that is falling to the left pushes the adjacent domino on the left. Similarly,
 * the dominoes falling to the right push their adjacent dominoes standing on the right.
 *
 * When a vertical domino has dominoes falling on it from both sides, it stays still due to the balance of the forces.
 *
 * For the purposes of this question, we will consider that a falling domino expends no additional force to a falling or already
 * fallen domino.
 *
 * You are given a string dominoes representing the initial state where:
 *
 * dominoes[i] = 'L', if the ith domino has been pushed to the left,
 * dominoes[i] = 'R', if the ith domino has been pushed to the right, and
 * dominoes[i] = '.', if the ith domino has not been pushed.
 * Return a string representing the final state.
 *
 *
 *
 * Example 1:
 *
 * Input: dominoes = "RR.L"
 * Output: "RR.L"
 * Explanation: The first domino expends no additional force on the second domino.
 * Example 2:
 *
 *
 * Input: dominoes = ".L.R...LR..L.."
 * Output: "LL.RR.LLRRLL.."
 *
 *
 * Constraints:
 *
 * n == dominoes.length
 * 1 <= n <= 105
 * dominoes[i] is either 'L', 'R', or '.'.
 */
public class PushDominoes {
    public static String pushDominoes(String dominoes) {
        int [] left = new int [dominoes.length()];
        int [] right = new int [dominoes.length()];

        int preRight = -1;
        for(int i=0; i<dominoes.length();i++) {
            char ch = dominoes.charAt(i);
            if(ch == 'L') {
                preRight = -1;
            } else if(ch == 'R') {
                preRight = i;
            }
            right[i] = preRight;
        }
        int preLeft = -1;
        for(int i=dominoes.length()-1; i>=0;i--) {
            char ch = dominoes.charAt(i);
            if(ch == 'L') {
                preLeft = i;
            } else if(ch == 'R') {
                preLeft = -1;
            }
            left[i] = preLeft;
        }
        char [] res = new char[dominoes.length()];
        for(int i=0; i<dominoes.length(); i++) {
            char ch = dominoes.charAt(i);
            if(ch == 'R' || ch == 'L') {
                res[i] = ch;
                continue;
            }
            int leftVal = left[i];
            int rightVal = right[i];
            if(leftVal == -1 && rightVal == -1) res[i] = '.';
            else if(leftVal == -1) res[i] = 'R';
            else if(rightVal == -1) res[i] = 'L';
            else {
                int diffL = Math.abs(leftVal - i);
                int diffR = Math.abs(rightVal - i);
                if(diffL == diffR) res[i] = '.';
                else res[i] = diffL > diffR ? 'R' : 'L';
            }
        }
        return new String(res);
    }

    public static void main(String [] args) {
        String test = "RR.L";
        pushDominoes(test);
    }
}
