class Solution {
    public void sortColors(int[] nums) {
        int first = 0;
        int second = 0;
        int third = nums.length - 1;
        
        while (second <= third) {
            if(nums[second] == 0) {
                swap(nums, first, second);
                first++;
                second++;
            }
            else if(nums[second] == 2) {
                swap(nums, second, third);
                third--;
            }
            else {
                second++;
            }
        }
    }
    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
