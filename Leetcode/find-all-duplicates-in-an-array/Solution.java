class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int absVal = Math.abs(nums[i]);
            if (nums[absVal - 1] < 0) result.add(absVal);
            else nums[absVal - 1] *= -1;
        }
        
        return result;
    }
}
