package BitManipulation;

// qus: https://leetcode.com/problems/counting-bits/description/

public class CountingBits {
    public int[] countBits(int n) {
        int[] ans = new int[n+1];
        if(n==0)
            return ans;
        ans[0] = 0;
        for(int i=1; i<=n; i++){
            int temp = i/2;
            if(i%2==0)
                ans[i] = ans[temp];
            else
                ans[i] = ans[temp] + 1;
        }
        return ans;
    }
}
