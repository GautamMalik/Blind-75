package BitManipulation;

// ques: https://leetcode.com/problems/sum-of-two-integers/description/

public class SumOfTwoIntegers {

    public int getSum(int a, int b) {
        int ans = 0;

        int carry = 0;
        for(int i=0; i<32; i++){
            int bitA = a & 1;
            int bitB = b & 1;

            if((bitA == 1 && bitB==0) || (bitA == 0 && bitB==1)){
                if(carry==0)
                    ans = ans | (1<<i);
            } else if (bitA == 0 && bitB ==0) {
                if(carry==1){
                    ans = ans | (1<<i);
                    carry=0;
                }
            }
            else {
                if(carry == 1)
                    ans = ans | (1<<i);
                carry=1;
            }
            a=a>>1;
            b=b>>1;
        }
        return ans;
    }

    public static void main(String[] args) {
        SumOfTwoIntegers sumOfTwoIntegers = new SumOfTwoIntegers();
        System.out.println(sumOfTwoIntegers.getSum(3,129));
    }
}
