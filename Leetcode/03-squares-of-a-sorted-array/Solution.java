class Solution {
    public int[] sortedSquares(int[] nums) {
        int squaredArray[] = new int[nums.length];

        int count, right, left = 0;
        count = right = nums.length - 1;

        while (left <= right) {
            int leftSquared = nums[left] * nums[left];
            int rightSquared = nums[right] * nums[right];
            if (leftSquared > rightSquared) {
                squaredArray[count] = leftSquared;
                left++;
                count--;
            } else {
                squaredArray[count] = rightSquared;
                right--;
                count--;
            }
        }

        return squaredArray;
    }
}
