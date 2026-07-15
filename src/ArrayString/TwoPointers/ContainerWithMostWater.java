package ArrayString.TwoPointers;

// ques: https://leetcode.com/problems/container-with-most-water/description/

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int left=0, right=height.length-1;
        int ans=0;
        while(left<right){
            int area = (right-left) * Math.min(height[left],height[right]);
            ans = Math.max(ans,area);
            if(height[left] < height[right])
                left++;
            else right--;
        }
        return ans;
    }
}
