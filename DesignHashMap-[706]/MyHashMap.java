import java.util.LinkedList;

//PROBLEM: Design HashMap
//  Design a HashMap without using any built-in hash table libraries.
//  Implement the MyHashMap class:
//  MyHashMap() initializes the object with an empty map.
//  void put(int key, int value) inserts a (key, value) pair into the HashMap. If the key already exists in the map,
//  update the corresponding value.
//  int get(int key) returns the value to which the specified key is mapped, or -1 if this map contains no mapping for
//  the key.
//  void remove(key) removes the key and its corresponding value if the map contains the mapping for the key
//Constraints:
//  0 <= key, value <= 106
//  At most 104 calls will be made to put, get, and remove.

// time complexity: O(n / k); k = #predefined total buckets
// space complexity: O(k + m); k = #total predefined buckets and m = #unique values inserted in HashSet
//[custom Pair for key-values, LinkedList for bucket implementation and % operator for hashing]
//took 17 ms (62 percentile) and 46.6 MB (43 percentile)
public class MyHashMap {
    MyBucket[] buckets;
    int hasher;
    public MyHashMap(){
        hasher = 796;
        buckets = new MyBucket[hasher];

        for(int i = 0; i < buckets.length; i++)
            buckets[i] = new MyBucket();
    }

    public int hash(int key){
        return key % hasher;
    }

    public void put(int key, int val){
        int bucketIndex = hash(key);
        buckets[bucketIndex].add(key, val);
    }

    public int get(int key){
        int bucketIndex = hash(key);
        return buckets[bucketIndex].get(key);
    }

    public void remove(int key){
        int bucketIndex = hash(key);
        buckets[bucketIndex].remove(key);
    }
}

class Pair<K, V>{
    public K first;
    public V second;
    public Pair(K first, V second){
        this.first = first;
        this.second = second;
    }
}

class MyBucket{
    LinkedList<Pair<Integer, Integer>> list;
    public MyBucket(){
        list = new LinkedList<>();
    }

    public void add(Integer key, Integer value){
        boolean found = false;
        for(Pair<Integer, Integer> pair : list) {
            if (pair.first.equals(key)) {
                pair.second = value;
                found = true;
            }
        }
        if(!found) list.add(new Pair<Integer, Integer>(key, value));
    }

    public void remove(Integer key){
        for(Pair<Integer, Integer> pair : list){
            if(pair.first.equals(key)) list.remove(pair);
        }
    }

    public int get(Integer key){
        for(Pair<Integer, Integer> pair : list) {
            if (pair.first.equals(key)) return pair.second;
        }
        return -1;
    }
}