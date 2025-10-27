class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        helper(nums, new ArrayList<>(), res, visited);
        return res;
    }

    void helper(int[] nums, List<Integer> tempList, List<List<Integer>> res, boolean[] visited) {
        if(tempList.size() == nums.length) {
            res.add(new ArrayList<>(tempList));
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            if(visited[i] || (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1])) {
                continue;
            }
            visited[i] = true;
            tempList.add(nums[i]);
            helper(nums, tempList, res, visited);
            tempList.remove(tempList.size() - 1);
            visited[i] = false;
        }
    }
}
