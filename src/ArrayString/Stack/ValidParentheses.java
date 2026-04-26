package ArrayString.Stack;

import java.util.Stack;

// ques : https://leetcode.com/problems/valid-parentheses/description/

public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()){
            if(c == '(' || c=='[' || c=='{')
                stack.push(c);
            else{
                if(stack.isEmpty() || (c==')' && !(stack.peek()=='(')))
                    return false;
                if(stack.isEmpty() || (c==']' && !(stack.peek()=='[')))
                    return false;
                if(stack.isEmpty() || (c=='}' && !(stack.peek()=='{')))
                    return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
