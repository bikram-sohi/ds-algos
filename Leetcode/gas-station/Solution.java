class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0;
        int start = 0;
        int extra = 0;
        for (int i = 0; i < gas.length; i++) {
            total += gas[i] - cost[i];
            extra += gas[i] - cost[i];
            if (extra < 0) {
                extra = 0;
                start = i + 1;
            }
        }
        return total >= 0 ? start : -1;
    }
}
