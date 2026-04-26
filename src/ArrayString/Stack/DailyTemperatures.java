package ArrayString.Stack;

import java.util.Stack;

// ques : https://leetcode.com/problems/daily-temperatures/description/

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temp) {
        Stack<Integer> stack = new Stack<>();
        stack.push(temp.length-1);
        int[] ans = new int[temp.length];
        for(int i=temp.length-2; i>=0; i--){
            while(!stack.isEmpty() && temp[stack.peek()] <= temp[i]){
                stack.pop();
            }
            if(stack.isEmpty())
                ans[i]=0;
            else
                ans[i] = stack.peek()-i;
            stack.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        DailyTemperatures d= new DailyTemperatures();
        d.dailyTemperatures(new int[]{89,62,70,58,47,47,46,76,100,70});
    }
}
