/**
 * Design a HashMap without using any built-in hash table libraries.
 *
 * To be specific, your design should include these functions:
 *
 * put(key, value) : Insert a (key, value) pair into the HashMap. If the value already exists in the HashMap, update the value.
 * get(key): Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key.
 * remove(key) : Remove the mapping for the value key if this map contains the mapping for the key.
 *
 * Example:
 *
 * MyHashMap hashMap = new MyHashMap();
 * hashMap.put(1, 1);
 * hashMap.put(2, 2);
 * hashMap.get(1);            // returns 1
 * hashMap.get(3);            // returns -1 (not found)
 * hashMap.put(2, 1);          // update the existing value
 * hashMap.get(2);            // returns 1
 * hashMap.remove(2);          // remove the mapping for 2
 * hashMap.get(2);            // returns -1 (not found)
 *
 * Note:
 *
 * All keys and values will be in the range of [0, 1000000].
 * The number of operations will be in the range of [1, 10000].
 * Please do not use the built-in HashMap library.
 */
public class DesignHashMap {
}

class MyHashMap {
    final Bucket [] hashMap = new Bucket[10000];
    /** Initialize your data structure here. */
    public MyHashMap() {
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int hashKey = key%1000;
        if(hashMap[hashKey] == null) {
            //no hash key value as current hash key before we create our initial bucket chain
            //add this dummy node
            Bucket bucket = new Bucket(-1, -1);
            hashMap[hashKey] = bucket;
        }
        Bucket head = hashMap[hashKey];
        Bucket node= head, prev = null;
        while(node != null && node.key != key) {
            prev = node;
            node = node.next;
        }
        if(prev.next == null) {
            //create new
            prev.next = new Bucket(key, value);
        } else {
            //update
            prev.next.value = value;
        }
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int hashKey = key%1000;
        Bucket head = hashMap[hashKey];
        if(head != null) {
            Bucket node = head;
            while(node != null && node.key != key) {
                node = node.next;
            }
            if(node != null) {
                return node.value;
            }
        }
        return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int hashKey = key%1000;
        Bucket head = hashMap[hashKey];
        if(head != null) {
            Bucket node = head, prev = null;
            while(node != null && node.key != key) {
                prev = node;
                node = node.next;
            }
            if(prev.next != null) {
                prev.next = node.next;
            }
        }
    }
}

class Bucket {
    int key, value;
    Bucket next;
    public Bucket(int key, int value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */