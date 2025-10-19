class Solution {
    public int thirdMax(int[] nums) {
        long[] res = new long[3];
        
        for (int i = 0; i < res.length; i++) {
            res[i] = Long.MIN_VALUE;
        }

        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j < 3; j++) {
                if(nums[i] == res[j]) break;
                if(nums[i] > res[j]) {
                    for(int k = 2; k > j; k--) {
                        res[k] = res[k - 1];
                    }
                    res[j] = nums[i];
                    break;
                }
            }
        }

        return res[2] == Long.MIN_VALUE ? (int) res[0] : (int) res[2];
    }
}
