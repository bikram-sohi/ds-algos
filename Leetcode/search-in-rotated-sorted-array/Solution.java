class Solution {
    public int search(int[] nums, int target) {
        return helper(nums, target, 0, nums.length - 1);
    }
    int helper(int[] nums, int target, int left, int right) {
        if(left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        if(target == nums[mid]) {
            return mid;
        }
        if(nums[left] <= nums[mid]) {
            if(target >= nums[left] && target < nums[mid]) {
                return helper(nums, target, left, mid - 1);
            }
            else {
                return helper(nums, target, mid + 1, right);
            }
        }
        else {
            if(target > nums[mid] && nums[right] >= target) {
                return helper(nums, target, mid + 1, right);
            }
            else {
                return helper(nums, target, left, mid - 1);
            }
        }
    }
}
