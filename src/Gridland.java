import java.util.*;
public class Gridland {
    public static List<String> getsafePaths(List<String> journeys) {
        List<String> ans = new ArrayList<>();
        for(int i=0; i<journeys.size(); i++) {
            List <String> subSolution = new ArrayList<>();
            String journey = journeys.get(i);
            String [] splited = journey.split(" ");
            int tx = Integer.parseInt(splited[0]);
            int ty = Integer.parseInt(splited[1]);
            int index =Integer.parseInt(splited[2]);
            backtrack("", tx, ty, subSolution, 0, 0);
            Collections.sort(subSolution);
            ans.add(subSolution.get(index));
        }
        return ans;
    }

    private static void backtrack(String cur, int tH, int tV, List<String> res, int H, int V) {
        if(tH == H && tV == V) {
            res.add(cur);
            return;
        }
        if(H < tH) {
            backtrack(cur + "H", tH, tV, res, H + 1, V);
        }
        if( V< tV) {
            backtrack(cur + "V", tH, tV, res, H, V + 1);
        }
    }

    public static void main(String [] args) {
        List<String> journeys = new ArrayList<>();
        journeys.add("2 2 2");
        journeys.add("2 2 3");
        List<String> ans = Gridland.getsafePaths(journeys);
        for(int i=0; i<ans.size(); i++) {
            System.out.println(ans.get(i));
        }
    }
}
