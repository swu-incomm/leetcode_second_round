import java.util.*;

/**
 * Given a non-empty array of integers, return the k most frequent elements.
 *
 * Example 1:
 *
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * Example 2:
 *
 * Input: nums = [1], k = 1
 * Output: [1]
 * Note:
 *
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 */
public class TopKFrequentElements {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> ans = new ArrayList<>();
        if(nums == null || nums.length == 0) return ans;
        Map<Integer,Integer> map = new HashMap<>();
        PriorityQueue<Integer> heap = new PriorityQueue<>((n1, n2)->map.get(n1) - map.get(n2));
        for(int i : nums) { map.put(i, map.getOrDefault(i, 0) + 1); }
        map.entrySet().stream().forEach(e->{
            heap.offer(e.getKey());
            if(heap.size() > k) {heap.poll();}
        });
        heap.stream().forEach(h->{
            ans.add(0, h);
        });
        return ans;
    }

    // this is how we define a max heap
    class MaxHeap implements Comparator<Integer> {
        public int compare(Integer x, Integer y) {
            return y - x;
        }
    }
}
