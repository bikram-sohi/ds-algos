class Solution {
    public int[] productExceptSelf(int[] nums) {
        int product = 1;
        int zeroCount = 0;
        int zeroIndex = -1;
        int nonZeroCount = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroCount++;
                if (zeroCount > 1) break;
                zeroIndex = i;
                continue;
            }
            product *= nums[i];
            nonZeroCount++;
        }

        if (nonZeroCount == 0) return nums;

        for (int i = 0; i < nums.length; i++) {
            if (zeroCount == 1) {
                if (nums[i] == 0) nums[i] = product;
                else nums[i] = 0;
            } else if (zeroCount > 1) {
                nums[i] = 0;
            } else {
                if (nums[i] == 0) nums[i] = product;
                else nums[i] = product/nums[i];
            }
        }
        return nums;
    }
}

