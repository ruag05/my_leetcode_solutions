import java.util.LinkedList;

//PROBLEM:
//  Design a HashSet without using any built-in hash table libraries.
//  Implement MyHashSet class:
//  void add(key) Inserts the value key into the HashSet.
//  bool contains(key) Returns whether the value key exists in the HashSet or not.
//  void remove(key) Removes the value key in the HashSet. If key does not exist in the HashSet, do nothing
//Constraints:
//  0 <= key <= 106
//  At most 104 calls will be made to add, remove, and contains.

class Bucket{
    LinkedList<Integer> list;
    public Bucket(){
        list = new LinkedList<>();
    }
    public void add(Integer key){
        if(!list.contains(key))
            list.addFirst(key);
    }
    public void delete(Integer key){
        list.remove(key);
    }
    public boolean exists(Integer key){
       return list.contains(key);
    }
}

// time complexity: O(n / k); k = #predefined total buckets
// space complexity: O(k + m); k = #total predefined buckets and m = #unique values inserted in HashSet
//[LinkedList for bucket implementation and % operator for hashing]
//took 13 ms (66 percentile) and 46.4 MB (68 percentile)
public class MyHashSet{
    Bucket[] buckets;
    int hasher;
    /** Initialize your data structure here. */
    public MyHashSet() {
        hasher = 769;
        buckets = new Bucket[769];

        for(int i = 0; i < buckets.length; i++)
            buckets[i] = new Bucket();
    }

    public int hash(int key){
        return key % hasher;
    }

    public void add(int key) {
        int bucketIndex = hash(key);
        buckets[bucketIndex].add(key);
    }

    public void remove(int key) {
        int bucketIndex = hash(key);
        buckets[bucketIndex].delete(key);
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int bucketIndex = hash(key);
        return buckets[bucketIndex].exists(key);
    }
}

class MyHashSet1 {
    LinkedList<Integer> list;
    /** Initialize your data structure here. */
    public MyHashSet1() {
        list = new LinkedList<>();
    }

    public void add(int key) {
        if(!contains(key)) list.add(key);
    }

    public void remove(int key) {
        if(contains(key)) list.remove((Integer)key);
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return list.contains(key);
    }
}

class DesignHashSet{
    public static void main(String[] args){
        MyHashSet myHashSet = new MyHashSet();
        myHashSet.add(1);      // set = [1]
        printHashSet(myHashSet);

        myHashSet.add(2);      // set = [1, 2]
        printHashSet(myHashSet);

        System.out.println(myHashSet.contains(1)); // return True

        System.out.println(myHashSet.contains(3)); // return False, (not found)

        myHashSet.add(2);      // set = [1, 2]
        printHashSet(myHashSet);

        System.out.println(myHashSet.contains(2)); // return True

        myHashSet.remove(2);   // set = [1]
        printHashSet(myHashSet);

        System.out.println(myHashSet.contains(2)); // return False, (already removed)
    }
    public static void printHashSet(MyHashSet set){
        for(Bucket b : set.buckets)
            for(int i : b.list)
                System.out.println(i);
        System.out.println("------------");
    }
}

