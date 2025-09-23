class Solution {
    public int rob(int[] nums) {
        int first = 0;
        int second = 0;
        int maxSum = nums[0];

        for(int i = 1; i < nums.length; i++) {
            first = second;
            second = maxSum;
            maxSum = Math.max(maxSum, first + nums[i]);
        }

        return maxSum;
    }
}
