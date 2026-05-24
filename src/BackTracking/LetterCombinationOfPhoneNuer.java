package BackTracking;

import java.util.*;

// ques: https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/

public class LetterCombinationOfPhoneNuer {
    List<String> ans  = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        Map<Character, String> map = new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");

        char[] nums = digits.toCharArray();

        dfs(nums, map, 0, new StringBuilder());
        return ans;
    }

    private void dfs(char[] nums, Map<Character, String> map, int idx, StringBuilder sb){
        if(sb.length()==nums.length){
            ans.add(sb.toString());
            return;
        }
        if(sb.length()>nums.length)
            return;


        for(int i=idx; i<nums.length; i++){
            String st = map.get(nums[i]);
            for(int j=0; j<st.length(); j++){
                sb.append(st.charAt(j));
                dfs(nums,map,i+1,sb);
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }

    public static void main(String[] args) {
        LetterCombinationOfPhoneNuer letterCombinationOfPhoneNuer = new LetterCombinationOfPhoneNuer();
        System.out.println(letterCombinationOfPhoneNuer.letterCombinations("234"));
    }
}
