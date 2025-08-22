class Solution {
    public boolean isMonotonic(int[] nums) {
        int count = 0;
        
        while (count < nums.length - 1 && nums[count] == nums[count + 1]) {
            count++;
        }

        if (count == nums.length - 1) return true;

        boolean order = nums[count] < nums[count + 1];
        
        for (int i = count + 2; i < nums.length; i++) {
            if (order) {
                if ((nums[i - 1] <= nums[i]) != order) {
                    return false;
                }
            }
            else {
                if((nums[i - 1] >= nums[i]) == order) {
                    return false;
                }
            } 

        }
        return true;
    }
}
