package ArrayString.ManipulationAndHashing;
import java.util.*;

// ques: https://leetcode.com/problems/group-anagrams/description/

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String,List<String>> map = new HashMap<>();

        for(String i : strs){
            char[] temp = i.toCharArray();
            Arrays.sort(temp);
            String key = new String(temp); // or String.valueOf(temp);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(i);
        }

        return new ArrayList<>(map.values());

    }

    public static void main(String[] args) {
        GroupAnagrams groupAnagrams = new GroupAnagrams();
        System.out.println(groupAnagrams.groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));
    }
}
