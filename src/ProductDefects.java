import java.util.*;
public class ProductDefects {
    public static int largestArea(List<List<Integer>> sample) {
        int ans = 0;
        if(sample == null || sample.size() == 0) return ans;
        int n = sample.size();
        int [][] matrix = new int [n][n];
        for(int i=0; i<n; i++) {
            List<Integer> subSample = sample.get(i);
            for(int j=0; j<n; j++) {
                matrix[i][j] = subSample.get(j);
            }
        }
        int [][]dp= new int [n][n];
        for(int i=0; i<n; i++) {
            dp[i][0] = matrix[i][0];
            dp[0][i] = matrix[0][i];
            ans = Math.max(Math.max(dp[i][0], ans), dp[0][i]);
        }

        for(int i=1; i<n; i++) {
            for(int j=1; j<n; j++) {
                if(matrix[i][j] == 0)continue;;
                dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i-1][j-1]), dp[i][j-1]) + 1;
                ans = Math.max(dp[i][j], ans);
            }
        }

        return ans;
    }

    public static void main(String [] args) {
//        int [][] testArray = {
//                {1,1,1,1,1},
//                {1,1,1,0,0},
//                {1,1,1,0,0},
//                {1,1,1,0,0},
//                {1,1,1,1,1}
//        };
        int [][] testArray = {
          {1}
       };
        List<List<Integer>> test = new ArrayList<>();
        for(int i=0; i<1; i++) {
            List<Integer> subList = new ArrayList<>();
            for(int j=0; j<1; j++) {
                subList.add(testArray[i][j]);
            }
            test.add(subList);
        }
//        for(int i=0; i<5; i++) {
//            List<Integer> subList = test.get(i);
//            for(int j=0; j<5; j++) {
//                System.out.printf("%d ", subList.get(j));
//            }
//            System.out.println();
//        }
        System.out.println(largestArea(test));
    }
}
