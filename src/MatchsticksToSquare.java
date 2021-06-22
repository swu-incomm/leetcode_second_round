import java.util.Arrays;

/**
 * You are given an integer array matchsticks where matchsticks[i] is the length of the ith matchstick.
 * You want to use all the matchsticks to make one square. You should not break any stick, but you can link them up,
 * and each matchstick must be used exactly one time.
 *
 * Return true if you can make this square and false otherwise.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: matchsticks = [1,1,2,2,2]
 * Output: true
 * Explanation: You can form a square with length 2, one side of the square came two sticks with length 1.
 * Example 2:
 *
 * Input: matchsticks = [3,3,3,3,4]
 * Output: false
 * Explanation: You cannot find a way to form a square with all the matchsticks.
 *
 *
 * Constraints:
 *
 * 1 <= matchsticks.length <= 15
 * 0 <= matchsticks[i] <= 109
 */
public class MatchsticksToSquare {
    int [] matchsticks;
    public boolean makesquare(int[] matchsticks) {
        this.matchsticks = matchsticks;
        int len = 0;
        for(int i:matchsticks) len+=i;
        if(len%4 != 0) return false;
        len/=4;
        int [] square = new int [4];
        Arrays.fill(square, len);
        return backtrack(0, square);
    }

    public boolean backtrack(int index, int [] square) {
        if(index == this.matchsticks.length) {
            return (square[0] == 0) && (square[1] == 0) && (square[2] == 0) && (square[3] == 0);
        }
        if(square[0] <0 || square[1] <0 || square[2] <0 || square[3] <0) return false;
        for(int i=0; i<4; i++) {
            if(square[i] > 0) {
                square[i] -= matchsticks[index];
                if(backtrack(index + 1, square)) {
                    return true;
                }
                square[i] += matchsticks[index];
            }
        }
        return false;
    }

    public static void main(String [] args) {
        //int [] test = {2,5,3,4,3,1,2,8,5,8,10,6,9,3,6};
        int [] test = {1,1,2,2,2};
        MatchsticksToSquare ms = new MatchsticksToSquare();
        ms.makesquare(test);
    }
}
