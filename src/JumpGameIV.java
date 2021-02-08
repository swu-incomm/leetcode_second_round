import java.util.*;

/**
 * Given an array of integers arr, you are initially positioned at the first index of the array.
 *
 * In one step you can jump from index i to index:
 *
 * i + 1 where: i + 1 < arr.length.
 * i - 1 where: i - 1 >= 0.
 * j where: arr[i] == arr[j] and i != j.
 * Return the minimum number of steps to reach the last index of the array.
 *
 * Notice that you can not jump outside of the array at any time.
 *
 *
 *
 * Example 1:
 *
 * Input: arr = [100,-23,-23,404,100,23,23,23,3,404]
 * Output: 3
 * Explanation: You need three jumps from index 0 --> 4 --> 3 --> 9. Note that index 9 is the last index of the array.
 * Example 2:
 *
 * Input: arr = [7]
 * Output: 0
 * Explanation: Start index is the last index. You don't need to jump.
 * Example 3:
 *
 * Input: arr = [7,6,9,6,9,6,9,7]
 * Output: 1
 * Explanation: You can jump directly from index 0 to index 7 which is last index of the array.
 * Example 4:
 *
 * Input: arr = [6,1,9]
 * Output: 2
 * Example 5:
 *
 * Input: arr = [11,22,7,7,7,7,7,7,7,22,13]
 * Output: 3
 *
 *
 * Constraints:
 *
 * 1 <= arr.length <= 5 * 10^4
 * -10^8 <= arr[i] <= 10^8
 */
public class JumpGameIV {
    /**
    public int minJumps(int[] arr) {
        int ans = 0;
        if(arr.length <= 1) return ans;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        //map key is the value in the arr, the value will be the index list
        for(int i = 0; i<arr.length; i++) {
            map.computeIfAbsent(arr[i], v -> new ArrayList<>()).add(i);
        }
        //create the queue
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        while(!queue.isEmpty()) {
            int size = queue.size();
            ans ++;
            for(int i= 0; i<size; i++) {
                int curIndex = queue.poll();
                int curVal = arr[curIndex];
                List<Integer> indexes = map.get(curVal);
                //find prev
                if(curIndex > 0 && map.containsKey(arr[curIndex - 1])) {
                    queue.offer(curIndex - 1);
                }
                //find next
                if(curIndex < arr.length -1 && map.containsKey(arr[curIndex + 1])) {
                    if(curIndex +1 == arr.length-1) return ans;
                    queue.offer(curIndex + 1);
                }
                //find equal
                if(indexes != null) {
                    for(int j = 0; j<indexes.size(); j++) {
                        int temp = indexes.get(j);
                        if(temp != curIndex && map.containsKey(arr[temp])) {
                            if(temp == arr.length-1) return ans;
                            queue.offer(temp);
                        }
                    }
                }

                map.remove(arr[curIndex]);
            }
        }
        return ans;
    }
     **/
    public int minJumps(int[] arr) {
        if(arr == null || arr.length<=1) return 0;
        //build the hash map
        HashMap<Integer, List<Integer>> map = new HashMap();
        for(int i=0; i<arr.length; i++) {
            if(map.containsKey(arr[i])) {
                map.get(arr[i]).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(arr[i], list);
            }
        }
//        for(int i = 0; i<arr.length; i++) {
//            map.computeIfAbsent(arr[i], v -> new ArrayList<>()).add(i);
//        }
        //index queue
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        int step = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            step++;
            for(int i=0; i<size; i++) {
                int cur = queue.poll();
                List<Integer> subList = map.get(arr[cur]);

                if(cur > 0 && map.containsKey(arr[cur -1])) {
                    queue.offer(cur-1);
                }
                if(cur + 1 < arr.length && map.containsKey(arr[cur + 1])) {
                    if(cur + 1 == arr.length -1) {
                        return step;
                    }
                    queue.offer(cur + 1);
                }
                if(subList != null && subList.size() > 0) {
                    for(int j = 0; j< subList.size(); j++) {
                        int temp = subList.get(j);
                        if(temp != cur && map.containsKey(arr[temp])) {
                            if(temp == arr.length-1) {
                                return step;
                            }
                            queue.offer(temp);
                        }
                    }
                }
                map.remove(arr[cur]);
            }
        }
        return step;
    }
}
