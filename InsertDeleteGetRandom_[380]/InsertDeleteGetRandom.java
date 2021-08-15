import java.util.*;
public class InsertDeleteGetRandom {
    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();
        randomizedSet.insert(1); // Inserts 1 to the set. Returns true as 1 was inserted successfully.
        randomizedSet.remove(2); // Returns false as 2 does not exist in the set.
        randomizedSet.insert(2); // Inserts 2 to the set, returns true. Set now contains [1,2].
        randomizedSet.getRandom(); // getRandom() should return either 1 or 2 randomly.
        randomizedSet.remove(1); // Removes 1 from the set, returns true. Set now contains [2].
        randomizedSet.insert(2); // 2 was already in the set, so return false.
        randomizedSet.getRandom(); // Since 2 is the only number in the set, getRandom() will always return 2.
    }
}
// time complexity: getRandom - O(1) [always]
//                  insert - O(1)[average], O(n)[worst case, when operation exceeds current size of hashmap/arraylist and
//                           space allocation needs to be done
//                  delete - O(1)[average], O(n)[worst case, when operation exceeds current size of hashmap/arraylist and
//                           space allocation needs to be done
// space complexity: O(n)
//[HashMap and ArrayList] Insert and Delete could be achieved in O(1) using HashMap alone but getRandom was not possible
//as HashMap does not have index. So, we have to use ArrayList that stores the elements sequentially which will help in
//fetching random element in O(1)
//took 21 ms (97 percentile) and 88.6 MB (63 percentile)
class RandomizedSet {

    Map<Integer, Integer> map;
    List<Integer> list;
    Random rand;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        rand = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val))
            return false;
        map.put(val, list.size());
        list.add(list.size(), val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(map.containsKey(val)){
            //get last element
            int last = list.get(list.size() - 1);
            //get the current index of element to delete
            int index = map.get(val);
            //modify the position of (current)last element in list
            list.set(index, last);
            //modify the value of the (current)last element in map
            map.put(last, index);
            //delete the element
            map.remove(val);
            //delete the last element
            list.remove(list.size() - 1);
            return true;
        }
        return false;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}
