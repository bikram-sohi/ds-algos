import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hm = new HashMap<>();

        hm.put(nums[0], 0);

        for (int i = 1; i < nums.length; i++) {
            if (hm.containsKey(target - nums[i])) {
                return new int[] {hm.get(target - nums[i]), i};
            }
            else {
                hm.put(nums[i], i);
            }
        }
        return new int[] {0, 0};
    }
}
