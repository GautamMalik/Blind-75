package ArrayString.BinarySearch;

public class SearchinRotatedSortedArray {
    public int search(int[] nums, int target) {
        int left=0, right=nums.length-1;

        while(left<=right){
            int mid = (left+right)/2;
            if(nums[mid]==target)
                return mid;
            else if( nums[mid]>= nums[left] && (target<= nums[mid] && target >= nums[left]))  // left side sorted and target is in left
                right = mid-1;
            else if( nums[mid]>= nums[left] && !(target<= nums[mid] && target >= nums[left]))  // left side sorted and target is in right
                left = mid+1;
            else if(nums[mid] <= nums[right] && (target >= nums[mid] && target <= nums[right])) // right side sorted and target is in right
                left= mid+1;
            else if(nums[mid] <= nums[right] && !(target >= nums[mid] && target <= nums[right])) // right side sorted and target is in left
                right = mid-1;
        }
        return -1;
    }

    public int searchTheirSolution(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            // If the left half is sorted
            if (nums[mid] >= nums[left]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                // If the right half is sorted
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        SearchinRotatedSortedArray i = new SearchinRotatedSortedArray();
        i.search(new int[]{4,5,6,7,0,1,2},0);
    }
}
