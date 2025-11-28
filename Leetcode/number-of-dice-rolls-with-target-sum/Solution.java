class Solution {
    final int mod = 1_000_000_007;
    int[][] dp;

    public int numRollsToTarget(int n, int k, int target) {
        dp = new int[n + 1][target + 1];
        for(int i = 0; i <= n; i++) {
            for(int j = 0; j <= target; j++) {
                dp[i][j] = -1;
            }
        }
        return helper(n, k, target);
    }

    int helper(int n, int k, int target) {
        if( target < 0 || n == 0 ){  
            return  target == 0 ? 1 : 0; 
        }
        if(dp[n][target] != -1) {
            return dp[n][target];
        }
        int t = 0;
        for(int i = 1; i <= k; i++) {
            t = (t + helper(n - 1, k, target - i)) % mod;
        }
        dp[n][target] = t;
        return dp[n][target];
    }
}
