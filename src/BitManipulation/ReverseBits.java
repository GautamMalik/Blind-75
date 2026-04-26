package BitManipulation;

// ques: https://leetcode.com/problems/reverse-bits/description/

public class ReverseBits {

    public int reverseBits(int n) {
        int ans = 0;
        for(int i=0; i<32; i++){
            ans = (ans << 1) | (n & 1);  // [ (n & 1) = last bit ]
            n = n >> 1;                  // [ ans << 1  = increasing one bit]
                                         // [ or operation to set last bit ans 1st bit]
        }
        return ans;
    }
}
