package BitManipulation;

// ques: https://leetcode.com/problems/missing-number/description/

public class MissingNumber {

    public int missingNumber(int[] nums) {
        int ans=0;
        for(int i=0; i<nums.length; i++){
            ans = ans ^ i ^ nums[i];
        }
        ans = ans ^ nums.length;
        return ans;
    }

    public int missingNumberMathematicalApproach(int[] nums) {
        int sum=0;
        for(int i : nums){
            sum += i;
        }
        int n = nums.length;
        int sigma = (n*(n+1)) >> 1;
        return  sigma - sum;
    }


    public static void main(String[] args) {
        MissingNumber m = new MissingNumber();
        m.missingNumber(new int[]{3,0,1});
    }
}
