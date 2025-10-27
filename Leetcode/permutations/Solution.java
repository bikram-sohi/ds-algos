class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper(0, nums, res);
        return res;
    }

    void helper(int pos, int[] nums, List<List<Integer>> res) {
        if(pos == nums.length - 1) {
            List<Integer> list = new ArrayList<>();
            for (int num : nums) {
                list.add(num);
            }
            res.add(list);
            return;
        }
        for(int i = pos; i < nums.length; i++) {
            swap(nums, pos, i);
            helper(pos + 1, nums, res);
            swap(nums, pos, i);
        }
    }

    void swap(int[] nums, int pos, int i) {
        int temp = nums[pos];
        nums[pos] = nums[i];
        nums[i] = temp;
    }
}
