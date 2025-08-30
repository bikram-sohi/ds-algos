class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> sums = new HashMap<>();
        sums.put(0, 1);
        int sum = 0, result = 0;

        for (int n : nums) {
            sum += n;

            if (sums.containsKey(sum - k)) {
                result += sums.get(sum - k);
            }

            sums.put(sum, sums.getOrDefault(sum, 0) + 1);
        }

        return result;        
    }
}
