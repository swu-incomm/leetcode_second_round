/**
 * Given three integers x, y, and bound, return a list of all the powerful integers that have a value less
 * than or equal to bound.
 *
 * An integer is powerful if it can be represented as xi + yj for some integers i >= 0 and j >= 0.
 *
 * You may return the answer in any order. In your answer, each value should occur at most once.
 *
 *
 *
 * Example 1:
 *
 * Input: x = 2, y = 3, bound = 10
 * Output: [2,3,4,5,7,9,10]
 * Explanation:
 * 2 = 20 + 30
 * 3 = 21 + 30
 * 4 = 20 + 31
 * 5 = 21 + 31
 * 7 = 22 + 31
 * 9 = 23 + 30
 * 10 = 20 + 32
 * Example 2:
 *
 * Input: x = 3, y = 5, bound = 15
 * Output: [2,4,6,8,10,14]
 *
 *
 * Constraints:
 *
 * 1 <= x, y <= 100
 * 0 <= bound <= 106
 */
import java.util.*;
import java.util.stream.Collectors;

public class PowerfulIntegers {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        List<Integer> powerX = new ArrayList<>();
        List<Integer> powerY = new ArrayList<>();
        powerX.add(1);
        powerY.add(1);
        if(x != 1) {
            int tempX = x;
            while(tempX < bound) {
                powerX.add(tempX);
                tempX *= x;
            }
        }
        if(y != 1) {
            int tempY = y;
            while(tempY < bound) {
                powerY.add(tempY);
                tempY *= y;
            }
        }
        Set<Integer> res = new HashSet<>();
        for(int i=0; i<powerX.size(); i++) {
            for(int j=0; j<powerY.size(); j++) {
                int temp = powerX.get(i) + powerY.get(j);
                if(temp <= bound) {
                    res.add(temp);
                }
            }
        }
        return res.stream().collect(Collectors.toList());
    }

    public static void main(String [] args) {
        PowerfulIntegers powerfulIntegers = new PowerfulIntegers();
        powerfulIntegers.powerfulIntegers(2, 3, 10);
    }
}
