package ArrayString.BinarySearch;

// ques: https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/

public class FindMinimuminRotatedSortedArray {
    public int findMin(int[] nums) {
        int left=0, right=nums.length-1;
        int ans = (int)1e9;
        while(left <= right){
            int mid = (left+right)/2;
            if(nums[left]<=nums[mid]){
                ans = Math.min(ans,nums[left]);
                left=mid+1;
            } else{
                ans = Math.min(ans,nums[mid]);
                right=mid-1;
            }
        }
        return ans;
    }

    public int findMinthiersolution(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }
}
