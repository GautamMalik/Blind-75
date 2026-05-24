package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParantheses {
    List<String> ans = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        dfs(n,new StringBuilder(),0,0);
        return ans;
    }

    private void dfs(int n, StringBuilder sb, int open, int close) {
        if (open == close && close == n) {
            ans.add(sb.toString());
            return;
        }

        if (open < n) {
            sb.append("(");
            dfs(n,sb,open+1,close);
            sb.deleteCharAt(sb.length()-1);
        }

        if(close<open){
            sb.append(")");
            dfs(n,sb,open,close+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public static void main(String[] args) {
        GenerateParantheses generateParantheses = new GenerateParantheses();
        System.out.println(generateParantheses.generateParenthesis(3));
    }
}
