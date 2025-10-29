class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> li = new ArrayList<>();
        Arrays.sort(nums);
        helper(nums, 0, li, res);
        return res;
    }

    void helper(int[] nums, int i, List<Integer> li, List<List<Integer>> res) {
        if(i == nums.length) {
            res.add(new ArrayList<>(li));
            return;
        }

        li.add(nums[i]);
        helper(nums, i + 1, li, res);
        li.remove(li.size() - 1);

        while(i + 1 < nums.length && nums[i + 1] == nums[i]) {
            i++;
        }

        helper(nums, i + 1, li, res);
    }
}
