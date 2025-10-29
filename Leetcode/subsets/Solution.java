class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        res = helper(nums, 0, res);
        return res;
    }

    List<List<Integer>> helper(int[] nums, int idx, List<List<Integer>> res) {
        if(idx == nums.length) {
            return res;
        }
        for(int i = res.size() - 1; i >= 0; i--) {
            List<Integer> li = new ArrayList<>(res.get(i));
            li.add(nums[idx]);
            res.add(li);
        }
        res = helper(nums, idx + 1, res);
        return res;
    }
}
