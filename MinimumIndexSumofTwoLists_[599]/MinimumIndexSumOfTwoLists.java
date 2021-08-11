import java.util.*;

public class MinimumIndexSumOfTwoLists {

    //PROBLEM: Minimum Index Sum of Two Lists
    //  Suppose Andy and Doris want to choose a restaurant for dinner, and they both have a list of favorite restaurants
    //  represented by strings.
    //  You need to help them find out their common interest with the least list index sum. If there is a choice tie
    //  between answers, output all of them with no order requirement. You could assume there always exists an answer.
    //Constraints:
    //  1 <= list1.length, list2.length <= 1000
    //  1 <= list1[i].length, list2[i].length <= 30
    //  list1[i] and list2[i] consist of spaces ' ' and English letters.
    //  All the stings of list1 are unique.
    //  All the stings of list2 are unique.

    public static void main(String[] args) {
        String[] list1 = new String[]{"KFC"};
        String[] list2 = new String[]{"KFC"};

        for(String s : findRestaurant2(list1, list2))
            System.out.println(s);
    }

    // time complexity: O(n + m)
    // space complexity; O(n + m)
    //[2 HashMap] Traverse first string and store it and its index in a HashMap. Then, traverse other list and see if
    //that string is present in first map. If yes, then put it in second HashMap. Then find the min value in second
    //hashmap and retrieve all the entryset with that (min value)
    //took 9 ms (47 percentile) and 39.5 MB (86 percentile)
    public static String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 =  new HashMap<>();
        int i = 0;
        for(i = 0; i < list1.length; i++)
            map1.put(list1[i], i);

        for(i = 0; i < list2.length; i++){
            if(map1.containsKey(list2[i])) map2.put(list2[i], i + map1.get(list2[i]));
        }

        int min = Integer.MAX_VALUE;
        for(Map.Entry<String, Integer> entry : map2.entrySet()){
            min = Math.min(min, entry.getValue());
        }

        List<String> res = new ArrayList<>();
        for(Map.Entry<String, Integer> entry : map2.entrySet()){
            if(entry.getValue() == min) res.add(entry.getKey());
        }
        return res.toArray(new String[res.size()]);
    }

    // time complexity: O(n + m)
    // space complexity; O(n + m)
    //[1 HashMap] Traverse first string and store it and its index in a HashMap. Then, traverse other list and see if
    //that string is present in first map and if the sum of its prev index and current index is less/equal to min sum
    //observed till now. If less than clear result list and add this string and if equal then just this string
    //took 5 ms (99.8 percentile) and 40 MB (26 percentile)
    public static String[] findRestaurant2(String[] list1, String[] list2){
        Map<String, Integer> map1 = new HashMap<>();
        List<String> res = new ArrayList<>();
        int i = 0;

        for(i = 0; i < list1.length; i++)
            map1.put(list1[i], i);

        int minSum = Integer.MAX_VALUE, sum = 0;
        for(i = 0; i < list2.length; i++){
            if(map1.containsKey(list2[i])) {
                sum = i + map1.get(list2[i]);
                if(sum < minSum){
                    res.clear();
                    res.add(list2[i]);
                    minSum = sum;
                } else if(sum == minSum) res.add(list2[i]);
            }
        }
        return res.toArray(new String[res.size()]);
    }
}
