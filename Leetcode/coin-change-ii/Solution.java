class Solution {
    public int change(int amount, int[] coins) {
        int[] ways = new int[amount + 1];
        ways[0] = 1;
        for(int coin : coins) {
            for(int j = coin; j < ways.length; j++) {
                if(coin <= j) {
                    ways[j] += ways[j - coin];
                }
            }
        }
        return ways[amount];
    }
}
