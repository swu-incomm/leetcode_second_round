import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Design a HashSet without using any built-in hash table libraries.
 *
 * To be specific, your design should include these functions:
 *
 * add(value): Insert a value into the HashSet.
 * contains(value) : Return whether the value exists in the HashSet or not.
 * remove(value): Remove a value in the HashSet. If the value does not exist in the HashSet, do nothing.
 *
 * Example:
 *
 * MyHashSet hashSet = new MyHashSet();
 * hashSet.add(1);
 * hashSet.add(2);
 * hashSet.contains(1);    // returns true
 * hashSet.contains(3);    // returns false (not found)
 * hashSet.add(2);
 * hashSet.contains(2);    // returns true
 * hashSet.remove(2);
 * hashSet.contains(2);    // returns false (already removed)
 *
 * Note:
 *
 * All values will be in the range of [0, 1000000].
 * The number of operations will be in the range of [1, 10000].
 * Please do not use the built-in HashSet library.
 */
public class DesignHashSet {

    public static void main(String[] args) {
        MyHashSet myHashSet = new MyHashSet();
//        myHashSet.add(9);
//        myHashSet.add(2);
//        myHashSet.contains(1);
//        myHashSet.contains(3);
//        myHashSet.add(2);
//        myHashSet.contains(2);
//        myHashSet.remove(2);
//        myHashSet.contains(2);
        myHashSet.contains(72);
        myHashSet.remove(91);
        myHashSet.add(48);
        myHashSet.add(41);
        myHashSet.contains(96);
        myHashSet.remove(87);
        myHashSet.contains(48);
        myHashSet.contains(49);
    }
}

class MyHashSet {

    private List<List<Integer>> hashSet =  new ArrayList<>(1000);;

    /** Initialize your data structure here. */
    public MyHashSet() {
        for(int i =0; i<1000; i++) this.hashSet.add(null);
    }

    public void add(int key) {
        int hashKey = key%1000;
        List<Integer> subSet = hashSet.get(hashKey);
        if(subSet == null) {
            List<Integer> newSet = new ArrayList<>();
            newSet.add(key);
            hashSet.set(hashKey, newSet);
        } else {
            for(int i = 0; i<subSet.size();i++) {
                if(subSet.get(i) == key) return;
            }
            subSet.add(key);
        }
    }

    public void remove(int key) {
        int hashKey = key%1000;
        List<Integer> subSet = hashSet.get(hashKey);
        if(subSet == null) return;
        for(int i = 0; i<subSet.size(); i++) {
            if(subSet.get(i) == key) {
                subSet.remove(i);
                return;
            }
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int hashKey = key%1000;
        List<Integer> subSet = hashSet.get(hashKey);
        if(subSet == null) return false;
        return subSet.stream().filter(s->s == key).findAny().isPresent();
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
