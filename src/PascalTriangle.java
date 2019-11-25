import java.util.ArrayList;
import java.util.List;

/*
Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
Example:

Input: 5
Output:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
 */
public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        if(numRows == 0) return ans;
        List<Integer> secondRow = new ArrayList<>();
        secondRow.add(1);
        secondRow.add(1);
        ans.add(firstRow);
        if(numRows == 1) return ans;
        ans.add(secondRow);
        if(numRows == 2) return ans;

        for(int i = 3; i<=numRows;i++) {
            List<Integer> subList = new ArrayList<>();
            for(int j = 0; j<i; j++) {
                if(j == 0 || j == i-1) {
                    subList.add(1);
                } else {
                    subList.add(ans.get(ans.size()-1).get(j-1) + ans.get(ans.size()-1).get(j));
                }
            }
            ans.add(subList);
        }
        return ans;
    }

    public static void main(String [] args) {
        PascalTriangle pascalTriangle = new PascalTriangle();
        List<List<Integer>> test = pascalTriangle.generate(6);
        for(List<Integer> subList:test) {
            subList.stream().forEach(s->System.out.printf("%s ", s));
            System.out.println();
        }

    }
}
