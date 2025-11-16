class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        boolean isSorted = true;

        for(int i = 0; i < nums.length - 1; i++) {
            if(nums[i + 1] < nums[i]) {
                isSorted = false;
                max = Math.max(nums[i], max);
                min = Math.min(nums[i + 1], min);
            }
        }
        
        if(isSorted) return 0;

        int low = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > min) {
                low = i;
                break;
            }
        }

        int high = nums.length - 1;
        for(int i = nums.length - 1; i >= 0; i--) {
            if(nums[i] < max) {
                high = i;
                break;
            }
        }                    

        return (high - low) + 1;
    }
}
