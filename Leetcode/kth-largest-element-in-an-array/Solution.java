class Solution {
    public int findKthLargest(int[] nums, int k) {
        int start = 0;
        int end = nums.length - 1;

        while(true) {
            int pivot = start;
            int left = start + 1;
            int right = end;
            while(left <= right && left < nums.length) {
                if(nums[right] < nums[pivot] && nums[left] > nums[pivot]) {
                    int temp = nums[left];
                    nums[left] = nums[right];
                    nums[right] = temp;
                }
                if(nums[left] <= nums[pivot]) {
                    left++;
                }
                if(nums[right] >= nums[pivot]) {
                    right--;
                }
            }
            int temp = nums[pivot];
            nums[pivot] = nums[right];
            nums[right] = temp;
            if(right == nums.length - k) {
                return nums[right];
            }
            else if(right < nums.length - k){
                start = right + 1;
            }
            else {
                end = right - 1;
            }
        }
    }
}
