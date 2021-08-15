import java.util.HashMap;
import java.util.Map;

public class TwoSumIIIDataStructureDesign {

    //PROBLEM:
    //  Design a data structure that accepts a stream of integers and checks if it has a pair of integers that sum up to
    //  a particular value.
    //  Implement the TwoSum class:
    //  TwoSum() Initializes the TwoSum object, with an empty array initially.
    //  void add(int number) Adds number to the data structure.
    //  boolean find(int value) Returns true if there exists any pair of numbers whose sum is equal to value, otherwise,
    //  it returns false
    //Constraints:
    //  -105 <= number <= 105
    //  -231 <= value <= 231 - 1
    //  At most 104 calls will be made to add and find

    public static void main(String[] args) {
        TwoSum obj = new TwoSum();
        obj.add(0);
        obj.add(3);
        obj.add(5);
        System.out.println(obj.find(0));
        System.out.println(obj.find(7));
    }
}

// time complexity: add - O(1)
//                : find - O(n)
// space complexity: add - O(n)
//[HashMap] Store each number as key and its freq as value in HashMap, in add operation. Then, in find operation, for
//each integer check if the hashmap contains complement of that number
//took 87 ms (62 percentile) and 47.3 MB (12 percentile)
class TwoSum {

    Map<Integer, Integer> numbers;
    /** Initialize your data structure here. */
    public TwoSum() {
        numbers = new HashMap<>();
    }

    /** Add the number to an internal data structure.. */
    public void add(int number) {
        numbers.put(number, numbers.getOrDefault(number, 0) + 1);
    }

    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        for(int num : numbers.keySet()){
            int complement = value - num;
            if(complement == num){
                if(numbers.get(num) > 1) return true;
            } else if(numbers.containsKey(complement)) return true;
        }
        return false;
    }
}

