package BitManipulation;

// ques : https://leetcode.com/problems/number-of-1-bits/description/

public class SetBits {
    int setBits(int n) {
        int cnt = 0;
        while (n > 0) {
            n = n & (n - 1);
            cnt++;
        }
        return cnt;
    }

    int setBits2(int n) {
        int cnt = 0;
        while (n > 0) {
            if ((n & 1) == 1)   // check last bit  OR n%2==1
                cnt++;
            n = n >> 1;  // right shift
        }
        return cnt;
    }
}
