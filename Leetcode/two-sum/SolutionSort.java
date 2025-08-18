class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] orig = Arrays.copyOf(nums, nums.length);

        Arrays.sort(nums);
        
        int left, leftRes, rightRes;
        left = leftRes = rightRes = 0;
        int right = nums.length - 1;

        int sum = nums[left] + nums[right];
        while(sum != target) {
            if (sum > target) {
                right -= 1;
            }
            else {
                left += 1;
            }
            sum = nums[left] + nums[right];
        }

        Boolean leftSet, rightSet;
        leftSet = rightSet = false;

        for (int i = 0; i < nums.length; i++) {
            if (nums[left] == orig[i] && (!leftSet)) {
                leftRes = i;
                leftSet = true;
                continue;
            }
            if (nums[right] == orig[i] && (!rightSet)) {
                rightRes = i;
                rightSet = true;
            }
        }

        return new int[] {leftRes, rightRes};
    }
}

