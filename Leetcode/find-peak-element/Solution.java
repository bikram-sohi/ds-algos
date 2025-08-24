class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int mid = right / 2;

        while(left < right) {
            if (nums[mid + 1] >= nums[mid]) {
                left = mid + 1;
            }
            else {
                right = mid;
            }
            mid = (right + left) / 2;
        }
        return left;
    }
}
